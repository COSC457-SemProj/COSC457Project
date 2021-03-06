package com.cdra.controller;

import com.cdra.exception.InvalidSQLTypeException;

public class Contract extends Model {
    private String conNum;
    private String conCustNum;
    private String conName;
    private String conBudget;

    public Contract(){
        super("Proj_Contract",
                new String[] {"ConNum", "ConCustNum", "ConName", "ConBudget"},
                new String[] {"ConNum"});
    }
    
    public String getConNum(){
    return conNum;
    }
    public String getConCustNum(){
        return conCustNum;
    }
    public String getConName(){
        return conName;
    }
    public String getConBudget(){
        return conBudget;
    }
    public void setConNum(String conNum){
        this.conNum = validateInput(conNum);
    }
    public void setConCustNum(String conCustNum){
        this.conCustNum = validateInput(conCustNum);
    }
    public void setConName(String conName){
        this.conName = validateInput(conName); 
    }
    public void setConBudget(String conBudget){
        this.conBudget = validateInput(conBudget);
    }

    @Override
    public boolean validate() {
        if( conNum== null || conNum.length() != 7){
            return false;
        }else if( conCustNum== null || conCustNum.length() != 7){
            return false;
        }else if(conName == null || conName.length() > 45){
            return false;
        }else if(conBudget != null && conBudget.length() > 13){
            return false;
        }
        return true;
    }

    @Override
    public String getInsertQuery() {
        String superQuery;
        if((superQuery = super.getInsertQuery()) == null){
            return null;
        }
        return superQuery +
                "VALUES (\'" +
                conNum +
                "\', \'" +
                conCustNum +
                "\', \'" +
                conName +
                "\', \'" +
                conBudget +
                "\');";
    }
}
