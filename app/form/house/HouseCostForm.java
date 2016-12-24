package form.house;

import form.BaseForm;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/8 下午5:48
 * @Descrition:
 */
public class HouseCostForm extends BaseForm{

    private Integer houseId;

    private Long chummageDaily; //每天租金

    private Long chummageMonth; //每月租金

    private Long chummageYear; //每年租金

    private Integer chummageIncrease; //租金递增

    private String chummageIncreaseRule; //租金递增规则

    private Long transferCost; //转让费

    private String deposit; //压几个月

    private String payMoney; //附几个月

    private Long propertyFee; //物业费

    private Long waterRate; //水费

    private Long gasRate; //电费

    private Long shopSignRate; //店招费用 /年


    public Long getChummageDaily() {
        return chummageDaily;
    }

    public void setChummageDaily(Long chummageDaily) {
        this.chummageDaily = chummageDaily;
    }

    public Long getChummageMonth() {
        return chummageMonth;
    }

    public void setChummageMonth(Long chummageMonth) {
        this.chummageMonth = chummageMonth;
    }

    public Long getChummageYear() {
        return chummageYear;
    }

    public void setChummageYear(Long chummageYear) {
        this.chummageYear = chummageYear;
    }

    public Integer getChummageIncrease() {
        return chummageIncrease;
    }

    public void setChummageIncrease(Integer chummageIncrease) {
        this.chummageIncrease = chummageIncrease;
    }

    public String getChummageIncreaseRule() {
        return chummageIncreaseRule;
    }

    public void setChummageIncreaseRule(String chummageIncreaseRule) {
        this.chummageIncreaseRule = chummageIncreaseRule;
    }

    public Long getTransferCost() {
        return transferCost;
    }

    public void setTransferCost(Long transferCost) {
        this.transferCost = transferCost;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    public Long getPropertyFee() {
        return propertyFee;
    }

    public void setPropertyFee(Long propertyFee) {
        this.propertyFee = propertyFee;
    }

    public Long getWaterRate() {
        return waterRate;
    }

    public void setWaterRate(Long waterRate) {
        this.waterRate = waterRate;
    }

    public Long getGasRate() {
        return gasRate;
    }

    public void setGasRate(Long gasRate) {
        this.gasRate = gasRate;
    }

    public Long getShopSignRate() {
        return shopSignRate;
    }

    public void setShopSignRate(Long shopSignRate) {
        this.shopSignRate = shopSignRate;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
}
