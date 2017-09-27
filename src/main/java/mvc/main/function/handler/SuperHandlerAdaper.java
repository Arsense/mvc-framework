package mvc.main.function.handler;


import mvc.main.function.mapper.HandlerMapping;
import mvc.other.HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 伟 on 2017/9/25.
 */

public class SuperHandlerAdaper implements HandlerAdapter {

    private SuperHandler superHandler;
    private static final String PREFIX = "/WEB-INF/";
    private static final String SUFFIX = ".jsp";

    public boolean support(HandlerMapping handlerMapping) {
        return false;
    }

    public boolean support(Handler handler) {
        return handler instanceof  SuperHandler;
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {

        //所有变量放到paramsObjects


        Object[] paramObjects = new Object[50];
        Method  method = superHandler.getMethod();
        Class[] classes= superHandler.getParams();
        int  count = 0;
        count= makeParamsObjects(paramObjects,classes,request,response);

        //掉用Dispathcher 运行所有符合请求的函数

        String dispatcher = null;

        dispatcher = (String) method.invoke(superHandler.getController(),paramObjects);

        //转发请求 //构建Jsp路径  /WEB-INF/+dispatcher+.jsp
        request.getRequestDispatcher(PREFIX+dispatcher+SUFFIX).forward(request,response);



    }

    /**
     * 处理请求类的个数 session request response
     * @param paramObjects
     * @param classes
     * @param request
     * @param response
     * @return
     */
    public  int makeParamsObjects(Object[] paramObjects,Class[] classes,HttpServletRequest request,HttpServletResponse response){
        int count = 0;
        for(Class c:classes){
            if(c == HttpServletRequest.class){
                paramObjects[count++] = request;
            }else if(c == HttpServletResponse.class){
                paramObjects[count++] = response;
            }else if(c == HttpSession.class){
                    paramObjects[count++]=request.getSession();
            }
        }

        return  count;



    }

    public void setHandler(Handler handler) {
        this.superHandler = (SuperHandler) handler;
    }



    public SuperHandler getSuperHandler() {
        return superHandler;
    }

    public void setSuperHandler(SuperHandler superHandler) {
        this.superHandler = superHandler;
    }
}
