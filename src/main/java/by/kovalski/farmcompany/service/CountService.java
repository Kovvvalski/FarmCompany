package by.kovalski.farmcompany.service;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.exception.ServiceException;

import java.util.List;

public interface CountService {
  /**
   *
   * @param packs - any list of packs
   * @return total weight of packs
   * @throws ServiceException
   */
  int countTotalWeight(List<Pack> packs) throws ServiceException;

  /**
   *
   * @param packs - any list of packs
   * @return total price of packs
   * @throws ServiceException
   */
  int countTotalPrice(List<Pack> packs) throws ServiceException;
}
