package by.kovalski.farmcompany.repository.specification.impl;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.entity.Producer;
import by.kovalski.farmcompany.exception.SpecificationException;
import by.kovalski.farmcompany.repository.specification.PackSpecification;

public class ProducerSpecification implements PackSpecification {
  private Producer producer;

  public ProducerSpecification(Producer producer) {
    this.producer = producer;
  }

  public void setProducer(Producer producer) {
    this.producer = producer;
  }

  @Override
  public boolean specified(Pack pack)throws SpecificationException {
    if(pack!=null)
    return producer.equals(pack.getProducer());
    else throw new SpecificationException("Input argument is null pointer");
  }
}
