package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactDeletionTests extends TestBase {

  @Test

  public void testContactDeletion() {

    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new NewContactData(
              "Daria",
              "Zamotorina",
              "Dara",
              "QA Engineer",
              "1234567890",
              "7987987987",
              "0980980980",
              "daraz@gmail.com",
              "11",
              "June",
              "1986",
              "qiwueiuye Rd",
              "2456",
              "test1"),
              true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().closeAlert();
    app.getNavigationHelper().gotoHomePage();

  }
}
