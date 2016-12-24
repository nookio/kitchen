package services;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Query;
import exception.KitchenException;
import form.house.*;
import models.Credential;
import models.House;
import helper.Page;
import play.Logger;
import utils.ERROR;

import java.util.List;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/8 下午4:13
 * @Descrition:
 */
public class HouseService {

    private static final Logger.ALogger logger = Logger.of(HouseService.class);

    public Page<House> pList(Integer page, Integer size){
        return new Page<House>(House.finder.query().findPagedList(page, size));
    }

    public Page<House> list(HouseQueryForm form){
        Query query = House.finder.query();
        ExpressionList where = query.where();
        if (form.getAcreagenS() != null && form.getAcreagenE() != null){
            where.between("areas", form.getAcreagenS(), form.getAcreagenE());
        }
        if (form.getChummageDailyS() != null && form.getChummageDailyE() != null){
            where.between("chummage_daily", form.getChummageDailyS(), form.getChummageDailyE());
        }
        if (form.getDistrictCode() != null){
            where.eq("district_code", form.getDistrictCode());
        }
        /**
         private List<Integer> signs; //标志建筑物
         */
        if (form.getPower() != null) {
            where.eq("power", form.getPower());
        }
        if (form.getDownPipe() != null ){
            where.eq("down_pipe", form.getDownPipe());
        }
        if (form.getGasCylinders() != null){
            where.eq("gas_cylinders", form.getGasCylinders());
        }
        if (form.getFire() != null){
            where.eq("fire", form.getFire());
        }
        if (form.getDuct() != null){
            where.eq("duct",form.getDuct());
        }
        if (form.getBlowOff() != null){
            where.eq("blow_off", form.getBlowOff());
        }
        if (form.getGreaseTrap() != null){
            where.eq("grease_trap", form.getGreaseTrap());
        }
        if (form.getOilFume() != null){
            where.eq("oil_fume", form.getOilFume());
        }
        if (form.getHouseType() != null){
            where.in("house_type", form.getHouseType());
        }
        if (form.getHouseLevel() != null){
            where.in("house_level", form.getHouseLevel());
        }
        if (form.getHouseSource() != null){
            where.in("house_source", form.getHouseSource());
        }
        return new Page<House>(where.findPagedList(form.getPage(), form.getSize()));

    }



    public List<House> list(Integer page, Integer size){
        return House.finder.query().findPagedList(page, size).getList();
    }

    public House byId(Integer id){
        House exist = House.finder.byId(id);
        if (null == exist){
            logger.warn("记录不存在");
            throw new KitchenException("记录不存在");
        }
        if (!exist.getStatus().equals(House.NORMAL)) {
            logger.warn("数据状态不正常");
            throw new KitchenException("记录不存在");
        }
        return exist;
    }

    public boolean update(House house){
        try {
            house.save();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public House addNew(House house){
        house.save();
        return house;
    }

    public boolean updatePosition(Integer id, HousePositionForm position){
        try{
            House old = byId(id);
            old.setPosition(position);
            old.save();
        }catch (Exception e){
            logger.warn("出现异常{}", e);
            return false;
        }
        return true;
    }

    public boolean updateFacility(Integer id, HouseFacilityForm position){
        try{
            House old = byId(id);
            old.setFacility(position);
            old.save();
        }catch (Exception e){
            logger.warn("出现异常{}", e);
            return false;
        }
        return true;
    }

    public boolean updateArea(Integer id, HouseAreaForm area){
        try{
            House old = byId(id);
            old.setArea(area);
            old.save();
        }catch (Exception e){
            logger.warn("出现异常{}", e);
            return false;
        }
        return true;
    }

    public boolean updateCost(Integer id, HouseCostForm cost){
        try{
            House old = byId(id);
            old.setCost(cost);
            old.save();
        }catch (Exception e){
            logger.warn("出现异常{}", e);
            return false;
        }
        return true;
    }

    public boolean updateEvaluate(Integer id, HouseEvaluateForm evaluate){
        try{
            House old = byId(id);
            old.setEvaluate(evaluate);
            old.save();
        }catch (Exception e){
            logger.warn("出现异常{}", e);
            return false;
        }
        return true;
    }

    public boolean updateRent(Integer id, HouseRentForm rent){
        try{
            House old = byId(id);
            old.setRent(rent);
            old.save();
        }catch (Exception e){
            logger.warn("出现异常{}", e);
            return false;
        }
        return true;
    }

    public boolean update(Integer id, HouseForm house){
        try{
            House old = byId(id);
            old.setHouse(house);
            old.save();
        }catch (Exception e){
            logger.warn("出现异常{}", e);
            return false;
        }
        return true;
    }


    public House get(Integer id) {
        House house = House.finder.byId(id);
        if (null == house) throw new KitchenException(ERROR.NULL_OBJECT, "房源不存在");
        if (!house.getStatus().equals(House.NORMAL))
            throw new KitchenException(ERROR.STATUS_ERROR, "房源已经被删除");
        return house;
    }

    public House generate(){
        House house = new House();
        house.save();
        return house;
    }
}
