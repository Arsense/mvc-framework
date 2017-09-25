package mvc.controller;

import mvc.main.function.helper.SuperRequestMapping;
import mvc.main.function.helper.SuperRequestMethod;

/**
 * Created by 伟 on 2017/9/22.
 */
@SuperRequestMapping(path = "/demo" )
public class TestController{


    @SuperRequestMapping(path="/test1",method = SuperRequestMethod.GET)
    public String function1(){
        return "test";
    }

}
