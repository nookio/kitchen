package form.record;

import form.BaseForm;
import form.BasePageForm;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/14 下午3:36
 * @Descrition:
 */
public class ShowRecordQueryForm extends BasePageForm {

    private Integer staffId;

    private Integer houseId;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
}
