package org.laby.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class CaseElement {

	@NotNull
    private Integer posX;

	@NotNull
    private Integer posY;

    @NotNull
    private Integer imageY;

    @NotNull
    private Integer imageX;
    
    @NotNull
    private Integer type;
    
    @ManyToOne
    @JoinColumn(name="niveauId", nullable=false)
    private Niveau niveau;
}
