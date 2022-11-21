package org.sda.java19.model;

public class Developer extends Person {

    private boolean isMale;

    private String email;


    // constructor
    public Developer(String name, int age, boolean isMale, String email) {
        super(name, age);
        this.isMale = isMale;
        this.email = email;
    }

    // getter
    public boolean isMale() {
        return isMale;
    }

    public String getEmail() {
        return email;
    }

    // setter
    public void setMale(boolean male) {
        isMale = male;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString
    @Override
    public String toString() {
        return "Developer{" +
                "isMale=" + isMale +
                ", email='" + email + '\'' +
                '}';
    }
}
