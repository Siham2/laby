package org.laby.client.scaffold.laby;

import org.laby.client.laby.GWTBonus;
import org.laby.client.laby.GWTCase;
import org.laby.client.laby.GWTJoueur;
import org.laby.client.laby.GWTMechant;
import org.laby.client.laby.GWTPoint;
import org.laby.client.managed.request.BonusProxy;
import org.laby.client.managed.request.CaseElementProxy;
import org.laby.client.managed.request.JoueurProxy;
import org.laby.client.managed.request.MechantProxy;
import org.laby.client.managed.request.NiveauProxy;

import com.google.gwt.core.client.GWT;

public class NiveauLoader {


	/** Joueur */
	GWTJoueur joueur;
	/** Tableau de cases (carte) */
	GWTCase[] cases;
	/** Tableau de méchants */
	GWTMechant[] vilain;
	/** Tableau des bonus */
	GWTBonus[] bonus;
	/**
	 * Images
	 */
	
	
	public NiveauLoader(String imagePath) {
		super();
		this.joueur = new GWTJoueur(imagePath);
	}


	public void chargerPlateau(final NiveauProxy niveau) {
		cases = new GWTCase[niveau.getCases().size()];
		int i = 0;
		// Creation des cases du plateau de jeu
		for (CaseElementProxy caseElementProxy : niveau.getCases()) {
			cases[i] = new GWTCase();
			cases[i].setAll(caseElementProxy.getPosX(), caseElementProxy
					.getPosY(), caseElementProxy.getType(), caseElementProxy
					.getImageX(), caseElementProxy.getImageY());
			i++;
		}

		GWT.log("Chargement cases OK");

		chargerJoueur(niveau);

	}

	
	/**
	 * Méthode de Chargement des données concernant les méchants du niveau ID
	 * depuis les tables SQL vers des variables locales
	 * 
	 * @param ID
	 *            Identifiant du Niveau
	 */
	public void chargerMechants(final NiveauProxy niveau) {

		vilain = new GWTMechant[niveau.getVilains().size()];
		int i = 0;
		for (MechantProxy mechantProxy : niveau.getVilains()) {
			vilain[i] = new GWTMechant();
			vilain[i].initPosition(mechantProxy.getType(), mechantProxy
					.getPosX(), mechantProxy.getPosY(), new GWTPoint(
					mechantProxy.getImageX(), mechantProxy.getImageY()));
			vilain[i].initCases(cases);
			i++;
		}

		GWT.log("Chargement vilains OK");
		chargerBonus(niveau);

	}

	/**
	 * M�thode de Chargement des donn�es concernant le Joueur du niveau ID
	 * depuis les tables SQL vers des variables locales
	 * 
	 * @param ID
	 *            Identifiant du Niveau
	 */

	public void chargerJoueur(final NiveauProxy niveau) {

		JoueurProxy joueurProxy = niveau.getJoueur();
		joueur.initPosition(joueurProxy.getPosX(), joueurProxy.getPosY());
		joueur.initCases(cases);
		joueur.activer();
		GWT.log("Chargement joueurs OK");

		chargerMechants(niveau);

	}

	/**
	 * M�thode de Chargement des donn�es concernant les bonus du niveau ID
	 * depuis les tables SQL vers des variables locales
	 * 
	 * @param ID
	 *            Identifiant du Niveau
	 */

	public void chargerBonus(final NiveauProxy niveau) {
		bonus = new GWTBonus[niveau.getBonus().size()];
		int i = 0;
		for (BonusProxy mechantProxy : niveau.getBonus()) {
			bonus[i] = new GWTBonus();
			bonus[i].initPosition(mechantProxy.getType(), mechantProxy
					.getPosX(), mechantProxy.getPosY(), mechantProxy
					.getImageX(), mechantProxy.getImageY());
			i++;
		}
		GWT.log("Chargement bonus OK");


	}

	
	
}
