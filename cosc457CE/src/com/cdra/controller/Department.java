package com.cdra.controller;

import com.cdra.exception.InvalidSQLTypeException;

public class Department extends Model {
    private String deptNum;
    private String deptLocNum;
    private String deptName;

    public Department(){
        super("Proj_Department",
                new String[] {"DeptNum", "DeptLoc", "DeptManagerEmpNum", "DeptName"},
                new String[] {"DeptNum"});
    }

    public String getDeptNum() { return deptNum; }
    public String getDeptLocNum() { return deptLocNum; }
    public String getDeptName() { return deptName; }

    public void setDeptNum(String deptNum) {
        this.deptNum = validateInput(deptNum);
    }

    public void setDeptLocNum(String deptLocNum) {
        this.deptLocNum = validateInput(deptLocNum);
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
        if(deptName == null || deptName.length() != 45){
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
                deptNum +
                "\', \'" +
                deptLocNum +
                "\', \'" +
                deptName +
                "\');";
    }
}
