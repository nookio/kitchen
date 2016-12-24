package controllers;

import annotions.BBCommand;
import com.alibaba.fastjson.JSON;
import com.google.inject.Inject;
import form.staff.StaffRegisterForm;
import helper.Response;
import models.Staff;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.StaffService;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/9 下午4:51
 * @Descrition:
 */
public class StaffController extends Controller {

    @Inject
    private StaffService staffService;

    @BodyParser.Of(BodyParser.Json.class)
    @BBCommand(checkToken = false, form = StaffRegisterForm.class)
    public Result staffLogin(){
        StaffRegisterForm form = (StaffRegisterForm) ctx().args.get("--");
        Staff staff = staffService.login(form.getUsername(), form.getPassword());
        session().put("user", JSON.toJSONString(staff));
        return Response.getSuccessResult(staff);
    }

    @BodyParser.Of(BodyParser.Json.class)
    @BBCommand(checkToken = false, form = StaffRegisterForm.class)
    public Result staffLogout(){
        StaffRegisterForm form = (StaffRegisterForm) ctx().args.get("--");
        Staff staff = staffService.login(form.getUsername(), form.getPassword());
        session().remove("user");
        return Response.getSuccessResult("ok");
    }


}
