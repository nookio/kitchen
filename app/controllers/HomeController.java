package controllers;

import com.google.inject.Inject;
import helper.Response;
import models.Contact;
import models.Credential;
import models.House;
import models.address.Area;
import models.address.City;
import models.address.District;
import models.address.Province;
import play.mvc.*;

import services.CredentialService;
import services.HouseService;
import services.PictureService;
import views.html.*;
import views.html.house.houseAdd;
import views.html.house.houseShow;
import views.html.house.houses;
import views.html.staff.login;
import vo.HouseVo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    private HouseService houseService;

    @Inject
    private CredentialService credentialService;

    @Inject
    PictureService pictureService;


    public Result house(Integer id) {
        House house =  houseService.get(id);
        Credential credential = credentialService.byHouseId(house.getId());
        house.setCredential(credential);
        house.setPictures(pictureService.byHouseId(house.getId()));
        return ok(houseShow.apply(HouseVo.transformFromHouse(house,
                Contact.finder.byId(house.getContactId()))));
    }

    public Result jsp() {
        House house = houseService.get(1);
        return ok(jsq.apply(house));
    }

    public Result home(){
        return ok(home.apply());
    }

    public Result show(Integer houseId) {
        House house = houseService.get(houseId);
        return ok(show.apply(house));
    }

    public Result showCase() {
//        return ok(search.apply());
        return TODO;
    }

    public Result editHouse() {
        return Results.TODO;
    }

    public Result houses() {
        return ok(houses.apply());
    }

    public Result addHouse() {
        return ok(houseAdd.apply());
    }

    public Result header() {
        if (null == session("user")) redirect("/staff/login");
        return ok(header.apply(session("user")));
    }


    public Result boot() {
        return ok(boot.apply());
    }

    public Result getAreas() {
        List<Area> areas = Area.finder.where().eq("cityCode", 110100).findList();
        return ok(areas.toString());
    }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result login(){
        return ok(login.render("welcome"));
    }


//    public Result houses() {
//        return ok(houses.render(Area.finder.where().eq("id", 1).findUnique()));
//    }


}
