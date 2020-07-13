package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestBase {

  protected static ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
  public WebDriver wd;

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File(app.getProperty("ftp_client") + "config_inc.php"), "config_inc.php", "config_inc.php.bak");
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws IOException {
    app.ftp().restore("config_inc.php.bak", "config_inc.php");
    app.stop();
  }

  private boolean isIssueOpen(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    if (app.soap().getIssueStatus(issueId).equals("closed")){
      return false;
    }
    return true;
  }

  public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}
