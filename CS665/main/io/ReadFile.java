package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

public interface ReadFile {
	
	public Vector<String> readUserFile(String givenUserName, int givenUserID, String givenUserType);

	
	public Vector<String> readRosterFile(String userName, int userID);


	public Vector<String> readInventoryFile(String givenInvName, int givenInvID) throws IOException, FileNotFoundException;
	
	
}//end ReadFile