package com.cdra.controller;

import com.cdra.exception.InvalidSQLTypeException;

public class WorksOn extends Model {
    private String worksOnEmpNum;
    private String worksOnConNum;
    private String worksOnHours;

    public WorksOn(){
        super("Proj_WorksOn",
                new String[] {"WorksOnEmpNum", "WorksOnConNum", "WorksOnHours"},
                new String[] {"WorksOnEmpNum", "WorksOnConNum"});
    }

    public String getWorksOnEmpNum() { return worksOnEmpNum; }

    public String getWorksOnConNum() { return worksOnConNum; }

    public String getWorksOnHours() { return worksOnHours; }

    public void setWorksOnEmpNum(String worksOnEmpNum) {
        this.worksOnEmpNum = validateInput(worksOnEmpNum);
    }

    public void setWorksOnConNum(String worksOnConNum) {
        this.worksOnConNum = validateInput(worksOnConNum);
    }

    public void setWorksOnHours(String worksOnHours) {
        this.worksOnHours = validateInput(worksOnHours);
    }

    public boolean validate(){
        if(worksOnEmpNum == null || worksOnEmpNum.length() != 7){
            return false;
        }
        if(worksOnConNum == null || worksOnConNum.length() != 7){
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
                worksOnEmpNum +
                "\', \'" +
                worksOnConNum +
                "\', \'" +
                worksOnHours +
                "\');";
    }
}
