package org.laby.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@RooJavaBean
@RooToString
@RooEntity
public class Niveau {

	
    @NotNull
    private String nom;

    @NotNull
    private String CanvaCouloir;

    @NotNull
    private String CanvaMur;

    @NotNull
    private String CanvaBonus;

    @NotNull
    private String CanvaSortie;

    @NotNull
    private String CanvaMechants;

    @NotNull
    private Integer tailleX;

    @NotNull
    private Integer tailleY;


    @OneToMany(cascade = CascadeType.ALL,mappedBy="niveau")
    private List<Bonus> bonus = new ArrayList<Bonus>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy="niveau")
    private List<Mechant> vilains = new ArrayList<Mechant>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy="niveau")
    private List<CaseElement> cases = new ArrayList<CaseElement>();

    @OneToOne(mappedBy="niveau")
    private Joueur joueur;

	/**
	 * @return the bonus
	 */
	public List<Bonus> getBonus() {
		 return entityManager()
		 .createQuery("select o from Bonus o where o.niveauId = :niveauId ")
		 .setParameter("niveauId",this.getId())
		 .getResultList();
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(List<Bonus> bonus) {
		this.bonus = bonus;
	}

	/**
	 * @return the vilains
	 */
	public List<Mechant> getVilains() {
		 return entityManager()
		 .createQuery("select o from Mechant o where o.niveauId = :niveauId ")
		 .setParameter("niveauId",this.getId())
		 .getResultList();
	}

	/**
	 * @param vilains the vilains to set
	 */
	public void setVilains(List<Mechant> vilains) {
		this.vilains = vilains;
	}

	/**
	 * @return the cases
	 */
	public List<CaseElement> getCases() {
		 return entityManager()
		 .createQuery("select o from CaseElement o where o.niveauId = :niveauId ")
		 .setParameter("niveauId",this.getId())
		 .getResultList();
	}

	/**
	 * @param cases the cases to set
	 */
	public void setCases(List<CaseElement> cases) {
		this.cases = cases;
	}

	/**
	 * @return the joueur
	 */
	public Joueur getJoueur() {
		return (Joueur)entityManager()
		 .createQuery("select o from Joueur o where o.niveauId = :niveauId ")
		 .setParameter("niveauId",this.getId())
		 .getResultList().get(0);
	}

	/**
	 * @param joueur the joueur to set
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
    
    
    
    
    
}
