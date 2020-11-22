/**
 * Finding genes in a strand of DNA
 * Using the StorageResource Class
 * 
 * Part 2: Finding a Gene - Using the Simplified Algorithm Reorganized
 * 
 * @source Week 2 Coursera cource 'Java Programming and Software Engineering Fundamentals Specialization' by  Duke University
 * 
 * @author Jana Semenova
 * @version 1
 */

import edu.duke.*;
import java.io.*;

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
    	int start = dna.toLowerCase().indexOf(startCodon.toLowerCase());
    	if (start == -1) {
    		return "";
    	}
    	int stop = dna.toLowerCase().indexOf(stopCodon.toLowerCase(), start + 3);
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
        String strDNAwithATGandTAA = "cccatggggtttgaataataataggagagagagagagagttt"; // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
    	String ap = "atggggtttaaataataatag"; // DNA with ATG, TAA and the substring between them is not a multiple of 3
    	//String a = strDNAwithATGandTAA;
    	//String a = "atgcctag";
    	//String ap = "";
    	String a = "ATGCCCTAA";
    	//String ap = "ATGCCCTAG";
    	String result = findSimpleGene(a, "atg", "taa");
    	System.out.println("***   ***   ***");
    	//System.out.println("String a " + a);
    	if (result != "")
    	{
    		System.out.println("Result " + result);
    	}
    	else {
    	        System.out.println("No result");
    	}
    	/*
    	if (ap.equals(result)) {
    		System.out.println("success for " + ap + " length " + ap.length());
    	}
    	else {
    		System.out.println("mistake for input: " + a);
    		System.out.println("got: " + result);
    		System.out.println("not: " + ap);
    	}
    	*/
    }
    
    public void realTesting() {
    	DirectoryResource dr = new DirectoryResource();
    	for (File f : dr.selectedFiles()) {
    		FileResource fr = new FileResource(f);
    		String s = fr.asString();
    		System.out.println("read " + s.length() + " characters");
    		String result = findSimpleGene(s, "atg", "taa");
    		System.out.println("found " + result);
    	}
    }
}
