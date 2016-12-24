package services;

import com.avaje.ebean.PagedList;
import models.Credential;
import play.Logger;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/14 下午4:26
 * @Descrition:
 */
public class CredentialService {

    private static final Logger.ALogger logger = Logger.of(CredentialService.class);

    public Credential byHouseId(Integer houseId) {
        PagedList<Credential> credentials = Credential.finder.where()
                .eq("houseId", houseId)
//                .eq("status", Credential.NORMAL)
                .findPagedList(0, 10);
        if (credentials.getTotalRowCount() >1 ){
            logger.error("Credential出现重复数据{}",houseId);
            return credentials.getList().get(1);
        }
        if (credentials.getTotalRowCount() == 1) {
            return credentials.getList().get(0);
        }
        else return new Credential();
    }
}
