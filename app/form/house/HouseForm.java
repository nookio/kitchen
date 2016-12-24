package form.house;

import form.BaseForm;

import java.util.Date;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/8 下午6:13
 * @Descrition:
 */
public class HouseForm extends BaseForm{

    private Integer houseId;

    //经营状态
    private Integer business; //经营业态

    private String businessName; //经营业态

    private String businessStatus; //经营业态

    //租约相关
    private Date nextPayRentDate; //下次交租日

    private String maxRentYear; //最大可租年

    private Integer repetition; //可以重复签约

    //其它
    private String desc;

    private Integer houseSource;

    private String sourceName;

    private Integer status;

    public Integer getBusiness() {
        return business;
    }

    public void setBusiness(Integer business) {
        this.business = business;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public Date getNextPayRentDate() {
        return nextPayRentDate;
    }

    public void setNextPayRentDate(Date nextPayRentDate) {
        this.nextPayRentDate = nextPayRentDate;
    }

    public String getMaxRentYear() {
        return maxRentYear;
    }

    public void setMaxRentYear(String maxRentYear) {
        this.maxRentYear = maxRentYear;
    }

    public Integer getRepetition() {
        return repetition;
    }

    public void setRepetition(Integer repetition) {
        this.repetition = repetition;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getHouseSource() {
        return houseSource;
    }

    public void setHouseSource(Integer houseSource) {
        this.houseSource = houseSource;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
}
