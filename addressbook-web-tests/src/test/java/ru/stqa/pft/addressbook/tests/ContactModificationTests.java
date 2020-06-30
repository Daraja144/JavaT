package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      Groups groups = app.db().groups();
      app.goTo().homePage();
      app.contact().create(new ContactData().withFirstname("firstname 1").withLastname("lastname 1").inGroup(groups.iterator().next()), false);
    }
  }

  @Test
  public void testContactModification() {

    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("firstname 1").withLastname("lastname 1")
            .withHomePhone("home 1").withMobilePhone("mobile 1").withWorkPhone("777");

    app.goTo().homePage();
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}
