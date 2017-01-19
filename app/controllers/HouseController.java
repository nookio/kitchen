package controllers;

import annotions.BBCommand;
import com.google.inject.Inject;
import form.house.*;
import helper.Page;
import helper.Response;
import models.Contact;
import models.Credential;
import models.House;
import play.api.libs.iteratee.Cont;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.CredentialService;
import services.HouseService;
import services.PictureService;
import views.html.list;
import vo.HouseVo;
import vo.HousesVo;

import java.util.List;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/11 上午2:19
 * @Descrition:
 */
public class HouseController extends Controller {

    @Inject
    private HouseService houseService;

    @Inject
    private CredentialService credentialService;

    @Inject
    PictureService pictureService;


    @BodyParser.Of(BodyParser.Json.class)
    @BBCommand(form = HouseQueryForm.class)
    public Result query() {
        HouseQueryForm form = (HouseQueryForm) ctx().args.get("--");
        Page<House> houses = houseService.list(form);
        return Response.getSuccessResult(HousesVo.transformFromHouse(houses));
    }

    @BodyParser.Of(BodyParser.Json.class)
    @BBCommand(form = HouseGetForm.class)
    public Result get() {
        HouseGetForm form = (HouseGetForm) ctx().args.get("--");
        House house = houseService.get(form.getId());
        Credential credential = credentialService.byHouseId(house.getId());
        house.setCredential(credential);
        house.setPictures(pictureService.byHouseId(house.getId()));
        Contact contact = null;
        if (null != house.getContactId()){
            contact = Contact.finder.byId(house.getContactId());
        }
        return Response.getSuccessResult(HouseVo.transformFromHouse(house, contact));
    }


    public Result houseList() {
        HouseQueryForm form = (HouseQueryForm) ctx().args.get("--");
        List<House> houses = houseService.list(0, 10);
        return ok(list.apply());
    }

    @BodyParser.Of(BodyParser.Json.class)
    @BBCommand(form = HouseAreaForm.class)
    public Result updateHouseArea() {
        HouseAreaForm form = (HouseAreaForm) ctx().args.get("--");
        boolean result = houseService.updateArea(form.getHouseId(), form);
        return Response.getSuccessResult(result);
    }

    @BodyParser.Of(BodyParser.Json.class)
    @BBCommand(form = HouseCostForm.class)
    public Result updateHouseCost() {
        HouseCostForm form = (HouseCostForm) ctx().args.get("--");
        boolean result = houseService.updateCost(form.getHouseId(), form);
        return Response.getSuccessResult(result);
    }

    @BodyParser.Of(BodyParser.Json.class)
    @BBCommand(form = HouseEvaluateForm.class)
    public Result updateHouseEvaluate() {
        HouseEvaluateForm form = (HouseEvaluateForm) ctx().args.get("--");
        boolean result = houseService.updateEvaluate(form.getHouseId(), form);
        return Response.getSuccessResult(result);
    }

    @BodyParser.Of(BodyParser.Json.class)
    @BBCommand(form = HouseForm.class)
    public Result updateHouse() {
        HouseForm form = (HouseForm) ctx().args.get("--");
        boolean result = houseService.update(form.getHouseId(), form);
        return Response.getSuccessResult(result);
    }

    @BodyParser.Of(BodyParser.Json.class)
    @BBCommand(form = HouseFacilityForm.class)
    public Result updateHouseFacility() {
        HouseFacilityForm form = (HouseFacilityForm) ctx().args.get("--");
        boolean result = houseService.updateFacility(form.getHouseId(), form);
        return Response.getSuccessResult(result);
    }

    @BodyParser.Of(BodyParser.Json.class)
    @BBCommand(form = HousePositionForm.class)
    public Result updateHousePosition() {
        HousePositionForm form = (HousePositionForm) ctx().args.get("--");
        boolean result = houseService.updatePosition(form.getHouseId(), form);
        return Response.getSuccessResult(result);
    }

    @BodyParser.Of(BodyParser.Json.class)
    @BBCommand(form = HouseRentForm.class)
    public Result updateHouseRent() {
        HouseRentForm form = (HouseRentForm) ctx().args.get("--");
        boolean result = houseService.updateRent(form.getHouseId(), form);
        return Response.getSuccessResult(result);
    }

    @BodyParser.Of(BodyParser.Json.class)
    @BBCommand(form = NewHouseForm.class)
    public Result addHouse() {
        NewHouseForm form = (NewHouseForm) ctx().args.get("--");
        House house = form.toHouse();
        house.setStatus(House.NORMAL);
        Contact contact = form.toContact();
        contact.save();
        house.setContactId(contact.getId());
        Credential credential = form.toCredential();
        house.setCredential(credential);
        house.save();
        credential.setHouseId(house.getId());
        credential.save();
        return Response.getSuccessResult(house);
    }

    public Result add() {
        House result = houseService.generate();
        return Response.getSuccessResult(result);
    }


}
