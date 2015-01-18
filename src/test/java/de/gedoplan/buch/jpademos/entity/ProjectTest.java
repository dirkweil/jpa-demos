package de.gedoplan.buch.jpademos.entity;

import de.gedoplan.baselibs.persistence.entity.SingleIdEntity;
import de.gedoplan.buch.jpademos.TestBase;

import java.util.List;

import javax.persistence.TypedQuery;

import org.junit.BeforeClass;
import org.junit.Test;

//CHECKSTYLE:OFF

/**
 * Test der Persistence-Fuktionalität bzgl. der Entity Project_xxx.
 *
 * @author dw
 */
public class ProjectTest extends TestBase
{
  public static Department         testDepartment  = new Department("Enterprise Java Team");
  public static Department[]       testDepartments = { testDepartment };

  public static ProjectCompositeId testProject1    = new ProjectCompositeId(testDepartment, "jpa_demos2_0", "JPA-Demos (v2.0)", 9000);
  public static ProjectEmbeddedId  testProject2    = new ProjectEmbeddedId(testDepartment, "jpa_demos2_1", "JPA-Demos (v2.1)", 9000);
  public static Object[]           testProjects    = { testProject1, testProject2 };

  /**
   * Testdaten aufsetzen.
   */
  @BeforeClass
  public static void setup()
  {
    deleteAll(ProjectCompositeId.TABLE_NAME, Department.TABLE_NAME);
    insertAll(testDepartments, testProjects);
  }

  /**
   * Alle Testdaten ausgeben.
   *
   * Dies ist kein Unit-Test im eigentlichen Sinne. Er kann probeweise für eine Ausgabe der Testdaten genutzt werden.
   */
  @Test
  // @Ignore
  public void showAllCompositeId()
  {
    System.out.println("----- showAllCompositeId -----");

    TypedQuery<ProjectCompositeId> query = this.entityManager.createQuery("select x from ProjectCompositeId x", ProjectCompositeId.class);
    showList(query.getResultList());
  }

  /**
   * Alle Testdaten ausgeben.
   *
   * Dies ist kein Unit-Test im eigentlichen Sinne. Er kann probeweise für eine Ausgabe der Testdaten genutzt werden.
   */
  @Test
  // @Ignore
  public void showAllEmbeddedId()
  {
    System.out.println("----- showAllEmbeddedId -----");

    TypedQuery<ProjectEmbeddedId> query = this.entityManager.createQuery("select x from ProjectEmbeddedId x", ProjectEmbeddedId.class);
    showList(query.getResultList());
  }

  private static void showList(List<? extends SingleIdEntity<?>> list)
  {
    for (SingleIdEntity<?> entry : list)
    {
      System.out.println(entry.toDebugString());
    }
  }
}
