package tk.djandjiev.practice.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Сущность документа, удостоверяющего личность.
 * */
@Entity
@Table(indexes = {
    @Index(
        name = "document_number_index",
        columnList = "doc_number")
})
@NamedQueries({
    @NamedQuery(name = Document.ALL_SORTED, query = "SELECT d FROM Document d ORDER BY d.id")
})
public class Document extends AbstractBaseEntity {

  public static final String ALL_SORTED = "Document.getAllSorted";

  @NotNull
  @OneToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name = "doc_type_id", nullable = false)
  private DocType type;

  @Size(max = 20)
  @Column(name = "doc_number")
  private String number;

  @Column(name = "issue_date")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate issueDate;

  public Document() {
  }

  public Document(
      @NotNull DocType type, @Size(max = 20) String number, LocalDate issueDate) {
    this.type = type;
    this.number = number;
    this.issueDate = issueDate;
  }

  public DocType getType() {
    return type;
  }

  public void setType(DocType type) {
    this.type = type;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public LocalDate getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
  }
}
