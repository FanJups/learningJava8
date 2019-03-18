package intstreamoperations;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class IntStreamOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Same process for LongStream and DoubleStream

		int[] values = { 3, 10, 6, 1, 4, 8, 2, 5, 9, 7 };

		IntPredicate even = value -> value % 2 == 0;
		IntPredicate greaterThan5 = value -> value > 5;

		// display original values
		System.out.print("Original values: ");

		IntStream.of(values).forEach(value -> System.out.print(value + " ")); // only one line instead of at least 2
																				// lines with for or while, powerful

		System.out.println();

		// summaryStatictics
		System.out.println("Summary Stats : " + IntStream.of(values).summaryStatistics());

		// count min max sum average of the values
		System.out.println("Count :" + IntStream.of(values).count());
		System.out.println("Min :" + IntStream.of(values).min().getAsInt());
		System.out.println("Max :" + IntStream.of(values).max().getAsInt());
		System.out.println("Sum :" + IntStream.of(values).sum());

		System.out.println("Average :" + IntStream.of(values).average().getAsDouble());

		// sum of values with reduce method
		System.out.println("Sum via reduce method :" + IntStream.of(values).reduce(0, (x, y) -> x + y));

		// sum of squares with reduce method
		System.out.println("Sum of squares via reduce method :" + IntStream.of(values).reduce(0, (x, y) -> x + y * y));

		// product of values with reduce method
		System.out.println("Product of values via reduce method :" + IntStream.of(values).reduce(1, (x, y) -> x * y));

		// even values displayed in sorted order
		System.out.print("even values displayed in sorted order: ");

		IntStream.of(values).filter(value -> value % 2 == 0).sorted().forEach(value -> System.out.print(value + " "));

		System.out.println();

		// even values greater than 5 displayed in sorted order
		System.out.print("even values greater than 5 displayed in sorted order: ");

		IntStream.of(values).filter(even.and(greaterThan5)).sorted().forEach(value -> System.out.print(value + " "));

		System.out.println();

		// odd values displayed in sorted order

		System.out.print("odd values displayed in sorted order: ");

		IntStream.of(values).filter(value -> value % 2 != 0).sorted().forEach(value -> System.out.print(value + " "));

		System.out.println();

		// odd values multiplied by 10 and displayed in sorted order

		System.out.print("odd values multiplied by 10 and  displayed in sorted order : ");

		IntStream.of(values).filter(value -> value % 2 != 0).map(value -> value * 10).sorted()
				.forEach(value -> System.out.print(value + " "));

		System.out.println();

		// sum range of integers from 1 to 10, exclusive
		System.out.println("sum of integers from 1 to 9 : " + IntStream.range(1, 10).sum());

		// sum range of integers from 1 to 10, inclusive
		System.out.println("sum of integers from 1 to 10 : " + IntStream.rangeClosed(1, 10).sum());

	}

}
