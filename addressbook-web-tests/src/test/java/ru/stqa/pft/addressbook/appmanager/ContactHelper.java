package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.NewContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }


  public void submitNewContactForm(TestBase testBase) {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillNewContactForm(NewContactData newContactData, TestBase testBase) {
    type(By.name("firstname"), newContactData.getFirstname());
    type(By.name("lastname"), newContactData.getLastname());
    type(By.name("nickname"), newContactData.getNickname());
    type(By.name("title"), newContactData.getTitle());
    type(By.name("home"), newContactData.getHomenumber());
    type(By.name("mobile"), newContactData.getMobile());
    type(By.name("work"), newContactData.getWorknumber());
    type(By.name("email"), newContactData.getEmail());
    selectDay(By.name("bday"), newContactData.getBday());
    selectMonth(By.name("bmonth"), newContactData.getBmonth());
    type(By.name("byear"), newContactData.getByear());
    type(By.name("address2"), newContactData.getAddress());
    type(By.name("phone2"), newContactData.getHome());
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }
}
