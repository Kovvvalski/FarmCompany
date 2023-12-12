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
      Instance.data = new ArrayList<>();
    }
    return Instance;
  }

  /**
   *
   * @return all copy of data list
   */
  public List<Pack> getData() {
    return new ArrayList<>(data);
  }

  /**
   * sets packs with null pointer checking
   * @param data - any list of packs
   */

  public void setData(List<Pack> data) {
    this.data = new ArrayList<>();
    for(Pack pack: data){
      if(pack!=null)
        this.data.add(pack);
    }
  }

  /**
   * if repository does not contain an argument, add it, else throws exception
   * @param pack - any pack
   * @throws RepositoryException
   */

  @Override
  public void addPack(Pack pack) throws RepositoryException {
    if (pack == null || data.stream().anyMatch(o -> o.getId() == pack.getId()))
      throw new RepositoryException("The pack of medicine with is already exists in repository or it's null");
    data.add(pack);
  }

  /**
   * deletes pack by id if it exists, else throws exception
   * @param pack - any pack
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
   * @param pack - any pack
   * @throws RepositoryException
   */

  @Override
  public void updatePack(Pack pack) throws RepositoryException {
    removePack(pack);
    data.add(pack);
  }

  /**
   * returns list of packs that equals to specification
   * @param specification - any specification
   * @return list of specified packs
   * @throws RepositoryException
   */
  @Override
  public List<Pack> query(PackSpecification specification) throws RepositoryException {
    List<Pack> out = new ArrayList<>();
    for(Pack pack : data ){
      try{
        if(specification.specified(pack))
          out.add(pack);
      }catch (SpecificationException e){
        throw new RepositoryException("Pack is not correct",e);
      }
    }
    return out;
  }
}
