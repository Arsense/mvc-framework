package mvc.main.function.helper.handler;

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
    public SuperHandler(Method method, Object controller, Class[] params) {
        super(method, controller, params);
    }
}
