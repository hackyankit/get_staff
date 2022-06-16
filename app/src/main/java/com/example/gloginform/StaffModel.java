package com.example.gloginform;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class StaffModel implements Parcelable {
    String name,mob,address,firmname;

    public StaffModel(String name, String mob, String address,String firmname) {
        this.name = name;
        this.mob = mob;
        this.address = address;
        this.firmname=firmname;
    }

    public StaffModel() {
    }

    protected StaffModel(Parcel in) {
        name = in.readString();
        mob = in.readString();
        address = in.readString();
        firmname=in.readString();
    }

    public static final Creator<StaffModel> CREATOR = new Creator<StaffModel>() {
        @Override
        public StaffModel createFromParcel(Parcel in) {
            return new StaffModel(in);
        }

        @Override
        public StaffModel[] newArray(int size) {
            return new StaffModel[size];
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

    public String getFirmname() {
        return firmname;
    }

    public void setFirmname(String firmname) {
        this.firmname = firmname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        parcel.writeString((firmname));
    }
}
