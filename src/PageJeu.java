   package modoku;

import java.awt.event.FocusAdapter;

import java.awt.event.FocusEvent;

import java.awt.Color;

import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
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

import java.util.Hashtable;

import javax.swing.ImageIcon;


public class PageJeu extends JApplet implements MouseListener,Runnable {
    
//attributs du plateau de jeu
  private  ImageIcon monIcone = new ImageIcon("jPanel1.jpg");
  private JPanel jPanel1 = new JPanel();
  private JButton jButton1 = new JButton();
  private JPanel jPanel4 = new JPanel();
  private JPanelApplet jPanelChrono=new JPanelApplet();
  private JPanelApplet1 jPanelMots=new JPanelApplet1();
  private JPanelApplet2 jPanelScoreTotal = new JPanelApplet2();
  private JLabel score = new JLabel();
  
  private JTextField[][] tableauJTextField= new JTextField[4][4];
  private JTextField jTextField1 = new JTextField();
  private JTextField jTextField2 = new JTextField();
  private JTextField jTextField3 = new JTextField();
  private JTextField jTextField4 = new JTextField();
  private JTextField jTextField5 = new JTextField();
  private JTextField jTextField8 = new JTextField();
  private JTextField jTextField9 = new JTextField();
  private JTextField jTextField6 = new JTextField();
  private JTextField jTextField7 = new JTextField();
  private JTextField jTextField10 = new JTextField();
  private JTextField jTextField11 = new JTextField();
  private JTextField jTextField12 = new JTextField();
  private JTextField jTextField13 = new JTextField();
  private JTextField jTextField14 = new JTextField();
  private JTextField jTextField15 = new JTextField();
  private JTextField jTextField16 = new JTextField();
  
  private JPanel zone1 = new JPanel();
  private JPanel zone2 = new JPanel();
  private JPanel zone3 = new JPanel();
  private JPanel zone4 = new JPanel();
  private JPanel zone5 = new JPanel();
  private JPanel zone6 = new JPanel();
  private JPanel zone7 = new JPanel();
  private JPanel zone8 = new JPanel();
  private JPanel zone9 = new JPanel();
  private JPanel zone10 = new JPanel();
  private JPanel zone11 = new JPanel();
  private JPanel zone12 = new JPanel();
  private JPanel zone13 = new JPanel();
  private JPanel zone14 = new JPanel();
  private JPanel zone15 = new JPanel();
  private JPanel zone16 = new JPanel();
  
  private GridLayout gridLayout1 = new GridLayout(4,4);
  private XYLayout xYLayout2 = new XYLayout();
  private GridBagLayout gridBagLayout1 = new GridBagLayout();
  private JLabel jLabel3 = new JLabel();
  private int scoreInstantane=0;
  Boolean modeSelectionMot = false;
  
  private JLabel bordureGauche = new JLabel();
  private JLabel bordureHaut = new JLabel();
  private JLabel bordureDroite = new JLabel();
  private JLabel bordureBas= new JLabel();
    
//Attributs de la page Menu
  private JPanel jPanelMenu=new JPanel();
  private JLabel wall = new JLabel();
  private JButton boutonRegles = new JButton();
  private JButton boutonJouer = new JButton();
  private JLabel jLabel1 = new JLabel();
  
//Attributs de la page Score
  private JPanel jPanelScore=new JPanel();
  private JLabel wallScore=new JLabel();
  private JLabel votreScore=new JLabel();
  private JTextField scoreTotal =new JTextField();
  private JLabel votreListe = new JLabel();
  protected JList jList1 = new JList();
  private JScrollPane jScrollPane1 = new JScrollPane();
  private JList listeTotale = new JList();
  private JScrollPane jScrollPane2 = new JScrollPane();
  private JLabel tempEcoule =new JLabel();
  private JLabel tousLesMotsPossibles =new JLabel();
  
//Attributs de la page Règles
  private ImageIcon monIconeRegles = new ImageIcon("regles.jpg");
  private JLabel wallRegles=new JLabel();
  private JPanel jPanelRegles = new JPanel();
  private JButton boutonMenu = new JButton();
    
//attributs de la gestion de mots
  protected ArrayList<String> listeMots=new ArrayList<String> ();
  private String motSelectionne="";
  private Color couleur = new Color(145,248,181);
  private ArrayList<JTextField> chemin=new ArrayList<JTextField>(); 

//Attributs du Chronomètre
  private Thread chronometre=new Thread(this); 
  int speed=1000;
  private int s=120;



