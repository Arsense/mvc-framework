package mvc.other;
import mvc.main.function.handler.Handler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by 伟 on 2017/9/22.
 */
public interface HandlerAdapter {

    boolean support(Handler handler);
    void execute(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException;
    void setHandler(Handler handler);
}
