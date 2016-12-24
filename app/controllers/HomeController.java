package controllers;

import com.google.inject.Inject;
import models.House;
import models.address.Area;
import play.mvc.*;

import services.HouseService;
import views.html.*;
import views.html.house.houseShow;
import views.html.house.houses;
import views.html.staff.login;

import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    private HouseService houseService;

    public Result house(Integer id) {
        House house = houseService.get(id);
        return ok(houseShow.apply(house));
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
        return Results.TODO;
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
