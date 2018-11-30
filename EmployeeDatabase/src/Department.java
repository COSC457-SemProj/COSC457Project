public class Department {
    private String deptNum;
    private String deptLocNum;
    private String deptManagerEmpNum;
    private String deptName;

    public String getDeptNum() { return deptNum; }
    public String getDeptLocNum() { return deptLocNum; }
    public String getDeptManagerEmpNum() { return deptManagerEmpNum; }
    public String getDeptName() { return deptName; }

    public void setDeptNum(String deptNum) {
        if(deptNum == null || deptNum.length() != 7){
            throw new InvalidSQLTypeException();
        }
        this.deptNum = deptNum;
    }

    public void setDeptLocNum(String deptLocNum) {
        if(deptLocNum == null || deptLocNum.length() != 7){
            throw new InvalidSQLTypeException();
        }
        this.deptLocNum = deptLocNum;
    }

    public void setDeptManagerEmpNum(String deptManagerEmpNum) {
        if(deptManagerEmpNum == null || deptManagerEmpNum.length() != 7){
            throw new InvalidSQLTypeException();
        }
        this.deptManagerEmpNum = deptManagerEmpNum;
    }

    public void setDeptName(String deptName) {
        if(deptName == null || deptName.length() != 45){
            throw new InvalidSQLTypeException();
        }
        this.deptName = deptName;
    }
}
