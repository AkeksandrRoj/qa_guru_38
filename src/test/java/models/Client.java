package models;

import java.util.List;

public class Client {


        public int id;
        public String name;
        public int age;
        public String email;
        public boolean isActive;
        public Address address;
        public List<Contact> contacts;


        public static class Address {
            public String city;
            public String street;
        }


        public static class Contact {
            public String type;
            public String value;
        }
    }

