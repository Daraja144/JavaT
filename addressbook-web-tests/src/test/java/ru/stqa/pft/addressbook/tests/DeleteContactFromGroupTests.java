package ru.stqa.pft.addressbook.tests;

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

    /*
    if (contact.getGroups().equals(groups)) {
      app.goTo().groupPage();
      groupChosen = new GroupData().withName("test555");
      app.group().create(groupChosen);
    }
    */

    app.goTo().homePage();

    groups = new Groups(app.db().groups().stream().filter(g -> (g.getContacts().contains(contact))).collect(Collectors.toSet()));

    //int groupId = group.getId();
    //System.out.println("Group ID is: " + groupId);

    GroupData groupNew = new GroupData().withName("777");

    if (! groups.contains(contact)) {
      app.goTo().groupPage();
      app.group().create(groupNew);
      app.goTo().homePage();
      app.contact().addToGroup(contact, groupNew);
      System.out.println("Contact with ID " + contactId + " has been added to group " + groupNew.withName(groupNew.getName()));
    }
    //GroupData group = groups.iterator().next();


    app.goTo().homePage();
    app.contact().deleteFromGroup(contact, groupNew);
    System.out.println("Contact with ID " + contactId + " has been deleted from group " + groupNew.withName(groupNew.getName()));



  }
}
