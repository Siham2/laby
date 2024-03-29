// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.laby.model;

import java.lang.Integer;
import java.lang.Long;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import org.laby.model.Niveau;

privileged aspect Bonus_Roo_JavaBean {
    
    declare @field: * Bonus.niveau: -@ManyToOne;
    
    declare @field: * Bonus.niveau: @Transient;
    
    private Long Bonus.niveauId;
    
    public Integer Bonus.getImageX() {
        return this.imageX;
    }
    
    public void Bonus.setImageX(Integer imageX) {
        this.imageX = imageX;
    }
    
    public Integer Bonus.getImageY() {
        return this.imageY;
    }
    
    public void Bonus.setImageY(Integer imageY) {
        this.imageY = imageY;
    }
    
    public Integer Bonus.getPosY() {
        return this.posY;
    }
    
    public void Bonus.setPosY(Integer posY) {
        this.posY = posY;
    }
    
    public Integer Bonus.getPosX() {
        return this.posX;
    }
    
    public void Bonus.setPosX(Integer posX) {
        this.posX = posX;
    }
    
    public Integer Bonus.getType() {
        return this.type;
    }
    
    public void Bonus.setType(Integer type) {
        this.type = type;
    }
    
    public Niveau Bonus.getNiveau() {
        if (this.niveauId != null) {
            this.niveau = Niveau.findNiveau(this.niveauId);
        } else {
            this.niveau = null;
        }
        return this.niveau;
    }
    
    public void Bonus.setNiveau(Niveau niveau) {
        if (niveau != null) {
            if (niveau.getId() == null) {
                niveau.persist();
            }
            this.niveauId = niveau.getId();
        } else {
            this.niveauId = null;
        }
    }
    
}
