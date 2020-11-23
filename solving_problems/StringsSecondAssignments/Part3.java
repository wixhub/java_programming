/**
 * Finding Many Genes
 * 
 * Part 3: To count how many genes are in a strand of DNA
 * 
 * @source Week 2 Coursera cource 'Java Programming and Software Engineering Fundamentals Specialization' by  Duke University
 * 
 * @author Jana Semenova
 * @version 1
 */

import edu.duke.*;
import java.io.*;

public class Part3 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        // String parameter dna
        // an integer parameter startIndex represents where the first occurrence of ATG occurs in dna
        // String parameter stopCodon
        
        //method returns the index of the first occurrence of stopCodon that appears past startIndex and is a multiple of 3 away from startIndex
        int firstStopCodon = 0;
        
        // If there is no such stopCodon, this method returns the length of the dna strand
        int lenghtDNA = dna.length()|0;
        
        firstStopCodon = dna.toLowerCase().indexOf(stopCodon.toLowerCase(), startIndex + 3);
        //System.out.println("startIndex " + startIndex);
        //System.out.println("firstStopCodon " + firstStopCodon);
        if (firstStopCodon > startIndex && (firstStopCodon - startIndex) % 3 == 0) {
            return firstStopCodon;
        }
        
        return lenghtDNA;
    }
    
    public String findGene(String dna, int startIndex) {
        String gene = "";
        int startPoint = startIndex|0;
        int lenghtDNA = dna.length()|0;
        String startCodon = "ATG";
        int indexStartCodon = 0;
        int minIndex = 0;
        String stopCodon0 = "TAA";
        int indexStopCodon0 = 0;
        String stopCodon1 = "TAG";
        int indexStopCodon1 = 0;
        String stopCodon2 = "TGA";
        int indexStopCodon2 = 0;
        
        //System.out.println("lenghtDNA " + lenghtDNA);
        indexStartCodon = dna.toLowerCase().indexOf(startCodon.toLowerCase(), startPoint);
        if (indexStartCodon < 0) {
            return "";
        }
        
        indexStopCodon0 = findStopCodon(dna, indexStartCodon, stopCodon0);
        indexStopCodon1 = findStopCodon(dna, indexStartCodon, stopCodon1);
        indexStopCodon2 = findStopCodon(dna, indexStartCodon, stopCodon2);
        //minIndex = Math.min(indexStopCodon0, Math.min(indexStopCodon1, indexStopCodon2));
        //System.out.println("TAA=" + indexStopCodon0 + " TAG=" + indexStopCodon1 + " TGA=" + indexStopCodon2);
        if (indexStopCodon0 == -1 ||
            (indexStopCodon2 != -1 && indexStopCodon2 < indexStopCodon0)) {
            minIndex = indexStopCodon2;
        } else {
            minIndex = indexStopCodon0;
        }
        
        if (minIndex == -1 ||
            (indexStopCodon1 != -1 && indexStopCodon1 < minIndex)) {
            minIndex = indexStopCodon1;
        }
        
        if (minIndex == lenghtDNA || minIndex == -1) {
            return "";
        }
        //System.out.println("minIndex " + minIndex);
        if(minIndex > 0) {
            gene = dna.substring(indexStartCodon, minIndex + 3);
        }
        //System.out.println("gene " + gene);
        return gene;
    }
    
    public void printAllGenes(String dna) {
        int currIndex = 0;
        
        while (true) {
           String result = findGene(dna, currIndex);
           
           if (result.isEmpty()){
              break;
           }
           System.out.println(result);
           
           currIndex = dna.toLowerCase().indexOf(result.toLowerCase(), currIndex) + result.length();
        }
    }
    
    public int countGenes(String dna){
        // This method returns the number of genes found in dna
        int count = 0;
        int currIndex = 0;
        int checkIndex = 0;
        
        while (true) {
           String result = findGene(dna, currIndex);
           
           if (result.isEmpty()){
              break;
           }
           count++;
           currIndex = dna.toLowerCase().indexOf(result.toLowerCase(), currIndex) + result.length();
        }
        return count;
    }
    
    public void testFindStopCodon() {
        System.out.println("* ");
        System.out.println("* Start test FindStopCodon");
        // String startCodon = "ATG";
        // String stopCodon0 = "TAA";
        // String stopCodon1 = "TAG";
        // String stopCodon2 = "TGA";
        String testDNAwithNoATG = "cccgtggggtttaaataataataggagagagagagagagttt";// DNA with no “ATG”
        String testDNAwithNoTAA = "cccatggggtttatatattagtaggagagagagagagagttt";// DNA with no “TAA”
        String testDNAwithNoATGorTAA = "cccatggggtttatatattagtaggagagagagagagagttt"; // DNA with no “ATG” or “TAA”
        String testDNAwithATGandTAA = "cccatggggtttgaaggataataataggagagagagagagagttt"; // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        String testNoValid = "atggggtttaaataataatag"; // DNA with ATG, TAA and the substring between them is not a multiple of
      
        String dna = testDNAwithATGandTAA;
        int startIndex = 3;
        String stopCodon = "TAA";
        int result = findStopCodon(dna, startIndex, stopCodon);
        if (result < 0) {
            System.out.println("Error -----");
        }
        System.out.println("Result " + result);
        System.out.println("* End   test FindStopCodon");
    }
    
    public void testFindGene() {
        System.out.println("* ");
        System.out.println("* Start test FindGene");
        // String startCodon = "ATG";
        // String stopCodon0 = "TAA";
        // String stopCodon1 = "TAG";
        // String stopCodon2 = "TGA";
        String   testDNAwithNoATG = "cccgtggggtttaaataataataggagagagagagagagttt";// DNA with no “ATG”
        String resultDNAwithNoATG = "";// result DNA with no “ATG”
        String   testDNAwithNoTAAandTGA = "cccatggggtttatatattagtaggagagagagagagagttt";// DNA with no “TAA”
        String resultDNAwithNoTAAandTGA = "atgtggtttatatattag";// result DNA with no “TAA” and “TGA”
        String   testDNAwithNoTAGandTAA = "cccatggggtttatatattgatggagagagatgagagagttt"; // DNA with no “TAG” and “TAA”
        String resultDNAwithNoTAGandTAA = "atggggtttatatattga"; // DNA with no “TAG” and “TAA”
        String   testDNAwithATGandTAA = "cccatggggtttgtatatggataataataggagagagagagagagttt"; // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        String resultDNAwithATGandTAA = "atggggtttgtatatggataa"; // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        String   testNoValid = "tdtratgtgggtttataataataatag"; // DNA with ATG, TAA and the substring between them is not a multiple of 3
        String resultNoValid = "";
        
        String testString   =   testDNAwithATGandTAA;
        String resultString = resultDNAwithATGandTAA;
        
        String result = findGene(testString, 0);
        if (!result.equals(resultString)) {
            System.out.println("Error -----");
        }
        System.out.println("Result " + result);
        System.out.println("* End   test FindGene");
    }
    
    public void testPrintAllGenes() {
        System.out.println("* ");
        System.out.println("* Start test PrintAllGenes");
        String strDNAwithNoATG = "cccgtggggtttaaataataataggagagagagagagagttt";// DNA with no “ATG”
        String strDNAwithNoTAA = "cccgtggggtttagatagtagtaggagagagagagagagttt";// DNA with no “TAA”
        String strDNAwithNoATGorTAA = "cccatggggtttatatattagtaggagagagagagagagttt"; // DNA with no “ATG” or “TAA”
        String strDNAwithATGandTAA = "cccatggggtttgaaggataataataggagagagagagagagttt"; // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        String ap = "atggggtttaaataataatag"; // DNA with ATG, TAA and the substring between them is not a multiple of 3
        String a = "jaädjäatg1ggtttaaataataatagsopjäsdvjatg2ttaaataataatagnoejcävpawkefäpatg3aataataatagkwefäpjwvpnäpvoatg4ggtttaaataaSVJDDVVPOJÄW";
        
        String dna = a;
        printAllGenes(dna);
        System.out.println("* End   test PrintAllGenes");
    }
    
    public void testCountGenes(){
        System.out.println("* ");
        System.out.println("* Start test CountGenes");
        // String startCodon = "ATG";
        // String stopCodon0 = "TAA";
        // String stopCodon1 = "TAG";
        // String stopCodon2 = "TGA";
        String   testDNAwithNoATG = "cccgtggggtttaaataataataggagagagagagagagttt";// DNA with no “ATG”
        String resultDNAwithNoATG = "";// result DNA with no “ATG”
        String   testDNAwithNoTAAandTGA = "cccatggggtttatatattagtaggagagagagagagagttt";// DNA with no “TAA”
        String resultDNAwithNoTAAandTGA = "atgtggtttatatattag";// result DNA with no “TAA” and “TGA”
        String   testDNAwithNoTAGandTAA = "cccatggggtttatatattgatggagagagatgagagagttt"; // DNA with no “TAG” and “TAA”
        String resultDNAwithNoTAGandTAA = "atggggtttatatattga"; // DNA with no “TAG” and “TAA”
        String   testDNAwithATGandTAA = "cccatggggtttgtatatggataataataggagagagagagagagttt"; // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        String resultDNAwithATGandTAA = "atggggtttgtatatggataa"; // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        String   testNoValid = "tdtratgtgggtttataataataatag"; // DNA with ATG, TAA and the substring between them is not a multiple of 3
        String resultNoValid = "";
        
        String a = "jaädjäatg1ggtttaaataataatagsopjäsdvjatg2ttaaataataatagnoejcävpawkefäpatg3aataataatagkwefäpjwvpnäpvoatg4ggtttaaataaSVJDDVVPOJÄW";
        String b = "ATGTAAGATGCCCTAGT"; //returns 2
        String testString = b;
        
        int result = countGenes(testString);
        if (result < 0) {
            System.out.println("Error -----");
        }
        System.out.println("Result " + result);
        System.out.println("* End   test CountGenes");
    }
}
