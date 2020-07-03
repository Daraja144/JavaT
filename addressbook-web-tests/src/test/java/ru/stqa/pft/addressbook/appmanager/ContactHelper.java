package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }


  public void submitNewContactForm() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillNewContactForm(ContactData ContactData, boolean creation) {
    type(By.name("firstname"), ContactData.getFirstname());
    type(By.name("lastname"), ContactData.getLastname());
    //type(By.name("address"), ContactData.getAddress());
    //type(By.name("email"), ContactData.getEmail());
    //type(By.name("email2"), ContactData.getEmail2());
    //type(By.name("email3"), ContactData.getEmail3());
    type(By.name("home"), ContactData.getHomePhone());
    type(By.name("mobile"), ContactData.getMobilePhone());
    type(By.name("work"), ContactData.getWorkPhone());
    //attach(By.name("photo"), ContactData.getPhoto());

    if (creation) {
      if (ContactData.getGroups().size() > 0) {
        Assert.assertTrue(ContactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(ContactData.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void fillInfoContactForm(ContactData ContactData, boolean creation) {
    type(By.name("firstname"), ContactData.getFirstname());
    type(By.name("lastname"), ContactData.getLastname());
    type(By.name("address"), ContactData.getAddress());
    type(By.name("email"), ContactData.getEmail());
    type(By.name("email2"), ContactData.getEmail2());
    type(By.name("email3"), ContactData.getEmail3());
    type(By.name("home"), ContactData.getHomePhone());
    type(By.name("mobile"), ContactData.getMobilePhone());
    type(By.name("work"), ContactData.getWorkPhone());
    //attach(By.name("photo"), ContactData.getPhoto());

    if (creation) {
      if (ContactData.getGroups().size() > 0) {
        Assert.assertTrue(ContactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(ContactData.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactModificationById(int id) {
    //wd.findElement(By.cssSelector("input[value='"+ id +"']")).findElement(By.xpath("//img[@alt='Edit']")).click();
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }
  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='"+ id +"']")).click();
  }

  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='"+ id +"']")).click();
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

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    closeAlert();
    contactCache = null;
    gotoHomePage();
  }

  public void create(ContactData contact, boolean b) {
    gotoAddNewPage();
    fillNewContactForm(contact,
            true);
    submitNewContactForm();
    contactCache = null;
    gotoHomePage();
  }
  public void createInfo(ContactData contact, boolean b) {
    gotoAddNewPage();
    fillInfoContactForm(contact,
            true);
    submitNewContactForm();
    contactCache = null;
    gotoHomePage();
  }
  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillNewContactForm(contact, false);
    submitContactModification();
    contactCache = null;
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

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));

    for (WebElement element : elements) {

      List<WebElement> cells = element.findElements(By.tagName("td"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allemails = cells.get(4).getText();
      String allphones = cells.get(5).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAddress(address).withAllEmails(allemails)
              .withAllPhones(allphones);
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");

    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withHomePhone(home).withMobilePhone(mobile)
            .withWorkPhone(work).withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);
  }

  public void deleteAllContacts() {
    selectAll();
    deleteContact();
    closeAlert();
    contactCache = null;
    gotoHomePage();

  }

  private void selectAll() {
    wd.findElement(By.id("MassCB")).click();
  }

  public void addToGroup(ContactData contact, GroupData group) {
    selectContactById(contact.getId());
    new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(group.getName());
    wd.findElement(By.name("add")).click();
  }

  public void deleteFromGroup(ContactData contact, GroupData group) {
    new Select(wd.findElement(By.name("group"))).selectByVisibleText(group.getName());
    selectContactById(contact.getId());
    wd.findElement(By.name("remove")).click();
  }
}
