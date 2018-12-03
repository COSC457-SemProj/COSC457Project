package com.cdra.controller;

import com.cdra.exception.InvalidSQLTypeException;

public class Location extends Model {
    private String locNum;
    private String locAddress;
    private String locSecure;
    private String locName;

    public Location(){
        super("Proj_Location",
                new String[] {"LocNum", "LocAddress", "LocSecure", "LocName"},
                new String[] {"LocNum"});
    }

    public String getLocNum(){return locNum;}
    public String getLocAddress(){return locAddress;}
    public String getLocSecure(){return locSecure;}
    public String getLocName(){return locName;}


    public void setLocNum(String locNum){
        this.locNum = validateInput(locNum);
    }

    public void setLocAddress(String locAddress){
        this.locAddress = validateInput(locAddress);
    }

    public void setLocSecure(String locSecure){
        this.locSecure = validateInput(locSecure);
    }

    public void setLocName(String locName){
        this.locName = validateInput(locName);
    }

    public boolean validate(){
        if(locNum == null || locNum.length() > 7) {
            return false;
        }
        if(locAddress == null || locAddress.length() > 100) {
            return false;
        }
        if(locSecure == null || !(locSecure.equals("true") || locSecure.equals("false"))) {
            return false;
        }
        if(locName != null && locName.length() > 45) {
            return false;
        }
        return true;
    }

    @Override
    public String getInsertQuery() {
        return super.getInsertQuery() +
                "VALUES (\'" +
                locNum +
                "\', \'" +
                locAddress +
                "\', \'" +
                locSecure +
                "\', \'" +
                locName +
                "\')";
    }
}