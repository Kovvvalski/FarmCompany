package by.kovalski.farmcompany.service;

import by.kovalski.farmcompany.entity.Pack;

import java.util.Comparator;

public enum Condition {

  ID {
    @Override
    public Comparator<Pack> getComparator() {
      return (o1, o2) -> o1.getId() - o2.getId();
    }

  }, PRODUCER {
    @Override
    public Comparator<Pack> getComparator() {
      return (o1, o2) -> o1.getProducer().getName().compareTo(o2.getProducer().getName());
    }
  }, MEDICINE {
    @Override
    public Comparator<Pack> getComparator() {
      return (o1, o2) -> o1.getMedicine().getName().compareTo(o2.getMedicine().getName());
    }

  }, TOTAL_WEIGHT {
    @Override
    public Comparator<Pack> getComparator() {
      return (o1, o2) -> o1.getTotalWeight() - o2.getTotalWeight();
    }
  }, PRICE {
    @Override
    public Comparator<Pack> getComparator() {
      return (o1, o2) -> o1.getPrice() - o2.getPrice();
    }
  };

  public abstract Comparator<Pack> getComparator();

}
