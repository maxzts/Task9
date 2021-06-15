package com.company;

public class Person {

    private String firstName, lastName;
    private Address address;

    public Person(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return (getFirstname() + " " + getLastname() + ", Address: " + address.getHouseNumber() + ", " +
                address.getStreet() + ", " +  address.getCity()  + ";");
    }


    public void findNullFieldException () throws NullFieldException{
        System.out.print("Поля со значением null присутсвуют: ");
        if(getFirstname() != null && getLastname() != null && getAddress() != null){
            System.out.println("false");
        }
        else { throw new NullFieldException("true");}

    }


}
