package ru.stqa.pft.addressbook.model;

public class NewContactData {
  private String firstname;
  private String lastname;
  private String group;

  public NewContactData(String firstname, String lastname, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getGroup() { return group;
  }
}
