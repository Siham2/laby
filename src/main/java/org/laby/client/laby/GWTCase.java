package org.laby.client.laby;
/*
 * Case.java
 *
 */



/**
 * Cette classe permet de gerer une case du jeu pour eviter de faire appel
 * a la base SQL lors de chaque affichage des labyrinthes.
 *
 * On cr�e un tableau de cases correspondant au plateau de jeu. Celui ci est mis a jour
 * lorsque la base SQL est modifi�e.
 *
 * Pour l'affichage du plateau, on utilise ce tableau est l'on evite de solliciter la base SQL.
 */

public class GWTCase {
    
    private int posX;
    private int posY;
    private int imageX;
    private int imageY;
    private int type;
    
    public GWTCase() {
    }
    
    
    /**
     * @param x
     * @param y
     * @param t
     * @param ix
     * @param iy
     */
    public void setAll(int x,int y,int t, int ix, int iy) {
        posX = x;
        posY = y;
        
        type = t;
        
        imageX = ix;
        imageY = iy;
    }
    
    
    /**
     * @param x
     */
    public void setPosX(int x)   {
        posX = x;
    }
    
    /**
     * @param y
     */
    public void setPosY(int y) {
        posY = y;
    }
    
    /**
     * @param x
     */
    public void setImageX(int x)   {
        imageX = x;
    }
    
    /**
     * @param y
     */
    public void setImageY(int y) {
        imageY = y;
    }
    
    /**
     * @return
     */
    public int getPosX() {
        return posX;
    }
    
    /**
     * @return
     */
    public int getPosY() {
        return posY;
    }
    
    /**
     * @return
     */
    public int getImageX() {
        return imageX;
    }
    
    /**
     * @return
     */
    public int getImageY() {
        return imageY;
        
    }
    
    /**
     * @return
     */
    public int getType() {
        return type;
    }
    
    /**
     * @param t
     */
    public void setType(int t) {
        type = t;
    }
    
}
