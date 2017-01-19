package models.address;

import com.avaje.ebean.Model;
import models.Base;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meiyuan.com
 * @Date: 16/12/6 上午10:47
 * @Descrition: TODO
 */
@Entity
public class Area extends Base {

    public final static Finder<Integer, Area> finder = new Finder<Integer, Area>(Area.class);

    @Column
    private Integer code;

    @Column
    private String name;


    @Column
    private Integer cityCode;

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Area setName(String name) {
        this.name = name;
        return this;
    }
}
