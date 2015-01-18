package de.gedoplan.buch.jpademos.repository;

import de.gedoplan.buch.jpademos.entity.Publisher;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class PublisherRepository
{
  @PersistenceContext(name = "ee_demos")
  private EntityManager entityManager;

  public List<Publisher> findAll(String entityGraphName, boolean fetchOnly)
  {
    TypedQuery<Publisher> query = this.entityManager.createQuery("select p from Publisher p", Publisher.class);
    if (entityGraphName != null)
    {
      EntityGraph<?> entityGraph = this.entityManager.getEntityGraph(entityGraphName);
      if (entityGraph == null)
      {
        throw new IllegalArgumentException("Entity Graph not found: " + entityGraphName);
      }
      query.setHint(fetchOnly ? "javax.persistence.fetchgraph" : "javax.persistence.loadgraph", entityGraph);
    }
    return query.getResultList();
  }
}
