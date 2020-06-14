package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {


  public int id = Integer.MAX_VALUE;
  public String firstname;
  public String lastname;
  public String home;
  public String mobile;
  public String work;
  public String email;
  public String email2;
  public String email3;
  public String group;
  public String address;
  public String allphones;
  public String allemails;

  public String getAllphones() {
    return allphones;
  }

  public ContactData withAllPhones(String allphones) {
    this.allphones = allphones;
    return this;
  }

  public String getAllemails() {
    return allemails;
  }

  public ContactData withAllEmails(String allemails) {
    this.allemails = allemails;
    return this;
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
  public String getHomePhone() {
    return home;
  }

  public String getMobilePhone() {
    return mobile;
  }

  public String getWorkPhone() {
    return work;
  }

  public String getEmail() {
    return email;
  }
  public String getAddress() {
    return address;
  }
  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }


  public ContactData withId(int id) {
    this.id = id;
    return this;
  }
  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }
  public ContactData withHomePhone(String home) {
    this.home = home;
    return this;
  }
  public ContactData withMobilePhone(String mobile) {
    this.mobile = mobile;
    return this;
  }
  public ContactData withWorkPhone(String work) {
    this.work = work;
    return this;
  }
  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }
  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }
  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }
  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", home='" + home + '\'' +
            ", mobile='" + mobile + '\'' +
            ", work='" + work + '\'' +
            ", email='" + email + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", group='" + group + '\'' +
            ", address='" + address + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }
}