  private void jbInit() throws Exception {
        
    this.getContentPane().setLayout( null );
    this.setSize(new Dimension(763, 526));
    
//Initialisation du plateau de jeu;
    this.getContentPane().add(jPanel1, null);  
    tableauJTextField[0][0]=jTextField1;
    tableauJTextField[0][1]=jTextField2;
    tableauJTextField[0][2]=jTextField3;
    tableauJTextField[0][3]=jTextField4;
      
    tableauJTextField[1][0]=jTextField5;
    tableauJTextField[1][1]=jTextField6;
    tableauJTextField[1][2]=jTextField7;
    tableauJTextField[1][3]=jTextField8;
      
    tableauJTextField[2][0]=jTextField9;
    tableauJTextField[2][1]=jTextField10;
    tableauJTextField[2][2]=jTextField11;
    tableauJTextField[2][3]=jTextField12;
      
    tableauJTextField[3][0]=jTextField13;
    tableauJTextField[3][1]=jTextField14;
    tableauJTextField[3][2]=jTextField15;
    tableauJTextField[3][3]=jTextField16;

    zone1.add(tableauJTextField[0][0], BorderLayout.CENTER);
    zone2.add(tableauJTextField[0][1], BorderLayout.CENTER);
    zone3.add(tableauJTextField[0][2], BorderLayout.CENTER);
    zone4.add(tableauJTextField[0][3], BorderLayout.CENTER);
    zone5.add(tableauJTextField[1][0], BorderLayout.CENTER);
    zone6.add(tableauJTextField[1][1], BorderLayout.CENTER);
    zone7.add(tableauJTextField[1][2], BorderLayout.CENTER);
    zone8.add(tableauJTextField[1][3], BorderLayout.CENTER);
    zone9.add(tableauJTextField[2][0], BorderLayout.CENTER);
    zone10.add(tableauJTextField[2][1], BorderLayout.CENTER);
    zone11.add(tableauJTextField[2][2], BorderLayout.CENTER);
    zone12.add(tableauJTextField[2][3], BorderLayout.CENTER);
    zone13.add(tableauJTextField[3][0], BorderLayout.CENTER);
    zone14.add(tableauJTextField[3][1], BorderLayout.CENTER);
    zone15.add(tableauJTextField[3][2], BorderLayout.CENTER);
    zone16.add(tableauJTextField[3][3], BorderLayout.CENTER);
     
    jPanel4.add(zone1, null);
    jPanel4.add(zone2, null);
    jPanel4.add(zone3, null);
    jPanel4.add(zone4, null);
    jPanel4.add(zone5, null);
    jPanel4.add(zone6, null);
    jPanel4.add(zone7, null);
    jPanel4.add(zone8, null);
    jPanel4.add(zone9, null);
    jPanel4.add(zone10, null);
    jPanel4.add(zone11, null);
    jPanel4.add(zone12, null);
    jPanel4.add(zone13, null);
    jPanel4.add(zone14, null);
    jPanel4.add(zone15, null);
    jPanel4.add(zone16, null);
    
    jPanel1.setBounds(new Rectangle(0, 0, 0, 0));
    jPanel1.setBackground(new Color(237, 80, 86));
    jPanel1.setLayout(xYLayout2);
    jButton1.setText("REJOUER");
    jButton1.setPreferredSize(new Dimension(100, 30));
    jButton1.setFont(new Font("Solid Edge Stencil", 0, 17));
    jButton1.setForeground(new Color(124, 63, 104));
    jButton1.addActionListener(new PagePartieEvent());
 
    jPanel4.setLayout(gridLayout1);
    jPanel4.setPreferredSize(new Dimension(340, 340));
    jPanel4.setSize(new Dimension(340, 340));
    jPanel4.setBackground(new Color(193, 110, 237));
    jPanel4.setForeground(new Color(34, 183, 173));
    
    jPanelChrono.setPreferredSize(new Dimension(100,100));
    jPanelChrono.setLayout(new FlowLayout());
    jPanelChrono.setBackground(new Color(253,230,230));
    jPanelChrono.setForeground(new Color(167, 62, 95));
    jPanelChrono.setFont(new Font("Kokila", 1, 50));
    jPanelChrono.setBorder(BorderFactory.createLineBorder(new Color(226,190,190)));
        
    jPanelMots.setPreferredSize(new Dimension(100,100));
    jPanelMots.setLayout(new FlowLayout());
    jPanelMots.setBackground(new Color(253,230,230));
    jPanelMots.setForeground(new Color(167, 62, 95));
    jPanelMots.setFont(new Font("Kokila", 1, 40));   
    jPanelMots.setBorder(BorderFactory.createLineBorder(new Color(226,190,190)));
    
    jPanelScoreTotal.setPreferredSize(new Dimension(100,100));
    jPanelScoreTotal.setLayout(new FlowLayout());
    jPanelScoreTotal.setBackground(new Color(253,230,230));
    jPanelScoreTotal.setForeground(new Color(167, 62, 95));
    jPanelScoreTotal.setFont(new Font("Kokila", 1, 40));   
    
    score.setForeground(Color.white);
    score.setFont(new Font("Kokila", 1, 40)); 
    score.setText("Score :");
    
    zone1.setBackground(new Color(252,240,231));
    zone2.setBackground(new Color(252,240,231));
    zone3.setBackground(new Color(252,240,231));
    zone4.setBackground(new Color(252,240,231));
    zone5.setBackground(new Color(252,240,231));
    zone6.setBackground(new Color(252,240,231));
    zone7.setBackground(new Color(252,240,231));
    zone8.setBackground(new Color(252,240,231));
    zone9.setBackground(new Color(252,240,231));
    zone10.setBackground(new Color(252,240,231));
    zone11.setBackground(new Color(252,240,231));
    zone12.setBackground(new Color(252,240,231));
    zone13.setBackground(new Color(252,240,231));
    zone14.setBackground(new Color(252,240,231));
    zone15.setBackground(new Color(252,240,231));
    zone16.setBackground(new Color(252,240,231));
    
    for(int i=0; i<4; i++){
        for(int j=0; j<4; j++){
          tableauJTextField[i][j].setBackground(new Color(253,230,230));
          tableauJTextField[i][j].setEditable(false);
          tableauJTextField[i][j].setFont(new Font("AR DELANEY", 0, 80));
          tableauJTextField[i][j].setForeground(new Color(96, 31, 74));
          tableauJTextField[i][j].setHorizontalAlignment(JTextField.CENTER);
          tableauJTextField[i][j].setPreferredSize(new Dimension(65, 65));
          tableauJTextField[i][j].addMouseListener(this);
          tableauJTextField[i][j].setSelectionColor(null);
          tableauJTextField[i][j].setBorder(BorderFactory.createLineBorder(new Color(226,190,190)));
        }
    }    
   
    jLabel3.setIcon(monIcone);
    jLabel3.setSize(new Dimension(763, 526));
    jLabel3.setPreferredSize(new Dimension(763, 526));
    jLabel3.setMaximumSize(new Dimension(763, 526));
    jLabel3.setOpaque(true);
    jLabel3.setMinimumSize(new Dimension(763, 526));
    
    bordureGauche.addMouseListener(new MouseAdapter() {
    public void mouseEntered(MouseEvent e) {
             bordure_mouseEntered(e);
      } 
       });
    bordureDroite.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
                 bordure_mouseEntered(e);
          } 
           });
    bordureHaut.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
                 bordure_mouseEntered(e);
          } 
           });
    bordureBas.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
                 bordure_mouseEntered(e);
          } 
           });
    jPanel1.add(jPanelChrono,new XYConstraints(70,250,100,100));
    jPanel1.add(jPanelScoreTotal,new XYConstraints(630,30,50,50));
    jPanel1.add(jPanelMots,new XYConstraints(570,250,180,50));
    jPanel1.add(score,new XYConstraints(530,30,100,50));
    jPanel1.add(bordureGauche, new XYConstraints(50, 125, 160, 340));
    jPanel1.add(bordureHaut, new XYConstraints(200, 60, 425, 65));
    jPanel1.add(bordureDroite, new XYConstraints(550, 110, 85, 335));
    jPanel1.add(bordureBas, new XYConstraints(85, 465, 510, 70));
    jPanel1.add(jPanel4, new XYConstraints(210, 125, 340, 340));
    jPanel1.add(jButton1, new XYConstraints(35, 25, 110, 55));
    jPanel1.add(jLabel3, new XYConstraints(0, 0, 765, 535));          


