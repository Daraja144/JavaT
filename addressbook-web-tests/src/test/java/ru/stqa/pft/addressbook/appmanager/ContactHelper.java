package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.NewContactData;

import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }


  public void submitNewContactForm() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillNewContactForm(NewContactData newContactData, boolean creation) {
    type(By.name("firstname"), newContactData.getFirstname());
    type(By.name("lastname"), newContactData.getLastname());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(newContactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void selectContact(int index) {

    wd.findElements(By.name("selected[]")).get(index).click();

  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public void gotoAddNewPage() {
    if (isElementPresent(By.name("new_group"))) {
      return;
    }
    click(By.linkText("add new"));
  }

  public void createContact(NewContactData contact, boolean b) {
    gotoAddNewPage();
    fillNewContactForm(contact,
            true);
    submitNewContactForm();
    gotoHomePage();
  }

  private void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }


  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<NewContactData> getContactList() {
    List<NewContactData> contacts = new ArrayList<NewContactData>();

    //List<WebElement> cells = element.findElements("td");
    List<WebElement> elements = wd.findElements(By.cssSelector("tr"));
    for (WebElement element : elements) {
      String name = element.getText();
      NewContactData contact = new NewContactData(
              name,
              name,
              null);
      contacts.add(contact);
    }
    return contacts;
  }
}
