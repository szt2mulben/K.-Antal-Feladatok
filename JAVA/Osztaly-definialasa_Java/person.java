public class person {
    private String firstName;
    private String lastName;
    private int birthYear;
    private int birthMonth;
    private int birthDay;

    public person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = 0;
        this.birthMonth = 0;
        this.birthDay = 0;
    }

    public void printPerson() {
        System.out.println("Vezetéknév: " + lastName);
        System.out.println("Utónév: " + firstName);
        System.out.println("Születési idő: " + birthYear + "." + formatNumber(birthMonth) + "." + formatNumber(birthDay) + ".");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

  
    public void setBirthdate(int birthYear, int birthMonth, int birthDay) {
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }
    

    private String formatNumber(int number) {
        return (number < 10) ? "0" + number : String.valueOf(number);
    }

    public static void main(String[] args) {
        person person = new person("John", "Doe");
        person.printPerson();
        
        person.setBirthdate(1990, 5, 15);
        person.printPerson();
    }

}


