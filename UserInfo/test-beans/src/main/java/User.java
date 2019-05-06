import java.sql.Date;


public class User {
    public static GenderType.gendertype gendertype;

    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;
    private String gender;



    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public User(Integer id, String firstName, String middleName, String lastName, Date birthDate, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User(Integer id, String firstName, String lastName, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "first-name='" + firstName + '\'' +
                ",last-name='" + lastName + '\'' +
                '}';
    }


}