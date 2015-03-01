package de.gedoplan.buch.jpademos.schema;

import de.gedoplan.buch.jpademos.TestBase;
import de.gedoplan.buch.jpademos.entity.City;
import de.gedoplan.buch.jpademos.entity.Country;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


/**
 * Test für das Feature "Schema Generation" 
 * 
 * @author Michael Schäfer 
 */

public class SchemaMeetInTheMiddleTest extends TestBase
{
	
	@BeforeClass
	public static void setup() {
		
		// Konfiguration, die die richtigen Properties für das Szenario meet-in-the-middle setzt 
		createEntityManagerFactory("jpa-demo-meet-in-the-middle");
	}
	
	
	
  /**
   * Prüfe ob das Schemata und die Testdaten geladen wurden 
   * 
   * @author Michael Schäfer 
   */
  @Test
  public void testCreateScript()  {
   
	  Query query = this.entityManager.createNativeQuery("select * from " + Country.TABLE_NAME + " c");
	  List<Object[]> cities = query.getResultList();
	  Assert.assertEquals("Country count", 1, cities.size());
  }


}
