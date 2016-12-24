package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meiyuan.com
 * @Date: 16/12/6 下午1:21
 * @Descrition: TODO
 */
@MappedSuperclass
public abstract class Base extends Model {

    public static final int INIT = 1;     //初始化
    public static final int NORMAL = 2;   //正常
    public static final int FROZEN = 3;   //冻结
    public static final int DELETED = 4;  //删除

    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
