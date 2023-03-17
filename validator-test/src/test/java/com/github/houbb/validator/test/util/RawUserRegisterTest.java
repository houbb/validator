//package com.github.houbb.validator.test.util;
//
//import com.github.houbb.validator.test.enums.SexEnum;
//import com.github.houbb.validator.test.model.UserRegister;
//import org.junit.Test;
//
///**
// * @author binbin.hou
// * @since 1.0.0
// */
//public class RawUserRegisterTest {
//
//    @Test
//    public void simpleTest() {
//        UserRegister userRegister = new UserRegister();
//    }
//
//    private void paramCheck3(UserRegister userRegister) {
//        //1. 名称
//        ValidateUtil.validate(userRegister);
//
//        //2.2 确认密码
//        String password2 = userRegister.getPassword2();
//        if(!userRegister.getPassword().equals(password2)) {
//            throw new IllegalArgumentException("确认密码必须和密码保持一致");
//        }
//    }
//
//    private void paramCheck2(UserRegister userRegister) {
//        //1. 名称
//        ValidateUtil.validate(userRegister);
//
//        //2.2 确认密码
//        String password2 = userRegister.getPassword2();
//        if(!userRegister.getPassword().equals(password2)) {
//            throw new IllegalArgumentException("确认密码必须和密码保持一致");
//        }
//
//        //3. 性别
//        String sex = userRegister.getSex();
//        if(!SexEnum.BOY.getCode().equals(sex) && !SexEnum.GIRL.getCode().equals(sex)) {
//            throw new IllegalArgumentException("性别必须指定为 GIRL/BOY");
//        }
//    }
//
//    private void paramCheck(UserRegister userRegister) {
//        //1. 名称
//        String name = userRegister.getName();
//        if(name == null) {
//            throw new IllegalArgumentException("名称不可为空");
//        }
//        if(name.length() < 1 || name.length() > 32) {
//            throw new IllegalArgumentException("名称长度必须介于 1-32 之间");
//        }
//
//        //2. 密码
//        String password = userRegister.getPassword();
//        if(password == null) {
//            throw new IllegalArgumentException("密码不可为空");
//        }
//        if(password.length() < 6 || password.length() > 32) {
//            throw new IllegalArgumentException("密码长度必须介于 6-32 之间");
//        }
//
//        //2.2 确认密码
//        String password2 = userRegister.getPassword2();
//        if(!password.equals(password2)) {
//            throw new IllegalArgumentException("确认密码必须和密码保持一致");
//        }
//
//        //3. 性别
//        String sex = userRegister.getSex();
//        if(!SexEnum.BOY.getCode().equals(sex) && !SexEnum.GIRL.getCode().equals(sex)) {
//            throw new IllegalArgumentException("性别必须指定为 GIRL/BOY");
//        }
//    }
//
//}
