/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package import_gnu_qif.model;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
/**
 *
 * @author BOBYBOU
 */

public class CSV_EXTRACT {
    private List resultat;
    public CSV_EXTRACT(char DEFAULT_SEPARATOR, char DEFAULT_QUOTE, String csvFile)throws Exception{
        
        try{
            Scanner scanner = new Scanner(new File(csvFile));
            
            while (scanner.hasNext()) {
                resultat.add(parseLine(scanner.nextLine(),DEFAULT_SEPARATOR,DEFAULT_QUOTE));
                //System.out.println( line);
                
            }
            resultat = filter_list(resultat);
            scanner.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public List<String> get_result(){
        return resultat;
    }
    private static List filter_list(List in_list){
        in_list.remove(0);
        in_list.remove(0);
        in_list.remove(2);
        /*
        for (Iterator<String> iter = in_list.listIterator(); iter.hasNext(); ) {
            String a = iter.next();
            if () {
            iter.remove();
        }
        }
        */
        return in_list;
    }
    
    private static List<String> parseLine(String cvsLine, char separators, char customQuote) {
        
        List<String> result = new ArrayList<>();
        
        //if empty, return!
        if (cvsLine == null && cvsLine.isEmpty()) {
            return result;
        }
        
        if (customQuote == ' ') {
            customQuote = '"';
        }
        
        if (separators == ' ') {
            separators = ',';
        }
        
        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;
        
        char[] chars = cvsLine.toCharArray();
        
        for (char ch : chars) {
            
            if (inQuotes) {
                startCollectChar = true;
                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {
                    
                    //Fixed : allow "" in custom quote enclosed
                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }
                    
                }
            } else {
                if (ch == customQuote) {
                    
                    inQuotes = true;
                    
                    //Fixed : allow "" in empty quote enclosed
                    if (chars[0] != '"' && customQuote == '\"') {
                        curVal.append('"');
                    }
                    
                    //double quotes in column will hit this!
                    if (startCollectChar) {
                        curVal.append('"');
                    }
                    
                } else if (ch == separators) {
                    
                    result.add(curVal.toString());
                    
                    curVal = new StringBuffer();
                    startCollectChar = false;
                    
                } else if (ch == '\r') {
                    //ignore LF characters
                    continue;
                } else if (ch == '\n') {
                    //the end, break!
                    break;
                } else {
                    curVal.append(ch);
                }
            }
            
        }
        
        result.add(curVal.toString());
        
        return result;
    }
    
}
