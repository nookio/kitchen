package services;

import com.avaje.ebean.Finder;
import models.address.Area;
import models.address.City;
import models.address.District;
import models.address.Province;
import play.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/6 下午3:58
 * @Descrition:
 */
public class AddressService {


    public static Map<Integer, Province> PROVINCE_MAP = new HashMap<>();
    public static Map<Integer, City> CITY_MAP = new HashMap<>();
    public static Map<Integer, Area> AREA_MAP = new HashMap<>();
    public static Map<Integer, District> DISTRICT_MAP = new HashMap<>();

    static {
        PROVINCE_MAP = Province.finder.all().stream().collect(Collectors.toMap(Province::getCode, c->c));
        CITY_MAP = City.finder.all().stream().collect(Collectors.toMap(City::getCode, c->c));
        AREA_MAP = Area.finder.all().stream().collect(Collectors.toMap(Area::getCode, a->a));
        DISTRICT_MAP = District.finder.all().stream().collect(Collectors.toMap(District::getCode, c->c));
    }

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
