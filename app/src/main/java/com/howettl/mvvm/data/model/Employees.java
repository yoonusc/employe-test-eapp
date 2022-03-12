package com.howettl.mvvm.data.model;

import androidx.databinding.BaseObservable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.howettl.mvvm.data.typeConverter.DataConverter;

import java.io.Serializable;

/**
 * Created byyoonus on 23/1/18. @mycodlabs
 */

@Entity
public class Employees implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String username;
    public String email;
    public String profile_image;
    @TypeConverters(DataConverter.class)
    public Address address;
    public String phone;
    public String website;
    @TypeConverters(DataConverter.class)
    public Company company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}