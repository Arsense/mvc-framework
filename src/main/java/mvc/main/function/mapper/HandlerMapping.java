package mvc.main.function.mapper;

import mvc.main.function.helper.SuperRequestMapping;
import mvc.main.function.helper.SuperRequestMethod;
import mvc.main.function.helper.SuperResponseBody;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**根据RequesrMapping去匹配
 * Created by 伟 on 2017/9/22.
 */
public class HandlerMapping {

    public Map<String,Handler> handlerMap = new HashMap<String, Handler>();

    //构造函数 直接找到相应的放到Mapper中
    public  HandlerMapping(List<String> list) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class class1;
        for(String s:list){
            class1 = Class.forName(s);
            Object obj = class1.newInstance();
            String path1="";
            if(class1.isAnnotationPresent(SuperRequestMapping.class)){
                SuperRequestMapping requestMapping = (SuperRequestMapping) class1.getAnnotation(SuperRequestMapping.class);
                path1 = requestMapping.path();
            }
            Method[] methods = class1.getDeclaredMethods();
            for(Method method:methods){
                if(method.isAnnotationPresent(SuperRequestMapping.class)){
                    SuperRequestMapping requestMapping = method.getAnnotation(SuperRequestMapping.class);
                    Class[] params =method.getParameterTypes();
                    SuperRequestMethod requestMethod = requestMapping.method();
                    String path2 = requestMapping.path();
                    //shi ajax or jump
                    if(method.isAnnotationPresent(SuperResponseBody.class)){
                        //根据路径 存储method  params controller  requestmethod
                        handlerMap.put(path1+path2,new Handler(method,obj,params));
                    }else{
                        handlerMap.put(path1+path2,new Handler(method,obj,params));
                    }
                }
            }




        }



    }

}
