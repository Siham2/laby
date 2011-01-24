package org.laby.client.laby;



/** Classe qui g�re les bonus
 * Le joueur est oblig� de ramasser tous les bonus pr�sents sur le plateu pour
 * d�bloquer la sortie.
 * Un bonus contient un position sur la carte, un point qui d�fini l'image du bonus
 * dans le canevas de bonus, et un type (=~ valeur du bonus)
 */

public class GWTBonus
{
    /** position de l'image du bonus dans le canevas de bonus */    
    private GWTPoint image = new GWTPoint(0, 0);
    /** position du bonus sur la carte */    
    private GWTPoint pos = new GWTPoint(0,0);
    
    
    private int type = 0;
    /** bool�en qui determine si le bonus est "visible" ou pas */    
    private boolean affiche = true;
    

    /** constructeur de bonus */    
    public GWTBonus()
    {
    }
    
    /** Initialisation du bonus
     * @param type type du bonus (valeur du bonus)
     * @param posX abscisse de la position du bonus sur la carte
     * @param posY ordonn�e de la position du bonus sur la carte
     * @param imageX abscisse de la position de l'image du bonus dans le canevas des bonus
     * @param imageY ordonn�e de la position de l'image du bonus dans le canevas des bonus
     */    
    public void initPosition(int type, int posX, int posY, int imageX, int imageY)
    {
        this.type = type;
        this.pos.x = posX;
        this.pos.y = posY;
        this.image.x = imageX;
        this.image.y = imageY;
    }
    
    /** Renvoie le type du bonus
     * @return Type du bonus
     */    
    public int getType()
    {
        return type;
    }
    /** Renvoie la position de l'image du bonus dans le canevas de bonus
     * @return position de l'image du bonus dans le canevas de bonus
     */    
    public GWTPoint getImage()
    {
        return image;
    }
    
    /** modificateur de la variable affiche (qui d�termine si le bonus a doit �tre
     * affich� ou pas <=> determine si le bonus a �t� pris ou pas)
     * @param aff d�termine si le bonus a doit �tre affich� ou pas
     */    
    public void setAffiche(boolean aff)
    {
        affiche = aff;
    }
    
    /** Renvoie la position du bonus sur la carte
     * @return position du bonus sur la carte
     */    
    public GWTPoint getCoord()
    {
        return pos;
    }
    
    /** Renvoie la variable affiche
     * @return d�termine si le bonus a doit �tre affich� ou pas
     */    
    public boolean getAffiche()
    {
        return affiche;
    }
}
