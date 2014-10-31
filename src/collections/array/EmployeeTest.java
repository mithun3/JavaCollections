package collections.array;

public class EmployeeTest {
  public static void main(String[] args) {
    Employee[] staff = new Employee[3];
    staff[0] = new Employee("Harry Hacker", 3500);
    staff[1] = new Employee("Carl Cracker", 7500);
    staff[2] = new Employee("Tony Tester", 3800);

    for (int i = 0; i < 3; i++)
      staff[i].print();
  }
}

class Employee {
  private String name;

  private double salary;

  public Employee(String n, double s) {
    name = n;
    salary = s;
  }

  public void print() {
    System.out.println(name + " " + salary);
  }
}