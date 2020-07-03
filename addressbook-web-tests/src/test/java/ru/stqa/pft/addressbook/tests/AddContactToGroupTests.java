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
      app.group().create(new GroupData().withName("test"));
    }
  }

  @Test
  public void testAddContactToGroup() {

    GroupData groupChosen;

    Contacts contacts = app.db().contacts();
    System.out.println("How many contacts before: " + contacts.size());

    Groups groups = app.db().groups();
    System.out.println("How many groups before: " + groups.size());

    ContactData contact = app.db().contacts().iterator().next();
    int contactId = contact.getId();

    if (contact.getGroups().equals(groups)) {
      app.goTo().groupPage();
      groupChosen = new GroupData().withName("test");
      app.group().create(groupChosen);
    }
    app.goTo().homePage();
    app.contact().selectContactById(contactId);
    GroupData group = app.db().groups().iterator().next();
    if (!group.getContacts().contains(contact.withId(contactId))) {
      app.goTo().homePage();
      app.contact().addToGroup(contact, group);
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





    /*contacts = new Contacts(app.db().contacts().
           stream().filter(e -> (e.getGroups().isEmpty())).collect(Collectors.toSet()));
    System.out.println("How many filtered contacts: " + contacts.size());

    groups = new Groups(app.db().groups()
            .stream().filter(g -> (g.getContacts().contains();
    System.out.println("How many filtered groups: " + groups.size());
    GroupData group = groups.iterator().next();

    if (groups.isEmpty()) {
      groupChosen = new GroupData().withName("test");
      app.group().create(groupChosen);
      groups = new Groups(app.db().groups()
              .stream().filter(g -> (g.getContacts().isEmpty())).collect(Collectors.toSet()));
    }
    group = groups.iterator().next();
    System.out.println("This is the group: " + group);

GroupData group = new GroupData().withName("test");
        app.goTo().groupPage();
        app.group().create(group);


    /*if (contacts.isEmpty()){
      contactChosen = new ContactData().withFirstname("Daria").withLastname("Zamotorina");
      app.contact().create(contactChosen, true);
      contacts = new Contacts(app.db().contacts().
              stream().filter(e -> (e.getGroups().isEmpty())).collect(Collectors.toSet()));
    }
    contactChosen = contacts.iterator().next();
    System.out.println("This is the contact: " + contactChosen);

    app.goTo().homePage();
    app.contact().addToGroup(contactChosen, group);



    app.goTo().homePage();
    Contacts updatedContacts = app.db().contacts();
    System.out.println("How many contacts after: " + updatedContacts.size());

    for (ContactData contactFinal : updatedContacts) {

      if (contactFinal.getId() == contactId) {
        ContactData c = new ContactData().withId(contactId).withFirstname(contact.getFirstname()).withLastname(contact.getLastname()).inGroup(group);
        System.out.println("Updated contact is: " + c);

        Assert.assertTrue(c.getGroups().contains(group));
      }}*/
