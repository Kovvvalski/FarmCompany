package by.kovalski.farmcompany.repository;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.exception.RepositoryException;
import by.kovalski.farmcompany.repository.specification.PackSpecification;

import java.util.List;
import java.util.function.Predicate;

public interface Repository {
  /**
   * adds pack in repository
   * @param pack - any pack
   * @throws RepositoryException
   */
  void addPack(Pack pack)throws RepositoryException;

  /**
   * removes pack by id from repository
   * @param pack - pack to delete
   * @throws RepositoryException
   */

  void removePack(Pack pack) throws RepositoryException;

  /**
   * updates info about pack
   * @param pack - pack to update
   * @throws RepositoryException
   */

  void updatePack(Pack pack) throws RepositoryException;

  /**
   * returns query
   * @param specification - any specification
   * @return list of specified objects
   * @throws RepositoryException
   */

  List<Pack> query(PackSpecification specification)throws RepositoryException;

}
