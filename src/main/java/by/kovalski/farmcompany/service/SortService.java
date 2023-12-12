package by.kovalski.farmcompany.service;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.exception.ServiceException;

import java.util.List;
@FunctionalInterface
public interface SortService {
  /**
   * sorts packs by condition
   * @param packs - any list of packs
   * @param condition - any condition
   * @throws ServiceException
   */
  void sortByCondition(List<Pack> packs, Condition condition) throws ServiceException;
}
