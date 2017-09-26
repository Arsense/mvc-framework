package mvc.main.function.helper.handler;


import mvc.main.function.mapper.HandlerMapping;
import mvc.other.HandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 伟 on 2017/9/25.
 */

public class SuperHandlerAdaper implements HandlerAdapter {

    private SuperHandler superHandler;


    public boolean support(HandlerMapping handlerMapping) {
        return false;
    }

    public boolean support(Handler handler) {
        return false;
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) {

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
