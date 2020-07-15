package ru.stqa.pft.rest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestAssuredTests extends TestBase{

  @BeforeMethod
  public void before() throws IOException {
    skipIfNotFixed(45);
  }

  @Test
  public void testCreateIssue() throws IOException, InterruptedException {
    Set<Issue> oldIssues = getIssues();
    Issue newIssue = new Issue().withSubject("Test issue").withDescription("New test issue");
    int issueId = createIssue(newIssue);
    Set<Issue> newIssues = getIssues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }

  @Test
  public void testIsIssueClosed() throws IOException {
    boolean issueClosed = isIssueClosed(45);
    System.out.println("Issue is closed: " + issueClosed);
  }

}
