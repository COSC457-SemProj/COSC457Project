package com.cdra.controller;

import com.cdra.exception.InvalidSQLTypeException;

import java.text.SimpleDateFormat;

public class Employee extends Model {
    private String empNum;
    private String empFName;
    private String empMName;
    private String empLName;
    private String empSSN;
    private String empDoB;
    private String empPoB;
    private String empAddress;
    private String empZipCode;
    private String empEmergencyPhone;
    private String empEmergencyPoC;
    private String empTitle;
    private String empGender;
    private String empHomePhone;
    private String empCellPhone;
    private String empAnniversaryMonth;
    private String empSixMonthReview;
    private String empAnnualReview;
    private String empSalary;
    private String empVeteranStatus;

    public Employee(){
        super("Proj_Employee", new String[] {"EmpNum", "EmpFName", "EmpMName", "EmpLName", "EmpSSN",
                "EmpDoB", "EmpPoB", "EmpAddress", "EmpZipCode", "EmpEmergencyPhone", "EmpEmergencyPoC", "EmpTitle",
                "EmpGender", "EmpHomePhone", "EmpCellPhone", "EmpAnniversaryMonth", "EmpSixMonthReview", "EmpAnnualReview",
                "EmpSalary", "EmpVeteranStatus"},
                new String[] {"EmpNum"});
    }
    
    public Employee(String[] values){
        super("Proj_Employee", new String[] {"EmpNum", "EmpFName", "EmpMName", "EmpLName", "EmpSSN",
                "EmpDoB", "EmpPoB", "EmpAddress", "EmpZipCode", "EmpEmergencyPhone", "EmpEmergencyPoC", "EmpTitle",
                "EmpGender", "EmpHomePhone", "EmpCellPhone", "EmpAnniversaryMonth", "EmpSixMonthReview", "EmpAnnualReview",
                "EmpSalary", "EmpVeteranStatus"},
                new String[] {"EmpNum"});
        empNum = values[0];
        empFName = values[1];
        empMName = values[2];
        empLName = values[3];
        empSSN = values[4];
        empDoB = values[5];
        empPoB = values[6];
        empAddress = values[7];
        empZipCode = values[8];
        empEmergencyPhone = values[9];
        empEmergencyPoC = values[10];
        empTitle = values[11];
        empGender = values[12];
        empHomePhone = values[13];
        empCellPhone = values[14];
        empAnniversaryMonth = values[15];
        empSixMonthReview = values[16];
        empAnnualReview = values[17];
        empSalary = values[18];
        empVeteranStatus = values[19];
    }

    public String getEmpNum() {
        return empNum;
    }

    public String getEmpFName() {
        return empFName;
    }

    public String getEmpMName() {
        return empMName;
    }

    public String getEmpLName() {
        return empLName;
    }

    public String getEmpSSN() {
        return empSSN;
    }

    public String getEmpDoB() {
        return empDoB;
    }

