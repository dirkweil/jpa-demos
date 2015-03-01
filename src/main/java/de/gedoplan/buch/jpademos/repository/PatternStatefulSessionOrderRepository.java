package de.gedoplan.buch.jpademos.repository;

import de.gedoplan.buch.jpademos.entity.Order;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.SynchronizationType;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;


/**
 * Klasse zeigt das Patter Stateful Gateway  
 * 
 * @author Michael Schäfer 
 */
@Stateful
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PatternStatefulSessionOrderRepository
{
	
  @PersistenceContext(name = "ee_demos", type=PersistenceContextType.EXTENDED)
  EntityManager entityManager;

  public void begin() {
	  
  }
  
  @Transactional(value=TxType.REQUIRED)
  public void end() {
	  
  }
  
  public void insert(Order order)
  {		  
    this.entityManager.persist(order);
  }

  public Order findById(Integer id)
  {
    return this.entityManager.find(Order.class, id);
  }

  public List<Order> findAll()
  {
    return this.entityManager.createQuery("select o from Order o", Order.class).getResultList();
  }

 
  public void update(Order order)
  {
    this.entityManager.merge(order);
  }

  
  public void delete(Integer id)
  {
    Order order = findById(id);
    if (order != null)
    {
      this.entityManager.remove(order);
    }
  }
}
