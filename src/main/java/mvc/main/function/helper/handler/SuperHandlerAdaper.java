package mvc.main.function.helper.handler;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 伟 on 2017/9/25.
 */
public class SuperHandlerAdaper implements HandlerAdapter {


    public boolean supports(Object o) {
        return false;
    }

    public ModelAndView handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return null;
    }

    public long getLastModified(HttpServletRequest httpServletRequest, Object o) {
        return 0;
    }
}
