package ru.stqa.pft.addressbook.model;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NewContactData that = (NewContactData) o;
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(group, that.group);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, group);
  }

  @Override
  public String toString() {
    return "NewContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", group='" + group + '\'' +
            '}';
  }

}
