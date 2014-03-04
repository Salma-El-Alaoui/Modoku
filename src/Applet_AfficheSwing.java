package modoku;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.event.FocusAdapter;

import java.awt.event.FocusEvent;

import javax.swing.JList;

import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import modoku.Case;
import modoku.Position;
import modoku.Damier;
import modoku.Arbre;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import oracle.jdeveloper.layout.BoxLayout2;
import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Applet_AfficheSwing extends JApplet 
{

    private JPanel jPanel1 = new JPanel();
    private JPanelApplet panneau =new JPanelApplet( );

    public void init() {   
  this.getContentPane().add(jPanel1, BorderLayout.CENTER);
   panneau.setPreferredSize(new Dimension(300,300));
    JButton bouton = new JButton("OK"); 
     bouton.setBounds(100,50,80,30);   
     panneau.add(bouton); 
    jPanel1.add(panneau,new FlowLayout());
    panneau.setBackground(new Color(252,240,231));
   
    }


}
