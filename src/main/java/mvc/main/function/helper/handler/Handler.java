package mvc.main.function.helper.handler;

import java.lang.reflect.Method;

/**
 * Created by 伟 on 2017/9/22.
 */
public class Handler {
    protected Method method;
    protected Object controller;
    protected Class[] params;

    /**
     *  构造函数
     * @param method
     * @param controller
     * @param params
     */
    public Handler(Method method,Object controller, Class[] params){
        this.method = method;
        this.controller =controller;
        this.params = params;
    }
    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Class[] getParams() {
        return params;
    }

    public void setParams(Class[] params) {
        this.params = params;
    }





}
