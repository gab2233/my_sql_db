/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
import import_gnu_qif.mysql.MySQLAccess;
/**
 *
 * @author BOBYBOU
 */
public class tets {
    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase("select * from accounts");
        dao.close();
    }
}
