package controllers;

import annotions.BBCommand;
import com.avaje.ebean.PagedList;
import com.google.inject.Inject;
import form.record.ShowRecordForm;
import form.record.ShowRecordQueryForm;
import helper.Page;
import helper.Response;
import models.ShowRecord;
import models.Staff;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.ShowRecordService;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/14 下午3:23
 * @Descrition:
 */
public class ShowRecordController extends Controller {

    @Inject
    ShowRecordService showRecordService;

    @BodyParser.Of(BodyParser.Json.class)
    @BBCommand(form = ShowRecordForm.class)
    public Result add() {
        ShowRecordForm form = (ShowRecordForm) ctx().args.get("--");
        Staff staff = (Staff) ctx().args.get("user");
        ShowRecord record = showRecordService.addNew(form, staff);
        return Response.getSuccessResult(record);
    }


    @BodyParser.Of(BodyParser.Json.class)
    @BBCommand(form = ShowRecordQueryForm.class)
    public Result query() {
        ShowRecordQueryForm form = (ShowRecordQueryForm) ctx().args.get("--");
        Staff staff = (Staff) ctx().args.get("user");
        PagedList<ShowRecord> record = showRecordService.listByStaff(form, staff);
        return Response.getSuccessResult(new Page<>(record));
    }


}
