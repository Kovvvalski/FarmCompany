package by.kovalski.farmcompany.service;

import by.kovalski.farmcompany.entity.*;
import by.kovalski.farmcompany.exception.ServiceException;
import by.kovalski.farmcompany.service.impl.CountServiceImpl;
import by.kovalski.farmcompany.service.impl.SortServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceTest {
  private static List<Pack> testData;

  @BeforeAll
  static void createTestData() {
    Pack p1 = new Pack(1, new Producer("Belfarm", new Certification("reg1", "6d6a5sda5", LocalDate.of(2022, 12, 13), LocalDate.of(2024, 12, 13))), new Vitamins("VitA", Type.TABLETS, "2 times in day", Consumer.ALL), 300, 5);
    Pack p2 = new Pack(2, new Producer("Belfarm", new Certification("reg1", "6d6a5sda5", LocalDate.of(2022, 12, 13), LocalDate.of(2024, 12, 13))), new Vitamins("VitA", Type.TABLETS, "2 times in day", Consumer.ALL), 300, 5);
    Pack p3 = new Pack(3, new Producer("Belfarm", new Certification("reg1", "6d6a5sda5", LocalDate.of(2022, 12, 13), LocalDate.of(2024, 12, 13))), new Vitamins("VitA", Type.TABLETS, "2 times in day", Consumer.ALL), 300, 5);
    Pack p4 = new Pack(4, new Producer("Zollen", new Certification("regw", "6d6a5sda1dsa", LocalDate.of(2021, 12, 13), LocalDate.of(2024, 12, 13))), new Antibiotics("Amoklav", Type.CAPSULES, "3 times in day", true), 500, 15);
    Pack p5 = new Pack(5, new Producer("Zollen", new Certification("regw", "6d6a5sda1dsa", LocalDate.of(2021, 12, 13), LocalDate.of(2024, 12, 13))), new Antibiotics("Amoklav", Type.CAPSULES, "3 times in day", true), 500, 15);
    Pack p6 = new Pack(6, new Producer("Zollen", new Certification("regw", "6d6a5sda1dsa", LocalDate.of(2021, 12, 13), LocalDate.of(2024, 12, 13))), new Antibiotics("Amoklav", Type.CAPSULES, "3 times in day", true), 500, 15);
    Pack p7 = new Pack(7, new Producer("Psorex", new Certification("reg1", "6d6a5sasdasdda1dsa", LocalDate.of(2020, 12, 13), LocalDate.of(2024, 12, 13))), new Psychotropics("psycho", Type.POWDER, "3 times in day", "head ache"), 400, 20);
    Pack p8 = new Pack(8, new Producer("Psorex", new Certification("reg1", "6d6a5sasdasdda1dsa", LocalDate.of(2020, 12, 13), LocalDate.of(2024, 12, 13))), new Psychotropics("psycho", Type.POWDER, "3 times in day", "head ache"), 400, 20);
    Pack p9 = new Pack(9, new Producer("Psorex", new Certification("reg1", "6d6a5sasdasdda1dsa", LocalDate.of(2020, 12, 13), LocalDate.of(2024, 12, 13))), new Psychotropics("psycho", Type.POWDER, "3 times in day", "head ache"), 400, 20);
    Pack p10 = new Pack(10, new Producer("Psorex", new Certification("reg1", "6d6a5sasdasdda1dsa", LocalDate.of(2020, 12, 13), LocalDate.of(2024, 12, 13))), new Psychotropics("psycho", Type.POWDER, "3 times in day", "head ache"), 400, 20);
    List<Pack> data = new ArrayList<>();
    data.add(p1);
    data.add(p2);
    data.add(p3);
    data.add(p4);
    data.add(p5);
    data.add(p6);
    data.add(p7);
    data.add(p8);
    data.add(p9);
    data.add(p10);
    testData = data;

  }
  @Test
  void countWeight () {
    CountService service = CountServiceImpl.getInstance();
    try {
      Assertions.assertEquals(4000,service.countTotalWeight(testData));

    }catch (ServiceException e){
      e.printStackTrace();
    }
  }
  @Test
  void countPrice(){
    CountService service = CountServiceImpl.getInstance();
    try{
      Assertions.assertEquals(140,service.countTotalPrice(testData));
    }catch (ServiceException e){
      e.printStackTrace();
    }

  }

  @Test
  void sort(){
    SortService service = SortServiceImpl.getInstance();
    try {
      service.sortByCondition(testData, Condition.ID);
    }catch (ServiceException e){
      e.printStackTrace();
    }

    int prev = 1;
    for(Pack pack : testData){
      Assertions.assertEquals(pack.getId()>=prev,true);
      prev = pack.getId();
    }
  }
}
