package com.huhuo.carservicecore.csm.order;

import java.io.Serializable;
import java.util.Date;

import com.huhuo.carservicecore.cust.store.ModelStore;
import com.huhuo.integration.base.BaseModel;
import com.huhuo.integration.db.mysql.NotSqlField;

public class ModelOrder extends BaseModel implements Serializable {

	private static final long serialVersionUID = -4415196899388568753L;
	
	/** 租车人id（与csm_consumer关联） **/
	private Long consumerId;
	/** 车辆id **/
	private Long carId;
	/** 车辆出租前油量 **/
	private Double oilmassBegin;
	/** 车辆出租后油量 **/
	private Double oilmassEnd;
	/** 车辆出租时间 **/
	private Date carRentTime;
	/** 车辆实际归还时间 **/
	private Date carRetTime;
	/** 车辆预计归还时间 **/
	private Date carPlanRetTime;
	/** 车辆开始里程数（以车辆出租时为标准） **/
	private Long mileageBegin;
	/** 车辆结束里程数（以车辆归还时为标准） **/
	private Long mileageEnd;
	/** 总计（前面各项费用经过一定的算法之后得到的实际费用总额） **/
	private Double totalFee;
	/** 状态，字典表字段，组名：csm_order_status，0：删除；1：待结帐；2：已结帐 **/
	private Integer status;
	
	/** 租金方式  1.现金 2 刷卡**/
	private Integer rentalType;
	
	/** 是否上门送车 **/
	private Boolean isCarSend=false;
	/** 是否异店换车 **/
	private Boolean isDiffShopReturn=false;
	/** 备注 **/
	private String remark;
	
	
	/** 押金（元） **/
	private Double deposit;
	/** 保险费，xxx元/次 **/
	private Double premium;
	/** 租金（xxx元/天） **/
	private Double rent;
	/** 里程限制（xxx公里/日） **/
	private Long mileageLimits;
	/** 超里程费用（xxx元/公里） **/
	private Double overMileageFare;
	/** 超时标准（xxx元/小时） **/
	private Double overTimeFare;
	/** 上门送车（xxx元） **/
	private Double carSendFare;
	/** 异店结算（还车）附加费（元） **/
	private Double diffShopReturnFare;
	
	/** 油钱 元/升 **/
	private Double oilPrice;
	
	/** 该订单所属的门店id **/
	private Long storeId;
	
	
	/** external object **/
	@NotSqlField
	private ModelStore store;
	
	public Double getOilPrice() {
		return oilPrice;
	}
	public void setOilPrice(Double oilPrice) {
		this.oilPrice = oilPrice;
	}
	public Double getDeposit() {
		return deposit;
	}
	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	public Double getPremium() {
		return premium;
	}
	public void setPremium(Double premium) {
		this.premium = premium;
	}
	public Double getRent() {
		return rent;
	}
	public void setRent(Double rent) {
		this.rent = rent;
	}
	public Long getMileageLimits() {
		return mileageLimits;
	}
	public void setMileageLimits(Long mileageLimits) {
		this.mileageLimits = mileageLimits;
	}
	public Double getOverMileageFare() {
		return overMileageFare;
	}
	public void setOverMileageFare(Double overMileageFare) {
		this.overMileageFare = overMileageFare;
	}
	public Double getOverTimeFare() {
		return overTimeFare;
	}
	public void setOverTimeFare(Double overTimeFare) {
		this.overTimeFare = overTimeFare;
	}
	public Double getCarSendFare() {
		return carSendFare;
	}
	public void setCarSendFare(Double carSendFare) {
		this.carSendFare = carSendFare;
	}
	public Double getDiffShopReturnFare() {
		return diffShopReturnFare;
	}
	public void setDiffShopReturnFare(Double diffShopReturnFare) {
		this.diffShopReturnFare = diffShopReturnFare;
	}
	public Long getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	public Double getOilmassBegin() {
		return oilmassBegin;
	}
	public void setOilmassBegin(Double oilmassBegin) {
		this.oilmassBegin = oilmassBegin;
	}
	public Double getOilmassEnd() {
		return oilmassEnd;
	}
	public void setOilmassEnd(Double oilmassEnd) {
		this.oilmassEnd = oilmassEnd;
	}
	public Date getCarRentTime() {
		return carRentTime;
	}
	public void setCarRentTime(Date carRentTime) {
		this.carRentTime = carRentTime;
	}
	public Date getCarRetTime() {
		return carRetTime;
	}
	public void setCarRetTime(Date carRetTime) {
		this.carRetTime = carRetTime;
	}
	public Date getCarPlanRetTime() {
		return carPlanRetTime;
	}
	public void setCarPlanRetTime(Date carPlanRetTime) {
		this.carPlanRetTime = carPlanRetTime;
	}
	public Long getMileageBegin() {
		return mileageBegin;
	}
	public void setMileageBegin(Long mileageBegin) {
		this.mileageBegin = mileageBegin;
	}
	public Long getMileageEnd() {
		return mileageEnd;
	}
	public void setMileageEnd(Long mileageEnd) {
		this.mileageEnd = mileageEnd;
	}
	public Double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Boolean getIsCarSend() {
		return isCarSend;
	}
	public void setIsCarSend(Boolean isCarSend) {
		this.isCarSend = isCarSend;
	}
	public Boolean getIsDiffShopReturn() {
		return isDiffShopReturn;
	}
	public void setIsDiffShopReturn(Boolean isDiffShopReturn) {
		this.isDiffShopReturn = isDiffShopReturn;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getRentalType() {
		return rentalType;
	}
	public void setRentalType(Integer rentalType) {
		this.rentalType = rentalType;
	}
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public ModelStore getStore() {
		return store;
	}
	public void setStore(ModelStore store) {
		this.store = store;
	}
	
}