//Initialisation Page Menu
    this.getContentPane().add(jPanelMenu, null);  
    jPanelMenu.setBounds(new Rectangle(0, 0, 763, 526));
    jPanelMenu.setBackground(new Color(237, 80, 86));
    jPanelMenu.setLayout(xYLayout2);
    boutonJouer.setText("JOUER");
    boutonJouer.setPreferredSize(new Dimension(86, 30));
    boutonJouer.setForeground(new Color(124, 63, 104));
    boutonJouer.setFont(new Font("Solid Edge Stencil", 0, 17));
    boutonJouer.setHorizontalTextPosition(SwingConstants.CENTER);
    boutonJouer.addActionListener(new PageMenuEvent()); 
    boutonRegles.setText("REGLES");
    boutonRegles.setPreferredSize(new Dimension(86, 30));
    boutonRegles.setForeground(new Color(124, 63, 104));
    boutonRegles.setFont(new Font("Solid Edge Stencil", 0, 17));
    boutonRegles.setHorizontalTextPosition(SwingConstants.CENTER);
    boutonRegles.addActionListener(new PageMenuEvent());

    jLabel1.setText("MENU");
    jLabel1.setFont(new Font("Solid Edge Stencil", 1, 50));
    jLabel1.setForeground(Color.white);
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
    wall.setIcon(monIcone);
    wall.setSize(new Dimension(763, 526));
    wall.setPreferredSize(new Dimension(763, 526));
    wall.setMaximumSize(new Dimension(763, 526));
    wall.setOpaque(true);
    wall.setMinimumSize(new Dimension(763, 526));

    jPanelMenu.add(jLabel1, new XYConstraints(220, 30, 275, 75));
    jPanelMenu.add(boutonJouer, new XYConstraints(315, 145, 85, 55));
    jPanelMenu.add(boutonRegles, new XYConstraints(315, 235, 85, 55));
    jPanelMenu.add(wall, new XYConstraints(0, 0, 765, 535));
    
