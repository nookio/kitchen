package services;

import exception.KitchenException;
import models.Facility;
import play.Logger;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/8 下午3:53
 * @Descrition:
 */
public class FacilityService {

    private static final Logger.ALogger logger = Logger.of(ShowRecordService.class);

    public Facility getByHouseId(Integer houseId){
        List<Facility> results = Facility.finder.where().eq("houseId", houseId).eq("status", Facility.NORMAL).findList();
        if (results.size() == 1) return results.get(1);
        if (results.size() == 0) return new Facility();
        throw new KitchenException("数据有误,出现多条");
    }

    public Facility update(Facility facility){
        try {
            if (facility.getStatus().equals(Facility.INIT)){
                facility.setStatus(Facility.NORMAL);
            }
            facility.save();
        }catch (Exception e){
            logger.warn("存储错误{}",e);
            throw new KitchenException("出现错误");
        }
        return facility;
    }

    public Map<Integer ,Facility> maped(Collection<Integer> houseIds){
        return list(houseIds).stream().collect(Collectors.toMap(Facility::getHouseId, f->f));
    }

    public List<Facility> list(Integer page, Integer size){
        return Facility.finder.query().findPagedList(page, size).getList();
    }

    public List<Facility> list(Collection<Integer> houseIds){
        return Facility.finder.query().where().in("houseId", houseIds).findList();
    }

}
