package form.house;


import form.BaseForm;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/8 下午5:31
 * @Descrition:
 */
public class HouseAreaForm extends BaseForm{
    private Integer houseId;

    private Integer houseType;

    private Integer ownerType;

    private String owner;

    private String contactMobile;

    private String contact;

    private Integer contactType;

    private Integer propertyRightType;

    private String floor;

    private String maxFloor;

    private Long areas;

    private Long effien; //得房率

    private Integer showLength; //展示面宽度

    private Integer rentType; //0:不整租, 1:整租

    private Long shade; //遮挡程度

    private Integer decoration; //0无, 1有装修

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public Integer getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(Integer ownerType) {
        this.ownerType = ownerType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getPropertyRightType() {
        return propertyRightType;
    }

    public void setPropertyRightType(Integer propertyRightType) {
        this.propertyRightType = propertyRightType;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(String maxFloor) {
        this.maxFloor = maxFloor;
    }

    public Long getAreas() {
        return areas;
    }

    public void setAreas(Long areas) {
        this.areas = areas;
    }

    public Long getEffien() {
        return effien;
    }

    public void setEffien(Long effien) {
        this.effien = effien;
    }

    public Integer getShowLength() {
        return showLength;
    }

    public void setShowLength(Integer showLength) {
        this.showLength = showLength;
    }

    public Integer getRentType() {
        return rentType;
    }

    public void setRentType(Integer rentType) {
        this.rentType = rentType;
    }

    public Long getShade() {
        return shade;
    }

    public void setShade(Long shade) {
        this.shade = shade;
    }

    public Integer getDecoration() {
        return decoration;
    }

    public void setDecoration(Integer decoration) {
        this.decoration = decoration;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getContactType() {
        return contactType;
    }

    public void setContactType(Integer contactType) {
        this.contactType = contactType;
    }
}
