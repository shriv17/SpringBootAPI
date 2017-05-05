package com.spring_boot.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 5/5/2017.
 */
public class MemberModel {
    @Expose
    @SerializedName("name")
    String name;
    @SerializedName("email")
    @Expose
    String email;
    @SerializedName("phone")
    @Expose
    String phone;
    @SerializedName("id")
    @Expose
    String id;

    public MemberModel(String name, String email, String phone, String id) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
