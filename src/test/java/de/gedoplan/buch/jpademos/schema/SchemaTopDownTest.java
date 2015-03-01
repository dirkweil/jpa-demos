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
 * Test f�r das Feature "Schema Generation" 
 * 
 * @author Michael Sch�fer 
 */

public class SchemaTopDownTest extends TestBase
{
	
	@BeforeClass
	public static void setup() {
		
		// Konfiguration, die die richtigen Properties f�r das Szenario top-down setzt 
		createEntityManagerFactory("jpa-demo-top-down");
	}
	
	
	
  /**
   * Pr�fe ob das Schemata und die Testdaten geladen wurden 
   * 
   * @author Michael Sch�fer 
   */
  @Test
  public void testCreateScript()  {
   
	  Query query = this.entityManager.createNativeQuery("select * from " + Country.TABLE_NAME + " c");
	  List<Object[]> countries = query.getResultList();
	  Assert.assertEquals("Country count", 1, countries.size());
  }


}
