/**
 * 
 */
package org.reneer.verse;

import java.io.PrintStream;
import java.util.List;
import java.util.Random;

/**
 * @author bradley reneer
 *
 */
public class RandomScriptureVerse {
    public static void main(String[] args) {
        System.out.print(verses());
    }

    /**
     * 
     */
    public static String verses() {
        StringBuilder stringBuilder = new StringBuilder();
        Book bookOfMormon = new BookOfMormon();
        List<String> bookOfMormonVerses = bookOfMormon.getVerses();
        int size = bookOfMormonVerses.size();
        Random random = new Random();

        int i = random.nextInt(size);
        stringBuilder.append("<p>Getting verse " + i + " of " + size + " from The Book of Mormon:</p>");
        stringBuilder.append("<p>" + bookOfMormonVerses.get(i) + "</p>");

        stringBuilder.append("<br/><br/>");

        Book bible = new Bible();
        List<String> bibleVerses = bible.getVerses();
        size = bibleVerses.size();
        random = new Random();

        i = random.nextInt(size);
        stringBuilder.append("<p>Getting verse "+i+" of "+size+" from The Bible:</p>");
        stringBuilder.append("<p>" + bibleVerses.get(i) + "</p>");

        return stringBuilder.toString();
    }
}
