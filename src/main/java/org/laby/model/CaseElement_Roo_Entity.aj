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
import org.laby.model.CaseElement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect CaseElement_Roo_Entity {
    
    declare @type: CaseElement: @Entity;
    
    @PersistenceContext
    transient EntityManager CaseElement.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long CaseElement.id;
    
    @Version
    @Column(name = "version")
    private Integer CaseElement.version;
    
    public Long CaseElement.getId() {
        return this.id;
    }
    
    public void CaseElement.setId(Long id) {
        this.id = id;
    }
    
    public Integer CaseElement.getVersion() {
        return this.version;
    }
    
    public void CaseElement.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void CaseElement.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void CaseElement.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            CaseElement attached = CaseElement.findCaseElement(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void CaseElement.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public CaseElement CaseElement.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        CaseElement merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager CaseElement.entityManager() {
        EntityManager em = new CaseElement().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    @Transactional
    public static long CaseElement.countCaseElements() {
        return ((Number) entityManager().createQuery("select count(o) from CaseElement o").getSingleResult()).longValue();
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public static List<CaseElement> CaseElement.findAllCaseElements() {
        return entityManager().createQuery("select o from CaseElement o").getResultList();
    }
    
    @Transactional
    public static CaseElement CaseElement.findCaseElement(Long id) {
        if (id == null) return null;
        Query query = entityManager().createQuery("select o from CaseElement o where o.id = :id").setParameter("id",id);
        CaseElement result = null;
        List results = query.getResultList();
        if (results.size() > 0) {
            result = (CaseElement) results.get(0);
        }
        return result;
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public static List<CaseElement> CaseElement.findCaseElementEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from CaseElement o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
