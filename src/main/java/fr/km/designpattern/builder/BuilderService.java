package fr.km.designpattern.builder;

import java.util.Date;

public class BuilderService {

    public static void main(String[] args) {
        final Address address = new Address.Builder()
                .withStreet("122 Rue de Belleville")
                .withZipCode("75020")
                .withCity("Paris")
                .build();

        final Contact contact = new Contact.Builder()
                .withEmail("aa@aa.com")
                .withFirstName("John")
                .withLastName("LABEL")
                .withPhone("0102020211")
                .build();

        final Account account = new Account.Builder()
                .withAddress(address)
                .withContact(contact)
                .withId(152414411)
                .withStartDate(new Date())
                .build();
    }
}

class Account{

    private Integer id;
    private Date startDate;
    private Contact contact;
    private Address address;

    private Account(Builder builder) {
        this.id = builder.id;
        this.startDate = builder.startDate;
        this.contact = builder.contact;
        this.address = builder.address;
    }

    public Integer getId() {
        return id;
    }



    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static class Builder{
        private Integer id;
        private Date startDate;
        private Contact contact;
        private Address address;

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }
        public Builder withStartDate(Date startDate){
            this.startDate = startDate;
            return this;
        }
        public Builder withContact(Contact contact){
            this.contact = contact;
            return this;
        }
        public Builder withAddress(Address address){
            this.address = address;
            return this;
        }

        public Account build(){
            return new Account(this);
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public Contact getContact() {
            return contact;
        }

        public void setContact(Contact contact) {
            this.contact = contact;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

    }
}

class Address{
    private String street;
    private String zipCode;
    private String city;

    private Address(Builder builder) {
        this.street = builder.street;
        this.zipCode = builder.zipCode;
        this.city = builder.city;
    }

    public static class Builder{
        private String street;
        private String zipCode;
        private String city;

        public Builder withStreet(String street){
            this.street = street;
            return this;
        }
        public Builder withZipCode(String zipCode){
            this.zipCode = zipCode;
            return this;
        }
        public Builder withCity(String city){
            this.city = city;
            return this;
        }

        public Address build(){
            return new Address(this);
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

    }
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

class Contact {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    private Contact(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phone = builder.phone;
        this.email = builder.email;
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private String phone;
        private String email;

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Contact build(){
            return new Contact(this);
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}