package dataIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class WriteFileInventory implements WriteFile {

	private static String fileName;

	public void writeToFile (String givenInvName, int givenInvID, String givenItem, int givenQty) {
		
		fileName = givenInvName + String.format("%02d",givenInvID) +".txt";
		BufferedWriter bw = null;
		FileWriter fw = null;

		
		try {

			String data = givenItem + "," + givenQty+"\n";

			File file = new File(fileName);

			// if file doesn't exist, then create it
			if (!file.exists()) {
				file.createNewFile();
				
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(data);

			System.out.println("Data saved.");

		} catch (IOException ex) {

			ex.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}//end closure try catch 
		}//end writer try catch finally
		

	}//end writeToFile
	
}//end WriteFile
