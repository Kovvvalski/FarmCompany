package by.kovalski.farmcompany.entity;

import java.util.Objects;
import java.util.StringJoiner;

public class Antibiotics extends Medicine{
  /**
   * Field for storing data about prescription requirements
   */
  private boolean byPrescription;

  /**
   *Calls the constructor of super class end sets field byPrescription
   * @param name name of medicine
   * @param type one of the values of enum Type
   * @param dosage string that consists info about dosage
   * @param byPrescription boolean value
   */


  public Antibiotics(String name, Type type, String dosage, boolean byPrescription) {
    super(name, type, dosage);
    this.byPrescription = byPrescription;
  }

  /**
   *
   * @return value of byPrescription
   */

  public boolean isByPrescription() {
    return byPrescription;
  }

  /**
   *
   * @param byPrescription - boolean value
   */

  public void setByPrescription(boolean byPrescription) {
    this.byPrescription = byPrescription;
  }

  /**
   *
   * @param o - any object
   * @return true if Objects are equal
   */

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Antibiotics that = (Antibiotics) o;
    return super.equals(that) && byPrescription == that.byPrescription;
  }

  /**
   *
   * @return hash code of object
   */

  @Override
  public int hashCode() {
    return Objects.hash(byPrescription);
  }

  /**
   *
   * @return string of object
   */

  @Override
  public String toString() {
    return new StringJoiner(", ", Antibiotics.class.getSimpleName() + "[", "]")
            .add("byPrescription=" + byPrescription)
            .add("name='" + getName() + "'")
            .add("type=" + getType())
            .add("dosage='" + getDosage() + "'")
            .toString();
  }



  @Override
  public void info() {
    System.out.println("Antibiotic + " + getName() + (byPrescription?" with prescription requirement":" without prescription requirement"));
  }
}