    public String getEmpPoB() {
        return empPoB;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public String getEmpZipCode() {
        return empZipCode;
    }

    public String getEmpEmergencyPhone() {
        return empEmergencyPhone;
    }

    public String getEmpEmergencyPoC() {
        return empEmergencyPoC;
    }

    public String getEmpTitle() {
        return empTitle;
    }

    public String getEmpGender() {
        return empGender;
    }

    public String getEmpHomePhone() {
        return empHomePhone;
    }

    public String getEmpCellPhone() {
        return empCellPhone;
    }

    public String getEmpAnniversaryMonth() {
        return empAnniversaryMonth;
    }

    public String getEmpSixMonthReview() {
        return empSixMonthReview;
    }

    public String getEmpAnnualReview() {
        return empAnnualReview;
    }

    public String getEmpSalary() {
        return empSalary;
    }

    public String getEmpVeteranStatus() {
        return empVeteranStatus;
    }

    public void setEmpNum(String empNum) {
        this.empNum = validateInput(empNum);
    }

    public void setEmpFName(String empFName) {
        this.empFName = validateInput(empFName);
    }

    public void setEmpMName(String empMName) {
        this.empMName = validateInput(empMName);
    }

    public void setEmpLName(String empLName) {
        this.empLName = validateInput(empLName);
    }

    public void setEmpSSN(String empSSN) {
        this.empSSN = validateInput(empSSN);
    }

    public void setEmpDoB(String empDoB) {
        this.empDoB = validateInput(empDoB);
    }

    public void setEmpPoB(String empPoB) {
        this.empPoB = validateInput(empPoB);
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = validateInput(empAddress);
    }

    public void setEmpZipCode(String empZipCode) {
        this.empZipCode = validateInput(empZipCode);
    }

    public void setEmpEmergencyPhone(String empEmergencyPhone) {
        this.empEmergencyPhone = validateInput(empEmergencyPhone);
    }

    public void setEmpEmergencyPoC(String empEmergencyPoC) {
        this.empEmergencyPoC = validateInput(empEmergencyPoC);
    }

    public void setEmpTitle(String empTitle) {
        this.empTitle = validateInput(empTitle);
    }

    public void setEmpGender(String empGender) {
        this.empGender = validateInput(empGender);
    }

    public void setEmpHomePhone(String empHomePhone) {
        this.empHomePhone = validateInput(empHomePhone);
    }

    public void setEmpCellPhone(String empCellPhone) {
        this.empCellPhone = validateInput(empCellPhone);
    }

    public void setEmpAnniversaryMonth(String empAnniversaryMonth) {
        this.empAnniversaryMonth = validateInput(empAnniversaryMonth);
    }

    public void setEmpSixMonthReview(String empSixMonthReview) {
        this.empSixMonthReview = validateInput(empSixMonthReview);
    }

    public void setEmpAnnualReview(String empAnnualReview) {
        this.empAnnualReview = validateInput(empAnnualReview);
    }

    public void setEmpSalary(String empSalary) {
        this.empSalary = validateInput(empSalary);
    }

    public void setEmpVeteranStatus(String empVeteranStatus) {
        this.empVeteranStatus = validateInput(empVeteranStatus);
    }

    public boolean validate(){
        if(empNum == null || empNum.length() != 7){
            return false;
        }
        if(empFName == null || empFName.length() > 45){
            return false;
        }
        if(empMName == null || empMName.length() > 45){
            return false;
        }
        if(empLName == null || empLName.length() > 45){
            return false;
        }
        if(empSSN == null || empSSN.length() != 9){
            return false;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.parse(empDoB);
        }catch(java.text.ParseException e){
            return false;
        }
        if(empPoB == null || empPoB.length() > 45){
            return false;
        }
        if(empAddress == null || empAddress.length() > 100){
            return false;
        }
        if(empZipCode == null || empZipCode.length() != 5){
            return false;
        }
        if(empEmergencyPhone == null || empEmergencyPhone.length() != 10){
            return false;
        }
        if(empEmergencyPoC == null || empEmergencyPoC.length() > 45){
            return false;
        }
        if(empTitle == null || empTitle.length() > 45){
            return false;
        }
        if(empGender != null && empGender.length() > 1){
            return false;
        }
        if(empHomePhone != null && empHomePhone.length() > 10){
            return false;
        }
        if(empCellPhone != null && empCellPhone.length() > 10){
            return false;
        }
        if(empAnniversaryMonth != null && empAnniversaryMonth.length() > 2){
            return false;
        }
        if(empSixMonthReview != null && empSixMonthReview.length() > 2){
            return false;
        }
        if(empAnnualReview != null && empAnnualReview.length() > 2){
            return false;
        }
        if(empSalary != null && empSalary.length() > 10){
            return false;
        }
        if(empVeteranStatus != null && empVeteranStatus.length() > 8){
            return false;
        }
        return true;
    }

    public String getInsertQuery(){
        String superQuery;
        if((superQuery = super.getInsertQuery()) == null){
            return null;
        }
        return superQuery +
                "VALUES (\'" +
                empNum +
                "\', \'" +
                empFName +
                "\', \'" +
                empMName +
                "\', \'" +
                empLName +
                "\', \'" +
                empSSN +
                "\', \'" +
                empDoB +
                "\', \'" +
                empPoB +
                "\', \'" +
                empAddress +
                "\', \'" +
                empZipCode +
                "\', \'" +
                empEmergencyPhone +
                "\', \'" +
                empEmergencyPoC +
                "\', \'" +
                empTitle +
                "\', \'" +
                empGender +
                "\', \'" +
                empHomePhone +
                "\', \'" +
                empCellPhone +
                "\', \'" +
                empAnniversaryMonth +
                "\', \'" +
                empSixMonthReview +
                "\', \'" +
                empAnnualReview +
                "\', \'" +
                empSalary +
                "\', \'" +
                empVeteranStatus +
                "\');";
    }
}
