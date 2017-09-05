/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package import_gnu_qif.model;
import import_gnu_qif.python.PythonCaller;
import javax.activation.*;
import import_gnu_qif.model.CSV_EXTRACT;
import import_gnu_qif.mysql.MySQLAccess;
import java.util.*;
/**
 *
 * @author BOBYBOU
 */
public class converter extends AbstractModel{
    
    private List resultat;
    
    public void ajouter_transactions(String path){
        FileDataSource ds = new FileDataSource(path);
        String contentType = ds.getContentType();
        
        if (contentType.toUpperCase() == "CSV")
        {
            try{
                CSV_EXTRACT csv = new CSV_EXTRACT(':', '"', path);
                resultat = csv.get_result();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(contentType.toUpperCase() == "PDF")
        {
            try{
                PythonCaller pdf = new PythonCaller("\\plot_pdf.py");
                resultat = pdf.get_output();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("The file type is " + contentType + " and is not supported");
        }
        
    }
    public void get_arbre_compte(){
        Object[] data = new Object[500];
        int count = 0;
        int i = 0;
        String parent = "x";
        ArrayList<Integer> unallocated = new ArrayList<Integer>();
        MySQLAccess access_db = new MySQLAccess(); 
        Map<Integer,String> dic_column = new HashMap<Integer,String>();
        dic_column.put(1, "string");
        dic_column.put(2, "string");
        dic_column.put(7, "string");
        Map<Integer,String> dic_column_count = new HashMap<Integer,String>();
        dic_column_count.put(1,"integer");
        
        
        try{
        count = (int)access_db.readDataBase("SELECT Count(*) FROM Accounts", dic_column_count)[0];
        data = access_db.readDataBase("SELECT * FROM Accounts", dic_column); 
        
        while(!parent.isEmpty()){
            parent = ((String[])data[i])[2]; // houseId is at first place in your query
            i++;   
        }
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
