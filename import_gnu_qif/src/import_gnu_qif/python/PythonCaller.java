/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package import_gnu_qif.python;
import java.io.*;
import java.util.List;
import java.util.Vector;
/**
 *
 * @author BOBYBOU
 */

public class PythonCaller {
    /**
     * @param args
     * @throws IOException
     */
    private Process pr;
    
    public PythonCaller(String pythonScriptPath) throws IOException {
// set up the command and parameter

String[] cmd = new String[2];
cmd[0] = "python "; // check version of installed python: python -V
cmd[1] = pythonScriptPath;

// create runtime to execute external command
Runtime rt = Runtime.getRuntime();
try{
    pr = rt.exec(cmd);
}
catch(Exception e){
    e.printStackTrace();
}
    }
    
    
    public List get_output() {
// retrieve output from python script
BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
String line = "";
String[] result ;
List<String[]> final_result = new Vector<String[]>();
try{
    while((line = bfr.readLine()) != null) {
// display each output line form python script
result = line.split(":",-1);
final_result.add(result);
//System.out.println(line);
    }
}catch(Exception e){
    e.printStackTrace();
}

return final_result;
    }
}
