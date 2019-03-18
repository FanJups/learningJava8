package streamstringmanipulations;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strings = { "Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet" };

		// display original strings

		System.out.println("Original strings : " + Arrays.asList(strings));

		// strings in uppercase

		System.out
				.println("Uppercase : " + Arrays.stream(strings).map(String::toUpperCase).collect(Collectors.toList()));

		// strings less than "n" (case insensitive) sorted ascending

		System.out.println("strings less than \"n\" (case insensitive) sorted ascending : "
				+ Arrays.stream(strings).filter(s -> s.compareToIgnoreCase("n") < 0)
						.sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList()));

		// strings less than "n" (case insensitive) sorted descending

		System.out.println("strings less than \"n\" (case insensitive) sorted descending : "
				+ Arrays.stream(strings).filter(s -> s.compareToIgnoreCase("n") < 0)
						.sorted(String.CASE_INSENSITIVE_ORDER.reversed()).collect(Collectors.toList()));

	}

}
