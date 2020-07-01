package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

public class AddContactToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      Groups groups = app.db().groups();
      app.goTo().homePage();
      app.contact().create(new ContactData().withFirstname("firstname 1").withLastname("lastname 1").inGroup(groups.iterator().next()), false);
    }
  }

  @Test
  public void testAddContactToGroup() {
    Contacts contacts = app.db().contacts();
    Groups groups = app.db().groups();

    app.goTo().homePage();
    ContactData selectedContact = contacts.iterator().next();
    app.contact().selectContactById(selectedContact.getId());
    app.contact().addToGroup();
    app.goTo().homePage();
  }
}
