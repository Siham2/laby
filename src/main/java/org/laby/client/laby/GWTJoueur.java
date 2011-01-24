package org.laby.client.laby;
/*
 * Class.java
 *
 * Created on 10 f�vrier 2004, 14:13
 */

/**
 *Cette classe g�re le joueur
 *
 */

import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.widgetideas.graphics.client.ImageLoader;

/** La classe joueur g�re le personnage dirig� par le joueur humain */
public class GWTJoueur
{
    
    /** position du joueur sur la carte */    
    private GWTPoint pos = new GWTPoint(0,0);
    /** environnment du joueur */    
    private GWTCase [] cases;
    
    /** image courante du joueur */
    private ImageElement imageCourante;
    
    private ImageElement marcheNord, marcheSud,marcheOuest,marcheEst , mort; 
    /** bool�en qui determine si le joueur a le droit de bouger ou pas */    
    private boolean vivant;
    
    /** Creates a new instance of Class */
    public GWTJoueur(String imagePath)
    {
    	  String[] urls = new String[] {
  	    		imagePath+"marchedevant.gif",
  	    		imagePath+"marchederriere.gif",
  	    		imagePath+"marchegauche.gif",
  	    		imagePath+"marchedroite.gif",
  	    		imagePath+"mort.gif"
  	    		};
  	    
  	    
  	    ImageLoader.loadImages(urls, new ImageLoader.CallBack() {

  			@Override
  			public void onImagesLoaded(ImageElement[] imageElements) {
          
  	         marcheNord = imageElements[0];
  	         marcheSud = imageElements[1];
  	         marcheOuest = imageElements[2];
  	         marcheEst = imageElements[3];
  	         mort = imageElements[4];
           
  			}});

    	
    	
    }
    
    
    /** Initialise la position du joueur sur la carte
     * @param posX abscisse de la position du joueur sur la carte.
     * @param posY ordonn�e de la position du joueur sur la carte.
     * @param URL chemin du r�pertoire des images utilis�es par le jeu
     */    
    public void initPosition(int posX,int posY)
    {
        pos.x = posX;
        pos.y = posY;
        
      
        imageCourante = marcheNord;
        vivant = false;
    }
    
    
    /** Active le joueur (autorise le d�placement du joueur) */    
    public void activer()
    {
        vivant = true;
    }
    
    public void desactiver()
    {
        vivant = false;
    }
    /** Renvoie la position du Joueur
     * @return position du joueur.
     */    
    public GWTPoint getCoord()
    {
        return pos;
    }
    /** Renvoie l'image actuelle du Joueur
     * @return Image actuelle du Joueur.
     */    
    public ImageElement getImage()
    {
        return imageCourante;
    }
    
    /** Renvoie le type de la case dont les coordonn�es sont pass�es en param�tre
     * @param x
     * @param y
     * @return
     */    
    public int verifCase(int x, int y)
    {
        int typeCase = -1;
        for(int i=0;i<cases.length;i++)
            if(cases[i].getPosX() == x && cases[i].getPosY() == y)
                typeCase = cases[i].getType();
        return typeCase;
    }
    
    /** revoie le score du joueur */    
    public int score(GWTPoint pos,int type)
    {
        if(this.pos.equals(pos))
            return type;
        else return 0;
        
    }
    
    /** Methode qui v�rifie si le joueur est sur la case sortie */    
    public boolean sortie()
    {
        if(verifCase(pos.x, pos.y)==3)
        {
            return true;
        }
            else
            return false;
    }
    
    /** M�thode qui v�rifie si en le joueur est toujours en vie (compte tenu de ce qu'il
     * y a sur la case ou il se trouve)
     */    
    public boolean enVie(GWTPoint pos)
    {
        if(this.pos.equals(pos))
        {
            imageCourante = mort;
            vivant = false;
            return false;
        }
        else
            return true;
    }
    
    
    /** d�place le joueur d'un vecteur dont les coordonn�es sont pass�es en argument */    
    public void deplace(int x, int y)
    {
        if(vivant)
        {
            int tempX = x+pos.x;
            int tempY = y+pos.y;
            
            if( verifCase(tempX,tempY) == 1 || verifCase(tempX, tempY) == 3)
            {
                pos.x += x;
                pos.y += y;
            }
            
            if(x ==0 && y == -1)
                imageCourante = marcheNord;
            else if (x ==0 && y == 1)
                imageCourante = marcheSud;
            else if (x ==1 && y == 0)
                imageCourante  = marcheEst;
            else if (x ==-1 && y == 0)
                imageCourante = marcheOuest;
        }
    }
    
    /** initialise l'environnement (carte) du joueur. */    
    public void initCases(GWTCase [] cases)
    {
        this.cases = cases;
    }
    
}
