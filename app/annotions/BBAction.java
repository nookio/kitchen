package annotions;

import com.alibaba.fastjson.JSON;
import exception.KitchenException;
import helper.Response;
import models.Staff;
import play.Logger;
import play.data.Form;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import utils.ERROR;

import java.util.concurrent.CompletionStage;

import static play.mvc.Controller.session;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/9 下午5:00
 * @Descrition:
 */
public class BBAction extends Action<BBCommand> {

    Logger.ALogger logger = Logger.of(BBAction.class);


    @Override
    public CompletionStage<Result> call(Http.Context ctx) {
        CompletionStage<Result> result = null;
        try{
            if (configuration.checkToken() == true && null == session("user")){
                throw new KitchenException(ERROR.INVALID_TOKEN);
            }
            if (session("user") != null){
                String asd = session("user");
                ctx.args.put("user", JSON.parseObject(session("user"), Staff.class));
            }
            Form<?> form = Form.form(configuration.form()).bindFromRequest();
            ctx.args.put("--", form.get());
            result = delegate.call(ctx);
        }catch (KitchenException k){
            logger.warn("业务阻塞,阻塞内容{}", k.getMessage());
            return F.Promise.pure(Response.getErrorResult(k));
        }catch (Exception e) {
            logger.error("服务器异常,阻塞内容{}", e);
            return F.Promise.pure(Response.getErrorResult(e));
        }
        return result;
    }
}
