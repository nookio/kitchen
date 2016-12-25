package services;

import com.avaje.ebean.Finder;
import models.address.Area;
import models.address.City;
import models.address.Province;
import play.Logger;

import java.util.List;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/6 下午3:58
 * @Descrition:
 */
public class AddressService {

    private static final Logger.ALogger logger = Logger.of(StaffService.class);

    public List<Province> allProvince(){
        return Province.finder.all();
    }

    public List<City> provinceCities(Integer provinceCode){
        return City.finder.query().where().eq("provinceCode", provinceCode).findList();
    }

    public List<Area> cityAreas(Integer cityCode){
        return Area.finder.query().where().eq("cityCode", cityCode).findList();
    }

}
