// Turn a file into a string
// File name inside, with a method to clean out commas, periods, etc.
// To redirect output to a file java fileToString03 > nameoffile.txt

import java.io.*;

public class utilities {
	
	//Method called when using utilities to clean up a text file.
	//utilities.fileToStringArray("./filename.txt")
	public static String[] fileToStringArray (String fileName) throws IOException{
		String data = fileToString(fileName);
		String str = cleanText(data);
		String[] wordArray = str.split(" ");
		return wordArray;
	}
	
	//Takes a file and converts the entire thing to one string.
	public static String fileToString (String fileName) {
		String result = "";
		try {
			FileInputStream file = new FileInputStream(fileName);
			byte[] b = new byte[file.available()];
			file.read(b);
			file.close();
			result = new String(b);
		}
		catch (Exception e) {
			System.out.println("oops");
		}
		return result;
	}
	
	//Cleans up the text in the file using regular expressions to remove certain
	//elements in the data set.
	public static String cleanText (String s) {
		s = s.replaceAll("\\p{Punct}", "");
		s = s.replaceAll("\\s+", " ");
		return s;
	}
	
	//Clean up text in the file to remove punctuation, spaces, and numbers
	public static String cleanWordsOnly (String s) {
		s = s.replaceAll("\\p{Punct}", "");
		s = s.replaceAll("\\d","");
		s = s.replaceAll("\\s+", " ");
		return s;
	}
}