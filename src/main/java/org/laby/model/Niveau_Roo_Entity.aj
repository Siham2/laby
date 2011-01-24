// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.laby.model;

import java.lang.Integer;
import java.lang.Long;
import java.lang.SuppressWarnings;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Version;
import org.laby.model.Niveau;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Niveau_Roo_Entity {
    
    declare @type: Niveau: @Entity;
    
    @PersistenceContext
    transient EntityManager Niveau.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Niveau.id;
    
    @Version
    @Column(name = "version")
    private Integer Niveau.version;
    
    public Long Niveau.getId() {
        return this.id;
    }
    
    public void Niveau.setId(Long id) {
        this.id = id;
    }
    
    public Integer Niveau.getVersion() {
        return this.version;
    }
    
    public void Niveau.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void Niveau.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Niveau.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Niveau attached = Niveau.findNiveau(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Niveau.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public Niveau Niveau.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Niveau merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Niveau.entityManager() {
        EntityManager em = new Niveau().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    @Transactional
    public static long Niveau.countNiveaus() {
        return ((Number) entityManager().createQuery("select count(o) from Niveau o").getSingleResult()).longValue();
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public static List<Niveau> Niveau.findAllNiveaus() {
        return entityManager().createQuery("select o from Niveau o").getResultList();
    }
    
    @Transactional
    public static Niveau Niveau.findNiveau(Long id) {
        if (id == null) return null;
        Query query = entityManager().createQuery("select o from Niveau o where o.id = :id").setParameter("id",id);
        Niveau result = null;
        List results = query.getResultList();
        if (results.size() > 0) {
            result = (Niveau) results.get(0);
        }
        return result;
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public static List<Niveau> Niveau.findNiveauEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Niveau o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
