package by.kovalski.farmcompany.entity;

import java.util.Objects;
import java.util.StringJoiner;

public class Pack {
  /**
   * id of pack
   */
  private final int id;
  /**
   * producer of pack
   */
  private final Producer producer;
  /**
   * medicine that pack contains
   */
  private final Medicine medicine;
  /**
   * total weight of medicine inside
   */
  private final int totalWeight;
  /**
   * price
   */
  private int price;

  /**
   * constructor
   * @param id
   * @param producer
   * @param medicine
   * @param totalWeight
   * @param price
   */
  public Pack(int id, Producer producer, Medicine medicine, int totalWeight, int price) {
    this.id = id;
    this.producer = producer;
    this.medicine = medicine;
    this.totalWeight = totalWeight;
    this.price = price;
  }

  /**
   *
   * @return
   */
  public int getId() {
    return id;
  }

  /**
   *
   * @return
   */

  public Producer getProducer() {
    return producer;
  }

  /**
   *
   * @return
   */

  public Medicine getMedicine() {
    return medicine;
  }

  public int getTotalWeight() {
    return totalWeight;
  }

  /**
   *
   * @return
   */

  public int getPrice() {
    return price;
  }

  /**
   * sets price
   * @param price
   */
  public void setPrice(int price) {
    this.price = price;
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
    Pack pack = (Pack) o;
    return id == pack.id && totalWeight == pack.totalWeight && price == pack.price && producer.equals(pack.producer) && medicine.equals(pack.medicine);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, producer, medicine, totalWeight, price);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Pack.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("producer=" + producer)
            .add("medicine=" + medicine)
            .add("totalWeight=" + totalWeight)
            .add("price=" + price)
            .toString();
  }
}
