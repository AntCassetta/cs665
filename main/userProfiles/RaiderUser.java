package userProfiles;


public class RaiderUser {
	
	private static final RaiderUser instance = new RaiderUser();
	private long userID;
	private String userName;
	private String userType;
	private enum userLvls {OWNER, BUSINESS, CHARITY, RAIDER }
	
	private RaiderUser(){}
	
	public static RaiderUser getInstane(){
		return instance;
	}//end getInstance
	
	public String getUserName() { return userName; }
	
	public String getUserType() { return userType; }
	
	public long getUserID() { return userID; }
	
	public void setUserID(long givenUserID) { userID = givenUserID; }//end setuserID
	
	public void setUserName(String givenName) { userName = givenName; }//end setUserName
	
	public void setUserType(String givenUserType) { 
		
		try {
			String candidateType = givenUserType.toUpperCase();
			   userLvls.valueOf(candidateType); 
			   System.out.println("valid");
			   userType = givenUserType;
			   
			   
			} catch (IllegalArgumentException e) {
			   System.out.println("invalid, setting user level to Raider");
			   userType = "RAIDER";
			}//end try catch
	
	}//end setUserType

}//end User