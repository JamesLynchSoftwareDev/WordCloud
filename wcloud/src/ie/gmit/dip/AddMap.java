package ie.gmit.dip;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

/**
 * 
 * @author James Lynch
 * @version 1.0 wordCloud
 * @since JavaSE-15
 * 
 *        The Class <b> AddMap </b> houses the filter before adding the words to
 *        the word cloud.
 * 
 */

public class AddMap {
	private static Map<String, Integer> wordCloudOut = new HashMap<String, Integer>();
	// Map<String, Integer> wordsOut1 = new TreeMap<String, Integer>();

	/**
	 * The method <b> filterFreq </b> takes in a Map String, Integer to be passed
	 * through sets to Join and filter out duplicates in the union of the sets.
	 * which are then pass to the word cloud through another Map.
	 * 
	 * @param String, Integer userIn
	 * @return String for the word cloud
	 */

	public static void filterFreq(Map<String, Integer> userIn) {

		Set<Entry<String, Integer>> entries = userIn.entrySet(); // sorts them

		Set<Entry<String, Integer>> filterOut = new TreeSet<>(Map.Entry.comparingByValue()); // O(log n) Big-O

		filterOut.addAll(entries);

		for (Entry<String, Integer> word : filterOut) {

			int val = word.getValue();

			int frequency = 1;

			if (filterOut.contains(word)) { // O(1) Big-O
				frequency = val;
				frequency++;

			}

			wordCloudOut.put(word.getKey(), frequency); // O(1) Big-O

			try {

				WordCloud.goWord(wordCloudOut);

			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}
}
