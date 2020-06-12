package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;
import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size()==0) {
      app.contact().create(new NewContactData(
                      "Daria",
                      "Zamotorina",
                      "test1"),
              false);
    }
  }

  @Test
  public void testContactModification() {

    List<NewContactData> before = app.contact().list();
    int index = before.size() -1;
    NewContactData contact = new NewContactData(before.get(index).getId(),"Daria",
            "Zamotorina", null);

    app.contact().modify(index, contact);
    List<NewContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super NewContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }


}
