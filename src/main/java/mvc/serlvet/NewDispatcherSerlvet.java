package mvc.serlvet;

import mvc.main.function.helper.GetRequestUrl;
import mvc.main.function.PackageScan;
import mvc.main.function.handler.Handler;
import mvc.main.function.mapper.HandlerMapping;
import mvc.other.HandlerAdapter;


import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 伟 on 2017/9/21.
 */
//@WebFilter(filterName = "Serlver1" ,urlPatterns = "/*")
@WebServlet("/")
public class NewDispatcherSerlvet extends HttpServlet{


    private static  final String CONTROLLER_SCAN_PACKAGES="mvc.controller";
    private static  final String ADAPTER_SCAN_PACKAGES="mvc.main.function";
    private HandlerMapping handlerMapping;  //存储的Handler 和路劲的关系

    private  List<HandlerAdapter> handlerAdapters = new ArrayList<HandlerAdapter>();
    @Override
    public void init() throws ServletException {
        super.init();

        //扫描我们的Controller文件夹
        try {
            List<String> list = new PackageScan(CONTROLLER_SCAN_PACKAGES).getAllClassNamesFromPackage();
            handlerMapping = new HandlerMapping(list);
            initHandlerApaterList(handlerAdapters);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }



        printAdapterList(handlerAdapters);


    }


    public void printAdapterList(List<HandlerAdapter> handlerAdapters){
        for(HandlerAdapter hd:handlerAdapters){
            System.out.println(hd);
        }

    }

    public void initHandlerApaterList(List<HandlerAdapter> handlerAdapters) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {

            List<String> Classlist = new PackageScan(ADAPTER_SCAN_PACKAGES).getAllClassNamesFromPackage();
            for (String c:Classlist){
                Class class1 = Class.forName(c);
                //这里把相同的接口实现的类放进去
              //  Object obj1 = class1.newInstance();
                if(HandlerAdapter.class.isAssignableFrom(class1)){
                    Object obj = class1.newInstance();
                    handlerAdapters.add((HandlerAdapter)obj);
                }

            }


    }


    /**
     * Serlvet主要的截取功能
     * @param request
     * @param response
     */
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        HttpServletRequest tempRequest = (HttpServletRequest) request;
        HttpServletResponse tempResponse = (HttpServletResponse)response;
        //获取请求路径
        String requestUrl = GetRequestUrl.getUrl(tempRequest);

        //然后根据路径去匹配RequestMapper
        Handler handler = handlerMapping.getHandler(requestUrl);
        for(HandlerAdapter adapter:handlerAdapters){
            if(adapter != null){
                adapter.support(handler);
                adapter.setHandler(handler);
                try {
                    adapter.execute(tempRequest,tempResponse);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                tempResponse.sendError(HttpServletResponse.SC_FOUND);
            }
        }



    }



}

