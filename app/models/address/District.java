package models.address;

import models.Base;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/8 下午1:34
 * @Descrition:
 */
@Entity
public class District extends Base {


    public final static Finder<Integer, District> finder = new Finder<Integer, District>(District.class);

    @Column
    private Integer code;

    @Column
    private String name;

    @Column
    private Integer areaCode;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }
}
