package com.back.web.controller.demo.domain;

import com.back.common.annotation.Excel;
import com.back.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "UserEntity", description = "用户实体")
public class UserModel{

    @ApiModelProperty("用户姓名")
    @Excel(name = "用户姓名")
    private String username;

    @ApiModelProperty("用户手机")
    @Excel(name = "用户手机")
    private String phone;

    @ApiModelProperty("身份证")
    @Excel(name = "身份证")
    private String idNumber;

    @ApiModelProperty("wxid")
    private String wxid;

    @ApiModelProperty("openid")
    private String openid;

    @ApiModelProperty("book_id")
    private String bookId;

    @ApiModelProperty("user_uuid")
    private String userUuid;

    @ApiModelProperty("userCode")
    private String usercode;

    @ApiModelProperty("qrcode_link")
    private String qrcodeLink;

    @ApiModelProperty("route")
    private String route;

    @ApiModelProperty("用户状态")
    @Excel(name = "用户状态", readConverterExp = "1=预约中,2=预约成功,3=支付成功,4=已使用,5=已取消,6=黑名单,7=vip")
    private String appointmentStatus;

    @ApiModelProperty("预约时间")
    @Excel(name = "预约时间", width = 30)
    private String appointmentTime;

    public UserModel() {
    }

    public UserModel(String username, String phone, String idNumber, String wxid, String openid, String bookId, String userUuid, String usercode, String qrcodeLink, String route, String appointmentStatus, String appointmentTime) {
        this.username = username;
        this.phone = phone;
        this.idNumber = idNumber;
        this.wxid = wxid;
        this.openid = openid;
        this.bookId = bookId;
        this.userUuid = userUuid;
        this.usercode = usercode;
        this.qrcodeLink = qrcodeLink;
        this.route = route;
        this.appointmentStatus = appointmentStatus;
        this.appointmentTime = appointmentTime;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getWxid() {
        return wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getQrcodeLink() {
        return qrcodeLink;
    }

    public void setQrcodeLink(String qrcodeLink) {
        this.qrcodeLink = qrcodeLink;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}