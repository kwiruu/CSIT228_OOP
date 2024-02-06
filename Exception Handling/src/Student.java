public class Student extends Person{
    int studentID;

    public Student(int age, String name, int studentID) throws InvalidAgeException {
        super(age, name);
        this.studentID = studentID;
    }

}
