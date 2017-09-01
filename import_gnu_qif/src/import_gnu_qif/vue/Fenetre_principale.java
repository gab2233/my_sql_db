/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package import_gnu_qif.vue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.geom.Dimension2D;
import java.awt.Dimension;
import javax.swing.*;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
/**
 *
 * @author BOBYBOU
 */
public class Fenetre_principale extends JFrame {
    
    private panneau_principal pan = new panneau_principal();
    
    private JMenuBar menuBar = new JMenuBar();
    private JMenu test1 = new JMenu("Fichier");
    private JMenu test1_2 = new JMenu("Sous ficher");
    private JMenu test2 = new JMenu("Edition");
    
    private JMenuItem item1 = new JMenuItem("Ouvrir");
    private JMenuItem item2 = new JMenuItem("Fermer");
    private JMenuItem item3 = new JMenuItem("Lancer");
    private JMenuItem item4 = new JMenuItem("Arrêter");
    
    private JCheckBoxMenuItem jcmi1 = new JCheckBoxMenuItem("Choix 1");
    private JCheckBoxMenuItem jcmi2 = new JCheckBoxMenuItem("Choix 2");
    
    private JRadioButtonMenuItem jrmi1 = new JRadioButtonMenuItem("Radio 1");
    private JRadioButtonMenuItem jrmi2 = new JRadioButtonMenuItem("Radio 2");
    
    
    public Fenetre_principale() {
        //FENETRE PRINCIPALE
        ImageIcon img = new ImageIcon("C:\\Users\\BOBYBOU\\Documents\\NetBeansProjects\\import_gnu_qif\\src\\import_gnu_qif\\img.png");
        this.setIconImage(img.getImage());
        this.setTitle("Importation de transactions dans GNU Cash");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //bouton.addActionListener(new BoutonListener());
        //bouton2.addActionListener(new Bouton2Listener());
        
        
        //MENU
        //On initialise nos menus
        this.test1.add(item1);
        
        //On ajoute les éléments dans notre sous-menu
        this.test1_2.add(jcmi1);
        this.test1_2.add(jcmi2);
        //Ajout d'un séparateur
        this.test1_2.addSeparator();
        //On met nos radios dans un ButtonGroup
        ButtonGroup bg = new ButtonGroup();
        bg.add(jrmi1);
        bg.add(jrmi1);
        //On présélectionne la première radio
        jrmi1.setSelected(true);
        
        this.test1_2.add(jrmi1);
        this.test1_2.add(jrmi2);
        
        //Ajout du sous-menu dans notre menu
        this.test1.add(this.test1_2);
        //Ajout d'un séparateur
        this.test1.addSeparator();
        item2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        this.test1.add(item2);
        this.test2.add(item3);
        this.test2.add(item4);
        
        //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
        //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
        this.menuBar.add(test1);
        this.menuBar.add(test2);
        this.setJMenuBar(menuBar);
        
        
       
        
        //Ce sont maintenant nos classes internes qui écoutent nos boutons
        /*
        JPanel pan1 = new JPanel();
        pan1.setBackground(Color.blue);
      
        JPanel pan2 = new JPanel();
        pan2.setBackground(Color.red);
      */
    //On construit enfin notre séparateur
   
        
        
        this.setVisible(true);
        this.setContentPane(pan);
        
        
        
    }
    
}
/*
class BoutonListener implements ActionListener{
//Redéfinition de la méthode actionPerformed()
public void actionPerformed(ActionEvent arg0) {

}
}

//Classe écoutant notre second bouton
class Bouton2Listener implements ActionListener{
//Redéfinition de la méthode actionPerformed()
public void actionPerformed(ActionEvent e) {

}
}
*/