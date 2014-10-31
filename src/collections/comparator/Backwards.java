package collections.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Backwards {
  public static void main(String args[]) {
    Employee1 emps[] = { new Employee1("Finance", "Degree, Debbie"),
        new Employee1("Finance", "Grade, Geri"),
        new Employee1("Finance", "Extent, Ester"),
        new Employee1("Engineering", "Measure, Mary"),
        new Employee1("Engineering", "Amount, Anastasia"),
        new Employee1("Engineering", "Ratio, Ringo"),
        new Employee1("Sales", "Stint, Sarah"),
        new Employee1("Sales", "Pitch, Paula"),
        new Employee1("Support", "Rate, Rhoda") };
    SortedSet set = new TreeSet(Arrays.asList(emps));
    System.out.println(set);

    try {
      Object last = set.last();
      boolean first = true;
      while (true) {
        if (!first) {
          System.out.print(", ");
        }
        System.out.println(last);
        last = set.headSet(last).last();
      }
    } catch (NoSuchElementException e) {
      System.out.println();
    }

    Set subset = set.headSet(emps[4]);
    subset.add(emps[5]);

  }
}

class EmpComparator1 implements Comparator {

  public int compare(Object obj1, Object obj2) {
    Employee1 emp1 = (Employee1) obj1;
    Employee1 emp2 = (Employee1) obj2;

    int nameComp = emp1.getName().compareTo(emp2.getName());

    return ((nameComp == 0) ? emp1.getDepartment().compareTo(
        emp2.getDepartment()) : nameComp);
  }
}

class Employee1 implements Comparable {
  String department, name;

  public Employee1(String department, String name) {
    this.department = department;
    this.name = name;
  }

  public String getDepartment() {
    return department;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return "[dept=" + department + ",name=" + name + "]";
  }

  public int compareTo(Object obj) {
    Employee1 emp = (Employee1) obj;
    int deptComp = department.compareTo(emp.getDepartment());

    return ((deptComp == 0) ? name.compareTo(emp.getName()) : deptComp);
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof Employee1)) {
      return false;
    }
    Employee1 emp = (Employee1) obj;
    return department.equals(emp.getDepartment())
        && name.equals(emp.getName());
  }

  public int hashCode() {
    return 31 * department.hashCode() + name.hashCode();
  }
} 
 
 
