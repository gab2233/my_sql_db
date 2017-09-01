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
        
        MySQLAccess access_db = new MySQLAccess(); 
        Map<Integer,String> dic = new HashMap<Integer,String>();
        dic.put(1, "string");
        dic.put(2, "string");
        dic.put(7, "string");
        try{
           access_db.readDataBase("SELECT * FROM Accounts", dic); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