//Initialisation Page Regles
    this.getContentPane().add(jPanelRegles, null);
    jPanelRegles.setBounds(new Rectangle(0, 0, 0, 0));
    jPanelRegles.setBackground(new Color(237, 80, 86));
    jPanelRegles.setLayout(xYLayout2);
    wallRegles.setIcon(monIconeRegles);
    wallRegles.setSize(new Dimension(763, 526));
    wallRegles.setPreferredSize(new Dimension(763, 526));
    wallRegles.setMaximumSize(new Dimension(763, 526));
    wallRegles.setOpaque(true);
    wallRegles.setMinimumSize(new Dimension(763, 526));
    boutonMenu.setText("MENU");
    boutonMenu.setPreferredSize(new Dimension(70, 20));
    boutonMenu.setForeground(new Color(124, 63, 104));
    boutonMenu.setFont(new Font("Solid Edge Stencil", 0, 17));
    boutonMenu.setHorizontalTextPosition(SwingConstants.CENTER);
    boutonMenu.addActionListener(new PageReglesEvent());
    
    jPanelRegles.add(boutonMenu, new XYConstraints(10,480,70,40));
    jPanelRegles.add(wallRegles, new XYConstraints(0, 0, 765, 530));
  

//Initialisation Page Score
    this.getContentPane().add(jPanelScore, null);  
    jPanelScore.setBounds(new Rectangle(0, 0, 0, 0));
    jPanelScore.setBackground(new Color(237, 80, 86));
    jPanelScore.setLayout(xYLayout2);
    votreScore.setText("Votre score :");
    votreScore.setFont(new Font("Solid Edge Stencil", 1, 30));
    votreScore.setForeground(Color.white);
    votreScore.setHorizontalAlignment(SwingConstants.CENTER);
    votreScore.setHorizontalTextPosition(SwingConstants.CENTER);
    scoreTotal.setEditable(false);
    scoreTotal.setPreferredSize(new Dimension(100,30));
    scoreTotal.setForeground(new Color(167, 62, 95));
    scoreTotal.setFont(new Font("Kokila", 1, 50));
    scoreTotal.setHorizontalAlignment(JTextField.CENTER);
    wallScore.setIcon(monIcone);
    wallScore.setSize(new Dimension(763, 526));
    wallScore.setPreferredSize(new Dimension(763, 526));
    wallScore.setMaximumSize(new Dimension(763, 526));
    wallScore.setOpaque(true);
    wallScore.setMinimumSize(new Dimension(763, 526));
    votreListe.setText("Mots trouvés");
    votreListe.setFont(new Font("Times New Roman", 1, 20));
    votreListe.setForeground(Color.white);
    tousLesMotsPossibles.setText("Tous les mots possibles");
    tousLesMotsPossibles.setFont(new Font("Times New Roman", 1, 20));
    tousLesMotsPossibles.setForeground(new Color (167, 62, 95));
    tempEcoule.setText("Temps écoulé !");
    tempEcoule.setHorizontalAlignment(SwingConstants.CENTER);
    tempEcoule.setFont(new Font("Andalus", 1, 50));
    tempEcoule.setForeground(Color.white);
    
    this.update(this.getGraphics());
    jScrollPane2.getViewport().add(listeTotale, null);
    
    jPanelScore.add(votreScore, new XYConstraints(10, 145, 300, 100));
    jPanelScore.add(scoreTotal, new XYConstraints(300, 165, 100, 55));
    jPanelScore.add(votreListe,new XYConstraints(50,200,200,100));
    jPanelScore.add(tousLesMotsPossibles,new XYConstraints(500,200,200,100));
    jPanelScore.add(jScrollPane1, new XYConstraints(50, 270, 200, 180));
    jPanelScore.add(jScrollPane2, new XYConstraints(500, 270, 200, 180));
    jPanelScore.add(tempEcoule,new XYConstraints(175, 15, 435, 90));
    jPanelScore.add(wallScore, new XYConstraints(0, 0, 765, 530));
                
    }
    

