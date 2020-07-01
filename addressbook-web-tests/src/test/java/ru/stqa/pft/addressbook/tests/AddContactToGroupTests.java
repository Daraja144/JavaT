package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

public class AddContactToGroupTests extends TestBase {

  @Test
  public void testAddContactToGroup() {
    //Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    app.goTo().homePage();
    ContactData selectedContact = before.iterator().next();
    app.contact().selectContactById(selectedContact.getId());

    wd.findElement(By.name("to_group")).click();
    selectGroupFromList();
    wd.findElement(By.name("add")).click();
    wd.findElement(By.linkText("home")).click();
  }

  public void selectGroupFromList() {
    new Select(wd.findElement(By.name("to_group"))).selectByValue("111");
  }
}
