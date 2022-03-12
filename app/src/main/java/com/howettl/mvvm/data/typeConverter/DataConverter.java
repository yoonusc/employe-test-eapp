package com.howettl.mvvm.data.typeConverter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.howettl.mvvm.data.model.Address;
import com.howettl.mvvm.data.model.Company;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * Created byyoonus on 10/1/18. @mycodlabs
 */
public class DataConverter implements Serializable {

    @TypeConverter
    public String fromAddressToString(Address data) {
        if (data == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Address>() {
        }.getType();
        String json = gson.toJson(data, type);
        return json;
    }

    @TypeConverter
    public Address fromStringtoAddress(String address) {
        if (address == null || address.isEmpty()) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Address>() {
        }.getType();
        Address data = gson.fromJson(address, type);
        return data;
    }


    @TypeConverter
    public String fromCompanyToString(Company data) {
        if (data == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Company>() {
        }.getType();
        String json = gson.toJson(data, type);
        return json;
    }

    @TypeConverter
    public Company  toCompany(String address) {
        if (address == null || address.isEmpty()) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Company>() {
        }.getType();
        Company data = gson.fromJson(address, type);
        return data;
    }


}
