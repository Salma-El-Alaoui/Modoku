package modoku;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;

import modoku.Case;
import modoku.Position;

import utils.system;

import weblogic.ejb.container.persistence.spi.EoWrapper;


public class Damier {
     private Case[][]damier;
     protected ArrayList<String>tousLesMots=new ArrayList<String>();
    
    //constructeur
    public Damier(Case[][]damier) {
        this.damier=damier;
    }
    
    /**
     * La méthode setCase permet de créer une case à partir d'une position
     * @param i, la position de la case en ligne
     * @param j,  la position de la case en colonne
     * @return une case remplie
     */
      public Case setCase(int i,int j){
      Position pos = new Position(i,j);
      return this.damier[i][j]=new Case(pos,0);  
    }
    
      /**
     * La méthode remplirDamier permet de remplir une grille vide, de créer un Damier qui soit vérifié
     * @param grille un Damier vide
     * @return une grille de jeu Damier remplie
     */
    public static Damier remplirDamier(Damier grille){
    for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
            grille.setCase(i,j);        
            }
        }
        grille.verificationDamier();
        return grille;
    }
    
     /**
     * Méthode qui renvoie la case qui se trouve à la position rentrée en paramètre
     * @param i position dans la ligne
     * @param j position dans la colonne
     * @return la case qui se trouve à la position(i,j)
     */
    public Case getCase(int i, int j){
         return this.damier[i][j];   
    }
     
     /**
     * Méthode qui renvoie la case qui se trouve à la position rentrée en paramètre
     * @param pos la position de la case
     * @return la case qui se trouve à la position pos
     */
     
     public Case getCase(Position pos){
      return this.damier[pos.getPositionLigne()][pos.getPositionColonne()];
}
 
   
   /**
    *  Méthode qui vérifie que le damier est bien aux normes:
    *       chaque case avec une voyelle doit posséder au moins une case adjacente avec une consonne
    *       chaque case avec une consonne doit posséder au moins une case adjacente avec une voyelle
    */

     public void verificationDamier(){
      
      for(int i=0; i<4; i++){
          for(int j=0; j<4; j++){
            Case caseCourante = getCase(i,j); 
            Position PositionCourante=new Position(i,j);
            int nombreDeVoyelle=0;
            int nombreDeConsonne=0;
              
              //création d'une liste contenant les positions des cases adjacentes à la case courante
            ArrayList positionsCasesAdj = new ArrayList<Position>();
            positionsCasesAdj= caseCourante.getPositionsAdjacentes();
              
              //On parcourt la liste des cases adjacentes pour chercher le nombre de consonne et le nombre de voyelle
              for(int k=0; k <positionsCasesAdj.size(); k++){
                    Position positionCaseAdj = (Position) positionsCasesAdj.get(k);
                    Case caseAdj = getCase(positionCaseAdj);
                    if(caseAdj.getEstVoyelle() == true){
                        nombreDeVoyelle ++;
                    }else{
                        nombreDeConsonne ++;
                    }
                }
              //Si la case courante est une consonne entourée uniquement de consonnes, elle se transforme en voyelle
                if(caseCourante.getEstVoyelle() == false){
                     if(nombreDeVoyelle < 1){
                        damier[i][j] = new Case(PositionCourante,1);
                    }
              //De même, si la case courante est une voyelle entourée uniquement de voyelles, elle se transforme en consonne
                }else{
                    if(nombreDeConsonne < 1){
                        damier[i][j] = new Case(PositionCourante, 2);
                    }

                  
                }       
          }
      }
      
    }
   
   /**
     * La méthode nombreOccurences permet de retourner le nombre d'occurrences d'un String dans une ArrayList de String.
     * @param s le String dont on cherche l'occurence.
     * @param liste l'ArrayList.
     * @return le nombre d'occurence.
     */
   static int nombreOccurences(String s, ArrayList<String>liste){
     int n=0;
     for(int i=0;i<liste.size();i++){
         if(liste.get(i)==s){
           n++;
         }
     }
     return n;
   }
   
   /** La méthode supprimerDoublons permet de supprimer les occurences multiples d'un String dans une ArrayList.
     * @param liste L'ArrayList.
     * @return l'ArrayList sans les occurences multiples.
     */
   static ArrayList supprimerDoublons(ArrayList liste){
        int i=0;
        while( i<liste.size()){ 
            if(nombreOccurences((String)liste.get(i),liste)>1){
              liste.remove(i);
              
            }
            else{
              i++;
            }
        }
        return liste;
           
     }
             
   /**
     * La méthode MotAPartirDeListe permet de retourner un String formé des lettres contenues dans les cases d'une ArrayList.
     * @param ListeDeCases l'ArrayList de cases.
     * @return le String.
     */
   static String MotAPartirDeListe (ArrayList ListeDeCases){
       String mot="";
       for (int i=0; i<ListeDeCases.size(); i++ ){
           Case caseCourante=(Case)ListeDeCases.get(i);
           mot=mot+caseCourante.getLettre();
       }
        return mot;
   }
   
   /**
     * La méthode contient retourne true si une ArrayList de case contient case1, et faux sinon .
     * @param liste l'ArrayList de cases.
     * @param case1 la case dont on veut vérifier la présence dans l'ArrayList.
     * @return le boolean.
     */
   static boolean contient(ArrayList liste, Case case1){
    for(int i=0; i<liste.size();i++){
      Case caseListe=(Case)liste.get(i);
      Position positionListe=caseListe.getPosition();
      Position position1=case1.getPosition();
        if(position1.getPositionColonne()==positionListe.getPositionColonne()&& position1.getPositionLigne()==positionListe.getPositionLigne()){
           return true;
        }
    }
   return false;
   }

  
    /**
     *La méthode trouverMotsApartirDeCase permet de touver tous les mots d'une grille appartenant au dictionnaire en allant d'une case de position (i,j) dans la grille.
     * @param caseDebut, la case de laquelle on part
     * @param chemin, l'ArrayList des cases par lesquelles on passe.
     * @param dictionnaire l'Arbre dans lequel les mots qu'on trouve doivent être présents.
     * @param grille, la grille de jeu courante
     */
     static void trouverMotsApartirDeCase (Case caseDebut, ArrayList chemin , Arbre dictionnaire, Damier grille){
        //on commence la boucle sur toutes les positions adjacentes de la position de  caseDebut, qui sont contenues dans l'attribut positionsAdjacentes de la case.
        for(int i=0 ; i<caseDebut.getPositionsAdjacentes().size();i++){
            //on place la position adjavente d'index i dans la variable position adjacente.
            Position positionAdjacente=(Position)caseDebut.getPositionsAdjacentes().get(i);
            //on récupère la case correspondant à cette position.
            Case caseAdjacente= grille.getCase(positionAdjacente);
            // l'Array chemin représente toutes les "bonnes" cases par lesquelles on est passées depuis la première caseDebut jusqu'à la caseDebut actuelle.
            // il faut que la dernière case de ce chemin correseponde à la caseDebut actuelle pour pouvoir commencer la verification d'un nouveau mot.
            while(!Case.egal(caseDebut,(Case)chemin.get(chemin.size()-1))){
              chemin.remove(chemin.size()-1);
            }
            // le chemin ne doit pas contenir la case adjacente(puisqu'on ne peut pas utiliser la même case deux fois).
            if (contient(chemin,caseAdjacente)){
              // la case est deja dans le mot en cours de formation,on oublie .
              
            } else {
                // on rajoute cette case à chemin.
                chemin.add(caseAdjacente);
                //On commence la vérification du mot:
                  if ( !Arbre.prefixeEstDansArbre(MotAPartirDeListe(chemin),dictionnaire)){
                  // si le mot qu'on formeà partir des cases de chemin n'est le préfixe d'aucun mot dans le dictionnaire, on le supprime de l'ArrayList, ça ne sert à rien de continuer à chercher un mot.
                chemin.remove(caseAdjacente);
                }
                //Si c'est un préfixe d'un mot du dictionnaire.
                 else{
                    // Si ce n'est pas un mot, il faut continuer la recherche dans ce sens; 
                    if(!Arbre.estDansArbre(MotAPartirDeListe(chemin),dictionnaire)){
                      //on rappelle récursivement la méthode pour le case adjacente et le même chemin. 
                      trouverMotsApartirDeCase(caseAdjacente,chemin,dictionnaire,grille);

                    }
                   else{  
                      // Il s'agit d'un mot. on le stocke dans l'attribut ArrayListe LesMots de la grille courante.
                      grille.tousLesMots.add(MotAPartirDeListe(chemin));
                        //On rappelle la méthode récursivement car un mot peut être le préfixe d'un autre mot.
                      trouverMotsApartirDeCase(caseAdjacente,chemin,dictionnaire,grille);
                  
                    }
                
              }
          }
        }
 }
    /**
     * La méthode trouverTousLesMotsDeLaGrille permet de trouver tous les mots présents dans une grille et contenus dans l'Arbre dictionnaire.
     * @param dictionnaire, l'Arbre dans lequel les mots qu'on trouve doivent être présents.
     * @param grille, la damier dans lequel on souhaite trouver les mots
     */
       static void trouverTousLesMotsDeLaGrille(Arbre dictionnaire, Damier grille){
        ArrayList chemin=new ArrayList() ;
       int i=0;
       int j=0;
       for(i=0;i<4;i++){
           for(j=0;j<4;j++){    
                   // On applique la méthode trouverMotsAPartirDeCase à toutes les cases de la grille.
               Case caseDebut=grille.damier[i][j];
               chemin.clear();
               chemin.add(grille.getCase(i,j));
                trouverMotsApartirDeCase (caseDebut, chemin , dictionnaire, grille);
                 }
        } 
        
        System.out.println("La grille contient :"+ grille.tousLesMots.size());
        
    }
       
               
   //main pour essayer les classes ci-dessus
    public static void main (String[]args){
      String dico="C://JDeveloper//mywork//Modoku//modoku//francais.txt";
      Arbre dictionnaire= Arbre.getDictionnaire(dico);
      //essai pour le main   
      Case[][]cadrillage=new Case[4][4];
      Damier cadrillage1=new Damier(cadrillage);
      remplirDamier(cadrillage1);
      
      
      for (int i = 0; i < 4; i++) {
         System.out.println();
         for (int j = 0; j < 4; j++) {
             System.out.print("|" + cadrillage[i][j].getLettre() + "|");
          }
      }

     trouverTousLesMotsDeLaGrille( dictionnaire,cadrillage1);
    
    }
 }
        