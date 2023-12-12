package by.kovalski.farmcompany.repository.specification.impl;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.exception.SpecificationException;
import by.kovalski.farmcompany.repository.specification.PackSpecification;

public class IdSpecification implements PackSpecification {
  /**
   * id to specify
   */
  private int id;

  /**
   *
   * @param id - any int
   */

  public IdSpecification(int id) {
    this.id = id;
  }

  /**
   * sets id
   * @param id - any int
   */
  public void setId(int id) {
    this.id = id;
  }


  /**
   *
   * @param pack to specify
   * @return true if object specify to current id
   * @throws SpecificationException
   */
  @Override
  public boolean specified(Pack pack)throws SpecificationException {
    if(pack != null)
    return pack.getId() == id;
    else throw new SpecificationException("Input argument is null pointer");
  }
}
