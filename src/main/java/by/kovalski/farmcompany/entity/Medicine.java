package by.kovalski.farmcompany.entity;

import java.util.Objects;

public abstract class Medicine {
  /**
   * name of medicine
   */
  private final String name;
  /**
   * type of medicine
   */
  private final Type type;
  /**
   * info about dosage
   */
  private final String dosage;

  /**
   * constructor
   * @param name
   * @param type
   * @param dosage
   */

  public Medicine(String name, Type type, String dosage) {
    this.name = name;
    this.type = type;
    this.dosage = dosage;
  }

  public String getName() {
    return name;
  }

  public Type getType() {
    return type;
  }

  public String getDosage() {
    return dosage;
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
    Medicine medicine = (Medicine) o;
    return type == medicine.type && name.equals(medicine.name) && dosage.equals(medicine.dosage);
  }

  /**
   *
   * @return hash code of an object
   */

  @Override
  public int hashCode() {
    return Objects.hash(name, type, dosage);
  }
  /**
   * prints info about object
   */

  public abstract void info();
}
