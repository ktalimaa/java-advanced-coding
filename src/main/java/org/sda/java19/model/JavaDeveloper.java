package org.sda.java19.model;

public class JavaDeveloper extends Developer {

    private String company;

    private int workExperience;

    // constructor
    public JavaDeveloper(String name, int age, boolean isMale, String email, String company, int workExperience) {
        super(name, age, isMale, email);
        this.company = company;
        this.workExperience = workExperience;
    }

    // getter
    public String getCompany() {
        return company;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    // setter
    public void setCompany(String company) {
        this.company = company;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    // toString
    @Override
    public String toString() {
        return "JavaDeveloper{" +
                "company='" + company + '\'' +
                ", workExperience=" + workExperience +
                '}';
    }

    // Overload method from the Person class in JavaDeveloper class to accept additional parameters.
    // It can be also in Person class
    // Method overwriting - Method name and method parameter are same
    // Method overloading - same method name, but different number of parameters
    public void setName(String firstName, String lastName) {
        super.setName(firstName.concat(lastName));
    }
}
