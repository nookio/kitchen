package controllers;

import com.google.inject.Inject;
import helper.Response;
import play.mvc.Controller;
import play.mvc.Result;
import services.AddressService;

/**
 * Created by kris on 16/12/25.
 */
public class AddressController extends Controller {

    @Inject
    private AddressService addressService;

    public Result provinces(){
        return Response.getSuccessResult(addressService.allProvince());
    }

    public Result cities(Integer provinceCode){
        return Response.getSuccessResult(addressService.provinceCities(provinceCode));
    }

    public Result areas(Integer cityCode){
        return Response.getSuccessResult(addressService.cityAreas(cityCode));
    }

}
