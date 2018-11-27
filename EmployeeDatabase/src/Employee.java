import exception.InvalidSQLTypeException;

import java.text.SimpleDateFormat;

public class Employee {
    private String empNum;
    private String empDeptNum;
    private String empFName;
    private String empMName;
    private String empLName;
    private String empSSN;
    private String empDoB;
    private String empPoB;
    private String empAddress;
    private String empZipCode;
    private String empEmergencyPhone;
    private String empEmergencyPoC;
    private String empTitle;
    private String empGender;
    private String empHomePhone;
    private String empCellPhone;
    private String empAniversaryMonth;
    private String empSixMonthReview;
    private String empAnnualReview;
    private String empSalary;
    private String empVeteranStatus;

    public String getEmpNum() {
        return empNum;
    }

    public String getEmpDeptNum() {
        return empDeptNum;
    }

    public String getEmpFName() {
        return empFName;
    }

    public String getEmpMName() {
        return empMName;
    }

    public String getEmpLName() {
        return empLName;
    }

    public String getEmpSSN() {
        return empSSN;
    }

    public String getEmpDoB() {
        return empDoB;
    }

    public String getEmpPoB() {
        return empPoB;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public String getEmpZipCode() {
        return empZipCode;
    }

    public String getEmpEmergencyPhone() {
        return empEmergencyPhone;
    }

    public String getEmpEmergencyPoC() {
        return empEmergencyPoC;
    }

    public String getEmpTitle() {
        return empTitle;
    }

    public String getEmpGender() {
        return empGender;
    }

    public String getEmpHomePhone() {
        return empHomePhone;
    }

    public String getEmpCellPhone() {
        return empCellPhone;
    }

    public String getEmpAniversaryMonth() {
        return empAniversaryMonth;
    }

    public String getEmpSixMonthReview() {
        return empSixMonthReview;
    }

    public String getEmpAnnualReview() {
        return empAnnualReview;
    }

    public String getEmpSalary() {
        return empSalary;
    }

    public String getEmpVeteranStatus() {
        return empVeteranStatus;
    }

    public void setEmpNum(String empNum) {
        if(empNum.length() != 7){
            throw new InvalidSQLTypeException();
        }
        this.empNum = empNum;
    }

    public void setEmpDeptNum(String empDeptNum) {
        if(empDeptNum.length() != 7){
            throw new InvalidSQLTypeException();
        }
        this.empDeptNum = empDeptNum;
    }

    public void setEmpFName(String empFName) {
        if(empFName.length() > 45){
            throw new InvalidSQLTypeException();
        }
        this.empFName = empFName;
    }

    public void setEmpMName(String empMName) {
        if(empMName.length() > 45){
            throw new InvalidSQLTypeException();
        }
        this.empMName = empMName;
    }

    public void setEmpLName(String empLName) {
        if(empLName.length() > 45){
            throw new InvalidSQLTypeException();
        }
        this.empLName = empLName;
    }

    public void setEmpSSN(String empSSN) {
        if(empSSN.length() != 9){
            throw new InvalidSQLTypeException();
        }
        this.empSSN = empSSN;
    }

    public void setEmpDoB(String empDoB) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.parse(empDoB);
        }catch(java.text.ParseException e){
            throw new InvalidSQLTypeException();
        }
        this.empDoB = empDoB;
    }

    public void setEmpPoB(String empPoB) {
        if(empPoB.length() > 45){
            throw new InvalidSQLTypeException();
        }
        this.empPoB = empPoB;
    }

    public void setEmpAddress(String empAddress) {
        if(empAddress.length() > 100){
            throw new InvalidSQLTypeException();
        }
        this.empAddress = empAddress;
    }

    public void setEmpZipCode(String empZipCode) {
        if(empZipCode.length() != 5){
            throw new InvalidSQLTypeException();
        }
        this.empZipCode = empZipCode;
    }

    public void setEmpEmergencyPhone(String empEmergencyPhone) {
        if(empEmergencyPhone.length() != 10){
            throw new InvalidSQLTypeException();
        }
        this.empEmergencyPhone = empEmergencyPhone;
    }

    public void setEmpEmergencyPoC(String empEmergencyPoC) {
        if(empEmergencyPoC.length() > 45){
            throw new InvalidSQLTypeException();
        }
        this.empEmergencyPoC = empEmergencyPoC;
    }

    public void setEmpTitle(String empTitle) {
        if(empTitle.length() > 45){
            throw new InvalidSQLTypeException();
        }
        this.empTitle = empTitle;
    }

    public void setEmpGender(String empGender) {
        if(empGender.length() > 1){
            throw new InvalidSQLTypeException();
        }
        this.empGender = empGender;
    }

    public void setEmpHomePhone(String empHomePhone) {
        if(empHomePhone.length() > 10){
            throw new InvalidSQLTypeException();
        }
        this.empHomePhone = empHomePhone;
    }

    public void setEmpCellPhone(String empCellPhone) {
        if(empCellPhone.length() > 10){
            throw new InvalidSQLTypeException();
        }
        this.empCellPhone = empCellPhone;
    }

    public void setEmpAniversaryMonth(String empAniversaryMonth) {
        if(empAniversaryMonth.length() > 2){
            throw new InvalidSQLTypeException();
        }
        this.empAniversaryMonth = empAniversaryMonth;
    }

    public void setEmpSixMonthReview(String empSixMonthReview) {
        if(empSixMonthReview.length() > 2){
            throw new InvalidSQLTypeException();
        }
        this.empSixMonthReview = empSixMonthReview;
    }

    public void setEmpAnnualReview(String empAnnualReview) {
        if(empAnnualReview.length() > 2){
            throw new InvalidSQLTypeException();
        }
        this.empAnnualReview = empAnnualReview;
    }

    public void setEmpSalary(String empSalary) {
        if(empSalary.length() > 10){
            throw new InvalidSQLTypeException();
        }
        this.empSalary = empSalary;
    }

    public void setEmpVeteranStatus(String empVeteranStatus) {
        if(empSalary.length() > 8){
            throw new InvalidSQLTypeException();
        }
        this.empVeteranStatus = empVeteranStatus;
    }
}
