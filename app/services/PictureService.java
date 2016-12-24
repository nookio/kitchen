package services;

import models.Picture;

import java.util.List;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/14 下午4:45
 * @Descrition:
 */
public class PictureService {


    public List<Picture> byHouseId(Integer houseId) {
        return Picture.finder.query().where().eq("houseId", houseId).findList();
    }
}
