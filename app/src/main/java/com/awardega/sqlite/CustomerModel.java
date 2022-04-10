package com.awardega.sqlite;

public class CustomerModel {

    private int id;
    private String name;
    private String surname;
    private String country;
    private String sex;
    private int phoneNumber;

    public CustomerModel(int id, String name, String surname, String country, String sex, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
    }

    public CustomerModel() {
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
