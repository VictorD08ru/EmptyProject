package tk.djandjiev.practice.model;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Сущность справочника "Страна".
 * */
@Entity
@Table(indexes = {
    @Index(
        name = "country_unique_code",
        columnList = "code",
        unique = true)
})
@NamedQueries({
    @NamedQuery(name = Country.ALL_SORTED, query = "SELECT c FROM Country c ORDER BY c.code")
})
public class Country extends AbstractCatalog {

  public static final String ALL_SORTED = "Country.getAllSorted";

  public Country() {
  }

  public Country(
      @NotBlank @Size(min = 2, max = 10) String code,
      @Size(min = 2, max = 255) String name) {
    super(code, name);
  }
}