//Gestion des mots
    /**
   * Méthode ajoute une lettre au mot que le joueur forme
   * @param c, la lettre à ajouter pour former la suite du mot
   * @return void
   **/
  public void ajouterCaractere(char c) {
        motSelectionne+=c;
  }
    /**
     * Méthode qui valide le mot si il existe dans le dictionnaire en l'ajoutant à la liste des mots trouvés seulement s'il n'y est pas déjà présent
     * Elle calcule le score instantané du mot puis remet toute la grille prête à être réutilisée pour la sélection d'un nouveau mot (cases blanches, mode "sélection" désactivé, le mot sélectionné ne contient plus de lettre).
     * @param 
     * @return void
     **/
  public void validerMot() {
     modeSelectionMot = false;
     for(int i=0; i<4; i++){
        for(int j=0; j<4; j++){
            tableauJTextField[i][j].setBackground(new Color(253,230,230));
        }
     }
    Arbre dictionnaire=Arbre.getDictionnaire("C://JDeveloper//mywork//MODOKU//modoku//francais.txt");
    boolean presence = false;
    presence = listeMots.contains(motSelectionne);
    boolean existenceDico=Arbre.estDansArbre(motSelectionne,dictionnaire);
    if(!presence && existenceDico) {
        listeMots.add(motSelectionne);
        scoreInstantane=calculScoreInstantane(motSelectionne);
    }
    System.out.println(motSelectionne);
    motSelectionne = "";    
    System.out.println(listeMots.toString());
  }  
  
   
    
  /**
   * Méthode qui calcule le score que rapporte un mot trouvé
   * @param mot, le mot trouvé
   * @return score, le score rapporté par ce mot
   **/
  static int calculScoreInstantane(String mot) {
        Hashtable<String, Integer> valeurLettre = new Hashtable<String, Integer>();
        valeurLettre.put("a", 1);
        valeurLettre.put("b", 3);
        valeurLettre.put("c", 3);
        valeurLettre.put("d", 2);
        valeurLettre.put("e", 1);
        valeurLettre.put("f", 4);
        valeurLettre.put("g", 2);
        valeurLettre.put("h", 4);
        valeurLettre.put("i", 1);
        valeurLettre.put("j", 8);
        valeurLettre.put("k", 10);
        valeurLettre.put("l", 1);
        valeurLettre.put("m", 2);
        valeurLettre.put("n", 1);
        valeurLettre.put("o", 1);
        valeurLettre.put("p", 3);
        valeurLettre.put("q", 8);
        valeurLettre.put("r", 1);
        valeurLettre.put("s", 1);
        valeurLettre.put("t", 1);
        valeurLettre.put("u", 1);
        valeurLettre.put("v", 4);
        valeurLettre.put("w", 10);
        valeurLettre.put("x", 10);
        valeurLettre.put("y", 10);
        valeurLettre.put("z", 10);

        int scoreMot = 0;
        for (int i = 0; i < mot.length(); i++) {
            String lettre = ""+mot.charAt(i);
            scoreMot = scoreMot + (int)valeurLettre.get(lettre);
        }
        return scoreMot;
  }
    
  
