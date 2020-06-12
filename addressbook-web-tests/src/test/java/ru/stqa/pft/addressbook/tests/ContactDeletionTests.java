package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;
import java.util.List;

public class ContactDeletionTests extends TestBase {

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

  public void testContactDeletion() {

    List<NewContactData> before = app.contact().list();
    int index = before.size() -1;
    app.contact().delete(index);
    List<NewContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(index);
      Assert.assertEquals(before, after);


  }


}
