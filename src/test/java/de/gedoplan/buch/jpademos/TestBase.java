package de.gedoplan.buch.jpademos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import de.gedoplan.buch.jpademos.entity.Country;

public abstract class TestBase {
	
	private static String DEFAULT_TEST_UNIT = "test";
	
	protected static EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;

	private static final Log LOG = LogFactory.getLog(TestBase.class);
	protected Log log = LogFactory.getLog(getClass());

	
	@Before
	public void before() {
		this.log.debug("create entitymanager and start transaction");
		
		// Michael Schäfer Change for JPA 2.1 Demo 
		if(entityManagerFactory==null)
			createEntityManagerFactory(DEFAULT_TEST_UNIT);
		
		this.entityManager = entityManagerFactory.createEntityManager();
		this.entityManager.getTransaction().begin();
	}

	@After
	public void after() {
		try {
			EntityTransaction transaction = this.entityManager.getTransaction();
			if (transaction.isActive()) {
				if (!transaction.getRollbackOnly()) {
					this.log.debug("commit transaction");
					transaction.commit();
				} else {
					this.log.debug("rollback transaction");
					transaction.rollback();
				}
			}
		} catch (Exception e) // CHECKSTYLE:IGNORE
		{
			// ignore
		}

		try {
			this.log.debug("close entitymanager");
			this.entityManager.close();
		} catch (Exception e) // CHECKSTYLE:IGNORE
		{
			// ignore
		}
	}

	// Michael Schäfer Change for JPA 2.1 Demo  
	// Es ist möglich eine dezidierte Persistent Unit zu erstellen 
	protected static EntityManagerFactory createEntityManagerFactory(String unit) {
		
		if (entityManagerFactory == null) {
				LOG.debug("create entitymanager factory");
				entityManagerFactory = Persistence
						.createEntityManagerFactory(unit);	
				return entityManagerFactory;
		}
		
		return entityManagerFactory;
	}



	 protected static void deleteAll(String... tableName)
	  {
	  
		 if(entityManagerFactory==null)
				createEntityManagerFactory(DEFAULT_TEST_UNIT);
		 
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
	    try
	    {
	      for (String t : tableName)
	      {
	    	  entityManager.getTransaction().begin();
	        try
	        {
	          LOG.debug("delete from " + t);
	          entityManager.createNativeQuery("delete from " + t).executeUpdate();
	          entityManager.getTransaction().commit();
	        }
	        catch (Exception e) // CHECKSTYLE:IGNORE
	        {
	          try
	          {
	            entityManager.getTransaction().rollback();
	          }
	          catch (Exception e2) // CHECKSTYLE:IGNORE
	          {
	            // ignore
	          }
	        }
	      }
	    }
	    finally
	    {
	      try
	      {
	        entityManager.close();
	      }
	      catch (Exception e) // CHECKSTYLE:IGNORE
	      {
	        // ignore
	      }
	    }
	  }

	  public static void insertAll(Object[]... entities)
	  {
	   
		if(entityManagerFactory==null)
				createEntityManagerFactory(DEFAULT_TEST_UNIT);
		  
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		  
	    entityManager.getTransaction().begin();

	    try
	    {
	      for (Object[] e : entities)
	      {
	        insertTestData(e, entityManager);
	      }

	      entityManager.getTransaction().commit();
	    }
	    finally
	    {
	      try
	      {
	        entityManager.close();
	      }
	      catch (Exception e) // CHECKSTYLE:IGNORE
	      {
	        // ignore
	      }
	    }
	  }

	  public static void insertTestData(Object[] entities, EntityManager entityManager)
	  {
	    for (Object entity : entities)
	    {
	      entityManager.persist(entity);
	    }
	  }

}
