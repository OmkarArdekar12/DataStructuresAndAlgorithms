// Text Justification
// Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
// You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
// Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned 
// more spaces than the slots on the right.
// For the last line of text, it should be left-justified, and no extra space is inserted between words.
// Note:
// A word is defined as a character sequence consisting of non-space characters only.
// Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
// The input array words contains at least one word.

import java.util.*;

public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;

        List<String> result = new ArrayList<>();
        int currLineLength = 0;      
        int spaces = 0, totalSpaces = 0, remainingSpaces = 0; 
        for(int start=0, end=0, curr=0; curr<n; curr++) {
            int currLength = words[curr].length(); //calculating the length of the current string/word
            if((currLineLength + currLength + (curr - start)) <= maxWidth) { 
                //currentLineLength + currentWordLength + (curr - start) spaces
                //Note: There should be atleast one space between the 2 words/strings. 
                //So, (curr - start + 1) number string will consist (curr - start) number of spaces
                currLineLength += currLength;
            } else {
                end = curr - 1; //index of end word/string of the current line
                totalSpaces = maxWidth - currLineLength; //calculating the total spaces
                spaces = totalSpaces / Math.max((end - start), 1); //calculating the spaces in between the each string and also handling the edge case
                remainingSpaces = totalSpaces % Math.max((end - start), 1); //calculating the remaining spaces in between the each string and also handling the edge case

                String spaceStr = " ".repeat(spaces); //get the spaces number of space string
                StringBuilder currLine = new StringBuilder("");
                int singleStr = end - start; //edge case for the single string in the current line
                while(start <= end) {
                    currLine.append(words[start]);
                    //There should be the no spaces after the last word/string of the current line 
                    //except the last line and also handling the edge/corner for the single string/word
                    if(start < end || singleStr == 0) { 
                        currLine.append(spaceStr);
                        if(remainingSpaces > 0) { //distributing the extra spaces evenly
                            currLine.append(" ");
                            remainingSpaces--;
                        }
                    }
                    start++;
                }

                result.add(currLine.toString()); //adding the current line in the result

                start = curr; //storing the starting index/point of the string for the next line
                currLineLength = 0; //setting the currLineLength zero for the next line
                currLength = words[curr].length(); 
                if((currLineLength + currLength + (curr - start)) <= maxWidth) {
                    currLineLength += currLength;
                }
            }

            //handling the lastLine separately
            if(curr == n-1) {
                StringBuilder lastLine = new StringBuilder("");
                while(start < n) {
                    lastLine.append(words[start]);
                    if(start < n-1) {
                        lastLine.append(" ");
                    }
                    start++;
                }
                totalSpaces = maxWidth - lastLine.length();
                lastLine.append(" ".repeat(totalSpaces));
                result.add(lastLine.toString());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth1 = 16;
        List<String> res1 = fullJustify(words1, maxWidth1);
        System.out.println("[");
        for(String line : res1) {
            System.out.println("\t" + "\"" + line + "\"");
        }
        System.out.println("]");
        System.out.println();
        String[] words2 = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth2 = 16;
        List<String> res2 = fullJustify(words2, maxWidth2);
        System.out.println("[");
        for(String line : res2) {
            System.out.println("\t" + "\"" + line + "\"");
        }
        System.out.println("]");
        System.out.println();
        String[] words3 = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth3 = 20;
        List<String> res3 = fullJustify(words3, maxWidth3);
        System.out.println("[");
        for(String line : res3) {
            System.out.println("\t" + "\"" + line + "\"");
        }
        System.out.println("]");
        System.out.println();
    }
}