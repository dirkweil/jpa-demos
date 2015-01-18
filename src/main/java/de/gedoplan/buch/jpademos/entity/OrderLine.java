package de.gedoplan.buch.jpademos.entity;

import de.gedoplan.baselibs.persistence.entity.GeneratedIntegerIdEntity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Cacheable(true)
@Access(AccessType.FIELD)
@Table(name = OrderLine.TABLE_NAME)
public class OrderLine extends GeneratedIntegerIdEntity
{
  private static final long  serialVersionUID = 1L;

  public static final String TABLE_NAME       = "JPA_ORDERLINE";

  private String             name;
  private int                count;

  protected OrderLine()
  {
  }

  protected OrderLine(String name, int count)
  {
    this.name = name;
    this.count = count;
  }

  public String getName()
  {
    return this.name;
  }

  public int getCount()
  {
    return this.count;
  }
}
