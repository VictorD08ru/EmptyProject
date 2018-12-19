package tk.djandjiev.practice.model;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Сущность спрвочника "Тип документа".
 * */
@Entity
@Table(indexes = {
    @Index(
        name = "ux_doc_type_code",
        columnList = "code",
        unique = true)
})
@NamedQueries({
    @NamedQuery(name = DocType.ALL_SORTED, query = "SELECT d FROM DocType d ORDER BY d.code"),
    @NamedQuery(name = DocType.GET_BY_CODE,
        query = "SELECT d FROM DocType d WHERE d.code = ?1")
})
public class DocType extends AbstractCatalog {

  public static final String ALL_SORTED = "DocType.getAllSorted";
  public static final String GET_BY_CODE = "DocType.getByCode";

  public DocType() {
  }

  public DocType(
      @NotBlank @Size(max = 10) String code,
      @Size(min = 2, max = 255) String name) {
    super(code, name);
  }
}
