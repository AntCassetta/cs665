package io;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ReadFile {
	
	public void readUserFile(String givenUserName, int givenUserID);

	
	public void readRosterFile(String userName, int userID);


	public void readInventoryFile(String givenInvName, int givenInvID) throws IOException, FileNotFoundException;
	
	
}//end ReadFile