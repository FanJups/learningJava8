package streamemployeemanipulations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

		Predicate<Employee> test = e -> (e.getSalary() >= 100000);

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

		// display l Employee with last salary in the range $4000-$6000
		System.out.println(" Employee with last salary who earns $4000-$6000  : ");

		System.out
				.println(list.stream().filter(fourToSixThousand).min(Comparator.comparing(Employee::getSalary)).get());

		// Functions from getting first and last names form an employee

		Function<Employee, String> byFirstName = Employee::getFirstName;
		Function<Employee, String> byLastName = Employee::getLastName;
		Function<Employee, String> byName = Employee::getName;

		// Name of first employee range 4000 - 6000

		System.out.println(" Name of first employee range 4000 - 6000 : "
				+ list.stream().filter(fourToSixThousand).map(byName).findFirst().orElse("none"));

		// Name of first employee

		// System.out.println(" Name of first employee : " +
		// list.stream().map(byName).findFirst().orElse("none"));

		// System.out.println(list.stream().filter(fourToSixThousand).findFirst().or);

		// Name of first employee salary >= 10000

		try {

			System.out.println(" test " + list.stream().filter(test).map(byName).findFirst().orElse("KO"));

		} catch (NoSuchElementException e) {

			System.out.println(" Name of first employee salary >= 10000 : null ");

		}

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

		// group Employees by department
		System.out.println("Employees by department :");

		Map<String, List<Employee>> groupedByDepartment = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		groupedByDepartment.forEach((department, employeesInDepartment) -> {
			System.out.println(department);
			employeesInDepartment.forEach(employee -> System.out.println(employee));
		});

		// count number of Employees in each department
		System.out.println("Count of Employees by department :");
		Map<String, Long> employeeCountByDepartment = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		employeeCountByDepartment
				.forEach((department, count) -> System.out.println(department + " has " + count + " employee(s)"));

		// sum of Employee salaries with DoubleStream sum method

		System.out.println(
				"Sum of employees salaries via (sum method) : " + list.stream().mapToDouble(Employee::getSalary).sum());

		// Calculate sum of employee salaries with stream reduce method

		System.out.println(" Sum of employees salaries (via reduce method) : "
				+ list.stream().mapToDouble(Employee::getSalary).reduce(0, (value1, value2) -> value1 + value2));

		// Average of employee salaries with doublestream average method

		System.out.println("Average of employees salaries : "
				+ list.stream().mapToDouble(Employee::getSalary).average().getAsDouble());

		/*
		 * System.out.println("Average of employees salaries : " +
		 * list.stream().mapToDouble(Employee::getSalary).average().orElse(40.2));
		 * 
		 */

	}

}
