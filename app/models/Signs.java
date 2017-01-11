package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import models.enums.Sign;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 17/1/11 下午3:58
 * @Descrition:
 */
@Entity
public class Signs extends Base {

    @Column
    private Integer houseCode;

    @Column
    private Integer signCode;

    @Column
    private String signName;

    @Column
    @UpdatedTimestamp
    private Date updatedDate;

    @Column
    @CreatedTimestamp
    private Date createdDate;

    public Signs(Integer signCode) {
        Sign sign = Sign.signs.getOrDefault(signCode, Sign.DEFAULT);
        this.signCode = signCode;
        this.signName = sign.getName();
    }

    public Integer getSignCode() {
        return signCode;
    }

    public void setSignCode(Integer signCode) {
        this.signCode = signCode;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public Integer getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(Integer houseCode) {
        this.houseCode = houseCode;
    }
}
