import exception.InvalidSQLTypeException;

public class Race{

    private String raceEmpNum;
    private String race;



    public String getRaceEmpNum(){return raceEmpNum;}
    public String getRace() {return race;}


    public void setRaceEmpNum(){
        if(raceEmpNum == null || raceEmpNum.length > 7) {
            throw new InvalidSQLTypeException();
        }
        this.raceEmpNum = raceEmpNum;
    }

    public void setRace(){
        if(race == null || race.length > 45) {
            throw new InvalidSQLTypeException();
        }
        this.race = race;
    }


}