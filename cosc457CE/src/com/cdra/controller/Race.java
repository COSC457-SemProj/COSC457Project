package com.cdra.controller;

import com.cdra.exception.InvalidSQLTypeException;

public class Race extends Model{

    private String raceEmpNum;
    private String race;

    public Race(){
        super("Proj_Race",
                new String[] {"RaceEmpNum", "Race"},
                new String[] {"RaceEmpNum", "Race"});
    }

    public String getRaceEmpNum(){return raceEmpNum;}
    public String getRace() {return race;}


    public void setRaceEmpNum(String raceEmpNum){
        this.raceEmpNum = validateInput(raceEmpNum);
    }

    public void setRace(String race){
        this.race = validateInput(race);
    }

    public boolean validate(){
        if(raceEmpNum == null || raceEmpNum.length() > 7) {
            return false;
        }
        if(race == null || race.length() > 45) {
            return false;
        }
        return true;
    }

    @Override
    public String getInsertQuery(){
        return super.getInsertQuery() +
                "VALUES (\'" +
                raceEmpNum +
                "\', \'" +
                race +
                "\')";
    }
}