/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdra.controller;

/**
 *
 * @author cgood
 */
public class Manager extends Model{
    private String manEmpID;
    private String manDeptID;
    
    public Manager(){
        super("Proj_Manager",
                new String[] {"ManEmpID", "ManDeptID"},
                new String[] {"ManEmpID", "ManDeptID"});
    }

    public String getManEmpID() {
        return manEmpID;
    }

    public String getManDeptID() {
        return manDeptID;
    }

    public void setManEmpID(String ManEmpID) {
        this.manEmpID = ManEmpID;
    }

    public void setManDeptID(String ManDeptID) {
        this.manDeptID = ManDeptID;
    }
    
    public boolean validate(){
        if(manEmpID == null || manEmpID.length() != 7){
            return false;
        }
        if(manDeptID == null || manDeptID.length() != 7){
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
                "\', \'" +
                manEmpID +
                "\', \'" +
                manDeptID +
                "\');";
    }
}
