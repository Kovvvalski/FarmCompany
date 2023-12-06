package by.kovalski.farmcompany.service.impl;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.service.Condition;
import by.kovalski.farmcompany.service.SortService;

import java.util.List;

public class SortServiceImpl implements SortService {
  /**
   * instance of class
   */
  private static SortServiceImpl Instance;
  private SortServiceImpl(){

  }
  public static SortServiceImpl getInstance(){
    if(Instance == null)
      Instance = new SortServiceImpl();
    return Instance;
  }

  /**
   * sorting list of packs by condition
   * @param packs
   * @param condition
   */
  @Override
  public void sortByCondition(List<Pack> packs, Condition condition) {
    packs.sort(condition.getComparator());
    }
  }

