package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

public class AddContactToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstname("Daria").withLastname("Zamotorina")
              .withHomePhone("11-11-11").withAddress("Haffmeister Rd.")
              .withEmail("dara@gmail.com"), true);
    }

    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("pooo"));
    }
  }

  @Test
  public void testAddContactToGroup() {

    Contacts contacts = app.db().contacts();
    System.out.println("How many contacts before: " + contacts.size());

    Groups groups = app.db().groups();
    System.out.println("How many groups before: " + groups.size());

    ContactData contact = app.db().contacts().iterator().next();
    int contactId = contact.getId();
    GroupData groupChosen;

    if (contact.getGroups().equals(groups)) {
      app.goTo().groupPage();
      groupChosen = new GroupData().withName("fooo");
      app.group().create(groupChosen);
    }
    app.goTo().homePage();
    GroupData group = app.db().groups().iterator().next();

    if (!group.getContacts().equals(contact.withId(contactId))) {
      app.goTo().homePage();
      app.contact().addToGroup(contact, group);
      System.out.println("Contact with ID " + contactId + " has been added to group " + group.getName());
    }

    app.goTo().homePage();
    Contacts updatedContacts = app.db().contacts();
    System.out.println("How many contacts after: " + updatedContacts.size());

    for (ContactData contactFinal : updatedContacts) {

      if (contactFinal.getId() == contactId) {
        ContactData c = new ContactData().withId(contactId).withFirstname(contact.getFirstname()).withLastname(contact.getLastname()).inGroup(group);
        System.out.println("Updated contact is: " + c);

        Assert.assertTrue(c.getGroups().contains(group));

      }
    }
  }
}

