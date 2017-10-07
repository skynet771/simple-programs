package alphabetlist_of_words_from_file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Reading from file and sorts the words from the sentences in alphabetical
 * order, with removed duplicates
 * 
 * @author ditsinski
 *
 */
public class Exec {

	public static void main(String[] args) throws IOException {
		System.out.println("* Please enter the path to the file you want to use *");
		Scanner scan1 = new Scanner(System.in);
		System.out.print(">> ");
		String input = scan1.nextLine();
		scan1.close();
		Scanner scan = new Scanner(new File(input));
		String content = scan.useDelimiter("\\Z").next(); // get the content of
															// the file
		scan.close();
		String[] stringWords = content.split("\\W+"); // split the content of
														// the file to words
		List<String> words = new ArrayList<String>(Arrays.asList(stringWords)); // convert to list
		Collections.sort(words, new Comparator<String>() { // sort the list
			@Override
			public int compare(String s1, String s2) {
				return s1.compareToIgnoreCase(s2);
			}
		});
		removeDuplicates(words);
		for (String s : words) {
			System.out.println(s);
		}
	}

	/**
	 * removes duplicate words from list
	 * 
	 * @param ar
	 */
	public static void removeDuplicates(List<String> list) {

		int prev = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).equals(list.get(prev))) {
				list.remove(i);
			}
			prev++;
		}
	}

}
