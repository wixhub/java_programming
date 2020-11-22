/**
 * Finding genes in a strand of DNA
 * Using the StorageResource Class
 * 
 * Part 3: Problem Solving with Strings
 * 
 * @source Week 2 Coursera cource 'Java Programming and Software Engineering Fundamentals Specialization' by  Duke University
 * 
 * @author Jana Semenova
 * @version 1
 */

import edu.duke.*;
import java.io.*;

public class Part3 {
    public boolean twoOccurrences(String stringA, String stringB) {
        int start = stringB.toLowerCase().indexOf(stringA.toLowerCase());
    	if (start == -1) {
    	    return false;
    	}
    	else {
    	    int twice = stringB.toLowerCase().indexOf(stringA.toLowerCase(), start + stringA.toLowerCase().length());
    	    if (twice == -1) {
    		return false;
            }
	    else {
		return true;
    	    }
    	}
    }
    
    public String lastPart(String stringA, String stringB) {
        int start = stringB.toLowerCase().indexOf(stringA.toLowerCase());
    	if (start == -1) {
    	    return stringB;
    	}
    	else {
    	    return stringB.substring(start + stringA.toLowerCase().length());
    	}
    }
    
    public void testStrings() {
    	boolean a = twoOccurrences("by", "A story by Abby Long");
    	boolean b = twoOccurrences("a", "banana");
    	boolean c = twoOccurrences("atg", "ctgtatgta");
    	System.out.println("***   ***   ***");
    	//System.out.println("String a " + a);
    	System.out.println("Result a " + a);
    	System.out.println("Result b " + b);
    	System.out.println("Result c " + c);
    	
    	String strA = lastPart("an", "banana");
    	String strB = lastPart("zoo", "forest");
    	System.out.println("The part of the string after an in banana is " + strA);
    	System.out.println("The part of the string after zoo in forest is " + strB);
    }
}
