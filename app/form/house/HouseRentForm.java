package form.house;

import form.BaseForm;

import javax.persistence.Column;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/8 下午6:10
 * @Descrition:
 */
public class HouseRentForm extends BaseForm{

    private Integer houseId;

    private Integer rentBusinessType;

    private Integer rentStatus;

    public Integer getRentBusinessType() {
        return rentBusinessType;
    }

    public void setRentBusinessType(Integer rentBusinessType) {
        this.rentBusinessType = rentBusinessType;
    }

    public Integer getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(Integer rentStatus) {
        this.rentStatus = rentStatus;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
}
