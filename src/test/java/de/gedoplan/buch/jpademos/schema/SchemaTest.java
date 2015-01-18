package de.gedoplan.buch.jpademos.schema;

import de.gedoplan.buch.jpademos.TestBase;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Test;

public class SchemaTest extends TestBase
{
  /**
   * Test: Erstellung Create Script.
   */
  @Test
  public void testCreateScript()
  {
    System.out.println("----- testCreateScript -----");

    StringWriter createWriter = new StringWriter();

    Map<String, Object> properties = new HashMap<>();
    properties.put("javax.persistence.schema-generation.database.action", "none");
    properties.put("javax.persistence.schema-generation.scripts.action", "create");
    properties.put("javax.persistence.schema-generation.scripts.create-target", createWriter);

    Persistence.generateSchema("test", properties);

    String createScript = createWriter.toString();
    if (createScript.isEmpty())
    {
      Assert.fail("Script is empty");
    }

    System.out.println(createScript);
  }

  /**
   * Test: Erstellung Drop Script.
   */
  @Test
  public void testDropScript()
  {
    System.out.println("----- testDropScript -----");

    StringWriter dropWriter = new StringWriter();

    Map<String, Object> properties = new HashMap<>();
    properties.put("javax.persistence.schema-generation.database.action", "none");
    properties.put("javax.persistence.schema-generation.scripts.action", "drop");
    properties.put("javax.persistence.schema-generation.scripts.drop-target", dropWriter);

    Persistence.generateSchema("test", properties);

    String dropScript = dropWriter.toString();
    if (dropScript.isEmpty())
    {
      Assert.fail("Script is empty");
    }

    System.out.println(dropScript);
  }

  /**
   * Test: Zusatzskripte für Schemaerstellung und Datenladen.
   */
  @Test
  public void testCreateAndLoadSource()
  {
    Number dummyCount = (Number) this.entityManager.createNativeQuery("select count(*) from JPA_DUMMY").getSingleResult();
    Assert.assertEquals("Entries in JPA_DUMMY", 1, dummyCount.intValue());
  }
}
