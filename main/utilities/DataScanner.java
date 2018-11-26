package utilities;
import java.util.Scanner;

public class DataScanner {
	private static Scanner dataScanner = new Scanner(System.in);  // Reading from System.in
	
	private DataScanner(){}
	
	public static Scanner getDataScanner(){ return dataScanner; }

}//end DataScanner
