package com.cdra.controller;

import com.cdra.exception.InvalidSQLTypeException;

public class Customer extends Model {
    private String custNum;
    private String custName;   
    private String custPrimaryAddress;
    private String PoC;
    private String custPhone;

    public Customer(){
        super("Proj_Customer",
                new String[] {"CustNum", "CustName", "CustPrimaryAddress", "CustPoC", "CustPhone"},
                new String[] {"CustNum"});
    }
    
    public String getCustNum(){
    return custNum;
    }
    public String getCustName(){
        return custName;
    }
    public String getCustPrimaryAddress(){
        return custPrimaryAddress;
    }
    public String getPoC(){
        return PoC;
    }
    public String getCustPhone(){
        return custPhone;
    }

    public void setCustNum(String custNum){
        this.custNum = validateInput(custNum);
    }
    public void setCustName(String custName){
        this.custName = validateInput(custName);
    }
    public void setCustPrimaryAddress(String custPrimaryAddress){
        this.custPrimaryAddress = validateInput(custPrimaryAddress);
    }
    public void setPoC(String PoC){
        this.PoC = validateInput(PoC);
    }
    public void setCustPhone(String custPhone){
        this.custPhone = validateInput(custPhone);
    }

    public boolean validate(){
        if(custNum == null || custNum.length() != 7){
            return false;
        }
        if(custName == null || custName.length() > 45){
            return false;
        }
        if(custPrimaryAddress == null || custPrimaryAddress.length() > 100){
            return false;
        }
        if(custPhone == null || custPhone.length() > 45){
            return false;
        }
        if(PoC == null || PoC.length() > 45){
            return false;
        }
        return true;
    }

    @Override
    public String getInsertQuery(){
        String superQuery;
        if((superQuery = super.getInsertQuery()) == null){
            return null;
        }
        return superQuery +
                "VALUES (\'" +
                custNum +
                "\', \'" +
                custName +
                "\', \'" +
                custPrimaryAddress +
                "\', \'" +
                PoC +
                "\', \'" +
                custPhone +
                "\');";
    }
}
