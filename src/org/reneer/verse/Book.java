/**
 * 
 */
package org.reneer.verse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author breneer
 *
 */
public abstract class Book {

    protected BufferedReader bufferedReader;
    protected List<String> verses;
    protected String title;
    protected String copyRight;
    protected String rootFileLocation;
    private static final String BOOK_EXTENTION = ".txt";
    private static final String TITLE_EXTENTION = ".title";
    private static final String COPY_RIGHT_EXTENTION = ".cpnotice";

    public void setRootFileLocation(String newFileLocation) {
        this.rootFileLocation = newFileLocation;
    }

    public List<String> getVerses() {
        return this.verses;
    }

    protected void readBook() {
        this.verses = new ArrayList<String>();

        try {
            BufferedReader bufferedReader = bookReader();
            String line;
            line = bufferedReader.readLine();

            while (line!=null) {
                line.trim();
                // look for lines in the format "book 4:5"
                if (line.contains(":")) {
                    String chapter = line.substring(0, line.indexOf(":")+1).trim();
                    String tail = line.substring(line.indexOf(":")+1).trim();
                    try {
                        Integer.parseInt(tail);
                        // if the parse does not throw an exception then this
                        // should be a verse
                        StringBuffer newVerse = new StringBuffer(chapter);
//                        newVerse.append("\r\n");
                        line = bufferedReader.readLine();
                        while (line != null && line.compareTo("")!=0) {
                            newVerse.append(line.trim() + " ");
                            line = bufferedReader.readLine();
                        }
                        this.verses.add(newVerse.toString());
                    } catch (NumberFormatException e) {
                        // we just ignore this. Must not be a verse marker.
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

    /**
     * @return
     */
    protected BufferedReader bookReader() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(this.rootFileLocation + BOOK_EXTENTION);
        // FileReader fileReader = new FileReader(rootFileLocation);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return bufferedReader;
    }

    protected String getBookTitle() {
        return getFirstLineOfFile(TITLE_EXTENTION);
    }
    protected String getBookCopyRight() {
        return getFirstLineOfFile(COPY_RIGHT_EXTENTION);
    }

    private String getFirstLineOfFile(String extention) {
        try {
            InputStream inputStream = this.getClass().getClassLoader()
                            .getResourceAsStream(this.rootFileLocation + extention);
            // FileReader fileReader = new FileReader(rootFileLocation);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            return bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return " ";
    }
}
