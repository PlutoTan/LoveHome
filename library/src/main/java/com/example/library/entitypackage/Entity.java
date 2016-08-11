package com.example.library.entitypackage;

import java.util.List;

/**
 * Created by tanyang on 2016/8/10.
 */
public class Entity {
    public String business_location;
    public String child_category_id;
    public String city_id;
    public String closing_time;
    public String contact;
    public String detail_id;
    public String detail_info;
    public List<entity_image> imgUrlList;
    public String isApprove;
    public String is_take_out;
    public String measure_unit;
    public String merchant_name;
    public String opening_time;
    public String parent_category_id;
    public String per_capita_consumption;
    public String phone;
    public String user_id;

    public String getBusiness_location() {
        return business_location;
    }

    public void setBusiness_location(String business_location) {
        this.business_location = business_location;
    }

    public List<entity_image> getImgUrlList() {
        return imgUrlList;
    }

    public void setImgUrlList(List<entity_image> imgUrlList) {
        this.imgUrlList = imgUrlList;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getChild_category_id() {
        return child_category_id;
    }

    public void setChild_category_id(String child_category_id) {
        this.child_category_id = child_category_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(String detail_id) {
        this.detail_id = detail_id;
    }

    public String getClosing_time() {
        return closing_time;
    }

    public void setClosing_time(String closing_time) {
        this.closing_time = closing_time;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDetail_info() {
        return detail_info;
    }

    public void setDetail_info(String detail_info) {
        this.detail_info = detail_info;
    }

    public String getIs_take_out() {
        return is_take_out;
    }

    public void setIs_take_out(String is_take_out) {
        this.is_take_out = is_take_out;
    }

    public String getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(String isApprove) {
        this.isApprove = isApprove;
    }

    public String getMeasure_unit() {
        return measure_unit;
    }

    public void setMeasure_unit(String measure_unit) {
        this.measure_unit = measure_unit;
    }

    public String getMerchant_name() {
        return merchant_name;
    }

    public void setMerchant_name(String merchant_name) {
        this.merchant_name = merchant_name;
    }

    public String getOpening_time() {
        return opening_time;
    }

    public void setOpening_time(String opening_time) {
        this.opening_time = opening_time;
    }

    public String getPer_capita_consumption() {
        return per_capita_consumption;
    }

    public void setPer_capita_consumption(String per_capita_consumption) {
        this.per_capita_consumption = per_capita_consumption;
    }

    public String getParent_category_id() {
        return parent_category_id;
    }

    public void setParent_category_id(String parent_category_id) {
        this.parent_category_id = parent_category_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
