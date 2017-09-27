package mvc.main.function.handler;

import mvc.other.HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by 伟 on 2017/9/26.
 */
public class AjaxHandlerAdaper implements HandlerAdapter{
    public boolean support(Handler handler) {
        return false;
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {

    }

    public void setHandler(Handler handler) {

    }
}
