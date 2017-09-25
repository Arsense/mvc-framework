package mvc.main.function.helper;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 伟 on 2017/9/22.
 */
public class GetRequestUrl {

    /**
     * http://localhost:8080/jqueryLearn/resources/request.jsp
     * 获取到是/resources/request
     * @param request
     * @return
     */
    public static String getUrl(HttpServletRequest request){

        String requestUrl;
       //jqueryLearn/resources/request.jsp
       String uri = request.getRequestURI();
       //获取的是jqueryLearn
       String contextPath = request.getContextPath();
       int index = uri.indexOf(contextPath);
       //jqueryLearn


       int indexOfPoint = uri.indexOf(".");
       if(-1 == indexOfPoint)
           requestUrl =uri.substring(index+contextPath.length());

       else
           requestUrl =uri.substring(index+contextPath.length(),indexOfPoint);
       return requestUrl;



    }
}
