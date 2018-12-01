package com.cdra;

import com.cdra.controller.DBController;
import com.cdra.controller.Model;

import java.nio.ByteBuffer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SystemInterface {
    private static DBController db;

    public static void __init__(){
        db = new DBController("pathtopasswdfile");
    }

    public static String[][] select(String[] columns, String table, String condition){
        if(!db.validateTable(table)){
            return null;
        }
        try {
            ResultSet rs = db.executeQuery("SELECT " + String.join(", ", columns) + " FROM " + table + " WHERE " + condition + ";");

            ArrayList<String[]> results = new ArrayList<>();
            while(rs.next()){
                String[] newColumn = new String[columns.length];
                for(int i = 0; i < columns.length; i++){
                    newColumn[i] = ((String) rs.getObject(columns[i]));
                }
                results.add(newColumn);
            }
            return (String[][]) results.toArray();
        }catch(SQLException e){
            return null;
        }
    }

    public static String update(String table, String column, String value, String condition){
        if(db.validateTable(table)) {
            try {
                return String.valueOf(db.executeUpdate("Update" + table + "SET" + column + "=" + value + "WHERE" + condition + ";"));
            } catch (SQLException e) {
                return null;
            }
        }
        return null;
    }

    public static String insert(Model model){
        try {
            return String.valueOf(db.executeUpdate(model.getInsertQuery()));
        }catch(SQLException e){
            return null;
        }
    }

    public static String delete(String table, String condition){
        try{
            return String.valueOf(db.executeUpdate("DELETE FROM " + table + " WHERE " + condition));
        }catch(SQLException e){
            return null;
        }
    }

    public String generateUniqueId(String table){
        return db.generateUnique(table, System.currentTimeMillis());
    }
}
