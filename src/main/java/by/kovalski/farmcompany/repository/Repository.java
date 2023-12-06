package by.kovalski.farmcompany.repository;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.exception.RepositoryException;
import by.kovalski.farmcompany.repository.specification.PackSpecification;

import java.util.List;
import java.util.function.Predicate;

public interface Repository {
  void addPack(Pack pack)throws RepositoryException;

  void removePack(Pack pack) throws RepositoryException;

  void updatePack(Pack pack) throws RepositoryException;

  List<Pack> query(PackSpecification specification)throws RepositoryException;

}
