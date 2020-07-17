package ru.stqa.pft.github.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.github.addressbook.model.ContactData;
import ru.stqa.pft.github.addressbook.model.Contacts;
import ru.stqa.pft.github.addressbook.model.GroupData;
import ru.stqa.pft.github.addressbook.model.Groups;

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

    GroupData group;

    Contacts contacts = app.db().contacts();
    System.out.println("How many contacts before: " + contacts.size());

    Groups groupsBefore = app.db().groups();
    System.out.println("How many groups before: " + groupsBefore.size());

    ContactData contact = app.db().contacts().iterator().next();
    int contactId = contact.getId();
    System.out.println("Contact ID is: " + contactId);

    Groups groupsFiltered = new Groups(app.db().groups().stream().filter(g -> (g.getContacts().contains(contact))).collect(Collectors.toSet()));
    System.out.println("Filtered groups (contain selected contact): " + groupsFiltered);

    if (groupsFiltered.isEmpty()) {

      GroupData groupNew = new GroupData().withName("777");
      app.goTo().groupPage();
      app.group().create(groupNew);

      app.goTo().homePage();
      app.contact().addToGroup(contact, groupNew);
      System.out.println("Contact with ID " + contactId + " has been added to group " + groupNew.withName(groupNew.getName()));

      groupsFiltered = new Groups(app.db().groups().stream().filter(g -> (g.getContacts().contains(contact))).collect(Collectors.toSet()));
    }
    group = groupsFiltered.iterator().next();
    int groupId = group.getId();
    System.out.println("This is selected group: " + group);

    Contacts contactsInGroupBefore = new Contacts(app.contact().getContactsInGroup(group));
    System.out.println("Contacts in selected group: " + contactsInGroupBefore);

    app.goTo().homePage();
    app.contact().deleteFromGroup(contact, group);
    System.out.println("Contact with ID " + contactId + " has been deleted from group " + group.withName(group.getName()));

    Groups updatedGroups = app.db().groups();
    System.out.println("How many groups after: " + updatedGroups.size());

    for (GroupData groupFinal : updatedGroups) {

      if (groupFinal.getId() == groupId) {

        Contacts contactsInGroupAfter = new Contacts(app.contact().getContactsInGroup(groupFinal));
        System.out.println("Contacts in group after deleting a contact: " + contactsInGroupAfter);

        MatcherAssert.assertThat(contactsInGroupAfter, CoreMatchers.equalTo(contactsInGroupBefore.without(contact)));
        System.out.println("Contact has been deleted for sure!");
      }
    }
  }
}


