package by.kovalski.farmcompany.repository.specification;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.exception.SpecificationException;

@FunctionalInterface
public interface PackSpecification {
  boolean specified(Pack pack)throws SpecificationException;
}
