package de.gedoplan.buch.jpademos.repository;

import de.gedoplan.buch.jpademos.entity.Order;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class OrderRepository
{
  @PersistenceContext(name = "ee_demos")
  EntityManager entityManager;

  @Transactional
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

  @Transactional
  public void update(Order order)
  {
    this.entityManager.merge(order);
  }

  @Transactional
  public void delete(Integer id)
  {
    Order order = findById(id);
    if (order != null)
    {
      this.entityManager.remove(order);
    }
  }
}
