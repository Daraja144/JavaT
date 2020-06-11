package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class NewContactData {


  public int id;
  public String firstname;
  public String lastname;
  public String group;


  public NewContactData(String firstname, String lastname, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.lastname = lastname;
    this.group = group;
  }

  public NewContactData(int id, String firstname, String lastname, String group) {

    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.group = null;
  }

  public int getId() { return id; }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getGroup() { return group;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "NewContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NewContactData that = (NewContactData) o;
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname);
  }
}
