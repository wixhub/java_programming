/**
 * Finding genes in a strand of DNA
 * 
 * Part 4: Problem Finding Web Links
 * 
 * @source Week 2 Coursera cource 'Java Programming and Software Engineering Fundamentals Specialization' by  Duke University
 * 
 * @author Jana Semenova
 * @version 1
 */

import edu.duke.*;
import java.io.*;

public class Part4 {
    public void readURL(String urlString, String checkWord) {
        String quotes = "\"";
        String result = "";
        URLResource resource = new URLResource(urlString);
        //System.out.println("***   ***   ***");
        for (String currWord : resource.words()) {
            int check = currWord.toLowerCase().indexOf(checkWord.toLowerCase());
            if (check >= 0) {
                //System.out.println("check " + check);
                //System.out.println("currWord " + currWord);
                //
                int start = currWord.toLowerCase().lastIndexOf(quotes, check) + 1;
                int end = currWord.toLowerCase().indexOf(quotes, check);
                //System.out.println("start " + start + " end " + end);
                if (start >= 0 && end > 0) {
                    result = currWord.substring(start, end);
                    System.out.println(result);
                }
            }
        }
    }
    
    public void testStrings() {
        readURL("https://www.dukelearntoprogram.com/course2/data/manylinks.html", "youtube.com");
        //readURL("http://www.dukelearntoprogram.com/course2/data/manylinks.html", "youtube.com");
    }
}
