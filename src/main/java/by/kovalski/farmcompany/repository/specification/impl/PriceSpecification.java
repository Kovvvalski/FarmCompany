package by.kovalski.farmcompany.repository.specification.impl;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.exception.SpecificationException;
import by.kovalski.farmcompany.repository.specification.PackSpecification;

public class PriceSpecification implements PackSpecification {
  /**
   * price to specify
   */
  private int price;

  /**
   *
   * @param price - any int value
   */

  public PriceSpecification(int price) {
    this.price = price;
  }

  /**
   * sets current price
   * @param price - any int value
   */

  public void setPrice(int price) {
    this.price = price;
  }

  /**
   *
   * @param pack - any pack
   * @return true if object specify to current price
   * @throws SpecificationException
   */

  @Override
  public boolean specified(Pack pack) throws SpecificationException {
    if(pack!=null)
    return price == pack.getPrice();
    else throw new SpecificationException("Input argument is null pointer");
  }
}
