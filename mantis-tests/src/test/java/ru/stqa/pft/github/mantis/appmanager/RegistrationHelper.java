package ru.stqa.pft.github.mantis.appmanager;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.stream.Collectors;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.name;

public class RegistrationHelper extends HelperBase {

  public RegistrationHelper(ApplicationManager app) {
    super(app);
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
    type(name("username"), username);
    type(name("email"), email);
    click(cssSelector("input[value='Signup']"));

  }

  public void finish(String confirmationLink, String username, String password) {
    wd.get(confirmationLink);
    type(name("realname"), username);
    type(name("password"), password);
    type(name("password_confirm"), password);
    click(cssSelector("[type=submit]"));
  }

  public void loginAsAdmin() {
    type(name("username"), app.getProperty("web.adminLogin"));
    click(cssSelector("[type=submit]"));
    type(name("password"), app.getProperty("web.adminPassword"));
    click(cssSelector("[type=submit]"));
  }

  public HashMap<String, String> selectUser() {
    HashMap<String, String> result = new HashMap<>();
    app.getDriver().findElements(By.cssSelector("tbody [href]"))
            .stream().filter(user -> !user.getText().equals("administrator")).collect(Collectors.toList())
            .get(0).click();
    result.put("user", app.getDriver().findElement(name("username")).getAttribute("value"));
    result.put("email", app.getDriver().findElement(name("email")).getAttribute("value"));
    app.getDriver().findElement(By.cssSelector("[value='Reset Password']")).click();
    return result;
  }
}
