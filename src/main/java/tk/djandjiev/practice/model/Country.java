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
        name = "ux_country_code",
        columnList = "code",
        unique = true)
})
@NamedQueries({
    @NamedQuery(name = Country.ALL_SORTED, query = "SELECT c FROM Country c ORDER BY c.code"),
    @NamedQuery(name = Country.GET_BY_CODE,
        query = "SELECT c FROM Country c WHERE c.code = ?1")
})
public class Country extends AbstractCatalog {

  public static final String ALL_SORTED = "Country.getAllSorted";
  public static final String GET_BY_CODE = "Country.getByCode";

  public Country() {
  }

  public Country(
      @NotBlank @Size(max = 10) String code,
      @Size(min = 2, max = 255) String name) {
    super(code, name);
  }
}
