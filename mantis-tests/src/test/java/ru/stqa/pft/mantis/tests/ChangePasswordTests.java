package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertTrue;


  public class ChangePasswordTests extends TestBase {

    //@BeforeMethod
    public void startMailServer() {
      app.mail().start();
    }

    @Test
    public void testChangePassword() throws IOException, MessagingException {
      long now = System.currentTimeMillis();
      String password = String.format("password%s", now);

      app.registration().loginWithAdmin();
      app.getDriver().get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
      HashMap<String, String> cred = app.registration().selectUser();
      List<MailMessage> mailMessages = app.mail().waitForMail(0, 10000);
      String confirmationLink = findConfirmationLink(mailMessages, cred.get("email"));
      app.registration().finish(confirmationLink, cred.get("user"), password);
      assertTrue(app.newSession().login(cred.get("user"), password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
      MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
      VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
      return regex.getText(mailMessage.text);
    }

   // @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
      app.mail().stop();
    }
  }
