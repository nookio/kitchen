package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meiyuan.com
 * @Date: 16/12/6 上午10:49
 * @Descrition: TODO
 */
@Entity
public class ShowRecord extends Base {

    public final static Finder<Integer, ShowRecord> finder = new Finder<Integer, ShowRecord>(ShowRecord.class);

    @Column
    private Integer staffId;

    @Column
    private Integer houseId;

    @Column
    @Size(max = 500)
    private String content;

    @Column
    private Integer status;

    @Column
    private Date showDate;

    @Column
    private String clientName;

    @Column
    private Date date;

    @Column
    @UpdatedTimestamp
    private Date updated_date;

    @Column
    @CreatedTimestamp
    private Date created_date;


    public static ShowRecord generateNew(Integer staffId, Integer houseId, String content) {
        ShowRecord showRecord = new ShowRecord();
        showRecord.setContent(content);
        showRecord.setHouseId(houseId);
        showRecord.setStaffId(staffId);
        showRecord.setStatus(NORMAL);
        return showRecord;
    }

    public static ShowRecord generateNew(Integer staffId,
                                         String clientName, String date, Integer houseId, String content) {
        ShowRecord showRecord = new ShowRecord();
        showRecord.setClientName(clientName);
        showRecord.setDate(new Date(Long.valueOf(date)));
        showRecord.setContent(content);
        showRecord.setHouseId(houseId);
        showRecord.setStaffId(staffId);
        showRecord.setStatus(NORMAL);
        return showRecord;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
