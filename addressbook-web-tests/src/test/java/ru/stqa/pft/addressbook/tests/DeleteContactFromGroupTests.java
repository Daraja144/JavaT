package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.stream.Collectors;

public class DeleteContactFromGroupTests extends TestBase {
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
  public void testDeleteContactFromGroup() {

    Contacts contacts = app.db().contacts();
    System.out.println("How many contacts before: " + contacts.size());

    Groups groups = app.db().groups();
    System.out.println("How many groups before: " + groups.size());

    ContactData contact = app.db().contacts().iterator().next();
    int contactId = contact.getId();
    System.out.println("Contact ID is: " + contactId);

    groups = new Groups(app.db().groups().stream().filter(g -> (g.getContacts().contains(contact))).collect(Collectors.toSet()));
    System.out.println("Filtered groups (contain selected contact): " + groups);

    if (! groups.isEmpty()) {
      GroupData groupSelected = app.db().groups().iterator().next();
      System.out.println("This is selected group: " + groupSelected);
      app.goTo().homePage();
      app.contact().deleteFromGroup(contact, groupSelected);

      Groups updatedGroups = app.db().groups();
      System.out.println("How many groups after: " + updatedGroups.size());

      MatcherAssert.assertThat(groupSelected.getContacts().contains(contact.withId(contactId)), CoreMatchers.equalTo(false));
      System.out.println("Contact has been deleted for sure!");
    } else {
      GroupData groupNew = new GroupData().withName("777");
      app.goTo().groupPage();
      app.group().create(groupNew);

      app.goTo().homePage();
      app.contact().addToGroup(contact, groupNew);
      System.out.println("Contact with ID " + contactId + " has been added to group " + groupNew.withName(groupNew.getName()));

      app.goTo().homePage();
      app.contact().deleteFromGroup(contact, groupNew);
      System.out.println("Contact with ID " + contactId + " has been deleted from group " + groupNew.withName(groupNew.getName()));

      Groups updatedGroups = app.db().groups();
      System.out.println("How many groups after: " + updatedGroups.size());
      Assert.assertFalse(groupNew.getContacts().contains(contact));
      System.out.println("Contact has been deleted for sure!");
    }
  }
}

