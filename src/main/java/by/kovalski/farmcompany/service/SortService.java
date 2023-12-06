package by.kovalski.farmcompany.service;

import by.kovalski.farmcompany.entity.Pack;

import java.util.List;
@FunctionalInterface
public interface SortService {
  void sortByCondition(List<Pack> packs, Condition condition);
}
