package by.kovalski.farmcompany.repository.specification.impl;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.exception.SpecificationException;
import by.kovalski.farmcompany.repository.specification.PackSpecification;

public class PriceSpecification implements PackSpecification {
  private int price;

  public PriceSpecification(int price) {
    this.price = price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public boolean specified(Pack pack) throws SpecificationException {
    if(pack!=null)
    return price == pack.getPrice();
    else throw new SpecificationException("Input argument is null pointer");
  }
}
