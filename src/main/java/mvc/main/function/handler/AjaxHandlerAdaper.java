package mvc.main.function.handler;

import mvc.main.function.helper.JsonUtil;
import mvc.other.HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 伟 on 2017/9/26.
 */
public class AjaxHandlerAdaper implements HandlerAdapter{
    private static final String PREFIX = "/WEB-INF/";
    private static final String SUFFIX = ".jsp";

    public AjaxHandler getAjaxHandler() {
        return ajaxHandler;
    }

    private  AjaxHandler ajaxHandler;

    public boolean support(Handler handler) {
        return handler instanceof AjaxHandler;
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Object[] paramObjects = new Object[50];
        Method  method = ajaxHandler.getMethod();
        Class[] classes= ajaxHandler.getParams();
        int  count = 0;
        count= makeParamsObjects(paramObjects,classes,request,response);

        Object[] temp = new Object[count];
        for(int i = 0;i<count;i++){
            temp[i]=paramObjects[i];
        }

        //掉用Dispathcher 运行所有符合请求的函数

        Object body = null;

        body = (Object) method.invoke(ajaxHandler.getController(),temp);
        //向客户端输出数据
        PrintWriter out = response.getWriter();
        out.print(JsonUtil.toJson(out));
    }

    public void setHandler(Handler handler) {
            this.ajaxHandler = (AjaxHandler) handler;
    }

    public  int makeParamsObjects(Object[] paramObjects,Class[] classes,HttpServletRequest request,HttpServletResponse response) throws Exception {
        int count = 0;
        for(Class c:classes){
            if(c == HttpServletRequest.class){
                paramObjects[count++] = request;
            }else if(c == HttpServletResponse.class){
                paramObjects[count++] = response;
            }else if(c == HttpSession.class){
                paramObjects[count++]=request.getSession();
            } else {
                throw new Exception("控制器参数错误");
            }
        }

        return  count;



    }

}
