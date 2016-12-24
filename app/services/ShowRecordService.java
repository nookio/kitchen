package services;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.PagedList;
import exception.KitchenException;
import form.record.ShowRecordForm;
import form.record.ShowRecordQueryForm;
import models.ShowRecord;
import helper.Page;
import models.Staff;
import play.Logger;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/6 下午4:19
 * @Descrition:
 */
public class ShowRecordService {

    private static final Logger.ALogger logger = Logger.of(ShowRecordService.class);

    String CHECK_SQL = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"+
            "(\\b(select|update|and|or|delete|insert|trancate|char|into|" +
            "substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";


    public ShowRecord addNew(String content, Integer staffId, Integer houseId){
        if (Pattern.matches(CHECK_SQL,content)) throw new KitchenException("含有非法字符");
        ShowRecord showRecord = ShowRecord.generateNew(staffId, houseId, content);
        showRecord.save();
        return showRecord;
    }

    public ShowRecord addNew(ShowRecordForm form, Staff staff) {
        if (Pattern.matches(CHECK_SQL, form.getContent())) throw new KitchenException("含有非法字符");
        ShowRecord showRecord = ShowRecord.generateNew(staff.getId(), form.getClientName(), form.getDate(),
                form.getHouseId(), form.getContent());
        showRecord.save();
        return showRecord;
    }

    public ShowRecord delete(Integer evaluateId){
        ShowRecord showRecord = ShowRecord.finder.byId(evaluateId);
        if (null == showRecord){
            logger.warn("记录不存在");
            throw new KitchenException("记录不存在");
        }
        showRecord.setStatus(ShowRecord.DELETED);
        showRecord.save();
        return showRecord;
    }

    public PagedList<ShowRecord> listByStaff(ShowRecordQueryForm form, Staff staff){
        ExpressionList<ShowRecord> where = ShowRecord.finder.query().where();
        if (form.getHouseId() != null){
            where.eq("house_id", form.getHouseId());
        }
        if (form.getStaffId() != null){
            where.eq("staff_id", form.getStaffId());
        }
        PagedList<ShowRecord> result = where.findPagedList(form.getPage(), form.getSize());
        return result;
    }

    public List<ShowRecord> list(Integer page, Integer size){
        return ShowRecord.finder.query().findPagedList(page, size).getList();
    }

    public Page<ShowRecord> pagedList(Integer page, Integer size){
        PagedList<ShowRecord> list = ShowRecord.finder.query().findPagedList(page, size);
        return new Page<ShowRecord>(list);
    }

    public Page<ShowRecord> pagedStaffList(Integer staffId, Integer page, Integer size, Integer houseId){
        PagedList<ShowRecord> list = ShowRecord.finder.query().where()
                .eq("staffId", staffId).eq("houseId", houseId)
                .findPagedList(page, size);
        return new Page<ShowRecord>(list);
    }

}
