public class Person implements Serializable {
    private String name;
    private String surname;
    private String address;
    private String email;
    private String passportCode;

    private Person spouse;
    private List<Person> children;

    public Person(String name, String surname ) {
        this.name = name;
        this.surname = surname;

    }

    public Person(String name, String surname, String address, String email ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;

    }

    public String getFullName(){
        return name + " " + surname;
    }

    /*
     * Getters and setters for private fields
     */

    String getName() {
        return name
    }

    String getSurname() {
        return surname
    }

    String getAddress() {
        return address
    }

    String getEmail() {
        return email
    }

    void setName(String name) {
        this.name = name
    }

    void setSurname(String surname) {
        this.surname = surname
    }

    void setAddress(String address) {
        this.address = address
    }

    void setEmail(String email) {
        this.email = email
    }
}