package ru.stqa.pft.github.rest;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestAssuredTests extends TestBase{

  public RestAssuredTests() {
    super();
  }

  @BeforeSuite(enabled = true)
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
  public void testIsIssueOpen() throws IOException {
    boolean issueOpen = isIssueOpen(1);
    System.out.println("Issue is open: " + issueOpen);
  }

}
