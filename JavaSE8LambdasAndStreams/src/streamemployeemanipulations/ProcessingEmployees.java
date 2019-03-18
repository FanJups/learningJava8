package streamemployeemanipulations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProcessingEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// initialize array of Employees

		Employee[] employees = { new Employee("Jason", "Red", 5000, "IT"), new Employee("Ashley", "Green", 7600, "IT"),
				new Employee("Matthew", "Indigo", 3587.5, "Sales"),
				new Employee("James", "Indigo", 4700.77, "Marketing"), new Employee("Luke", "Indigo", 6200, "IT"),
				new Employee("Jason", "Blue", 3200, "Sales"), new Employee("Wendy", "Brown", 4236.4, "Marketing") };

		// get list view of the Employees

		List<Employee> list = Arrays.asList(employees);

		// display all employees

		System.out.println("Complete Employees list : ");
		list.stream().forEach(System.out::println);

		System.out.println();

		// predicate that returns true for salaries in the range $4000-$6000
		Predicate<Employee> fourToSixThousand = e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

		// display employees with salaries in the range $4000-$6000
		// sorted into ascending order by salary

		System.out.println("Employees earning $4000-$6000 per month sorted by salary into ascending order : ");
		list.stream().filter(fourToSixThousand).sorted(Comparator.comparing(Employee::getSalary))
				.forEach(System.out::println);

		// display employees with salaries in the range $4000-$6000
		// sorted into descending order by salary

		System.out.println("Employees earning $4000-$6000 per month sorted by salary into descending order : ");
		list.stream().filter(fourToSixThousand).sorted(Comparator.comparing(Employee::getSalary).reversed())
				.forEach(System.out::println);

		// display first Employee with salary in the range $4000-$6000
		System.out.println("First Employee who earns $4000-$6000  : ");

		System.out.println(list.stream().filter(fourToSixThousand).findFirst().get());

		/*
		 * // display first Employee with salary in the range $4000-$6000 System.out
		 * .println(list.stream().filter(fourToSixThousand).max(Comparator.comparing(
		 * Employee::getSalary)).get());
		 * 
		 */

		// display last Employee with salary in the range $4000-$6000
		System.out.println("Last Employee who earns $4000-$6000  : ");

		System.out
				.println(list.stream().filter(fourToSixThousand).min(Comparator.comparing(Employee::getSalary)).get());

		// Functions from getting first and last names form an employee

		Function<Employee, String> byFirstName = Employee::getFirstName;
		Function<Employee, String> byLastName = Employee::getLastName;
		Function<Employee, String> byName = Employee::getName;

		// Comparator for comparing Employees by first name then last name

		Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);

		// sort employees by last name then first name

		System.out.println("Employees in ascending order by last name then first : ");
		list.stream().sorted(lastThenFirst).forEach(System.out::println);

//sort employees in descending order  by last name then first name

		System.out.println("Employees in descending order by last name then first : ");
		list.stream().sorted(lastThenFirst.reversed()).forEach(System.out::println);

		// display unique employee last names sorted

		System.out.println("Unique Employee last names : ");
		list.stream().map(byLastName).distinct().sorted().forEach(System.out::println);

		// display only first and last names

		System.out.println("Unique Employee last names : ");
		list.stream().sorted(lastThenFirst).map(byName).forEach(System.out::println);

	}

}
