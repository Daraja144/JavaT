package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillNewContactForm(new NewContactData(
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
                    "2456"),
            ContactModificationTests.this);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();






  }
}
