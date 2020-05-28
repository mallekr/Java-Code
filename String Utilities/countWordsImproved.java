// Count the frequency of each word in our file.
// Use the Map data structure to do it in one pass.
// Improve the method so that it is case insensitive, sort highest value first, and clean up output.

import java.io.*;
import java.util.*;

public class countWordsImproved {
	public static void main (String[] args) throws IOException{
		String[] wordArray = utilities.fileToStringArray("./awmt.txt");
		List<String> wordList = Arrays.asList(wordArray);
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		String key = "";
		Integer value;
		Iterator<String> it = wordList.iterator();
		
		while (it.hasNext()) {
			key = it.next().toLowerCase();
			value = tm.get(key);
			if (value == null) {
				tm.put(key, 1);
			}
			else {
				tm.put(key, value+1);
			}
		}
		
		Set<String> allKeys = tm.keySet();
		Iterator<String> ki = allKeys.iterator();
		
		orderedPair[] opArray = new orderedPair[allKeys.size()];
		int index = 0;
		
		while (ki.hasNext()) {
			key = ki.next();
			value = tm.get(key);
			opArray[index++] = new orderedPair(key, value);
		}
			
		List<orderedPair> opList = Arrays.asList(opArray);
		// use collections method to reverse the order.
		Collections.sort(opList, Collections.reverseOrder());
		Iterator<orderedPair> li = opList.iterator();
		
		while (li.hasNext()) {
			orderedPair out = li.next();
			System.out.print(out);
		}
		//System.out.println(opList);
	}
}