package com.hxg.settlement.mysql.persistence;

import java.util.Date;
import javax.persistence.*;

@Table(name = "app_user")
public class AppUser {
    @Id
    private Integer id;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 用户头像url
     */
    @Column(name = "portrait_url")
    private String portraitUrl;

    /**
     * 用户默认地址
     */
    @Column(name = "address_id")
    private Integer addressId;

    /**
     * 0=未知,1=男,2=女
     */
    private Byte gender;

    /**
     * 出生日期
     */
    @Column(name = "birth_date")
    private Date birthDate;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 体重
     */
    private Integer weight;

    /**
     * 身份证号
     */
    @Column(name = "idcard_no")
    private String idcardNo;

    /**
     * 关联会员等级配置表相同字段
     */
    @Column(name = "level_sequence")
    private Integer levelSequence;

    /**
     * 会员当前成长值
     */
    @Column(name = "level_score")
    private Integer levelScore;

    /**
     * 用户当前总积分
     */
    @Column(name = "level_points")
    private Integer levelPoints;

    /**
     * 身高
     */
    private Integer height;

    /**
     * 客户类型
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 症状类型
     */
    @Column(name = "symptom_type")
    private String symptomType;

    /**
     * 地区
     */
    private String area;

    /**
     * 职业
     */
    private String career;

    /**
     * 婚姻状况
     */
    @Column(name = "marriage_info")
    private String marriageInfo;

    /**
     * 文化程度
     */
    @Column(name = "education_level")
    private String educationLevel;

    /**
     * 微信
     */
    private String wechat;

    /**
     * QQ
     */
    private String qq;

    /**
     * 资料完善程度:0-100之间
     */
    @Column(name = "profile_complete_percent")
    private Byte profileCompletePercent;

    /**
     * 是否BRM客户
     */
    @Column(name = "is_brm")
    private Boolean isBrm;

    /**
     * BRM系统客户ID
     */
    private String brmid;

    /**
     * 登录密码
     */
    private String passwd;

    /**
     * 微信登录openid
     */
    @Column(name = "wx_openid")
    private String wxOpenid;

    /**
     * QQ登录openid
     */
    @Column(name = "qq_openid")
    private String qqOpenid;

    /**
     * 身份证正面
     */
    @Column(name = "id_front_url")
    private String idFrontUrl;

    /**
     * 身份证反面
     */
    @Column(name = "id_back_url")
    private String idBackUrl;

    /**
     * 用户创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 用户状态:1=有效,0=冻结
     */
    private Byte state;

    /**
     * 顾问显示的备注名
     */
    @Column(name = "consult_display_name")
    private String consultDisplayName;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取手机号码
     *
     * @return mobile - 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号码
     *
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户昵称
     *
     * @return nick_name - 用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置用户昵称
     *
     * @param nickName 用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取用户头像url
     *
     * @return portrait_url - 用户头像url
     */
    public String getPortraitUrl() {
        return portraitUrl;
    }

    /**
     * 设置用户头像url
     *
     * @param portraitUrl 用户头像url
     */
    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    /**
     * 获取用户默认地址
     *
     * @return address_id - 用户默认地址
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * 设置用户默认地址
     *
     * @param addressId 用户默认地址
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    /**
     * 获取0=未知,1=男,2=女
     *
     * @return gender - 0=未知,1=男,2=女
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * 设置0=未知,1=男,2=女
     *
     * @param gender 0=未知,1=男,2=女
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * 获取出生日期
     *
     * @return birth_date - 出生日期
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * 设置出生日期
     *
     * @param birthDate 出生日期
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取体重
     *
     * @return weight - 体重
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置体重
     *
     * @param weight 体重
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取身份证号
     *
     * @return idcard_no - 身份证号
     */
    public String getIdcardNo() {
        return idcardNo;
    }

    /**
     * 设置身份证号
     *
     * @param idcardNo 身份证号
     */
    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    /**
     * 获取关联会员等级配置表相同字段
     *
     * @return level_sequence - 关联会员等级配置表相同字段
     */
    public Integer getLevelSequence() {
        return levelSequence;
    }

    /**
     * 设置关联会员等级配置表相同字段
     *
     * @param levelSequence 关联会员等级配置表相同字段
     */
    public void setLevelSequence(Integer levelSequence) {
        this.levelSequence = levelSequence;
    }

    /**
     * 获取会员当前成长值
     *
     * @return level_score - 会员当前成长值
     */
    public Integer getLevelScore() {
        return levelScore;
    }

    /**
     * 设置会员当前成长值
     *
     * @param levelScore 会员当前成长值
     */
    public void setLevelScore(Integer levelScore) {
        this.levelScore = levelScore;
    }

    /**
     * 获取用户当前总积分
     *
     * @return level_points - 用户当前总积分
     */
    public Integer getLevelPoints() {
        return levelPoints;
    }

    /**
     * 设置用户当前总积分
     *
     * @param levelPoints 用户当前总积分
     */
    public void setLevelPoints(Integer levelPoints) {
        this.levelPoints = levelPoints;
    }

