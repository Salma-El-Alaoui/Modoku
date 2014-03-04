package modoku;

import java.util.ArrayList;

public class Case {
    private char lettre;
    protected Position position;
    protected boolean estVoyelle;
    protected ArrayList positionsAdjacentes = new ArrayList<Position>();
    protected int nombreDePos = 0;
  
    /** constructeur
     * @param pos la position de la case,
     * @param nature un entier qui spécifie quelle type de lettre on veut: entrer 0 pour une lettre, 1 pour une voyelle et 2 pour une consonne
     */
    public Case(Position pos, int nature) {
        this.position = pos;
        genererLettre(nature);
        trouverCasesAdjacentes();
        this.nombreDePos = positionsAdjacentes.size();
    }

    public char getLettre() {
        return this.lettre;
    }

    public Position getPosition() {
        return this.position;
    }

    public boolean getEstVoyelle() {
        return this.estVoyelle;
    }

    public ArrayList getPositionsAdjacentes() {
        return this.positionsAdjacentes;
    }

    public int getNombreDePos() {
        return this.nombreDePos;
    }
    
    /**
     * La méthode egal permet de retourner true si deux cases ont la même position, et faux sinon.
     * @param case1 la case à comparer
     * @param case2 l'autre case à comparer
     * @return le boolean.
     */
  static  boolean egal(Case case1, Case case2){
       Position position1=case1.getPosition();
       Position position2=case2.getPosition();
       if(position1.getPositionLigne()==position2.getPositionLigne()&& position1.getPositionColonne()==position2.getPositionColonne()){
         return true;
       }
       else{
         return false;
       }
     }
    /**
     * Méthode qui crée une lettre selon sa fréquence d'apparition
     * @param nature, 0 si on veut une générer une lettre, 1 pour une voyelle et 2 pour une consonne
     */
    public void genererLettre(int nature) {
    //tableauPondere est un tableau qui traduit la fréquence d'apparition de chaque lettre dans le dictionnaire (une analyse fréquentielle du dictionaire "français" a été faite au préalable)
    //La tableau contient 1000 cases, la fréquence d'appartion de chaque lettre est donc traduite en "pour mille". 
        char tableauPondere[] = new char[1000];

        for (int a = 0; a < 130; a++) {
            tableauPondere[a] = 'a';
        }
        for (int e = 130; e < 257; e++) {
            tableauPondere[e] = 'e';
        }
        for (int i = 257; i < 347; i++) {
            tableauPondere[i] = 'i';
        }
        for (int o = 347; o < 403; o++) {
            tableauPondere[o] = 'o';
        }
        for (int u = 403; u < 439; u++) {
            tableauPondere[u] = 'u';
        }
        for (int b = 439; b < 472; b++) {
            tableauPondere[b] = 'b';
        }
        for (int c = 472; c < 530; c++) {
            tableauPondere[c] = 'c';
        }
        for (int d = 530; d < 544; d++) {
            tableauPondere[d] = 'd';
        }
        for (int f = 544; f < 556; f++) {
            tableauPondere[f] = 'f';
        }
        for (int g = 556; g < 571; g++) {
            tableauPondere[g] = 'g';
        }
        for (int h = 571; h < 586; h++) {
            tableauPondere[h] = 'h';
        }
        for (int j = 586; j < 589; j++) {
            tableauPondere[j] = 'j';
        }
        for (int k = 589; k < 592; k++) {
            tableauPondere[k] = 'k';
        }
        for (int l = 592; l < 634; l++) {
            tableauPondere[l] = 'l';
        }
        for (int m = 634; m < 652; m++) {
            tableauPondere[m] = 'm';
        }
        for (int n = 652; n < 722; n++) {
            tableauPondere[n] = 'n';
        }
        for (int p = 722; p < 739; p++) {
            tableauPondere[p] = 'p';
        }
        for (int q = 739; q < 743; q++) {
            tableauPondere[q] = 'q';
        }
        for (int r = 743; r < 829; r++) {
            tableauPondere[r] = 'r';
        }
        for (int s = 829; s < 905; s++) {
            tableauPondere[s] = 's';
        }
        for (int t = 905; t < 973; t++) {
            tableauPondere[t] = 't';
        }
        for (int v = 973; v < 981; v++) {
            tableauPondere[v] = 'v';
        }
        for (int w = 981; w < 984; w++) {
            tableauPondere[w] = 'w';
        }
        for (int x = 984; x < 987; x++) {
            tableauPondere[x] = 'x';
        }
        for (int y = 987; y < 991; y++) {
            tableauPondere[y] = 'y';
        }
        for (int z = 991; z < 1000; z++) {
            tableauPondere[z] = 'z';
        }
    
        if (nature == 0) {
            
            //Génération d'un nombre aléatoire compris entre 0 et 999, qui correspond à une lettre
            int nombreAleatoire0 = (int)(Math.random() * 1000);
            this.lettre = tableauPondere[nombreAleatoire0];
            if (nombreAleatoire0 < 439) {
            
            //on remplit l'attribut estVoyelle pour la case
                this.estVoyelle = true;
            } else {
                this.estVoyelle = false;
            }


        } else if (nature == 1) {
            int nombreAleatoire1 = (int)(Math.random() * 439);
            this.lettre = tableauPondere[nombreAleatoire1];
            this.estVoyelle = true;

        } else {
            int nombreAleatoire2 = (int)(439 + Math.random() * 561);
            this.lettre = tableauPondere[nombreAleatoire2];
            this.estVoyelle = false;
        }
    }

    /**
     * Méthode qui remplit l'ArrayList positionsAdjacentes des positions des cases adjacentes
     * à la case courante.
     **/

    public void trouverCasesAdjacentes() {
        
        //Boucle qui parcourt les lignes de la grille
        for (int i = this.position.getPositionLigne() - 1; i < this.position.getPositionLigne() + 2; i++) {
            
            //Boucle qui parcourt les colonnes de la grille
            for (int j = this.position.getPositionColonne() - 1; j < this.position.getPositionColonne() + 2; j++) {
                
                //condition:on garde les cases qui se trouvent autour de la case courante, attention à na pas sortir de la grille
                if (i >= 0 && i < 4 && j >= 0 && j < 4){
                    
                    //condition: la case ne doit pas être égale à la case courante
                    if ((i==this.position.getPositionLigne() && j == this.position.getPositionColonne())==false) {
                        
                    //remplissage de l'ArrayList avec les position des cases adjacentes
                    Position nouvellePosAdj = new Position(i, j);
                    this.positionsAdjacentes.add(nouvellePosAdj);
                    }
                }
            }
        }
    }


}
