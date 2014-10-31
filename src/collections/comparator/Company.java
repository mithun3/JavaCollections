package collections.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Company {
  public static void main(String args[]) {
    Employee2 emps[] = { new Employee2("Finance", "Degree, Debbie"),
        new Employee2("Finance", "Grade, Geri"),
        new Employee2("Finance", "Extent, Ester"),
        new Employee2("Engineering", "Measure, Mary"),
        new Employee2("Engineering", "Amount, Anastasia"),
        new Employee2("Engineering", "Ratio, Ringo"),
        new Employee2("Sales", "Stint, Sarah"),
        new Employee2("Sales", "Pitch, Paula"),
        new Employee2("Support", "Rate, Rhoda"), };
    Set set = new TreeSet(Arrays.asList(emps));
    System.out.println(set);
    Set set2 = new TreeSet(Collections.reverseOrder());
    set2.addAll(Arrays.asList(emps));
    System.out.println(set2);

    Set set3 = new TreeSet(new EmpComparator());
    for (int i = 0, n = emps.length; i < n; i++) {
      set3.add(emps[i]);
    }
    System.out.println(set3);
  }
}

class EmpComparator2 implements Comparator {

  public int compare(Object obj1, Object obj2) {
    Employee2 emp1 = (Employee2) obj1;
    Employee2 emp2 = (Employee2) obj2;

    int nameComp = emp1.getName().compareTo(emp2.getName());

    return ((nameComp == 0) ? emp1.getDepartment().compareTo(
        emp2.getDepartment()) : nameComp);
  }
}

class Employee2 implements Comparable {
  String department, name;

  public Employee2(String department, String name) {
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
    Employee2 emp = (Employee2) obj;
    int deptComp = department.compareTo(emp.getDepartment());

    return ((deptComp == 0) ? name.compareTo(emp.getName()) : deptComp);
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof Employee2)) {
      return false;
    }
    Employee2 emp = (Employee2) obj;
    return department.equals(emp.getDepartment())
        && name.equals(emp.getName());
  }

  public int hashCode() {
    return 31 * department.hashCode() + name.hashCode();
  }
}