/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package import_gnu_qif.vue;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color;
import java.io.File;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JTable;
import java.util.*;
/**
 *
 * @author BOBYBOU
 */
public class panneau_principal extends JPanel {
    private JSplitPane split;
    private bouton_export bouton = new bouton_export("Convert to QIF");
    private bouton_export bouton2 = new bouton_export("Export to DataBase");
    private JScrollPane scroll_pan1 = new JScrollPane();
    private JScrollPane scroll_pan2 = new JScrollPane();
    private boolean hasProportionalLocation = false;
    private double proportionalLocation = 0.5;
    private boolean isPainted = false;
    private bouton_export bouton3 = new bouton_export("add source transaction");
    private JComboBox combo2 = new JComboBox();
    private List data;
    //private List<String>;
    public panneau_principal(){
        this.setLayout(new BorderLayout());
        scroll_pan1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll_pan1, scroll_pan2);
        //data = 
        //        title = 
        //        JTable tableau = new JTable(data, title);
        //On le passe ensuite au content pane de notre objet Fenetre
        //placé au centre pour qu'il utilise tout l'espace disponible
        this.add(split, BorderLayout.CENTER);
        JPanel north = new JPanel();
        //LinearLayout north = new LinearLayout(this);
        JPanel south = new JPanel();
        //south.setLayout(new java.awt.GridLayout(1, 2));
        north.setLayout(new java.awt.GridLayout(2, 2));
        
        combo2.setPreferredSize(new Dimension(100, 20));
        
        combo2.addItem("Option 1");
        combo2.addItem("Option 2");
        combo2.addItem("Option 3");
        combo2.addItem("Option 4");
        JLabel titre = new JLabel("<html><b>Utilisateur</b></html>", SwingConstants.CENTER);
        JLabel titre2 = new JLabel("<html><b>SURFACE ET MODE DE FAIRE VALOIR</b></html>", SwingConstants.CENTER);
        north.add(titre);
        north.add(titre2);
        north.add(bouton3);
        north.add(combo2);
        //bouton.setPreferredSize(new Dimension(south.getWidth()/2,this.getHeight()));
        //bouton2.setPreferredSize(new Dimension(south.getWidth()/2,this.getHeight()));
        south.add(bouton);
        //south.add(bouton2);
        this.add(south, BorderLayout.SOUTH);
        this.add(north, BorderLayout.NORTH);
        this.setVisible(true);
        split.setDividerLocation(700);
        
    }
    
    
}
