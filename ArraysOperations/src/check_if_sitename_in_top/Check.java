package check_if_sitename_in_top;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Check {  //TODO: check if the input is correct "http, 5i1f.com"
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("*** Enter your full site name to see is it in top most visited sites! ***");
		Scanner scan1 = new Scanner(System.in);
		String choice = scan1.nextLine();
		Scanner scan = new Scanner(new File("resources\\sites.txt"));
		String content = scan.useDelimiter("\\Z").next(); // get the content  
		String[] stringWords = content.split(" ");  
		long start_time = System.nanoTime();
		/*boolean iss = findStringFirstMethod(stringWords, choice);  Uncomment to see difference in times
		long end_time = System.nanoTime();                           between the two search methods
		double difference = (end_time - start_time) / 1e6;
		System.out.println(iss);
		System.out.println("TIME: " + difference);
		long start_time2 = System.nanoTime();*/
		boolean is2 = findStringSecondMethod(stringWords, choice);
		//long end_time2 = System.nanoTime();
		//double difference2 = (end_time2 - start_time2) / 1e6;
		System.out.println(is2);
		//System.out.println("TIME: " + difference2);
	}

	public static boolean findStringFirstMethod(String[] arr, String element) {
		boolean found = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(element))
				found = true;
		}
		return found;
	}
	
	/**
	 * search for element in unsorted array  
	 * @param arr
	 * @param element
	 * @return
	 */
	public static boolean findStringSecondMethod(String[] arr, String element) {

		if (arr[arr.length - 1].equals(element))
			return true;
		String backup = arr[arr.length - 1];
		arr[arr.length - 1] = element;
		for (int i = 0;; i++) {
			if (arr[i].equals(element)) {
				arr[arr.length - 1] = backup;

				if (i < arr.length - 1) {
					return true;
				} else {
					return false;
				}
			}
		}
	}
}
