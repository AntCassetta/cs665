package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

public interface ReadFile {
	
	
	public Vector<String> readUserFile(String givenUserName, long givenUserID, String givenUserType) throws IOException, FileNotFoundException;

	
	public Vector<String> readRosterFile(String userName, long userID) throws IOException, FileNotFoundException;


	public Vector<String> readInventoryFile(String givenInvName, long givenInvID) throws IOException, FileNotFoundException;
	
	
}//end ReadFile