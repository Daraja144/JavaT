package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.tests.TestBase;

public class SessionHelper extends HelperBase {

  public SessionHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {

    type(By.name("user"), username);
    type(By.name("pass"), password);
    click(By.xpath("//input[@value='Login']"));
  }

  public void logout(TestBase testBase) {
    testBase.wd.findElement(By.linkText("Logout")).click();
  }
}
