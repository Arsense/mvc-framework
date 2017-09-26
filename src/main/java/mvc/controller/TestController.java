package mvc.controller;

import mvc.main.function.helper.SuperRequestMethod;
import mvc.other.SuperRequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 伟 on 2017/9/22.
 */
@SuperRequestMapping(path = "/demo" )
public class TestController{


    @SuperRequestMapping(path="/test1",method = SuperRequestMethod.GET)
    public String function1(){
        return "test";
    }

    @SuperRequestMapping(path = "test2",method = SuperRequestMethod.POST)
    public Map function2(HttpSession session, HttpServletRequest request, HttpServletResponse response, HttpSession session1, HttpServletRequest request1, HttpServletResponse response1){
        Map map=new HashMap();
        map.put("33","88");
        map.put("444",999);
        return map;
    }

}
