package ie.gmit.dip;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.io.BufferedReader;

/**
 * 
 * @author James Lynch
 * @version 1.0 wordCloud
 * @since JavaSE 15
 * 
 *        The Class <b> InputStream </b> takes in the ignore words list and the
 *        users input file and converts them into TreeSet String. The word
 *        frequency KV pair are also retrieved and stored into a Map String,
 *        Integer TreeMap.
 * 
 */

public class InputStream {
	private static Set<String> ignoreW = new TreeSet<String>(); // reads in ignore words
	private static Set<String> newtxt1 = new TreeSet<String>(); // takes the users txt file
	protected static Map<String, Integer> userIn = new TreeMap<String, Integer>(); // makes for KV pairs

	/**
	 * The method <b> readFile </b> reads in the already supplied ignoreWords.txt
	 * file to a TreeSet. it is executed at the same time the user selects to choose
	 * a filepath in the Menu Class.
	 *
	 */
	public static void readFile() {

		try { // reads in the Ignore txt words

			BufferedReader br = null;
			String read;
			String[] ignoreWords;

			br = new BufferedReader(new FileReader(".\\ignorewords.txt")); // rem to put in ie folder for cli

			while ((read = br.readLine()) != null) {
				ignoreWords = read.split(" ");
				ignoreW = new TreeSet<String>(Arrays.asList(ignoreWords)); // O(log n) -- BIG O

			}
			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * The <b> userFileIn </b> takes in the users specified file path as String
	 * type. Converts the text file into a TreeSet String and filters the words from
	 * the ignoreWords.txt file. The word frequency is then sought and stored into a
	 * TreeMap String, Integer
	 * 
	 * @param pathIn the users file path.
	 * 
	 */

	// Reads the userFile In

	public static void usersFileIn(String pathIn) {
		System.out.println();
		System.out.println(pathIn);
		System.out.println("  Generating Word Cloud...");
		try {

			BufferedReader br2 = null;
			String read2;
			String[] newtxt; //

			br2 = new BufferedReader(new FileReader(pathIn));

			while ((read2 = br2.readLine()) != null) {
				newtxt = read2.toLowerCase().split(" "); // spaces & lcase
				newtxt1 = new TreeSet<String>(Arrays.asList(newtxt)); // O(log n) --BIG O
				newtxt1.removeAll(ignoreW); // removes common words from the user input

				// array to a string

				for (String word : newtxt1) {

					int freq = 1; // word freq starts here

					if (userIn.containsKey(word)) { // treemap here

						freq = userIn.get(word);
						freq++;
					}

					userIn.put(word, (freq));// adds the frequency of the word occuring

					AddMap.filterFreq(userIn);

				}

			}
			br2.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
