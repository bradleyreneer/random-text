/**
 * 
 */
package org.reneer.verse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author bradley reneer
 *
 */
public class Bible extends Book {

    /**
     * 
     */
    private static final String FIRST_BOOK_MARKER = "THE FIRST BOOK OF MOSES, CALLED GENESIS";

    public Bible() {
        // using AV1611Bible.txt instead of pg10.txt -- pg10.txt has at least
        // one verse (Rev. 22:20) which
        // is not included in the same line
        super.setRootFileLocation("resources/AV1611Bible");
        setup();
    }

    protected void setup() {
        this.verses = new ArrayList<String>();

        try {
            BufferedReader bufferedReader = super.bookReader();
            String line;
            String currentBook = "";
            int currentChapter = 0;
            int currentVerse = 0;

            // Go to the beginning of the books
            boolean foundBeginning = false;
            line = bufferedReader.readLine();
            while (line!=null&&!foundBeginning) {
                line.trim();
                if (line.toUpperCase().contains(FIRST_BOOK_MARKER)) {
                    foundBeginning = true;
                    currentBook = line;
                }
                line = bufferedReader.readLine();
            }

            // we are looking for the following formatting
            //
            // THE FIRST BOOK OF MOSES, CALLED GENESIS
            //
            // CHAPTER 1
            // 1 In the beginning God created the heaven and the earth.
            // 2 And the earth was without form, and void; and darkness [was]
            // upon the face of the deep. And the Spirit of God moved upon the
            // face of the waters.

            // Blank lines are skipped
            // Finding a number at the beginning of the line means we make a
            // verse out of this line using the current Book and Chapter
            // Word "CHAPTER" at the beginning we look for a number to set the
            // current Chapter
            // Any other word and the line becomes the current Book

            while (line!=null) {
                String[] result;
                line.trim();
                if (!line.equals("")) {
                    if (line.toUpperCase().startsWith("CHAPTER")) {
                        result = line.split("\\s");
                        try {
                            // get second element - should be the chapter number
                            currentChapter = Integer.parseInt(result[1]); 
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    } else {
                        result = line.split("\\s");
                        try {
                            currentVerse = Integer.parseInt(result[0]);
                            String newVerse = currentBook+" "+currentChapter+":"+currentVerse+"\r\n"
                                            +line.substring(result[0].length());
                            this.verses.add(newVerse.toString());
                        } catch (NumberFormatException e) {
                            currentBook = line;
                        }
                    }
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
