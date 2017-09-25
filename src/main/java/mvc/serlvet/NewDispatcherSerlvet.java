package mvc.serlvet;

import mvc.helper.GetRequestUrl;
import mvc.main.function.PackageScan;
import mvc.main.function.mapper.Handler;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 伟 on 2017/9/21.
 */
@WebServlet
public class NewDispatcherSerlvet extends HttpServlet{


    private static  final String CONTROLLER_SCAN_PACKAGES="mvc.controller";
    @Override
    public void init() throws ServletException {
        super.init();

        //扫描我们的Controller文件夹
        List<String> list = PackageScan.getAllClassNamesFromPackage(CONTROLLER_SCAN_PACKAGES);



    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){

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



    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        //获取请求路径
        String requestUrl = GetRequestUrl.getUrl(request);
    }

}

