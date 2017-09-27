package mvc.main.function.handler;

import mvc.main.function.helper.SuperRequestMethod;

import java.lang.reflect.Method;

/**
 * Created by 伟 on 2017/9/22.
 */
public class Handler {
    protected Method method;
    protected Object controller;
    protected Class[] params;


    protected  SuperRequestMethod requestMethod;
    /**
     *  构造函数
     * @param method
     * @param controller
     * @param params
     */
    public Handler(Method method,Object controller, Class[] params,SuperRequestMethod requestMethod){
        this.method = method;
        this.controller =controller;
        this.params = params;
        this.requestMethod = requestMethod;
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
    public SuperRequestMethod getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(SuperRequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }





}
