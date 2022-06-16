package com.example.gloginform;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class PropModel implements Parcelable {
    String name,mob,address,password,firmName;

    public PropModel(String name, String mob, String address, String passwword, String firmName) {
        this.name = name;
        this.mob = mob;
        this.address = address;
        this.password = passwword;
        this.firmName = firmName;
    }
    PropModel(){

    }

    public static Creator<PropModel> getCREATOR() {
        return CREATOR;
    }

    protected PropModel(Parcel in) {
        name = in.readString();
        mob = in.readString();
        address = in.readString();
        password = in.readString();
        firmName = in.readString();
    }

    public static final Creator<PropModel> CREATOR = new Creator<PropModel>() {
        @Override
        public PropModel createFromParcel(Parcel in) {
            return new PropModel(in);
        }

        @Override
        public PropModel[] newArray(int size) {
            return new PropModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwword) {
        this.password = passwword;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(mob);
        parcel.writeString(address);
        parcel.writeString(password);
        parcel.writeString(firmName);
    }
}
