package by.kovalski.farmcompany.entity;

import java.util.Objects;
import java.util.StringJoiner;

public class Producer {
  /**
   * name of producer
   */
  private final String name;
  /**
   * certification of producer
   */
  private final Certification certification;

  /**
   * constructor
   * @param name - name of producer
   * @param certification - certificate
   */

  public Producer(String name, Certification certification) {
    this.name = name;
    this.certification = certification;
  }

  /**
   *
   * @return name of consumer
   */
  public String getName() {
    return name;
  }

  /**
   *
   * @return certification of consumer
   */

  public Certification getCertification() {
    return certification;
  }

  /**
   *
   * @param o - any object
   * @return true if objects are equals
   */

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Producer producer = (Producer) o;
    return name.equals(producer.name) && certification.equals(producer.certification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, certification);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Producer.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("certification=" + certification)
            .toString();
  }
}