//Méthodes permettant de Gérer les cases de la grille
  /**
     *La méthode casesAdjacentes trouve toutes les positions adjacentes d'une position.
     * @param position (la position dont nous voulons déterminer les cases adjacentes)
     * @return une Arraylist contenant toutes les cases adjacentes
     */
  public ArrayList casesAdjacentes(Position position) {
        ArrayList posAdj=new ArrayList<Position>();
        for (int i = position.getPositionLigne() - 1; i < position.getPositionLigne() + 2; i++) {
            for (int j = position.getPositionColonne() - 1; j < position.getPositionColonne() + 2; j++) {
                if (i >= 0 && i < 4 && j >= 0 && j < 4){
                      if ((i ==position.getPositionLigne() &&j ==position.getPositionColonne())==false) {
                      Position nouvellePosAdj = new Position(i, j);
                      posAdj.add(nouvellePosAdj);
                      }
                }
            }
        }
        return posAdj;
  }
  /**
     *la méthode estAdjacent retourne true si deux JTextField sont adjacents et false sinon.
     * @param jt1 JTextField
     * @param jt2 l'autre JTextField.
     * @return le boolean.
     */
  public boolean estAdjacent(JTextField jt1, JTextField jt2){
        Position pos1= positionJTextField(jt1);
        Position pos2= positionJTextField(jt2);                                                     
        for(int i=0; i<casesAdjacentes(pos1).size();i++){
            Position position=(Position)casesAdjacentes(pos1).get(i);
            if(position.getPositionColonne()==pos2.getPositionColonne()&& position.getPositionLigne()==pos2.getPositionLigne()){
                return true;
          
            }
        }
        return false;
  }
  /**
     *La méthode permet de déterminer la position d'un JTextField qui se trouve dans un tableau de JTextField.
     * @param tf le JTextField dont on veut déterminer la position.
     * @return la position du JTextField tf.
     */
  public Position positionJTextField(JTextField tf){
      Position pos= new Position(0,0);
      for(int i=0;i<4;i++){
          for(int j=0;j<4;j++){
              if(tf==tableauJTextField[i][j]){
                 pos=new Position(i,j);
                
              }
          }
      }
      return pos;
  }
    
  
//méthodes permettant la gestion des évenements de la grille de mot.
    /**
   * Méthode qui enclenche la sélection d'un nouveau mot (mode "sélection"), récupère la lettre du jTextField correspondant et l'ajoute au mot sélectionné, colore la case cliquée
   * @param évênement de la souris
   * @return void
   **/
  public void mousePressed(MouseEvent e) {
      if(modeSelectionMot==false) {
          modeSelectionMot = true;
          // Récupère le texfield à l'origine de l'événement souris
          JTextField tf = (JTextField) e.getComponent();
          chemin.add(tf);
          System.out.println(chemin.get(chemin.size()-1).getText());
          // Récupère le nouveau charactère
          char nouveauCharacter = tf.getText().charAt(0);
          tf.setBackground(new Color(145, 248, 181)); 
          motSelectionne+=nouveauCharacter;
      }
  }

    /**
     * Méthode déclare le mode "sélection" terminé et appelle la méthode "validerMot" lorsque le joueur relache la souris
     * @param e évênement de la souris
     * @return void
     **/
  public void mouseReleased(MouseEvent e) {
      System.err.println(e.getComponent().toString());
      if(modeSelectionMot) {
        validerMot();
        chemin.clear();
      }
  }
  
    /**
     * Méthode qui récupère la lettre du jTextField correspondant et l'ajoute au mot sélectionné, colore la case, lorsque la souris passe sur une case.
     * @param évênement de la souris
     * @return void
     **/  
  public void mouseEntered(MouseEvent e) {  
     if( modeSelectionMot == true) { 
          // Récupère le texfield à l'origine de l'événement souris
          JTextField tf = (JTextField) e.getComponent();
          // Récupère le nouveau charactère
          char nouveauCharacter = tf.getText().charAt(0);
          //on vérifie les condition de jeu : le JTextField ne doit pas avoir été sélectionné, et il doit être adjacent au dernierJTextField sélectionné qui se trouve dans le dernier index de l'Arraylist chemin
          if(tf.getBackground().equals(couleur)||!estAdjacent(chemin.get(chemin.size()-1),tf)){
               validerMot();
          }
          else{
              tf.setBackground(new Color(145, 248, 181)); 
              motSelectionne+=nouveauCharacter;
              chemin.add(tf);
          }

     }
  }

  public void mouseExited(MouseEvent e) {
    }
  public void mouseClicked(MouseEvent e) {
    }
  
  
