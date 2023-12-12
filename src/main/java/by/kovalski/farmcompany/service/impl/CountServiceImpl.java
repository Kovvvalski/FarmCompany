package by.kovalski.farmcompany.service.impl;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.exception.ServiceException;
import by.kovalski.farmcompany.service.CountService;

import java.util.List;

public class CountServiceImpl implements CountService {
  /**
   * instance of class
   */
  private static CountServiceImpl Instance;

  private CountServiceImpl() {

  }

  public static CountServiceImpl getInstance() {
    if (Instance == null)
      Instance = new CountServiceImpl();
    return Instance;
  }

  /**
   * returns total weight of list of packs
   *
   * @param packs
   * @return
   */
  @Override
  public int countTotalWeight(List<Pack> packs) throws ServiceException {
    int out = 0;
    for (Pack pack : packs) {
      if (pack == null)
        throw new ServiceException("Null object in repository");
      out += pack.getTotalWeight();

    }
    return out;
  }

  /**
   * returns total price of list of packs
   *
   * @param packs
   * @return
   */

  @Override
  public int countTotalPrice(List<Pack> packs) throws ServiceException {
    int out = 0;
    for (Pack pack : packs) {
      if (pack == null)
        throw new ServiceException("Null object in repository");
      out += pack.getPrice();
    }
    return out;
  }
}
