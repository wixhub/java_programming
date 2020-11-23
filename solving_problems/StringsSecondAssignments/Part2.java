/**
 * Finding Many Genes
 * 
 * Part 2: How many occurrences of a string appear in another string
 * 
 * @source Week 2 Coursera cource 'Java Programming and Software Engineering Fundamentals Specialization' by  Duke University
 * 
 * @author Jana Semenova
 * @version 1
 */

import edu.duke.*;
import java.io.*;

public class Part2 {
    public int howMany(String stringA, String stringB){
        //how many times stringa appears in stringb
        int count = 0;
        int currIndex = 0;
        int checkIndex = 0;
        
        while (true) {
           checkIndex = stringB.indexOf(stringA, currIndex);
           if (checkIndex < 0){
              break;
           }
           count++;
           currIndex = stringB.indexOf(stringA, checkIndex) + stringA.length();
        }
        return count;
    }
    
    public void testHowMany(){
        System.out.println("* ");
        System.out.println("* Start test HowMany");
        int count = 0;
        count = howMany("GAA", "ATGAACGAATTGAATC");
        System.out.println("count=" + count);
        //returns 3 as GAA occurs 3 times
        count = howMany("AA", "ATAAAA"); 
        System.out.println("count=" + count);
        //returns 2. The AA’s found cannot overlap
        System.out.println("* End   test HowMany");
    }
}