package by.kovalski.farmcompany.repository.specification.impl;

import by.kovalski.farmcompany.entity.Medicine;
import by.kovalski.farmcompany.entity.Pack;
import by.kovalski.farmcompany.exception.SpecificationException;
import by.kovalski.farmcompany.repository.specification.PackSpecification;

public class MedicineSpecification implements PackSpecification {
  /**
   * medicine to specify
   */
  private Medicine medicine;

  /**
   *
   * @param medicine - any medicine
   */

  public MedicineSpecification(Medicine medicine) {
    this.medicine = medicine;
  }

  /**
   * sets current medicine
   * @param medicine - any medicine
   */

  public void setMedicine(Medicine medicine) {
    this.medicine = medicine;
  }

  /**
   *
   * @param pack - any pack to specify
   * @return true if object specify to current medicine
   * @throws SpecificationException
   */

  @Override
  public boolean specified(Pack pack) throws SpecificationException{
    if(pack!=null)
    return medicine.equals(pack.getMedicine());
    else throw new SpecificationException("Input argument is null pointer");
  }
}
