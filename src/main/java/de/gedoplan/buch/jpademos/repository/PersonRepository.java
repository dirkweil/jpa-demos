package de.gedoplan.buch.jpademos.repository;

import de.gedoplan.baselibs.persistence.repository.SingleIdEntityRepository;
import de.gedoplan.buch.jpademos.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 * DB-Zugriffsklasse für {@link Person}.
 * 
 * @author dw
 */
@ApplicationScoped
@Transactional
public class PersonRepository extends SingleIdEntityRepository<Integer, Person>
{
  private static final long serialVersionUID = 1L;

  /**
   * Person anhand ihrer ID finden und Lazy-Attribute nachladen.
   * 
   * @param id ID
   * @return gefundene Person oder <code>null</code>
   */
  public Person findByIdEager(Integer id)
  {
    // TODO: Load Plan!
    Person person = findById(id);
    if (person != null)
    {
      person.getHobbies().size();
      person.getMailAddresses().size();
      person.getPhones().size();
    }
    return person;
  }

}
