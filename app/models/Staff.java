package models;

import com.avaje.ebean.Finder;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/6 下午2:04
 * @Descrition:
 */
@Entity
public class Staff extends Base {

    public final static Finder<Integer, Staff> finder = new Finder<Integer, Staff>(Staff.class);

    @Column
    private String username;

    @Column
    private String password;

    @Column
    @UpdatedTimestamp
    private Date updated_date;

    @Column
    @CreatedTimestamp
    private Date created_date;

    @Column
    private Integer title;

    @Column
    private Integer status;

    public Staff() {
    }

    public Staff(String password, String username, Integer title) {
        this.password = password;
        this.title = title;
        this.status = NORMAL;
        this.username = username;
    }

    public boolean checkPassword(String password){
        if (StringUtils.isNotBlank(password) && this.password.equals(password)) return true;
        return false;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }
}
