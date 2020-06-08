package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.List;

public class NewContactCreationTests extends TestBase {


  @Test
  public void testNewContactCreation() throws Exception {

    app.getContactHelper().gotoAddNewPage();
    List<NewContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().fillNewContactForm(new NewContactData("Daria", "Zamotorina", "test1"), true);
    app.getContactHelper().submitNewContactForm();
    app.getNavigationHelper().gotoHomePage();
    List<NewContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() +1);


  }

}
