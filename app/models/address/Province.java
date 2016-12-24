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
public class Province extends Base {

    public final static Finder<Integer, Province> finder = new Finder<Integer, Province>(Province.class);

    @Column
    private Integer code;

    @Column
    private String name;

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
}
