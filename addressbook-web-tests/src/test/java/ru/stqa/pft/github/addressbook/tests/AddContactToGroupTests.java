package ru.stqa.pft.github.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.github.addressbook.model.ContactData;
import ru.stqa.pft.github.addressbook.model.Contacts;
import ru.stqa.pft.github.addressbook.model.GroupData;
import ru.stqa.pft.github.addressbook.model.Groups;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

  @Test(enabled = false)
  public void testAddContactToGroup() {

    Contacts contacts = app.db().contacts();
    System.out.println("How many contacts before: " + contacts.size());

    Groups groups = app.db().groups();
    System.out.println("How many groups before: " + groups.size());

    ContactData contact = app.db().contacts().iterator().next();
    int contactId = contact.getId();
    System.out.println("Chosen contact is the contact with ID: " + contactId);

    if (contact.getGroups().equals(groups)) {
      app.goTo().groupPage();
      GroupData groupChosen = new GroupData().withName("fooo");
      app.group().create(groupChosen);
    }

    groups = new Groups(app.db().groups().stream().filter(g -> (! g.getContacts().contains(contact))).collect(Collectors.toSet()));
    System.out.println("Filtered groups (do not contain selected contact): " + groups);
    GroupData group = groups.iterator().next();
    int groupId = group.getId();
    System.out.println("Group ID is: " + groupId);

    Contacts contactsInGroupBefore = new Contacts(app.contact().getContactsInGroup(group));
    System.out.println("Contacts in selected group: " + contactsInGroupBefore);

    app.goTo().homePage();
    app.contact().addToGroup(contact, group);
    System.out.println("Contact with ID " + contactId + " has been added to group " + group.withId(groupId));

    Groups updatedGroups = app.db().groups();
    System.out.println("How many groups after: " + updatedGroups.size());


    for (GroupData groupFinal : updatedGroups) {

      if (groupFinal.getId() == groupId) {

        Contacts contactsInGroupAfter = new Contacts(app.contact().getContactsInGroup(groupFinal));
        System.out.println("Contacts in group after adding a contact: " + contactsInGroupAfter);

        assertThat(contactsInGroupAfter, equalTo(contactsInGroupBefore.withAdded(contact)));
        System.out.println("Contact has been added for sure!");
      }
    }
  }
}

