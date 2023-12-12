package by.kovalski.farmcompany.service;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.exception.RepositoryException;

import java.util.Comparator;

public enum Condition {

  ID {
    /**
     * checks to null arguments and throws RuntimeException if one of them are null
     * @return comparator by id
     */
    @Override
    public Comparator<Pack> getComparator(){
      return (o1,o2) -> {
       if(o1 == null || o2 == null){
         throw new RuntimeException("Null pointer in repository");
       }
       return o1.getId() - o2.getId();
      };
    }

  }, PRODUCER {
    /**
     * checks to null arguments and throws RuntimeException if one of them are null
     * @return comparator by producer
     */
    @Override
    public Comparator<Pack> getComparator() {
      return (o1, o2) -> {
        if(o1 == null || o2 == null){
          throw new RuntimeException("Null pointer in repository");
        }
        return o1.getProducer().getName().compareTo(o2.getProducer().getName());
      };
    }
  }, MEDICINE {
    /**
     * checks to null arguments and throws RuntimeException if one of them are null
     * @return comparator by medicine
     */
    @Override
    public Comparator<Pack> getComparator() {
      return (o1, o2) -> {
        if(o1 == null || o2 == null){
          throw new RuntimeException("Null pointer in repository");
        }
        return o1.getMedicine().getName().compareTo(o2.getMedicine().getName());
      };
    }

  }, TOTAL_WEIGHT {
    /**
     * checks to null arguments and throws RuntimeException if one of them are null
     * @return comparator by total weight
     */
    @Override
    public Comparator<Pack> getComparator() {
      return (o1, o2) -> {
        if(o1 == null || o2 == null){
          throw new RuntimeException("Null pointer in repository");
        }
        return o1.getTotalWeight()-o2.getTotalWeight();
      };
    }
  }, PRICE {
    /**
     * checks to null arguments and throws RuntimeException if one of them are null
     * @return comparator by price
     */
    @Override
    public Comparator<Pack> getComparator() {
      return (o1, o2) -> {
        if(o1 == null || o2 == null){
          throw new RuntimeException("Null pointer in repository");
        }
        return o1.getPrice() - o2.getPrice();
      };
    }
  };

  public abstract Comparator<Pack> getComparator();

}
