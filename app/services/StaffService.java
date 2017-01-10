package services;

import com.avaje.ebean.Finder;
import exception.KitchenException;
import models.Staff;
import play.Logger;
import utils.ERROR;

import java.util.List;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/6 下午2:07
 * @Descrition:
 */
public class StaffService {

    private static final Logger.ALogger logger = Logger.of(StaffService.class);

    public Staff login(String username, String password){
        List<Staff> staffs = Staff.finder.query().where().eq("username", username).findList();
        if (staffs.size() == 0 ){
            logger.warn("用户不存在");
            throw new KitchenException(ERROR.STAFF_NOT_EXIST);
        }
        Staff staff = staffs.get(0);
        if (!staff.checkPassword(password)){
            logger.warn("密码不正确");
            throw new KitchenException(ERROR.STAFF_WRONG_PASSWORD);
        }
        if (!staff.getStatus().equals(Staff.NORMAL)){
            logger.warn("账号状态不正确");
            throw new KitchenException(ERROR.STAFF_STATUS_BAD_STATUS);
        }
        return staff;
    }

    public Staff byId(Integer id){
        Staff staff = Staff.finder.byId(id);
        if (null == staff){
            logger.warn("用户不存在");
            throw new KitchenException("用户不存在");
        }
        if (!staff.getStatus().equals(Staff.NORMAL)){
            logger.warn("账号状态不正确");
            throw new KitchenException("账号状态不正确");
        }
        return staff;
    }


    public Staff delete(Integer id){
        Staff staff = Staff.finder.byId(id);
        if (null == staff){
            logger.warn("用户不存在");
            throw new KitchenException("用户不存在");
        }
        if (!staff.getStatus().equals(Staff.NORMAL)){
            logger.warn("账号状态不正确");
            throw new KitchenException("账号状态不正确");
        }
        staff.setStatus(Staff.DELETED);
        staff.save();
        return staff;
    }

    public Staff addNew(String username, String password, Integer title){
        Staff staff = Staff.finder.query().where().eq("username", username).findUnique();
        if (null != staff){
            logger.warn("用户名已经存在");
            throw new KitchenException("用户已经存在");
        }
        staff = new Staff(username, password, title);
        if (!staff.getStatus().equals(Staff.NORMAL)){
            logger.warn("账号状态不正确");
            throw new KitchenException("账号状态不正确");
        }
        staff.setStatus(Staff.DELETED);
        staff.save();
        return staff;
    }

    public Staff changePassword(Integer id, String newPassword){
        Staff staff = Staff.finder.byId(id);
        if (null == staff) {
            logger.warn("用户不存在");
            throw new KitchenException("用户不存在");
        }
        if (!staff.getStatus().equals(Staff.NORMAL)){
            logger.warn("账号状态不正确");
            throw new KitchenException("账号状态不正确");
        }
        staff.setPassword(newPassword);
        staff.save();
        return staff;
    }



}
