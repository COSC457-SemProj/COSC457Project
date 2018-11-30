public class WorksOn {
    private String worksOnEmpNum;
    private String worksOnConNum;
    private String worksOnHours;

    public String getWorksOnEmpNum() { return worksOnEmpNum; }

    public String getWorksOnConNum() { return worksOnConNum; }

    public String getWorksOnHours() { return worksOnHours; }

    public void setWorksOnEmpNum(String worksOnEmpNum) {
        if(worksOnEmpNum == null || worksOnEmpNum.length() != 7){
            throw new InvalidSQLTypeException();
        }
        this.worksOnEmpNum = worksOnEmpNum;
    }

    public void setWorksOnConNum(String worksOnConNum) {
        if(worksOnConNum == null || worksOnConNum.length() != 7){
            throw new InvalidSQLTypeException();
        }
        this.worksOnConNum = worksOnConNum;
    }

    public void setWorksOnHours(String worksOnHours) {
        if(worksOnHours != null ){
            throw new InvalidSQLTypeException();
        }
        this.worksOnHours = worksOnHours;
    }
}
