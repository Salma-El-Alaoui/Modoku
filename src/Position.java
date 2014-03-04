package modoku;
public class Position {
   private int positionLigne;
   private int positionColonne;
 
   
   
    /**constructeur
     * @param x la position de la case en ligne
     * @param y la position de la case en colonne
     */
    
    public Position(int x, int y) {
        this.positionLigne = x;
        this.positionColonne = y;     
        }
    public int getPositionLigne(){
     return this.positionLigne;
    }
    
    public int getPositionColonne(){
      return this.positionColonne;
    }
                        
      
}
    