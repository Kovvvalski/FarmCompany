package by.kovalski.farmcompany.repository.specification;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.exception.SpecificationException;

@FunctionalInterface
public interface PackSpecification {
  /**
   *
   * @param pack - any pack
   * @return true if object is specified, else - false
   * @throws SpecificationException
   */
  boolean specified(Pack pack)throws SpecificationException;
}
