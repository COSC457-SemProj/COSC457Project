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
        this.worksOnEmpNum = worksOnEmpNum;
    }

    public void setWorksOnConNum(String worksOnConNum) {
        this.worksOnConNum = worksOnConNum;
    }

    public void setWorksOnHours(String worksOnHours) {
        this.worksOnHours = worksOnHours;
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
        return super.getInsertQuery() +
                "VALUES (\'" +
                worksOnEmpNum +
                "\', \'" +
                worksOnConNum +
                "\', \'" +
                worksOnHours +
                "\')";
    }
}
