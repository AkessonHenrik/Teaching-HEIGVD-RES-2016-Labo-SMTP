package app;

public class Person {
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private String firstName;
    private String lastName;
    private String email;

    public Person(String email) {
        this.email = email;
        this.firstName = "";
        this.lastName = "";
        this.firstName += email.substring(0, email.indexOf('.'));
        this.lastName += email.substring(email.indexOf('.') + 1, email.indexOf('@'));
    }

    public String getEmail() {
        return email;
    }
}