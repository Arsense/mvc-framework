package mvc.main.function.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**根据RequesrMapping去匹配
 * Created by 伟 on 2017/9/22.
 */
public class HandlerMapping {

    public Map<String,Handler> handlerMap = new HashMap<String, Handler>();

    //构造函数 直接找到相应的放到Mapper中
    public  HandlerMapping(List<String> list){




    }

}
