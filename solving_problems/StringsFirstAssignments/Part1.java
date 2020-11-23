/**
 * Finding genes in a strand of DNA
 * 
 * Part 1: Finding a Gene - Using the Simplified Algorithm
 * 
 * @source Week 2 Coursera cource 'Java Programming and Software Engineering Fundamentals Specialization' by  Duke University
 * 
 * @author Jana Semenova
 * @version 1
 */

import edu.duke.*;
import java.io.*;

public class Part1 {
    public String findSimpleGene(String dna) {
    	int start = dna.indexOf("atg");
    	if (start == -1) {
    		return "";
    	}
    	int stop = dna.indexOf("taa", start + 3);
    	if (stop == -1) {
    		return "";
    	}
    	if ((stop - start) % 3 == 0) {
    		return dna.substring(start, stop + 3);
    	}
    	else {
    		return "";
    	}
    }
    
    public void testSimpleGene() {
    	String strDNAwithNoATG = "cccgtggggtttaaataataataggagagagagagagagttt";// DNA with no “ATG”
    	String strDNAwithNoTAA = "cccatggggtttatatattagtaggagagagagagagagttt";// DNA with no “TAA”
    	String strDNAwithNoATGorTAA = "cccatggggtttatatattagtaggagagagagagagagttt"; // DNA with no “ATG” or “TAA”
        String strDNAwithATGandTAA = "cccatggggtttgaaggataataataggagagagagagagagttt"; // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
    	String ap = "atggggtttaaataataatag"; // DNA with ATG, TAA and the substring between them is not a multiple of 3
    	//String a = strDNAwithATGandTAA;
    	String a = "atgccgtaa";
    	//String ap = "";
    	//String a = "ATGCCCTAA";
    	//String ap = "ATGCCCTAG";
    	String result = findSimpleGene(a);
    	if (result != "")
    	{
    		System.out.println("Result " + result);
    	}
    	else {
    	        System.out.println("No result");
    	}
    	if (a.equals(result)) {
    		System.out.println("success for " + a + " length " + a.length());
    	}
    	else {
    		System.out.println("mistake for input: " + a);
    		System.out.println("got: " + result);
    		System.out.println("not: " + a);
    	}
    }
}