//méthodes qui permettent de gérer les événements des autres boutons.
    /**
   * Méthode qui appelle la méthode validerMot si la souris sort de la grille de jeu
   * @param évênement de la souris
   * @return void
   **/
  private void bordure_mouseEntered(MouseEvent e) {
       if(modeSelectionMot) {
          validerMot();
       }
  }

   

  public class PageMenuEvent implements ActionListener{
      /**
       * Méthode qui démarre le jeu en remplissant la grille, en démarrant le chrono, et en affichant le jPanel1 qui correspond à la page "jeu"
       * Elle remplit également la liste qui va afficher tous les mots possibles pour la grille
       * @param évênement de la souris (clic sur le bouton pour jouer)
       * @return void
       **/
      public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boutonJouer){
            jPanel1.setBounds(new Rectangle(0, 0, 763, 526));
            jPanelMenu.setBounds(new Rectangle(0,0,0,0));
            jPanelScore.setBounds(new Rectangle(0,0,0,0));
            Case[][]cadrillage=new Case[4][4];
            Damier grille=new Damier(cadrillage);
            Damier.remplirDamier(grille);
            Arbre dictionnaire=Arbre.getDictionnaire("C://JDeveloper//mywork//Modoku//modoku//francais.txt");
            Damier.trouverTousLesMotsDeLaGrille(dictionnaire, grille);
            listeTotale.setListData(grille.tousLesMots.toArray());
            for(int i=0; i<4; i++){
              for(int j=0; j<4; j++){
                  tableauJTextField[i][j].setText(Character.toString(grille.getCase(i,j).getLettre()));
              }
            }
            s=120;
            chronometre.start();
            System.out.println(listeTotale);     
        }
        if(e.getSource()==boutonRegles){
            jPanelMenu.setBounds(new Rectangle(0,0,0,0));
            jPanelScore.setBounds(new Rectangle(0,0,0,0));
            jPanel1.setBounds(new Rectangle(0,0,0,0));
            jPanelRegles.setBounds(new Rectangle(0,0,763,526));
        }
      }
  }
  
  public class PageReglesEvent implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==boutonMenu){
          jPanel1.setBounds(new Rectangle(0, 0, 0,0));
          jPanelMenu.setBounds(new Rectangle(0,0,763, 526));
          jPanelScore.setBounds(new Rectangle(0,0,0,0));
          jPanelRegles.setBounds(new Rectangle(0,0,0,0));
      }
    }
  }
        
  public class PagePartieEvent implements ActionListener{
      /**
       * Méthode qui redémarre le jeu en changeant la grille, en redémarrant le chrono, et en affichant le jPanel1 qui correspond à la page "jeu"
       * Elle remplit également la liste qui va afficher tous les mots possibles pour la grille
       * @param évênement de la souris (clic sur bouton pour rejouer)
       * @return void
       **/
        public void actionPerformed(ActionEvent e) {
          if(e.getSource()==jButton1){
              jPanel1.setBounds(new Rectangle(0, 0, 763, 526));
              jPanelMenu.setBounds(new Rectangle(0,0,0,0));
              jPanelScore.setBounds(new Rectangle(0,0,0,0));
              Case[][]cadrillage=new Case[4][4];
              Damier grille=new Damier(cadrillage);
              Damier.remplirDamier(grille);
              Arbre dictionnaire=Arbre.getDictionnaire("D://JDeveloper//mywork//Application1//modoku//francais.txt");
              Damier.trouverTousLesMotsDeLaGrille(dictionnaire, grille);
              listeTotale.setListData(grille.tousLesMots.toArray());
              for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    tableauJTextField[i][j].setText(Character.toString(grille.getCase(i,j).getLettre()));
                }
              }
              listeMots.clear();
              s=120;
              chronometre.start();
              System.out.println(listeTotale);
          }            
        }
  }
  
    
              
   
    
