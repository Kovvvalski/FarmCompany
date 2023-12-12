package by.kovalski.farmcompany.entity;

import java.util.Objects;
import java.util.StringJoiner;

public class Pack {

  /**
   * default value
   */

  private static final int DEFAULT_PRICE_VALUE = 1;
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
   * @param id - any id
   * @param producer - producer of the pack
   * @param medicine - content of the pack
   * @param totalWeight - weight of the pack
   * @param price - price of the pack
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
   * @return id of the pack
   */
  public int getId() {
    return id;
  }

  /**
   *
   * @return producer of the pack
   */

  public Producer getProducer() {
    return producer;
  }

  /**
   *
   * @return medicine of the pack
   */

  public Medicine getMedicine() {
    return medicine;
  }

  /**
   *
   * @return total weight of the pack
   */

  public int getTotalWeight() {
    return totalWeight;
  }

  /**
   *
   * @return price
   */

  public int getPrice() {
    return price;
  }

  /**
   * sets price with positive number checking
   * @param price - valid int value
   */
  public void setPrice(int price) {
    this.price = price >= 0 ? price : DEFAULT_PRICE_VALUE;
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
