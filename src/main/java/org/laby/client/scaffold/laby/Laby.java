package org.laby.client.scaffold.laby;

import org.laby.client.managed.request.NiveauProxy;
import org.laby.client.scaffold.laby.ui.LabyView;

import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.widgetideas.graphics.client.Color;
import com.google.gwt.widgetideas.graphics.client.GWTCanvas;
import com.google.gwt.widgetideas.graphics.client.ImageLoader;

/**
 * Application for browsing entities.
 */
public class Laby extends SimpleCanvasGame implements KeyPressHandler,
		ClickHandler {

	public String imagePath = "/images/sprites/";// par défaut

	/** Taille des cases */
	private int TAILLE_CASE = 32;

	private int MARGIN = 10;

	private int REFRESH_RATE = 50;

	private NiveauLoader niveauLoader;
	
	private NiveauProxy niveau;
	

	private Boolean isStarted = false;
	

	Timer timer;

	/**
	 * Images
	 */
	/** palette qui contient les images du décor */
	private ImageElement paletteDecor;

	/** palette qui contient les images des méchants */
	private ImageElement paletteVilain;

	/** palette qui contient les images des bonus */
	private ImageElement paletteBonus;

	/** palette qui contient les images des sorties */
	private ImageElement paletteSortie;

	private int score = 100000;
	/** difficulté */
	private int difficulte = 1;
	
	//Todo crappy move all to activity
	private LabyView view;
	
	
	/** Le joueur a-t-il gagné? */
	private boolean gagne = true;

	public Laby(LabyView view, GWTCanvas theCanvas,
			NiveauProxy niveau) {
		super(theCanvas);
		this.gameName = "Laby";
		this.niveau = niveau;
		this.view = view;
		//resetAudioTag();
	}

	
	
	
	/**
	 * @param difficulte the difficulte to set
	 */
	public void setDifficulte(int difficulte) {
		this.difficulte = difficulte;
	}




	/***********************************************************
	 * Routine qui gère l'affichage (double buffering)
	 ***********************************************************/

	private void renderingLoop() {

		canvas.saveContext();
		canvas.clear();
		boolean shouldStop = false;

		for (int i = 0; i < niveauLoader.cases.length; i++) {

			int sourceX = 32 * niveauLoader.cases[i].getImageX();
			int sourceY = 32 * niveauLoader.cases[i].getImageY();
			int sourceWidth = 32;
			int sourceHeight = 32;

			int destX = niveauLoader.cases[i].getPosX() * TAILLE_CASE + (MARGIN / 2);
			int destY = niveauLoader.cases[i].getPosY() * TAILLE_CASE + (MARGIN / 2);
			int destWidth = TAILLE_CASE;
			int destHeight = TAILLE_CASE;

			if (niveauLoader.cases[i].getType() == 3) {
				canvas.drawImage(paletteSortie, sourceX, sourceY, sourceWidth,
						sourceHeight, destX, destY, destWidth, destHeight);
			} else if (niveauLoader.cases[i].getType() == 2) {
				canvas.drawImage(paletteDecor, sourceX, sourceY, sourceWidth,
						sourceHeight, destX, destY, destWidth, destHeight);
			} else {
				canvas.drawImage(paletteDecor, sourceX, sourceY, sourceWidth,
						sourceHeight, destX, destY, destWidth, destHeight);
			}

		}

		canvas.saveContext();

		// Dessin et gestion des bonus
		for (int i = 0; i < niveauLoader.bonus.length; i++) {
			if (niveauLoader.bonus[i].getAffiche()) {
				if (niveauLoader.joueur.score(niveauLoader.bonus[i].getCoord(), niveauLoader.bonus[i].getType()) > 0) {
					score += niveauLoader.joueur.score(niveauLoader.bonus[i].getCoord(), niveauLoader.bonus[i]
							.getType());
					niveauLoader.bonus[i].setAffiche(false);
				}

				int sourceX = 32 * niveauLoader.bonus[i].getImage().x;
				int sourceY = 32 * niveauLoader.bonus[i].getImage().y;
				int sourceWidth = 32;
				int sourceHeight = 32;

				int destX = niveauLoader.bonus[i].getCoord().x * TAILLE_CASE + (MARGIN / 2);
				int destY = niveauLoader.bonus[i].getCoord().y * TAILLE_CASE + (MARGIN / 2);
				int destWidth = TAILLE_CASE;
				int destHeight = TAILLE_CASE;

				canvas.drawImage(paletteBonus, sourceX, sourceY, sourceWidth,
						sourceHeight, destX, destY, destWidth, destHeight);
			}
		}

		// Dessin et gestion des m�chants
		for (int i = 0; i < niveauLoader.vilain.length; i++) { // mise � jour de la
			// difficult�
			niveauLoader.vilain[i].setDifficulte(difficulte);

			// Cas ou lengthjoueur a rencontr� un m�chant (il meurt)

			if (!niveauLoader.joueur.enVie(niveauLoader.vilain[i].getCoord())) {
				// canvas.drawImage(imageMort,(joueur.getCoord().x-1)*TAILLE_CASE+4,(joueur.getCoord().y+1)*TAILLE_CASE+MARGIN,3*TAILLE_CASE,1*TAILLE_CASE);
				canvas.setBackgroundColor(Color.RED);
				stopAudioTag();
				shouldStop = true;

			} else {

				int sourceX = 32 * niveauLoader.vilain[i].getImage().x;
				int sourceY = 32 * niveauLoader.vilain[i].getImage().y;
				int sourceWidth = 32;
				int sourceHeight = 32;

				int destX = niveauLoader.vilain[i].getCoord().x * TAILLE_CASE + (MARGIN / 2);
				int destY = niveauLoader.vilain[i].getCoord().y * TAILLE_CASE + (MARGIN / 2);
				int destWidth = TAILLE_CASE;
				int destHeight = TAILLE_CASE;

				canvas.drawImage(paletteVilain, sourceX, sourceY, sourceWidth,
						sourceHeight, destX, destY, destWidth, destHeight);
			}
		}

		// gestion de la sortie
		gagne = true;
		if (niveauLoader.joueur.sortie())// si le joueur est sur la sortie
		{
			for (int i = 0; i < niveauLoader.bonus.length; i++) {
				if (niveauLoader.bonus[i].getAffiche())// si un bonus n'a pas �t� pris
				{
					gagne = false;
				}
			}
			if (gagne) {
				niveauLoader.joueur.desactiver();
				canvas.setBackgroundColor(Color.GREEN);
				// canvas.drawImage(imageVictoire,(joueur.getCoord().x-1)*TAILLE_CASE+4,(joueur.getCoord().y+1)*TAILLE_CASE+MARGIN,3*TAILLE_CASE,1*TAILLE_CASE,this);
				// arret de tous les m�chants
				shouldStop = true;
				view.displayScorePopup(score);
			}
		}

		int destX = niveauLoader.joueur.getCoord().x * TAILLE_CASE + (MARGIN / 2);
		int destY = niveauLoader.joueur.getCoord().y * TAILLE_CASE + (MARGIN / 2);
		int destWidth = TAILLE_CASE;
		int destHeight = TAILLE_CASE;

		// Dessin du joueur
		canvas
				.drawImage(niveauLoader.joueur.getImage(), destX, destY, destWidth,
						destHeight);

//		if(!isStarted){
////			// Filled triangle
//		canvas.beginPath();
//		canvas.moveTo(25,25);
//		canvas.lineTo(105,25);
//		canvas.lineTo(25,105);
//		canvas.fill();
//		// Stroked triangle
//		canvas.beginPath();
//		canvas.moveTo(125,125);
//		canvas.lineTo(125,45);
//		canvas.lineTo(45,125);
//		canvas.closePath();
//		canvas.stroke();
//			
//	}
		
		
		canvas.restoreContext();

		if (shouldStop) {
			stopGame();
		} 	
		else if(isStarted) {
			score -= 100/difficulte;
			timer.schedule(REFRESH_RATE);
		}

	}

	@Override
	public void createControls() {
		this.controls = new LabyGameControls();
	}

	@Override
	public void drawGame() {

		this.niveauLoader = new NiveauLoader(imagePath);
		
		height = niveau.getTailleX() * TAILLE_CASE + MARGIN;
		width = niveau.getTailleY() * TAILLE_CASE + MARGIN;

		canvas.setCoordSize(width, height);
		canvas.setPixelHeight(height);
		canvas.setPixelWidth(width);

		String[] urls = new String[] { imagePath + niveau.getCanvaBonus(),
				imagePath + niveau.getCanvaCouloir(),
				imagePath + niveau.getCanvaMechants(),
				imagePath + niveau.getCanvaMur(),
				imagePath + niveau.getCanvaSortie(), };

		timer = new Timer() {

			@Override
			public void run() {
				renderingLoop();
			}

		};

		if (niveauLoader.cases == null) {
			// The first time this demo gets run we need to load our images.
			// Maintain a reference to the image we load so we can use it
			// the next time the demo is selected
			ImageLoader.loadImages(urls, new ImageLoader.CallBack() {

				@Override
				public void onImagesLoaded(ImageElement[] imageElements) {

					/** palette qui contient les images du décor */
					paletteDecor = imageElements[1];

					/** palette qui contient les images des méchants */
					paletteVilain = imageElements[2];

					/** palette qui contient les images des bonus */
					paletteBonus = imageElements[0];

					/** palette qui contient les images des sorties */
					paletteSortie = imageElements[4];
					

					niveauLoader.chargerPlateau(niveau);

					timer.schedule(REFRESH_RATE);

				}
			});

		} else {
			// Go ahead and animate
			if (isImageLoaded(paletteSortie)) {
				timer.schedule(REFRESH_RATE);
			} else {
				Window.alert("Refresh the page to reload the image.");
			}
		}

	}
	
	
	

	@Override
	public void stopGame() {
		for (int j = 0; j < niveauLoader.vilain.length; j++) {
			niveauLoader.vilain[j].stop();
		}
		timer.cancel();
		stopAudioTag();
		isStarted = false;
	}

	
	private native boolean isImageLoaded(ImageElement imgElem) /*-{
		return !!imgElem.__isLoaded;
	}-*/;

	public native void playAudioTag() /*-{
		if($doc.getElementById('audioTag')!=null){
			$doc.getElementById('audioTag').play();
		}
	}-*/;
	
	public native void stopAudioTag() /*-{
		if($doc.getElementById('audioTag')!=null){
			$doc.getElementById('audioTag').pause();
		}
	}-*/;
	
	
	public native void resetAudioTag() /*-{
		if($doc.getElementById('audioTag')!=null){
			$doc.getElementById('audioTag').currentTime = 0;
		}
	}-*/;
	
	
	@Override
	public void onKeyPress(KeyPressEvent event) {
		if(isStarted){
			switch (event.getNativeEvent().getKeyCode()) {
			case KeyCodes.KEY_UP:
				niveauLoader.joueur.deplace(0, -1);
				break;
			case KeyCodes.KEY_DOWN:
				niveauLoader.joueur.deplace(0, 1);
				break;
			case KeyCodes.KEY_RIGHT:
				niveauLoader.joueur.deplace(1, 0);
				break;
			case KeyCodes.KEY_LEFT:
				niveauLoader.joueur.deplace(-1, 0);
				break;
			}
		}

	}

	@Override
	public void onClick(ClickEvent event) {
		if (isStarted) {
			stopGame();
		   
		} else {
			playAudioTag();
			for (int j = 0; j < niveauLoader.vilain.length; j++) {
				niveauLoader.vilain[j].start();
			}
			isStarted = true;
			timer.schedule(REFRESH_RATE);
		}
	}




	public Integer getScore() {
		if(gagne){
			return score;
		}
		return null;
	}

}