package mvc.main.function.handler;

import mvc.main.function.helper.SuperRequestMethod;

import java.lang.reflect.Method;

/**
 * Created by 伟 on 2017/9/26.
 */
public class SuperHandler extends Handler{
    /**
     * 构造函数
     *
     * @param method
     * @param controller
     * @param params
     */
    public SuperHandler(Method method, Object controller, Class[] params, SuperRequestMethod requestMethod) {
        super(method, controller, params,requestMethod);
    }
}
