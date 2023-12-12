package by.kovalski.farmcompany.repository;

import by.kovalski.farmcompany.entity.*;
import by.kovalski.farmcompany.exception.RepositoryException;
import by.kovalski.farmcompany.repository.impl.ListRepository;
import by.kovalski.farmcompany.repository.specification.impl.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositoryTest {
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
  void add() {
    Pack p1 = new Pack(1, new Producer("Belfarm", new Certification("reg1", "6d6a5sda5", LocalDate.of(2022, 12, 13), LocalDate.of(2024, 12, 13))), new Vitamins("VitA", Type.TABLETS, "2 times in day", Consumer.ALL), 300, 5);
    ListRepository repository = ListRepository.getInstance();
    repository.setData(new ArrayList<>());
    try {
      repository.addPack(p1);
    } catch (RepositoryException e) {
      e.printStackTrace();
    }

    Pack p2 = new Pack(1, new Producer("Belfarm", new Certification("reg1", "6d6a5sda5", LocalDate.of(2022, 12, 13), LocalDate.of(2024, 12, 13))), new Vitamins("VitA", Type.TABLETS, "2 times in day", Consumer.ALL), 300, 5);
    Assertions.assertEquals(true, p2.equals(repository.getData().get(0)));
//    for(Pack pack:testData){
//      pack.getMedicine().toString();
//      pack.getMedicine().hashCode();
//      pack.getMedicine().equals(p2);
//      pack.getMedicine().info();
//      pack.toString();
//    }
    repository.setData(new ArrayList<>());
  }

  @Test
  void addExpectedException() {
    ListRepository repository = ListRepository.getInstance();
    Assertions.assertThrows(RepositoryException.class, () -> {
      repository.addPack(null);
    });
    repository.setData(new ArrayList<>());
  }

  @Test
  void remove() {
    Pack p1 = new Pack(1, new Producer("Belfarm", new Certification("reg1", "6d6a5sda5", LocalDate.of(2022, 12, 13), LocalDate.of(2024, 12, 13))), new Vitamins("VitA", Type.TABLETS, "2 times in day", Consumer.ALL), 300, 5);

    ListRepository repository = ListRepository.getInstance();
    repository.setData(new ArrayList<>());
    try {
      repository.addPack(p1);
    } catch (RepositoryException e) {
      e.printStackTrace();
    }
    try {
      repository.removePack(p1);
    } catch (RepositoryException e) {
      e.printStackTrace();
    }
    Assertions.assertEquals(true, repository.getData().isEmpty());
  }

  @Test
  void removeExpectedException() {
    ListRepository repository = ListRepository.getInstance();
    Assertions.assertThrows(RepositoryException.class, () -> {
      repository.removePack(new Pack(3, new Producer("Belfarm", new Certification("reg1", "6d6a5sda5", LocalDate.of(2022, 12, 13), LocalDate.of(2024, 12, 13))), new Vitamins("VitA", Type.TABLETS, "2 times in day", Consumer.ALL), 300, 5));
    });
    repository.setData(new ArrayList<>());
  }

  @Test
  void update() {
    Pack p1 = new Pack(1, new Producer("Belfarm", new Certification("reg1", "6d6a5sda5", LocalDate.of(2022, 12, 13), LocalDate.of(2024, 12, 13))), new Vitamins("VitA", Type.TABLETS, "2 times in day", Consumer.ALL), 300, 5);
    ListRepository repository = ListRepository.getInstance();
    try {
      repository.addPack(p1);
    } catch (RepositoryException e) {
      e.printStackTrace();
    }
    p1.setPrice(500);
    try {
      repository.updatePack(p1);
    } catch (RepositoryException e) {
      e.printStackTrace();
    }
    Pack p2 = new Pack(1, new Producer("Belfarm", new Certification("reg1", "6d6a5sda5", LocalDate.of(2022, 12, 13), LocalDate.of(2024, 12, 13))), new Vitamins("VitA", Type.TABLETS, "2 times in day", Consumer.ALL), 300, 5);
    p2.setPrice(500);
    Assertions.assertEquals(true, repository.getData().get(0).equals(p2));
    repository.setData(new ArrayList<>());
  }

  @Test
  void query() throws RepositoryException {
    ListRepository repository = ListRepository.getInstance();
    repository.setData(new ArrayList<>());
    repository.setData(testData);
    List<Pack> query = repository.query(new IdSpecification(1));
    Assertions.assertEquals(true, query.get(0).getId() == 1);
    Medicine m = new Antibiotics("Amoklav", Type.CAPSULES, "3 times in day", true);
    query = repository.query(new MedicineSpecification(new Antibiotics("Amoklav", Type.CAPSULES, "3 times in day", true)));
    for (Pack pack : query) {
      Assertions.assertEquals(true, pack.getMedicine().equals(m));
    }
    query = repository.query(new PriceSpecification(20));
    for (Pack pack : query) {
      Assertions.assertEquals(true, pack.getPrice() == 20);
    }
    query = repository.query(new WeightSpecification(400));
    for (Pack pack : query) {
      Assertions.assertEquals(true, pack.getTotalWeight() == 400);
    }
    query = repository.query(new ProducerSpecification(new Producer("Zollen", new Certification("regw", "6d6a5sda1dsa", LocalDate.of(2021, 12, 13), LocalDate.of(2024, 12, 13)))));
    Producer p = new Producer("Zollen", new Certification("regw", "6d6a5sda1dsa", LocalDate.of(2021, 12, 13), LocalDate.of(2024, 12, 13)));
    for (Pack pack : query) {
      Assertions.assertEquals(true, pack.getProducer().equals(p));
    }
    repository.setData(new ArrayList<>());
  }


}