    /**
     * 获取身高
     *
     * @return height - 身高
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 设置身高
     *
     * @param height 身高
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 获取客户类型
     *
     * @return user_type - 客户类型
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置客户类型
     *
     * @param userType 客户类型
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 获取症状类型
     *
     * @return symptom_type - 症状类型
     */
    public String getSymptomType() {
        return symptomType;
    }

    /**
     * 设置症状类型
     *
     * @param symptomType 症状类型
     */
    public void setSymptomType(String symptomType) {
        this.symptomType = symptomType;
    }

    /**
     * 获取地区
     *
     * @return area - 地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置地区
     *
     * @param area 地区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取职业
     *
     * @return career - 职业
     */
    public String getCareer() {
        return career;
    }

    /**
     * 设置职业
     *
     * @param career 职业
     */
    public void setCareer(String career) {
        this.career = career;
    }

    /**
     * 获取婚姻状况
     *
     * @return marriage_info - 婚姻状况
     */
    public String getMarriageInfo() {
        return marriageInfo;
    }

    /**
     * 设置婚姻状况
     *
     * @param marriageInfo 婚姻状况
     */
    public void setMarriageInfo(String marriageInfo) {
        this.marriageInfo = marriageInfo;
    }

    /**
     * 获取文化程度
     *
     * @return education_level - 文化程度
     */
    public String getEducationLevel() {
        return educationLevel;
    }

    /**
     * 设置文化程度
     *
     * @param educationLevel 文化程度
     */
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    /**
     * 获取微信
     *
     * @return wechat - 微信
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * 设置微信
     *
     * @param wechat 微信
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * 获取QQ
     *
     * @return qq - QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置QQ
     *
     * @param qq QQ
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取资料完善程度:0-100之间
     *
     * @return profile_complete_percent - 资料完善程度:0-100之间
     */
    public Byte getProfileCompletePercent() {
        return profileCompletePercent;
    }

    /**
     * 设置资料完善程度:0-100之间
     *
     * @param profileCompletePercent 资料完善程度:0-100之间
     */
    public void setProfileCompletePercent(Byte profileCompletePercent) {
        this.profileCompletePercent = profileCompletePercent;
    }

    /**
     * 获取是否BRM客户
     *
     * @return is_brm - 是否BRM客户
     */
    public Boolean getIsBrm() {
        return isBrm;
    }

    /**
     * 设置是否BRM客户
     *
     * @param isBrm 是否BRM客户
     */
    public void setIsBrm(Boolean isBrm) {
        this.isBrm = isBrm;
    }

    /**
     * 获取BRM系统客户ID
     *
     * @return brmid - BRM系统客户ID
     */
    public String getBrmid() {
        return brmid;
    }

    /**
     * 设置BRM系统客户ID
     *
     * @param brmid BRM系统客户ID
     */
    public void setBrmid(String brmid) {
        this.brmid = brmid;
    }

    /**
     * 获取登录密码
     *
     * @return passwd - 登录密码
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * 设置登录密码
     *
     * @param passwd 登录密码
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * 获取微信登录openid
     *
     * @return wx_openid - 微信登录openid
     */
    public String getWxOpenid() {
        return wxOpenid;
    }

    /**
     * 设置微信登录openid
     *
     * @param wxOpenid 微信登录openid
     */
    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    /**
     * 获取QQ登录openid
     *
     * @return qq_openid - QQ登录openid
     */
    public String getQqOpenid() {
        return qqOpenid;
    }

    /**
     * 设置QQ登录openid
     *
     * @param qqOpenid QQ登录openid
     */
    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid;
    }

    /**
     * 获取身份证正面
     *
     * @return id_front_url - 身份证正面
     */
    public String getIdFrontUrl() {
        return idFrontUrl;
    }

    /**
     * 设置身份证正面
     *
     * @param idFrontUrl 身份证正面
     */
    public void setIdFrontUrl(String idFrontUrl) {
        this.idFrontUrl = idFrontUrl;
    }

    /**
     * 获取身份证反面
     *
     * @return id_back_url - 身份证反面
     */
    public String getIdBackUrl() {
        return idBackUrl;
    }

    /**
     * 设置身份证反面
     *
     * @param idBackUrl 身份证反面
     */
    public void setIdBackUrl(String idBackUrl) {
        this.idBackUrl = idBackUrl;
    }

    /**
     * 获取用户创建时间
     *
     * @return create_time - 用户创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置用户创建时间
     *
     * @param createTime 用户创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取用户状态:1=有效,0=冻结
     *
     * @return state - 用户状态:1=有效,0=冻结
     */
    public Byte getState() {
        return state;
    }

    /**
     * 设置用户状态:1=有效,0=冻结
     *
     * @param state 用户状态:1=有效,0=冻结
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * 获取顾问显示的备注名
     *
     * @return consult_display_name - 顾问显示的备注名
     */
    public String getConsultDisplayName() {
        return consultDisplayName;
    }

    /**
     * 设置顾问显示的备注名
     *
     * @param consultDisplayName 顾问显示的备注名
     */
    public void setConsultDisplayName(String consultDisplayName) {
        this.consultDisplayName = consultDisplayName;
    }
}