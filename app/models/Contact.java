package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import models.enums.ContactEnums;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/8 下午1:00
 * @Descrition:
 */
@Entity
public class Contact extends Base {

    public final static Finder<Integer, Contact> finder = new Finder<Integer, Contact>(Contact.class);

    @Column
    private String name; //姓名

    @Column
    private String mobile; //电话

    @Column
    private Integer type = ContactEnums.OWNER_CONTACT; //默认是业主

    @Column
    @UpdatedTimestamp
    private Date updatedDate;

    @Column
    @CreatedTimestamp
    private Date createdDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
}
