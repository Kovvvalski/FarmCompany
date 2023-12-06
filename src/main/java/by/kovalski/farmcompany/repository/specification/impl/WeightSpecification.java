package by.kovalski.farmcompany.repository.specification.impl;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.exception.SpecificationException;
import by.kovalski.farmcompany.repository.specification.PackSpecification;

public class WeightSpecification implements PackSpecification {
  private int weight;

  public WeightSpecification(int weight) {
    this.weight = weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public boolean specified(Pack pack)throws SpecificationException{
    if(pack!=null)
    return pack.getTotalWeight() == weight;
    else throw new SpecificationException("Input argument is null pointer");
  }
}
