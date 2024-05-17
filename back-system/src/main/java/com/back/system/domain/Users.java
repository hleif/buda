package com.back.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.back.common.annotation.Excel;

/**
 * 【请填写功能名称】对象 users
 * 
 * @author back
 * @date 2024-03-29
 */
public class Users
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long userId;

    /** $column.columnComment */
    @Excel(name = "用户姓名")
    private String username;

    /** $column.columnComment */
    @Excel(name = "用户手机")
    private String phone;

    /** $column.columnComment */
    private String wxid;

    /** $column.columnComment */
    @Excel(name = "身份证")
    private String idNumber;

    /** $column.columnComment */
    private String openid;

    /** $column.columnComment */
    private String usercode;

    /** $column.columnComment */
    @Excel(name = "用户状态", readConverterExp = "1=预约中,2=预约成功,3=支付成功,4=已使用,5=已取消,6=黑名单,7=vip")
    private String appointmentStatus;

    /** $column.columnComment */
    private String qrcodeLink;

    /** $column.columnComment */
    private String bookId;

    /** $column.columnComment */
    private String userUuid;

    /** $column.columnComment */
    @Excel(name = "预约时间", width = 30)
    private String appointmentTime;

    public Users() {
    }

    public Users(Long userId, String username, String phone, String wxid, String idNumber, String openid, String usercode, String appointmentStatus, String qrcodeLink, String bookId, String userUuid, String appointmentTime) {
        this.userId = userId;
        this.username = username;
        this.phone = phone;
        this.wxid = wxid;
        this.idNumber = idNumber;
        this.openid = openid;
        this.usercode = usercode;
        this.appointmentStatus = appointmentStatus;
        this.qrcodeLink = qrcodeLink;
        this.bookId = bookId;
        this.userUuid = userUuid;
        this.appointmentTime = appointmentTime;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setWxid(String wxid) 
    {
        this.wxid = wxid;
    }

    public String getWxid() 
    {
        return wxid;
    }
    public void setIdNumber(String idNumber) 
    {
        this.idNumber = idNumber;
    }

    public String getIdNumber() 
    {
        return idNumber;
    }
    public void setOpenid(String openid) 
    {
        this.openid = openid;
    }

    public String getOpenid() 
    {
        return openid;
    }
    public void setUsercode(String usercode) 
    {
        this.usercode = usercode;
    }

    public String getUsercode() 
    {
        return usercode;
    }
    public void setAppointmentStatus(String appointmentStatus) 
    {
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentStatus() 
    {
        return appointmentStatus;
    }
    public void setQrcodeLink(String qrcodeLink) 
    {
        this.qrcodeLink = qrcodeLink;
    }

    public String getQrcodeLink() 
    {
        return qrcodeLink;
    }
    public void setBookId(String bookId) 
    {
        this.bookId = bookId;
    }

    public String getBookId() 
    {
        return bookId;
    }
    public void setUserUuid(String userUuid) 
    {
        this.userUuid = userUuid;
    }

    public String getUserUuid() 
    {
        return userUuid;
    }
    public void setAppointmentTime(String appointmentTime) 
    {
        this.appointmentTime = appointmentTime;
    }

    public String getAppointmentTime() 
    {
        return appointmentTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("username", getUsername())
            .append("phone", getPhone())
            .append("wxid", getWxid())
            .append("idNumber", getIdNumber())
            .append("openid", getOpenid())
            .append("usercode", getUsercode())
            .append("appointmentStatus", getAppointmentStatus())
            .append("qrcodeLink", getQrcodeLink())
            .append("bookId", getBookId())
            .append("userUuid", getUserUuid())
            .append("appointmentTime", getAppointmentTime())
            .toString();
    }
}
