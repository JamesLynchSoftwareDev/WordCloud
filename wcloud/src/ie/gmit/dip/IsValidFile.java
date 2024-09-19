package ie.gmit.dip;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * 
 * @author James Lynch
 * @version 1.0 wordCloud
 * @since JavaSE 15
 * 
 *        The Class <b> IsValidFile</b> checks to see if the users file they
 *        submit is a valid file path. It should be displayed as e.g :
 *        C:\Users\xxxx\Desktop\testfile.txt See fileSelect
 */

public class IsValidFile {

	public static boolean fileOk = false;
	private static Path userPath = null;
	private static Scanner scan = new Scanner(System.in);

	/**
	 * The <b> fileSelect </b> method waits for a user to input a file path address
	 * to be passed to the InputStream Class.
	 *
	 * If the users path is incorrect it will catch the exception.
	 *
	 */
	public static void fileSelect() {

		while (fileOk == false) {

			try {
				System.out.println();
				System.out.println("Please enter a valid filepath : ");
				System.out.println("e.g : C:\\Users\\xxxx\\Desktop\\file.txt ");
				String filePath = scan.nextLine();

				userPath = Paths.get(filePath);

				if (filePath.trim() == "") { // checks for null

					System.out.println("That path was empty Try again");
					continue;

				}

				if (Files.exists(userPath)) {

					fileOk = true;

					String pathIn;

					pathIn = userPath.toString(); // converts the users path to string for the method in Inputstream
													// Class
					InputStream.usersFileIn(pathIn);

				} else {

					System.out.println("Sorry File does not exist");

				}

			} catch (InvalidPathException e) {

				System.out.println("Path not Valid");

			}

			System.out.println("");
			System.out.println("");
			System.out.println("");

		}

		System.out.println("~###############################~## ");
		System.out.println("~##  WordCloud has been Generated ~##");
		System.out.println("~###############################~## ");
		System.out.println();

		Menu m = new Menu();
		m.userInput();

	}
}
