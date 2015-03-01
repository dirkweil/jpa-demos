package de.gedoplan.buch.jpademos.repository;

import de.gedoplan.buch.jpademos.entity.Order;

import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.SynchronizationType;
import javax.transaction.Transactional;

/**
 * 
 * UNSYNCHRONIZED CDI mit Conversation Scope   
 * 
 *   
 * 
 * @author Michael Schäfer 
 */

@ConversationScoped
public class UnsynchronizedConversationalOrderRepository
{
	
  @Inject
  Conversation conversation;
	
  @PersistenceContext(name = "ee_demos", synchronization=SynchronizationType.UNSYNCHRONIZED)
  EntityManager entityManager;

  public void begin() {
	  conversation.begin();
  }
  
  
  public void end() {
	  entityManager.joinTransaction();
	  entityManager.flush();
	  conversation.end(); 
  }
  
  
  public void insert(Order order)  {		  
    this.entityManager.persist(order);
  }

  public Order findById(Integer id)  {
    return this.entityManager.find(Order.class, id);
  }

  public List<Order> findAll()  {
    return this.entityManager.createQuery("select o from Order o", Order.class).getResultList();
  }

  public void update(Order order)  {
    this.entityManager.merge(order);
  }

 
  public void delete(Integer id)  {
    Order order = findById(id);
    if (order != null)
    {
      this.entityManager.remove(order);
    }
  }
}
