package ru.stqa.pft.github.mantis.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.github.mantis.model.Issue;
import ru.stqa.pft.github.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class SoapTests extends TestBase {

  @BeforeMethod
  public void before() throws RemoteException, ServiceException, MalformedURLException {
    skipIfNotFixed(4);
  }

  @Test
  public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    for (Project project : projects) {
      System.out.println(project.getName());
    }
  }

  @Test
  public void testCreateIssue() throws MalformedURLException, ServiceException, RemoteException {
    Set<Project> projects = app.soap().getProjects();

    Issue issue = new Issue().withSummary("test issue")
            .withDescription("test issue description").withProject(projects.iterator().next());
    Issue created = app.soap().addIssue(issue);
    assertEquals(issue.getSummary(), created.getSummary());

  }

  @Test
  public void testShowIssueStatus() throws RemoteException, ServiceException, MalformedURLException {
    String issueStatus = app.soap().getIssueStatus(1);
    System.out.println("Issue status is: " + issueStatus);
  }

}
