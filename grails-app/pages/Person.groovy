public class Person implements Serializable {
    private String name;
    private String surname;
    private String address;
    private String email;
    private String passportCode;

    private Person spouse;
    private List<Person> children;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getFullName(){
        return name + " " + surname;
    }

    /*
     * Getters and setters for private fields
     */
}