package by.kovalski.farmcompany.repository.impl;

import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.exception.RepositoryException;
import by.kovalski.farmcompany.exception.SpecificationException;
import by.kovalski.farmcompany.repository.Repository;
import by.kovalski.farmcompany.repository.specification.PackSpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ListRepository implements Repository {
  /**
   * Instance of class
   */
  private static ListRepository Instance;
  /**
   * repository of packs
   */
  private List<Pack> data;

  private ListRepository() {

  }

  /**
   *
   * @return instance of class
   */

  public static ListRepository getInstance() {
    if (Instance == null) {
      Instance = new ListRepository();
      Instance.setData(new ArrayList<>());
    }
    return Instance;
  }

  /**
   *
   * @return all packs
   */
  public List<Pack> getData() {
    return new ArrayList<>(data);
  }

  /**
   * sets packs
   * @param data
   */

  public void setData(List<Pack> data) {
    this.data = new ArrayList<>(data);
  }

  /**
   * if repository does not contains an argument, add it, else throws exception
   * @param pack
   * @throws RepositoryException
   */

  @Override
  public void addPack(Pack pack) throws RepositoryException {
    if (data.stream().anyMatch(o -> o.getId() == pack.getId()) || pack == null)
      throw new RepositoryException("The pack of medicine with id " + pack.getId() + " is already exists in repository or it's null");
    data.add(pack);
  }

  /**
   * deletes pack by id if it exists, else throws exception
   * @param pack
   * @throws RepositoryException
   */
  @Override
  public void removePack(Pack pack) throws RepositoryException {
    if (!data.stream().anyMatch(o1 -> (o1.equals(pack))))
      throw new RepositoryException("The pack of medicine with id " + pack.getId() + " is not exists in repository");
    List<Pack> toDelete = data.stream().filter(o1 -> (o1.equals(pack))).toList();
    data.remove(toDelete.get(0));
  }

  /**
   * deletes pack by id and adds it again
   * @param pack
   * @throws RepositoryException
   */

  @Override
  public void updatePack(Pack pack) throws RepositoryException {
    removePack(pack);
    data.add(pack);
  }

  /**
   * returns list of packs that equals to specification
   * @param specification
   * @return
   * @throws RepositoryException
   */
  @Override
  public List<Pack> query(PackSpecification specification) throws RepositoryException {

      return data.stream().filter(o1 -> {
        try {
          return specification.specified(o1);
        } catch (SpecificationException e) {
            throw new RuntimeException();
        }
      }).toList();
  }
}
