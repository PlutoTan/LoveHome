package com.example.library.httppackage;

/**
 * Created by tanyang on 2016/8/9.
 */
public class Http {
     //网址
     public static final  String Main_interface ="http://123.206.87.139/LoveHomeTownServer";
     //获取城市信息
     public static final  String city_interface =Main_interface +"/printCity";
     //获取父分类信息
     public static final  String superclass_interface =Main_interface +  "/printCategory";
     //.获取子分类信息
     public static final String  subclass_interface=Main_interface+"/printCategory?parent_category_id=1";
     //4.查询发布信息
     public static final String seerelease_interface=Main_interface+"/detailInfo";
     //用户登录
     public static final String register_interface=Main_interface+"/isLogin";
     //修改密码
     public static final String password_interface=Main_interface+"/updatePwd";
     //修改用户信息
     public static final String userinfo_interface=Main_interface+"/updateUser";
     //8.添加发布信息
     public static final String addrelease_interface=Main_interface+"/addDetail";
     //修改发布信息
     public static final String alterrelease_interface=Main_interface+"/updateDetail";
     //注册用户信息
     public static final String  enroll_interface=Main_interface+"/registerUser";
     //获取验证码
     public static final String code_interface=Main_interface+"/scanCode";
     //删除发布信息
     public static final String deldetail_interface=Main_interface+"/delDetail";
     //核对验证码
     public static final String  checkcode_interface=Main_interface+"/checkCode";
     //忘记密码
     public static final String forgetPwd_interface=Main_interface+"/forgetPwd";
     //获得商品详情
     public static final String Product="http://123.206.87.139/LoveHomeTownServer/detailInfo?is_approve=1";
}
