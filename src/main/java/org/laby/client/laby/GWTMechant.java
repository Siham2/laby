package org.laby.client.laby;

import com.google.gwt.user.client.Timer;



/** Cette classe g�re les m�chants du Jeu
 * Les mechants sont des threads ayant des param�tres internes.
 */
public class GWTMechant
{
    private GWTPoint pos = new GWTPoint(0,0);
    private int type = 0;
    private Timer timer;
    
    
    //Le m�chant a besoin de connaitre son environnement, donc il a le plateau de jeu comme variable interne
    private GWTCase[] cases;
    private GWTPoint prec = new GWTPoint(0,0);
    private int difficulte = 1;
    //Position de l'image du m�chant dans le canevas
    private GWTPoint image = new GWTPoint(0,0);
    
    /** classe m�chant */    
    public GWTMechant()
    {
        difficulte = 1;
    }
    
    
    /** surcharge de la fonction run du  thread m�chant.
     * � chaque it�ration de la boucle, le thread dort pendant un temps fonction du
     * niveau de difficult� et du type du m�chant.
     * Puis le m�chant se d�place.
     */    
    public void start()
    {
    	timer = new Timer() {
		        public void run() {
		        		 deplace();
		        }
		      };

	  timer.schedule((400/difficulte)/type);
		      
    }
    
    
    
    /** modifie le niveau de difficult� (la vitesse du m�chant)
     * @param difficulte param�tre influent sur la vitesse du m�chant (plus la difficult� est �lev�e,
     * plus le m�chant est rapide)
     */    
    public void setDifficulte(int difficulte)
    {
        this.difficulte = difficulte;
    }
    
    /** initialise le m�chant
     * @param type type du m�chant
     * @param posX position en X
     * @param posY position en Y
     * @param image position de l'image du m�chant dans le Canevas des m�chants
     */    
    public void initPosition( int type, int posX, int posY,GWTPoint image)
    {
        this.type = type;
        this.pos.x = posX;
        this.pos.y = posY;
        
        this.image.setLocation(image);
        this.prec.setLocation(pos);
    }
    
    
    
    /** Renvoie les coordonnes actuelle du m�chant
     * @return point de coordonn�es du m�chant sur la carte
     */    
    public GWTPoint getCoord()
    {
        return pos;
    }
    
    
    /** Renvoie les coordonn�e de l'image du m�chant dans le canevas de m�chant
     * @return coordonn�e de l'image du m�chant dans le canevas de m�chant
     */    
    public GWTPoint getImage()
    {
        return image;
    }
    
    /** Renvoie le type de la case dont les coordonn�es sont pass�es en argument.
     * @param x abcisse de la case � v�rifier
     * @param y ordonn�e de la case � v�rifier
     * @return type de la case pas� en argument.
     */    
    public int verifCase(int x, int y)
    {
        int typeCase = -1;
        for(int i=0;i<cases.length;i++){
            if(cases[i].getPosX() == x && cases[i].getPosY() == y){
                typeCase = cases[i].getType();
            }
        }
        return typeCase;
    }
           
    /** Methode qui g�re le d�placement du m�chant.
     * Le m�chant choisi une direction al�atoire, avance tout droit tant qu'il ne
     * rencontre pas d'obstacle. Si il rencontre un obstacle, une nouvelle direction
     * al�atoire est d�finie.
     */    
    public void deplace()
    {
    	GWTPoint temp = new GWTPoint(0,0);
        if(prec.equals(pos))
        {
          do
            {
                int rand = (int)(Math.random()*10000) % 3 -1;
                temp.x = pos.x + rand;
                if(rand !=0)
                {
                    temp.y = pos.y +0;
                }
                else
                {
                    int rand2 =((int)(Math.random()*10000 % 2)) * 2 -1;
                    temp.y = pos.y + rand2;
                }
                
            }     while(verifCase(temp.x , temp.y)!=1);
            
            prec.setLocation(pos);
            pos.setLocation(temp);
           
            
        }
        else
        {
            temp.x = pos.x + (pos.x-prec.x);
            temp.y = pos.y + (pos.y-prec.y);
            prec.setLocation(pos);
            if(verifCase(temp.x,temp.y)==1){
                pos.setLocation(temp);
            }
        }
        
     
        timer.schedule((400/difficulte)/type);

        
    }
    
    /** initialise l'environnement Cases du m�chant
     * @param cases tableau de cases du plateau de Jeu
     */    
    public void initCases(GWTCase [] cases)
    {
        this.cases = cases;
    }


	public void stop() {
		timer.cancel();
	}
    
}