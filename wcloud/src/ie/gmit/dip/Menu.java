package ie.gmit.dip;

import java.util.Scanner; // add scanner to detect options etc

/**
 * 
 * @author James Lynch
 * @version 1.0 wordCloud
 * @since JavaSE-15
 * 
 *        The Class <b> Menu </b> waits for the user to select a file or quit
 *        the application. If the user selects input a file, simultaneously the
 *        user is also buffering in the list of ignoreWords text file.
 * 
 *        See userInput
 * 
 */

public class Menu {

	private static Scanner s;
	private static Boolean active = true;

	/**
	 * The <b> userInput </b> method activates the scanner for input while showing
	 * the menu options for the user choices. .
	 * 
	 */

	public void userInput() {
		s = new Scanner(System.in);

		showMenu();
		while (active == true) {

			int select = Integer.parseInt(s.next());

			if (select == 1) {
				InputStream.readFile();
				IsValidFile.fileSelect();

			} else if (select == 2) {
				// shuts down the app
				System.out.println("Shutting Down");
				active = false;
			}

		}
	}

	/**
	 * The <b> showMenu </b> method provides a primitive GUI for the user.
	 *
	 */
	private static void showMenu() {
		System.out.println("####################################");
		System.out.println("#                                  #");
		System.out.println("## Welcome to the Word Cloud Menu ##");
		System.out.println("#                                  #");
		System.out.println("####################################");
		System.out.println();
		System.out.println("Press 1 to Enter a File Path "); // file name dir "example.txt" parce the file to a <map
																// string int>
		System.out.println("");
		System.out.println("Press 2 to Shut Down the App ");
		System.out.println("");
		System.out.println("####################################");

	}
}