package com.example.library.entitypackage;

import java.lang.reflect.Array;

/**
 * Created by tanyang on 2016/8/12.
 */
public class ClassifyONE {
    public Array  childCategoryList;
    public String parent_cate_id;
    public String parent_cate_img_url;
    public String parent_cate_name;

    public String getParent_cate_name() {
        return parent_cate_name;
    }

    public void setParent_cate_name(String parent_cate_name) {
        this.parent_cate_name = parent_cate_name;
    }

    public Array getChildCategoryList() {
        return childCategoryList;
    }

    public void setChildCategoryList(Array childCategoryList) {
        this.childCategoryList = childCategoryList;
    }

    public String getParent_cate_img_url() {
        return parent_cate_img_url;
    }

    public void setParent_cate_img_url(String parent_cate_img_url) {
        this.parent_cate_img_url = parent_cate_img_url;
    }

    public String getParent_cate_id() {
        return parent_cate_id;
    }

    public void setParent_cate_id(String parent_cate_id) {
        this.parent_cate_id = parent_cate_id;
    }
}
