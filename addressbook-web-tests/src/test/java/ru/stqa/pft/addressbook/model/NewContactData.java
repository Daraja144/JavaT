package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class NewContactData {
  private String id;
  private String firstname;
  private String lastname;
  private String group;

  public NewContactData(String id, String firstname, String lastname, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.group = group;
  }

  public NewContactData(String firstname, String lastname, String group) {
    this.id = null;
    this.firstname = firstname;
    this.lastname = lastname;
    this.group = group;
  }

  public String getId() { return id; }

  public String getFirstname() {
    return firstname;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NewContactData that = (NewContactData) o;
    return Objects.equals(id, that.id) &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }

  @Override
  public String toString() {
    return "NewContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public String getLastname() {
    return lastname;
  }

  public String getGroup() { return group;
  }

}
