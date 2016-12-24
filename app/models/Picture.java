package models;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/7 上午12:08
 * @Descrition:
 */
@Entity
public class Picture extends Base {

    public final static Finder<Integer, Picture> finder = new Finder<Integer, Picture>(Picture.class);


    @Column
    private Integer houseId;

    @Column
    private String url;

    @Column
    private Integer status;

    @Column
    private Integer name;

    @Column
    private String md5;

    @Column
    private Long size;

    @Column
    private Integer meta;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getMeta() {
        return meta;
    }

    public void setMeta(Integer meta) {
        this.meta = meta;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
}
