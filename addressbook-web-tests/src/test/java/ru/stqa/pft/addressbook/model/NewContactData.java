package ru.stqa.pft.addressbook.model;

public class NewContactData {
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String homenumber;
  private final String mobile;
  private final String worknumber;
  private final String email;
  private final String bday;
  private final String bmonth;
  private final String byear;
  private final String address;
  private final String home;
  private final String group;

  public NewContactData(String firstname, String lastname, String nickname, String title, String homenumber, String mobile, String worknumber, String email, String bday, String bmonth, String byear, String address, String home, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.homenumber = homenumber;
    this.mobile = mobile;
    this.worknumber = worknumber;
    this.email = email;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.address = address;
    this.home = home;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getHomenumber() {
    return homenumber;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWorknumber() {
    return worknumber;
  }

  public String getEmail() {
    return email;
  }

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }

  public String getAddress() {
    return address;
  }

  public String getHome() {
    return home;
  }

  public String getGroup() {
    return group;
  }
}
