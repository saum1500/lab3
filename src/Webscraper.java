import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class Webscraper {


    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int counter(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char possibleSpace = text.charAt(i);
            if (possibleSpace == ' ') {
                int j = i + 1;
                while(true) {
                    if (text.charAt(j) != ' ') {
                        count = count + 1;
                        i = j;
                        break;
                    }
                    j++;

                }

            }

        }
        return count;
    }
    public static void main(String Args[]) {

        String play = urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(counter(play));
    }
}

