package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;
import java.util.Comparator;
import java.util.List;

public class NewContactCreationTests extends TestBase {


  @Test
  public void testNewContactCreation() throws Exception {

    app.getNavigationHelper().gotoHomePage();
    List<NewContactData> before = app.getContactHelper().getContactList();
    NewContactData contact = new NewContactData("Daria",
            "Zamotorina", "test1");
    app.getContactHelper().createContact(contact, true);
    List<NewContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() +1);


    before.add(contact);
    Comparator<? super NewContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }



}
