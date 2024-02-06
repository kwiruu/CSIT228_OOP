public class Person {
    int age;
    String name;

    Person(int age, String name) throws InvalidAgeException {
        this.age = age;
        this.name = name;
        if(age<0){
            throw new InvalidAgeException("Invalid Age!");
        }
    }

    public void Birthday(){
        int oldAge = age;
        age++;
        System.out.println("Happy Birthday!! You are now "+ age + " years old!");
        assert age > oldAge : "Age must increase on birthday!!";
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "My age is " + age + ", My name is " + name;
    }
}
