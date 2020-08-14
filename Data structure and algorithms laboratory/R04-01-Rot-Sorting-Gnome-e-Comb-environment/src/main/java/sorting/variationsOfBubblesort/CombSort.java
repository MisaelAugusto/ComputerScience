package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int inputSize = rightIndex - leftIndex + 1;
		
		if (leftIndex < rightIndex && array.length > 1) {	
			int gap = inputSize;
			
			boolean swapped = true;
			while (gap > 1 || swapped) {
				swapped = false;
				
				if (gap > 1) {
					gap = (int) (gap / 1.247330950103979);
				}
				
				int i = leftIndex;
				while (i + gap < inputSize) {
					if (array[i].compareTo(array[i + gap]) > 0) {
						Util.swap(array, i, i + gap);
						swapped = true;
					}
					
					i++;
				}
			}
		}
	}
}
