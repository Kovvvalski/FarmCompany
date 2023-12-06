package by.kovalski.farmcompany.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class Certification {

  private static final LocalDate DEFAULT_DATE_VALUE = LocalDate.of(2022, 1, 1);
  /**
   *name of reg organization
   */
  private final String registryOrganization;
  /**
   * certificate if
   */
  private final String id;
  /**
   * date of beginning certification
   */
  private LocalDate since;
  /**
   * date of ending certification
   */
  private LocalDate to;

  /**
   * constructor
   * @param registryOrganization
   * @param id
   * @param since
   * @param to
   */

  public Certification(String registryOrganization, String id, LocalDate since, LocalDate to) {
    this.registryOrganization = registryOrganization;
    this.id = id;
    this.since = since;
    setTo(to);
  }

  public String getRegistryOrganization() {
    return registryOrganization;
  }

  public String getId() {
    return id;
  }

  public LocalDate getSince() {
    return since;
  }

  public void setSince(LocalDate since) {
    if (!since.isAfter(to))
      this.since = since;
    else {
      this.since = DEFAULT_DATE_VALUE;
      to = DEFAULT_DATE_VALUE;
    }
  }

  public LocalDate getTo() {
    return to;
  }

  public void setTo(LocalDate to) {
    if(to.isAfter(since))
    this.to = to;
    else{
      this.to = DEFAULT_DATE_VALUE;
      since = DEFAULT_DATE_VALUE;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Certification that = (Certification) o;
    return id.equals(that.id) && registryOrganization.equals(that.registryOrganization) && since.equals(that.since) && to.equals(that.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(registryOrganization, id, since, to);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Certification.class.getSimpleName() + "[", "]")
            .add("registryOrganization='" + registryOrganization + "'")
            .add("id='" + id + "'")
            .add("since=" + since)
            .add("to=" + to)
            .toString();
  }

}
