package models;


import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meiyuan.com
 * @Date: 16/12/6 上午10:51
 * @Descrition: TODO
 */
@Entity
public class Credential extends Base {

    public final static Finder<Integer, Credential> finder = new Finder<Integer, Credential>(Credential.class);

    @Column
    private Integer houseId;

    @Column
    private Integer businessLicence = 0; //营业执照

    @Column
    private Integer wholeBusiness = 0; //是否大照

    @Column
    private Integer foodAndBeverageBusinessLicense = 0;  //餐饮经营许可证

    @Column
    private Integer fireSafetyPermission = 0; //消防许可证

    @Column
    private Integer invoice = 0; //发票

//    @OneToOne
//    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
//    public House houseShow;

    @Column
    @UpdatedTimestamp
    private Date updated_date;

    @Column
    @CreatedTimestamp
    private Date created_date;

    public Integer getBusinessLicence() {
        return businessLicence;
    }

    public void setBusinessLicence(Integer businessLicence) {
        this.businessLicence = businessLicence;
    }

    public Integer getWholeBusiness() {
        return wholeBusiness;
    }

    public void setWholeBusiness(Integer wholeBusiness) {
        this.wholeBusiness = wholeBusiness;
    }

    public Integer getFoodAndBeverageBusinessLicense() {
        return foodAndBeverageBusinessLicense;
    }

    public void setFoodAndBeverageBusinessLicense(Integer foodAndBeverageBusinessLicense) {
        this.foodAndBeverageBusinessLicense = foodAndBeverageBusinessLicense;
    }

    public Integer getFireSafetyPermission() {
        return fireSafetyPermission;
    }

    public void setFireSafetyPermission(Integer fireSafetyPermission) {
        this.fireSafetyPermission = fireSafetyPermission;
    }

    public Integer getInvoice() {
        return invoice;
    }

    public void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

//    public House getHouse() {
//        return houseShow;
//    }
//
//    public void setHouse(House houseShow) {
//        this.houseShow = houseShow;
//    }
}
