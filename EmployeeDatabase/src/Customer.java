
import exception.InvalidSQLTypeException;

public class Customer {
    private String custNum;
    private String custName;   
    private String custPrimaryAddress;
    private String PoC;
    private String custPhone;
    
    public String getCustNum(){
    return custNum;
    }
    public String getCustName(){
        return custName;
    }
    public String getCustPrimaryAddress(){
        return custPrimaryAddress;
    }
    public String getPoC(){
        return PoC;
    }
    public String getCustPhone(){
        return custPhone;
    }
    public void setCustNum(String custNum){
        if(custNum == null || custNum.length() != 7){
            throw new InvalidSQLTypeException();
        }
        this.custNum = custNum;
    }
    public void setCustName(String custName){
        if(custName == null || custName.length() > 45){
            throw new InvalidSQLTypeException();
        }
        this.custName = custName;
    }
    public void setCustPrimaryAddress(String custPrimaryAddress){
        if(custPrimaryAddress == null || custPrimaryAddress.length() > 100){
            throw new InvalidSQLTypeException();
        }
        this.custPrimaryAddress = custPrimaryAddress;
    }
    public void setPoC(String PoC){
        if(PoC == null || PoC.length() > 45){
            throw new InvalidSQLTypeException();
        }
        this.PoC = PoC;
    }
    public void setCustPhone(String custPhone){
      if(custPhone == null || custPhone.length() > 45){
            throw new InvalidSQLTypeException();
        }
        this.custPhone = custPhone;
    }  
    
}
