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
        db = new DBController("/home/cgood/dbinfo.txt");
    }

    public static String[][] select(String[] table, String[] column, String[] comparator, String[] value){
        for(String t : table){
            if(!db.validateTable(t)){
                return null;
            }
        }
        
        table = db.validateInput(table);
        column = db.validateInput(column);
        comparator = db.validateInput(comparator);
        value = db.validateInput(value);
        
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM " + String.join(", ", table) + " WHERE ");
            int max = minimum(column.length, comparator.length, value.length);
            for(int i = 0; i < max; i++){
                sb.append(column[i] + " " + comparator[i] + " \'" + value[i] + "\'");
                if(i < max - 1){
                    sb.append(" AND ");
                }
            }
            sb.append(";");
            ResultSet rs = db.executeQuery(sb.toString());
            
            Model m = db.getModel(table[0]);
            String[] resColumns = m.getColumns();
            ArrayList<String[]> results = new ArrayList<>();
            while(rs.next()){
                String[] newColumn = new String[resColumns.length];
                for(int i = 0; i < resColumns.length; i++){
                    newColumn[i] = rs.getObject(resColumns[i]).toString();
                }
                results.add(newColumn);
            }
            return results.toArray(new String[results.size()][]);
        }catch(SQLException e){
            return null;
        }
    }
    
    public static String update(String table, String[] columns, String[] values,
            String[] conColumn, String[] conComparator, String[] conValues){
        db.validateInput(table);
        db.validateInput(columns);
        db.validateInput(values);
        db.validateInput(conColumn);
        db.validateInput(conComparator);
        db.validateInput(conValues);
        String[] sb;
        for(int j = 0; j < columns.length && j < values.length; j++){
            sb = new String[minimum(conColumn.length, conComparator.length, conValues.length)];
            for(int i = 0; i < conColumn.length && i < conComparator.length && i < conValues.length; i++){
                sb[i] = conColumn[i] + " " + conComparator[i] + " \'" + conValues[i] + "\'";
            }
            try{
                db.executeUpdate("UPDATE " + table +
                        " SET " + columns[j] + " = \'"+ values[j] +
                        "\' WHERE " + String.join(" AND ", sb) + ";");
            }catch(SQLException e){
                return Integer.toString(j);
            }
        }
        return Integer.toString(Math.min(columns.length, values.length));
    }
    
    private static int minimum(int i1, int i2, int i3){
        return Math.min(i1, Math.min(i2, i3));
    }

    public static String insert(Model model){
        try {
            String query;
            if((query = model.getInsertQuery()) == null){
                return null;
            }
            return String.valueOf(db.executeUpdate(query));
        }catch(SQLException e){
            return null;
        }
    }

    public static String delete(String table, String condition){
        table = db.validateInput(table);
        condition = db.validateInput(condition);
        try{
            return String.valueOf(db.executeUpdate("DELETE FROM " + table + " WHERE " + condition));
        }catch(SQLException e){
            return null;
        }
    }
    
    public static Model getModelByName(String tableName){
        return db.getModel(tableName);
    }

    public static String generateUniqueId(String table){
        return db.generateUnique(table, System.currentTimeMillis());
    }
}
