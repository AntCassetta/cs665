package RefrigeratorRaider;

import userProfiles.RaiderUser;

public class Context {
	
	   private RaiderUser activeUser = RaiderUser.getInstane();
	   
	   private State state;

	   public Context(){
	      state = null;
	   }

	   public void setState(State state){
	      this.state = state;		
	   }

	   public State getState(){
	      return state;
	   }
	   
	   public RaiderUser getUser(){return activeUser;}
	
}
