package dataIO;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.ReadFile;

public class ProxyDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//Instantiate new file reader Proxy
		ReadFile read = new ProxyReadTxtFile();
		
		//test first UserList read
		read.readUserFile("TestOwner", 01);
		
		//test second UserList read
		read.readUserFile("TestOwner", 01);
		
		//test first roster read
		read.readRosterFile("TestOwner", 01);
		
		//test second roster read
		read.readRosterFile("TestOwner", 01);
		
		//test first inventory read
		read.readInventoryFile("TestFridge", 01);
		
		//test second inventory read
		read.readInventoryFile("TestFridge", 01);

	}

}
