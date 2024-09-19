package ie.gmit.dip;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.Map;
import java.util.Set;

/**
 * @version 1.0 wordCloud
 * @since JavaSE-15
 * 
 *        The Class <b> WordCloud</b> takes a Map from the InputStream Class and
 *        tries to add the filtered words to a word cloud.
 * 
 * 
 */
public class WordCloud {
	private static String[] fonts;
	private static String[] color;

	/**
	 * The <b> goWord </b> method takes in the Map and converts the words from the
	 * key set to String type so the drawing tool can add them in. The variable str
	 * matches is meant to catch and stop duplicate words from being posted on the
	 * same line.
	 * 
	 */

	public static void goWord(Map<String, Integer> wordCloudOut) throws Exception {

		Set<String> s = wordCloudOut.keySet(); // O(1) Big-O

		String str = s.toString();

		// for (String str : s) {

		for (int i = 0; i < 10; i++) {

			if (!str.matches(str)) {

				// System.out.println(str);

				Font font = new Font(Font.SANS_SERIF, Font.BOLD, 62);
				BufferedImage image = new BufferedImage(600, 300, BufferedImage.TYPE_4BYTE_ABGR);
				Graphics graphics = image.getGraphics();
				graphics.setColor(Color.red);
				graphics.setFont(font);
				graphics.drawString(str, 0, 100);

				font = new Font(Font.SANS_SERIF, Font.ITALIC, 42);
				graphics.setFont(font);
				graphics.setColor(Color.yellow);
				graphics.drawString(str, 10, 120);

				font = new Font(Font.MONOSPACED, Font.PLAIN, 22);
				graphics.setFont(font);
				graphics.setColor(Color.blue);
				graphics.drawString(str, 40, 140);

				font = new Font(Font.SANS_SERIF, Font.PLAIN, 22);
				graphics.setFont(font);
				graphics.setColor(Color.GREEN);
				graphics.drawString(str, 80, 125);

				font = new Font(Font.MONOSPACED, Font.PLAIN, 22);
				graphics.setFont(font);
				graphics.setColor(Color.CYAN);
				graphics.drawString(str, 120, 105);

				font = new Font(Font.SANS_SERIF, Font.PLAIN, 22);
				graphics.setFont(font);
				graphics.setColor(Color.magenta);
				graphics.drawString(str, 140, 180);

				font = new Font(Font.MONOSPACED, Font.PLAIN, 22);
				graphics.setFont(font);
				graphics.setColor(Color.ORANGE);
				graphics.drawString(str, 130, 60);

				// implement a file save system here

				graphics.dispose();
				ImageIO.write(image, "png", new File("./imageOut.png"));

			}
		}
	}
}
