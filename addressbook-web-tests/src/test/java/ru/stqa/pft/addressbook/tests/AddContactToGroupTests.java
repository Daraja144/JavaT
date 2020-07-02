package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import java.util.stream.Collectors;

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
      app.group().create(new GroupData().withName("test"));
    }
  }

  @Test
  public void testAddContactToGroup() {
    ContactData contactChosen;
    Contacts contacts;
    Contacts before = app.db().contacts();
    System.out.println("How many contacts before: " + before.size());

    Groups groups = app.db().groups();
    System.out.println("Hi Daria. Those are your groups:" + groups);
    GroupData group = groups.iterator().next();
    System.out.println("This is the group: " + group);
    contacts = new Contacts(app.db().contacts().
            stream().filter(e -> (e.getGroups().isEmpty())).collect(Collectors.toSet()));
    System.out.println("How many filtered contacts: " + contacts.size());

    if (contacts.isEmpty()){
      contactChosen = new ContactData().withFirstname("Daria").withLastname("Zamotorina");
      app.contact().create(contactChosen, true);
      contacts = new Contacts(app.db().contacts().
              stream().filter(e -> (e.getGroups().isEmpty())).collect(Collectors.toSet()));
    }
    contactChosen = contacts.iterator().next();
    System.out.println("This is the contact: " + contactChosen);

    app.goTo().homePage();
    app.contact().addToGroup(contactChosen, group);

    int contactId = contactChosen.getId();
    System.out.println("This is the contact ID: " + contactId);

    app.goTo().homePage();
    Contacts updatedContacts = app.db().contacts();
    System.out.println("How many contacts after: " + updatedContacts.size());

    for (ContactData contact : updatedContacts) {

      if (contact.getId() == contactId) {
        ContactData c = new ContactData().withId(contactId).withFirstname(contact.getFirstname()).withLastname(contact.getLastname()).inGroup(group);
        System.out.println("Updated contact is: " + c);

        Assert.assertTrue(c.getGroups().contains(group));
      }
    }
  }
}
