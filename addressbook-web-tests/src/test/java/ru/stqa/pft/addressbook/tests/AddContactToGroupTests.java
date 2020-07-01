package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

public class AddContactToGroupTests extends TestBase {

  @Test
  public void testAddContactToGroup() {
    Contacts contacts = app.db().contacts();
    Groups groups = app.db().groups();
    app.goTo().homePage();
    ContactData selectedContact = contacts.iterator().next();
    app.contact().selectContactById(selectedContact.getId());

    app.contactHelper.addToGroup();
    app.goTo().homePage();
  }
}
