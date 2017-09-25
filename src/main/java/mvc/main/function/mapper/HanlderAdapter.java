package mvc.main.function.mapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 伟 on 2017/9/22.
 */
public interface HanlderAdapter {

    boolean support(HandlerMapping handlerMapping);
    void execute(HttpServletRequest request, HttpServletResponse response);
    void setHandler(HandlerMapping handlerMapping);
}
