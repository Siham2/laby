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
import org.laby.model.Score;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Score_Roo_Entity {
    
    declare @type: Score: @Entity;
    
    @PersistenceContext
    transient EntityManager Score.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Score.id;
    
    @Version
    @Column(name = "version")
    private Integer Score.version;
    
    public Long Score.getId() {
        return this.id;
    }
    
    public void Score.setId(Long id) {
        this.id = id;
    }
    
    public Integer Score.getVersion() {
        return this.version;
    }
    
    public void Score.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void Score.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Score.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Score attached = Score.findScore(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Score.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public Score Score.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Score merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Score.entityManager() {
        EntityManager em = new Score().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    @Transactional
    public static long Score.countScores() {
        return ((Number) entityManager().createQuery("select count(o) from Score o").getSingleResult()).longValue();
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public static List<Score> Score.findAllScores() {
        return entityManager().createQuery("select o from Score o").getResultList();
    }
    
    @Transactional
    public static Score Score.findScore(Long id) {
        if (id == null) return null;
        Query query = entityManager().createQuery("select o from Score o where o.id = :id").setParameter("id",id);
        Score result = null;
        List results = query.getResultList();
        if (results.size() > 0) {
            result = (Score) results.get(0);
        }
        return result;
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public static List<Score> Score.findScoreEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Score o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
