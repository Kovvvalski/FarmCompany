package by.kovalski.farmcompany.repository.specification.impl;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.exception.SpecificationException;
import by.kovalski.farmcompany.repository.specification.PackSpecification;

public class WeightSpecification implements PackSpecification {
  /**
   * current weight
   */
  private int weight;

  /**
   *
   * @param weight - any int value
   */

  public WeightSpecification(int weight) {
    this.weight = weight;
  }

  /**
   * sets current weight
   * @param weight - any int value
   */

  public void setWeight(int weight) {
    this.weight = weight;
  }

  /**
   *
   * @param pack - any pack
   * @return true if object specify to current weight
   * @throws SpecificationException
   */

  @Override
  public boolean specified(Pack pack)throws SpecificationException{
    if(pack!=null)
    return pack.getTotalWeight() == weight;
    else throw new SpecificationException("Input argument is null pointer");
  }
}
