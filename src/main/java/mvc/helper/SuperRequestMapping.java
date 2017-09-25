package mvc.helper;

import java.lang.annotation.*;

/**
 * Created by 伟 on 2017/9/25.
 */

//.TYPE:用于描述类、接口(包括注解类型) 或enum声明
@Target({ElementType.TYPE, ElementType.METHOD})
//注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
@Retention(RetentionPolicy.RUNTIME)
//在使用此自定义注解时，如果注解在类上面时，子类会自动继承此注解，否则的话，子类不会继承此注解
@Inherited
//Documented 注解表明这个注解应该被 javadoc工具记录
@Documented
public @interface SuperRequestMapping {
}
