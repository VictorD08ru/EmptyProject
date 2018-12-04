package tk.djandjiev.practice.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Сущность справочника "Страна".
 * */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(
        columnNames = {"code"},
        name = "country_code")
})
@NamedQueries({
    @NamedQuery(name = Country.ALL_SORTED, query = "SELECT c FROM Country c ORDER BY c.code"),
    @NamedQuery(name = Country.BY_CODE, query = "SELECT c FROM Country c WHERE c.code = ?1"),
})
public class Country extends AbstractCatalog {
  public static final String ALL_SORTED = "Country.getAllSorted";
  public static final String BY_CODE = "Country.getByCode";

  public Country() {
  }

  public Country(Integer id, String code, String name) {
    super(id, code, name);
  }
}
