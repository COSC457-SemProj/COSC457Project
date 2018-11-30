import exception.InvalidSQLTypeException;

public class Location{

   private String locNum;
   private String locAddress;
   private String locSecure;
   private String locName;


   public String getLocNum(){return locNum}
   public String getLocAddress(){return locAddress}
   public String getLocSecure(){return locSecure}
   public String getLocName(){return locName}


   public void setLocNum(String locNum){
       if(locNum == null || locNum.length > 7) {
           throw new InvalidSQLTypeException();
       }
       this.locNum = locNum;
   }

   public void setLocAddress(String locAddress){
       if(locAddress == null || locAddress.length > 100) {
           throw new InvalidSQLTypeException();
       }
       this.locAddress = locAddress;
   }
   public void setLocSecure(String locSecure){
       if(locSecure == null || locSecure.length > ) {
           throw new InvalidSQLTypeException();
       }
       this.locSecure = locSecure;
   }
   public void setLocName(String locName){
       if(locName != null && locName.length > ) {
           throw new InvalidSQLTypeException();
       }
       this.locName = locName;

   }



}