package dataIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import io.ReadFile;

public class ProxyDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//Instantiate new file reader Proxy
		ReadFile read = new ProxyReadTxtFile();
		
		//test first UserList read
		Vector<String> test1 = read.readUserFile("TestOwner", 01, "owner");
		
		for(String I : test1){
			System.out.println(I);
		}
		
		//test second UserList read
		Vector<String> test2 = read.readUserFile("TestOwner", 01, "owner");
		
		for(String I : test2){
			System.out.println(I);
		}
		
		//test first roster read
		Vector<String> roster1 = read.readRosterFile("TestOwner", 01);
		System.out.println(roster1.size());
		do {
			
			System.out.println(roster1.remove(0));
			
		} while (roster1.size() > 0);
		
		//test second roster read
		Vector<String> roster2 = read.readRosterFile("TestOwner", 01);
		System.out.println(roster2.size());
		do {
			
			System.out.println(roster2.remove(0));
			
		} while (roster2.size() > 0);
		
		//test first inventory read
		Vector<String> inv1 = read.readInventoryFile("TestFridge", 01);
		
		do {
			
			System.out.println(inv1.remove(0));
			
		} while (inv1.size() > 0);
		
		//test second inventory read
		Vector<String> inv2 = read.readInventoryFile("TestFridge", 01);
		do {
			
			System.out.println(inv2.remove(0));
			
		} while (inv2.size() > 0);

	}

}
