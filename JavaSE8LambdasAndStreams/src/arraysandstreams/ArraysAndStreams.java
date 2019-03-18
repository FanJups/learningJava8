package arraysandstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] values = { 2, 9, 5, 0, 3, 7, 1, 4, 8, 6 };

		// display original values
		System.out.println("Original values : " + Arrays.asList(values));

		// sort values in ascending order using streams

		System.out.printf("Sorted values : %s%n", Arrays.stream(values).sorted().collect(Collectors.toList()));

		// values greater than 4

		List<Integer> greaterThan4 = Arrays.stream(values).filter(value -> value > 4).collect(Collectors.toList());

		System.out.println("Values greater than 4 : " + greaterThan4);

		// filter values greater than 4 then sort the results

		System.out.println("Sorted values greater than 4 : "
				+ Arrays.stream(values).filter(value -> value > 4).sorted().collect(Collectors.toList()));

		// greaterThan4 List sorted with streams

		System.out.println("Values greater than 4 (ascending with streams) : "
				+ greaterThan4.stream().sorted().collect(Collectors.toList()));

	}

}
