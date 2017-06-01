package RefrigeratorRaider;

import userProfiles.User;

public class Context {
	
	   private User activeUser = User.getInstane();
	   
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
	   
	   public User getUser(){return activeUser;}
	
}
