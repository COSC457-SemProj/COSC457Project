package com.cdra.controller;

import com.cdra.exception.InvalidSQLTypeException;

public class Department extends Model {
    private String deptNum;
    private String deptLocNum;
    private String deptManagerEmpNum;
    private String deptName;

    public Department(){
        super("Proj_Department",
                new String[] {"DeptNum", "DeptLoc", "DeptManagerEmpNum", "DeptName"},
                new String[] {"DeptNum"});
    }

    public String getDeptNum() { return deptNum; }
    public String getDeptLocNum() { return deptLocNum; }
    public String getDeptManagerEmpNum() { return deptManagerEmpNum; }
    public String getDeptName() { return deptName; }

    public void setDeptNum(String deptNum) {
        this.deptNum = validateInput(deptNum);
    }

    public void setDeptLocNum(String deptLocNum) {
        this.deptLocNum = validateInput(deptLocNum);
    }

    public void setDeptManagerEmpNum(String deptManagerEmpNum) {
        this.deptManagerEmpNum = validateInput(deptManagerEmpNum);
    }

    public void setDeptName(String deptName) {
        this.deptName = validateInput(deptName);
    }

    public boolean validate(){
        if(deptNum == null || deptNum.length() != 7){
            return false;
        }
        if(deptLocNum == null || deptLocNum.length() != 7){
            return false;
        }
        if(deptManagerEmpNum == null || deptManagerEmpNum.length() != 7){
            return false;
        }
        if(deptName == null || deptName.length() != 45){
            return false;
        }
        return true;
    }

    @Override
    public String getInsertQuery(){
        return super.getInsertQuery() +
                "VALUES (\'" +
                deptNum +
                "\', \'" +
                deptLocNum +
                "\', \'" +
                deptManagerEmpNum +
                "\', \'" +
                deptName +
                "\')";
    }
}
