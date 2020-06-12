package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new NewContactData(
                      "Daria",
                      "Zamotorina",
                      "test1"),
              false);
    }
  }

  @Test

  public void testContactDeletion() {

    List<NewContactData> before = app.getContactHelper().getContactList();
    int index = before.size() -1;
    app.getContactHelper().deleteContact(index);
    List<NewContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), index);

    before.remove(index);
      Assert.assertEquals(before, after);


  }


}
