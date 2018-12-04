package tk.djandjiev.practice.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Сущность спрвочника "Тип документа".
 * */
@Entity
@Table(name = "Doc_type", uniqueConstraints = {
    @UniqueConstraint(
        columnNames = {"code"},
        name = "doc_type_code")
})
@NamedQueries({
    @NamedQuery(name = DocType.ALL_SORTED, query = "SELECT d FROM DocType d ORDER BY d.code"),
    @NamedQuery(name = DocType.BY_CODE, query = "SELECT d FROM DocType d WHERE d.code = ?1"),
})
public class DocType extends AbstractCatalog {
  public static final String ALL_SORTED = "DocType.getAllSorted";
  public static final String BY_CODE = "DocType.getByCode";

  public DocType() {
  }

  public DocType(Integer id, String code, String name) {
    super(id, code, name);
  }
}
