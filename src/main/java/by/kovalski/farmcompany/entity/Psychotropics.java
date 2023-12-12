package by.kovalski.farmcompany.entity;

import java.util.Objects;
import java.util.StringJoiner;


public class Psychotropics extends Medicine{
  /**
   * negative effects of medicine
   */
  private final String negativeEffects;

  /**
   *
   * @param name - name of medicine
   * @param type - type of medicine
   * @param dosage - info about dosage
   * @param negativeEffects - possible negative effects
   */

  public Psychotropics(String name, Type type, String dosage, String negativeEffects) {
    super(name, type, dosage);
    this.negativeEffects = negativeEffects;
  }

  /**
   *
   * @return info about negative effects
   */

  public String getNegativeEffects() {
    return negativeEffects;
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
    Psychotropics that = (Psychotropics) o;
    return super.equals(that) && negativeEffects.equals(that.negativeEffects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), negativeEffects);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Psychotropics.class.getSimpleName() + "[", "]")
            .add("negativeEffects='" + negativeEffects + "'")
            .add("name='" + getName() + "'")
            .add("type=" + getType())
            .add("dosage='" + getDosage() + "'")
            .toString();
  }

  @Override
  public void info() {
    System.out.println("Psychotropic with " + negativeEffects + " negative effects");
  }
}
