/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package import_gnu_qif.model;
import import_gnu_qif.observer.Observable;
import import_gnu_qif.observer.Observer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTree;

/**
 *
 * @author BOBYBOU
 */
public abstract class AbstractModel implements Observable{
    
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();
    protected List transactions;
    protected JTree arbre_comptes;
    public abstract void ajouter_transactions(String path);
    public abstract void get_arbre_compte();
    //public abstract void
            
            
            public void addObserver(Observer obs) {
                this.listObserver.add(obs);
            }
            public void removeObserver() {
                listObserver = new ArrayList<Observer>();
            }
            
}
