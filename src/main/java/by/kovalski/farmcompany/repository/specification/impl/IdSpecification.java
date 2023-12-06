package by.kovalski.farmcompany.repository.specification.impl;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.exception.SpecificationException;
import by.kovalski.farmcompany.repository.specification.PackSpecification;

public class IdSpecification implements PackSpecification {
  private int id;

  public IdSpecification(int id) {
    this.id = id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean specified(Pack pack)throws SpecificationException {
    if(pack != null)
    return pack.getId() == id;
    else throw new SpecificationException("Input argument is null pointer");
  }
}
