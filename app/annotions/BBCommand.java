package annotions;

import form.BaseForm;
import play.mvc.BodyParser;
import play.mvc.With;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/9 下午5:00
 * @Descrition:
 */
@With(BBAction.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BBCommand {

    boolean checkToken() default true;

    Class<? extends BaseForm> form();

}
