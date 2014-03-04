package modoku;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


  public class Arbre {
  private char val ;
  private Arbre suivantDansLeMot;
  private Arbre suivantDansLeDico ;

 /**
     *Constructeur
     * @param val la lettre qui repr�sente le sommet de chaque arbre
     */
   public Arbre(char val) { 
      this.val = val ;
  }

/**
     * Constructeur
     * @param val la lettre qui repr�sente le sommet de chaque arbre 
     * @param suivantDansLeMot l'arbre dont le sommet repr�sente la lettre suivante dans le mot
     * @param suivantDansLeDico l'arbre dont le sommet repr�sente la lettre suivante dans le dictionnaire.
     */
    public  Arbre(char val, Arbre suivantDansLeMot, Arbre suivantDansLeDico) {
    this.val = val ;
    this.suivantDansLeMot = suivantDansLeMot  ; this.suivantDansLeDico=suivantDansLeDico ;
  }
  
  // le char EOW repr�sente la marque de fin de mot dans notre dictionnaire.
  final static char EOW = '\0';
  
  public char getVal(){
  return this.val;
  }
  public Arbre getSuivantDansLeMot(){
    return this.suivantDansLeMot;
  }
  public Arbre getSuivantDansLeDico(){
    return this.suivantDansLeDico;
  }
  
  

   /** 
     * La m�thode getChar permet de retourner le caract�re d'index i dans une chaine de caract�re s, ou de retourner le caract�re vide quand i est plus grand que le nombre de caract�res de s.
     * @param s la chaine de caract�re.
     * @param i l'index du caract�re
     * @return le caract�re d'indice i ou le caract�re vide;
       */
   
  static char getChar(String s, int i) {
     return i < s.length() ? s.charAt(i) : EOW ;
   }
  
     /**
          *La m�thode estDansArbre permet de d�terminer si le suffixe d'un mot est dans l'arbre.
          * @param s le mot � chercher.
          * @param i indice du premier caract�re du suffixe.
          * @param a arbre dans lequel on cherche le mot.
          * @return objet de type boolean.
          */  
   static boolean estDansArbre(String s, int i, Arbre a) {
        char c = getChar(s, i) ;
        while (a != null) {
          if (c < a.val) { return false; } ; // le mot d'existe pas dont notre dictionnaire
          if (c > a.val) { a= a.suivantDansLeDico ; } // on passe � la lettre suivante
          else { // c == t.val,  soit c'est la marque de fin de mot, soit on passe� la lettre suivante dans le mot.
            if (c == EOW) {
              return true ;
            } else {
              i++ ; c = getChar(s, i) ;
              a = a.suivantDansLeMot ;
            }
          }
        }
        return false ;
      }
     
     /**
     * la m�thode estDansArbre permet de v�rifier l'existence d'un mot dans le dictionnaire.
     * @param s le mot dont on veut v�rifier la pr�sence
     * @param a le dictionnaire
     * @return true si le mot est dans le dictionnaire et false sinon.
     */
      static boolean estDansArbre(String s, Arbre a ) { 
          return estDansArbre(s, 0, a) ; 
      }
     
     
     /**
     * La m�thode prefixeEstDansArbre permet de d�terminer si une chained e caract�res est le pr�fixe d'un mot dans le dictionnaire
     * @param s la chaine de caract�res
     * @param a le dictionnaire
     * @return true si s est le pr�fixe d'un mot dans le dictionnaire et false sinon.
     */
     static boolean prefixeEstDansArbre(String s,Arbre a){
        int i=0;
        char c = s.charAt(i) ;
        //on parcourt le dictionnaire
        while(a!=null ){
          if (c < a.val) { return false; } ;
          if (c > a.val) { a= a.suivantDansLeDico ; } 
          else{
              i++ ;
              c = s.charAt(i);
              a = a.suivantDansLeMot ;
            }
        if (a==null){
          return false;
        }
        //on v�rifie que le derni�re lettre de notre mot correspond bien au sommet de l'arbre ou on est arriv� apr�snotre parcours.
         if (c==s.charAt(s.length()-1) && a.val==c){
              return true;
            }
        }
    return false;
    
     }
    

      /** La m�thode ajoute permet d'ajouter le suffixe d'un mot � un arbre.
       * soit le mot est vide alors on ajoute le caract�re vide � notre arbre, et sinon on l'�crit sous la forme m=cm'.
       * @param a est � l'arbre o� on veut faire l'ajout.
       * @param s est le mot qui comprend le suffixe.
       * @param i est l'indice du premier caract�re du suffixe dans le mot.
       * @return l'arbre avec le suffixe ajout�.
       */
      
  static Arbre ajoute(Arbre a, String s, int i) {
    char c = getChar(s, i) ;
    if (c == EOW) {
       if (a!= null && a.val == EOW) { // D�j� l�.
          return a ;
       } else { // Ajouter effectivement le mot vide.
          return new Arbre(EOW, null, a) ;
       }
    } else {
      return ajouteDansArbre(a, c, s, i+1) ;
    }} // ne renvoie jamais null
  
      /** La m�thode ajoutedansarbre permet d'ajouter un suffixe dans un arbre dans le cas o� il ne commence pas par le caract�re vide(m=cm')
           * @param a est � l'arbre o� on veut ajouter le mot;
           * @param c est le premier caract�re du suffixe qu'on veut ajouter;
           * @param s est le mot qui comprend le suffixe;
           * @param i est l'index du premier caract�re de m'.
           * @return l'arbre avec le suffixe ajout�;
           */
      
    static Arbre ajouteDansArbre(Arbre a, char c, String s, int i) {
      if (a == null || c < a.val) { // c�d que la liste est nulle, on cr�e un nouvel arbre, ou alors on l'ajoute devant 
         return new Arbre(c, ajoute(null, s, i), a) ;
      } else if (c == a.val) { // Completer un sous-dictionnaire
         return new Arbre(c, ajoute(a.suivantDansLeMot, s, i), a.suivantDansLeDico) ;
      } else { //  ajouter plus loin
         return new Arbre(a.val, a.suivantDansLeMot, ajouteDansArbre(a.suivantDansLeDico, c, s, i)) ;
      }}
      
      /**
     *La m�thode ajoute permet d'ajouter un mot dans un arbre.
     * @param a Arbre 
     * @param s String
     * @return l'arbre avec le mot s.
     */
      static Arbre ajoute(Arbre a, String s) { 
          return ajoute(a, s, 0) ; 
          }
      
    
    /**
     * La m�thode construitArbre permet de construire un arbre a partir d'un BufferedReader
     * @param br le BufferedReader
     * @return L'arbre.
     */
      public static Arbre construitArbre(BufferedReader br) {
        Arbre r = null ;
        String line ;
        try {
          while ((line = br.readLine()) != null) { // Idiome !
            r = ajoute(r, line) ;
          }
        } catch (IOException e) {
          System.err.println(e.getMessage()) ;
          System.exit(2) ;
        }
        return r ;
      }
      
      /**
     * La m�thode getDictionnaire permet de lire tous mots d'un fichier texte ligne pare ligne et  de les ajouter dans un arbre
     * @param dico un String qui repr�sente l'emplacement du  fichier.
     * @return l'arbre contenant tous les mots du fichier.
     */
      public static Arbre getDictionnaire(String dico){
      
       Arbre dictionnaire=new Arbre(EOW);
        try {
           InputStream ips=new FileInputStream(dico);
           InputStreamReader ipsr=new InputStreamReader(ips);
           BufferedReader br=new BufferedReader(ipsr);
           dictionnaire=dictionnaire.construitArbre(br);
        }      
        catch (Exception e) {
           System.out.println(e.toString());
         } 
        return dictionnaire;
      }
      

   
    public static void main(String[]args){
     String dico="C://JDeveloper//mywork//Modoku//modoku//francais.txt";
     Arbre dictionnaire= new Arbre(EOW);
      try {
         InputStream ips=new FileInputStream(dico);
         InputStreamReader ipsr=new InputStreamReader(ips);
         BufferedReader br=new BufferedReader(ipsr);
         dictionnaire=dictionnaire.construitArbre(br);
      }      
      catch (Exception e) {
         System.out.println(e.toString());
       } 
           
        
         }
    
      
   
    }