package form.house;


import form.BaseForm;

import javax.validation.constraints.NotNull;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/8 下午5:03
 * @Descrition:
 */
public class HousePositionForm extends BaseForm{

    private Integer houseId;

    @NotNull(message = "省份不能为空")
    private Integer provinceCode;

    @NotNull(message = "城市不能为空")
    private Integer cityCode;

    @NotNull(message = "区域不能为空")
    private Integer areaCode;

    private Integer districtCode;

    private String address;

    private String longitude; //经度

    private String latitude; //经度

    private String sign; //标志建筑物

    private String mapUrl;

    private String mapUrlType;

    private String wholeMapUrl;

    private String hotMapUrl;

    public Integer getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(Integer districtCode) {
        this.districtCode = districtCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public String getMapUrlType() {
        return mapUrlType;
    }

    public void setMapUrlType(String mapUrlType) {
        this.mapUrlType = mapUrlType;
    }

    public String getWholeMapUrl() {
        return wholeMapUrl;
    }

    public void setWholeMapUrl(String wholeMapUrl) {
        this.wholeMapUrl = wholeMapUrl;
    }

    public String getHotMapUrl() {
        return hotMapUrl;
    }

    public void setHotMapUrl(String hotMapUrl) {
        this.hotMapUrl = hotMapUrl;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
}
