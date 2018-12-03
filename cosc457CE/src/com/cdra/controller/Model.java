package com.cdra.controller;

public abstract class Model {
    private String[] columns;
    private String tableName;
    private String[] primaryKey;
    public Model(String tableName, String[] columns, String[] primaryKey){
        this.tableName = tableName;
        this.columns = columns;
        this.primaryKey = primaryKey;
    }

    public String getTableName(){
        return tableName;
    }

    public String[] getPrimaryKey(){
        return primaryKey;
    }

    public abstract boolean validate();
    public String getInsertQuery() {
        validate();
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(tableName);
        sb.append("(");

        for(int i = 0; i < columns.length - 1; i++){
            sb.append(columns[i]);
            sb.append(", ");
        }
        sb.append(columns[columns.length-1]);
        sb.append(") ");

        return sb.toString();
    }
    
    public String validateInput(String input){
        return input.replace("\'", "\\\'").
                replace("\0", "\\\0").
                replace("\b", "\\\b").
                replace("\t", "\\\t").
                replace("\n", "\\\n").
                replace("\r", "\\\r").
                replace("\"", "\\\"").
                replace("%", "\\%").
                replace("_", "\\_");
    }
}
