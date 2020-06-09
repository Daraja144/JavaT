package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    app.getNavigationHelper().gotoHomePage();

    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new NewContactData(
                      "Daria",
                      "Zamotorina",
                      "test1"),
              true);
    }
    List<NewContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().selectContact(before.size() -1);
    app.getContactHelper().initContactModification();
    NewContactData contact = new NewContactData("Daria",
            "Zamotorina",
            "test1");
    app.getContactHelper().fillNewContactForm(contact, true);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    List<NewContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));







  }
}
