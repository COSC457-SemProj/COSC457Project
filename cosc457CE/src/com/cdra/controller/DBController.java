package com.cdra.controller;

import com.cdra.exception.DBControllerException;
import com.cdra.exception.DBNotFoundException;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.*;
import java.util.Scanner;

public class DBController {
    public static final String[] base32Int = {"0", "1", "2", "3", "4", "5", "6",
        "7", "8", "9", "b", "c", "d", "e", "f", "g", "h", "j", "k",
        "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    public static final String[] base32Bin = {"00000", "00001", "00010", "00011", "00100", "00101",
            "00110", "00111", "01000", "01001", "01010", "01011",
            "01100", "01101", "01110", "01111", "10000","10001",
            "10010", "10011", "10100", "10101", "10110", "10111",
            "11000", "11001", "11010", "11011", "11100", "11101",
            "11110", "11111"};

    public static final Model[] models = {new Employee(), new Race(), new Location(), new WorksOn(), new Contract(),
            new Customer(), new Department(), new Manager()};

    private Object newInstance;
    private Connection connection;

    public DBController(String filePath) {
        try {
            Scanner userFile = new Scanner(new File(filePath));
            String username = userFile.nextLine().replace("\n", "");
            String password = userFile.nextLine().replace("\n", "");
            userFile.close();
            newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3360/cgood4db", username, password);
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException e){
            throw new DBControllerException("The driver com.mysql.jdbc.Driver cannot be found.");
        }catch(SQLException e){
            throw new DBNotFoundException("The database specified cannot be found.");
        }catch(IOException e){
            throw new DBControllerException("The userFile specified cannot be found");
        }
    }

    public ResultSet executeQuery(String query) throws SQLException{
        return connection.createStatement().executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException{
        return connection.createStatement().executeUpdate(query);
    }
    
    public String validateInput(String input){
        return input.replace("\'", "\\\'").
                replace("\0", "\\\0").
                replace("\b", "\\\b").
                replace("\t", "\\\t").
                replace("\n", "\\\n").
                replace("\r", "\\\r").
                replace("\"", "\\\"").
                replace("%", "\\%");
    }
    
    public String[] validateInput(String[] input){
        String[] validatedInput = new String[input.length];
        for(int i = 0; i < input.length; i++){
            validatedInput[i] = input[i].replace("\'", "\\\'").
                replace("\0", "\\0").
                replace("\b", "\\b").
                replace("\t", "\\t").
                replace("\n", "\\n").
                replace("\r", "\\r").
                replace("\"", "\\\"").
                replace("%", "\\%");
        }
        return validatedInput;
    }

    public boolean validateTable(String table){
        boolean valid = false;
        for(Model model : models){
            if(table.equals(model.getTableName())){
                valid = true;
            }
        }
        return valid;
    }

    public Model getModel(String table){
        for(Model model : models){
            if(table.equals(model.getTableName())){
                return model;
            }
        }
        return null;
    }

    public String generateUnique(String table, long time) {
        if(validateTable(table)) {
            ByteBuffer timeBuffer = ByteBuffer.allocate(Long.BYTES);
            timeBuffer.putLong(time);

            StringBuilder sb = new StringBuilder();
            for (byte tByte : timeBuffer.array()) {
                sb.append(Integer.toBinaryString(0xFF & tByte));
            }
            String timeString = sb.toString();
            sb = new StringBuilder();

            for (int i = 0, k = 0; i + 5 < timeString.length() && k < 7; i += 6, k += 1) {
                String b = timeString.substring(i, i + 5);
                for (int j = 0; j < base32Bin.length; j++) {
                    if (base32Bin[j].equals(b)) {
                        sb.append(base32Int[j]);
                    }
                }
            }
            
            while(sb.length() != 7){
                sb.insert(0, "0");
            }
            
            Model model = getModel(table);
            try {
                if (executeQuery("SELECT * FROM " + model.getTableName() + " WHERE " + model.getPrimaryKey()[0] + "=\'" + sb.toString() + "\';").getFetchSize() > 0) {
                    return generateUnique(table, System.currentTimeMillis());
                }
            }catch(SQLException e){
                return null;
            }
            return sb.toString();
        }
        return null;
    }

//    String querys="select * from cgood4db.Employee;"; //your db
//    ResultSet results = queryStatement.executeQuery(querys);
//        while(results.next())
//    {
//        System.out.print(results.getString("FName"));
//        System.out.print("    ");
//        System.out.print(results.getString("LName"));
//        System.out.println();
//    }

}