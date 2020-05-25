package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class NewContactCreationTests extends TestBase {


  @Test
  public void testNewContactCreation() throws Exception {

    app.getNavigationHelper().gotoAddNewPage();
    app.getContactHelper().fillNewContactForm(new NewContactData("Daria", "Zamotorina", "Dara", "QA Engineer", "1234567890", "7987987987", "0980980980", "daraz@gmail.com", "11", "June", "1986", "qiwueiuye Rd", "2456"), NewContactCreationTests.this);
    app.getContactHelper().submitNewContactForm(NewContactCreationTests.this);
    app.getNavigationHelper().gotoHomePage();

  }

}
