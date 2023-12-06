package by.kovalski.farmcompany.entity;

import java.util.Objects;
import java.util.StringJoiner;

public class Vitamins extends Medicine {
  /**
   * main consumer of medicine
   */
  private final Consumer consumer;

  public Vitamins(String name, Type type, String dosage, Consumer consumer) {
    super(name, type, dosage);
    this.consumer = consumer;
  }

  public Consumer getConsumer() {
    return consumer;
  }


  /**
   *
   * @param o
   * @return true if objects are equals
   */

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vitamins vitamins = (Vitamins) o;
    return super.equals(vitamins) && consumer == vitamins.consumer;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), consumer);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Vitamins.class.getSimpleName() + "[", "]")
            .add("consumer=" + consumer)
            .add("name='" + getName() + "'")
            .add("type=" + getType())
            .add("dosage='" + getDosage() + "'")
            .toString();
  }

  @Override
  public void info() {
    System.out.println("Vitamin "+ getName() +" for " + consumer.name());
  }
}

