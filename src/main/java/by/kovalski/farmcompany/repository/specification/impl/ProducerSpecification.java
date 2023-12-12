package by.kovalski.farmcompany.repository.specification.impl;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.entity.Producer;
import by.kovalski.farmcompany.exception.SpecificationException;
import by.kovalski.farmcompany.repository.specification.PackSpecification;

public class ProducerSpecification implements PackSpecification {
  /**
   * producer to specify
   */
  private Producer producer;

  /**
   *
   * @param producer - any producer
   */

  public ProducerSpecification(Producer producer) {
    this.producer = producer;
  }

  /**
   * sets current producer
   * @param producer - any producer
   */

  public void setProducer(Producer producer) {
    this.producer = producer;
  }


  /**
   *
   * @param pack - any pack
   * @return true if object specify to current producer
   * @throws SpecificationException
   */
  @Override
  public boolean specified(Pack pack)throws SpecificationException {
    if(pack!=null)
    return producer.equals(pack.getProducer());
    else throw new SpecificationException("Input argument is null pointer");
  }
}
