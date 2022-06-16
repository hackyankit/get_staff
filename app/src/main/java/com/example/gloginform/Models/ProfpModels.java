package com.example.gloginform.Models;

public class ProfpModels {
    String name,number,address,firmName;

    public ProfpModels(String name, String number, String address) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.firmName=firmName;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
