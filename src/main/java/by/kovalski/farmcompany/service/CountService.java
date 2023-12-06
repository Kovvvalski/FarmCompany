package by.kovalski.farmcompany.service;

import by.kovalski.farmcompany.entity.Pack;

import java.util.List;

public interface CountService {
  int countTotalWeight(List<Pack> packs);
  int countTotalPrice(List<Pack> packs);
}
