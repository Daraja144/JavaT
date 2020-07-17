package ru.stqa.pft.github.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.github.addressbook.model.ContactData;
import ru.stqa.pft.github.addressbook.model.Groups;

import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInfoTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    Groups groups = app.db().groups();
    app.goTo().homePage();
    if (app.contact().all().size()==0) {
        app.contact().createInfo(new ContactData().withFirstname("Daria").withLastname("Zamotorina")
              .inGroup(groups.iterator().next()).withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withEmail("aaa").withEmail2("bbb").withEmail3("ccc")
              .withAddress("ddd"),false);
      }
    if (app.contact().all().size()!=0) {
      app.contact().deleteAllContacts();
      app.contact().createInfo(new ContactData().withFirstname("Daria").withLastname("Zamotorina")
              .inGroup(groups.iterator().next()).withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withEmail("aaa").withEmail2("bbb").withEmail3("ccc")
              .withAddress("ddd"),false);
    }
  }

  @Test()
  public void testContactInfo () {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    assertThat(contact.getAllemails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    assertThat(contact.getAllphones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(" "))
            .map(ContactInfoTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(" "))
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
