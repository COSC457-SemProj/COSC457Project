import exception.InvalidSQLTypeException;

public class Contract {
    private String conNum;
    private String conCustNum;
    private String conName;
    private String conBudget;
    
    public String getConNum(){
    return conNum;
    }
    public String getConCustNum(){
        return conCustNum;
    }
    public String getConName(){
        return conName;
    }
    public String ConBudget(){
        return conBudget;
    }
    public void setConNum(String conNum){
         if( conNum== null || conNum.length() != 7){
            throw new InvalidSQLTypeException();
        }
        this.conNum = conNum;
    }
    public void setConCustNum(String conCustNum){
        if( conCustNum== null || conCustNum.length() != 7){
            throw new InvalidSQLTypeException();
        }
        this.conCustNum = conCustNum;
    }
    public void setConName(String conName){
        if(conName == null || conName.length() > 45){
            throw new InvalidSQLTypeException();
        }
        this.conName = conName; 
    }
    public void setConBudget(String conBudget){
        if(conBudget != null && conBudget.length() > 13){
            throw new InvalidSQLTypeException();
        }
        this.conBudget = conBudget;
    }
}