//Gestion du chronomètre
   /**
    * Méthode qui fait évoluer le chrono et affiche, lorsque le chrono arrive à zéro, le jPanelScore qui correspond à la page "score", le score total est calculé pour être affiché 
    * @param 
    * @return void
    **/    
  public void run() {
    while (chronometre!=null&&s>0) {
     repaint ();
     s--;
     try {
      chronometre.sleep(speed);
     } catch (InterruptedException e) {}
    }
    if(s==0){
        jPanel1.setBounds(new Rectangle(0,0,0,0));
        jPanelScore.setBounds(new Rectangle(0,0,763,526));
        jList1.setListData(listeMots.toArray());
        this.update(this.getGraphics());
        jScrollPane1.getViewport().add(jList1, null);
        this.update(this.getGraphics());
        jScrollPane2.getViewport().add(listeTotale, null);
        int scoreFinal=0;
        for(int i =0; i<listeMots.size();i++){
          scoreFinal+=calculScoreInstantane(listeMots.get(i)); 
        }
        System.out.println("le score final est : " +scoreFinal);
        scoreTotal.setText(String.valueOf(scoreFinal));
    }
  }

  
  class JPanelApplet extends JPanel { 
     JPanelApplet( ) // constructeur 
    { 
     } 
      /**
       * Méthode qui dessine le chrono
       * @param g
       * @return void
       **/ 
    public void paintComponent (Graphics g)  { // le redessinement est traité ici 
       super.paintComponent(g);
       String S= (int)(s/60)+":"+(int)(s%60)/10+(s%60)%10;
       //affichage centré  
       FontMetrics fm=g.getFontMetrics();
       int largeur=fm.stringWidth(S);
       int hauteur=fm.getHeight();
       int x=(getSize().width-largeur)/2;
       int y=(getSize().height-hauteur)/2;  
       g.drawString(S, x, y+hauteur-fm.getDescent());
     } 
  }
   
  class JPanelApplet1 extends JPanel { 
   JPanelApplet1( ) // constructeur 
  { 
   }
      /**
       * Méthode qui dessine le jpanel qui affiche le mot que le joueur sélectionne
       * @param g
       * @return void
       **/ 
    public void paintComponent (Graphics g)  { // le redessinement est traité ici 
      super.paintComponent(g);
      String S= motSelectionne;
     //affichage centré  
      FontMetrics fm=g.getFontMetrics();
       int largeur=fm.stringWidth(S);
       int hauteur=fm.getHeight();
       int x=(getSize().width-largeur)/2;
       int y=2*(getSize().height-hauteur);  
      g.drawString(S, x, y+hauteur-fm.getDescent());
     }
  }
  
  class JPanelApplet2 extends JPanel { 
     JPanelApplet2( ) // constructeur 
    { 
     } 
        /**
         * Méthode qui dessine le jPanel qui affiche le score instantané du mot que le joueur sélectionne
         * @param g
         * @return void
         **/ 
      public void paintComponent (Graphics g)  { // le redessinement est traité ici 
        super.paintComponent(g);
        String S= String.valueOf(scoreInstantane);
       //affichage centré  
         FontMetrics fm=g.getFontMetrics();
         int largeur=fm.stringWidth(S);
         int hauteur=fm.getHeight();
         int x=(getSize().width-largeur)/2;
         int y=(getSize().height-hauteur)/2;  
        g.drawString(S, x, y+hauteur-fm.getDescent());
       System.out.println("good");
       }
    }
  
    
     
  
  public void init() {
    try {
      jbInit();
    } 
    catch (Exception e) {
      e.printStackTrace();
    }
  }

    
}
