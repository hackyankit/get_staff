package com.example.gloginform.Models;

public class StafModel {
        String name,number,address;

        public StafModel(String name, String number, String address, String firmName) {
            this.name = name;
            this.number = number;
            this.address = address;
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
