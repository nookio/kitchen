package models;


import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
    private Integer businessLicence; //营业执照

    @Column
    private Integer wholeBussiness; //是否大照

    @Column
    private Integer foodAndBeverageBusinessLicense;  //餐饮经营许可证

    @Column
    private Integer fireSafetyPermition; //消防许可证

    @Column
    private Integer invoice; //发票

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

    public Integer getWholeBussiness() {
        return wholeBussiness;
    }

    public void setWholeBussiness(Integer wholeBussiness) {
        this.wholeBussiness = wholeBussiness;
    }

    public Integer getFoodAndBeverageBusinessLicense() {
        return foodAndBeverageBusinessLicense;
    }

    public void setFoodAndBeverageBusinessLicense(Integer foodAndBeverageBusinessLicense) {
        this.foodAndBeverageBusinessLicense = foodAndBeverageBusinessLicense;
    }

    public Integer getFireSafetyPermition() {
        return fireSafetyPermition;
    }

    public void setFireSafetyPermition(Integer fireSafetyPermition) {
        this.fireSafetyPermition = fireSafetyPermition;
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
