package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && array.length > 1) {
			int position = leftIndex + 1;
			
			while (position <= rightIndex) {
				if (array[position].compareTo(array[position - 1]) >= 0) {
					position++;
				} else {
					Util.swap(array, position, position - 1);
					if (position > leftIndex + 1) {
						position--;
					} else {
						position++;
					}
				}
			}
		}
	}
}
