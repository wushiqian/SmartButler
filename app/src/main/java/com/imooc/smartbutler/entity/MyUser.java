package com.imooc.smartbutler.entity;
/*
 * 包名：SmartButler
 * 文件名： MyUser
 * 创建者：wushiqian
 * 创建时间 2018/8/19 下午4:43
 * 描述： TODO//
 */

import cn.bmob.v3.BmobUser;

public class MyUser extends BmobUser{

    private int age;
    private boolean sex;
    private String desc;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
