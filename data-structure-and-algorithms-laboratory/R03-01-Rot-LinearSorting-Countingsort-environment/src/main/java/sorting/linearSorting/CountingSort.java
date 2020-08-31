package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && array.length > 1) {
			int[] arrayCounting = new int[max(array) + 1];
			
			for (int i = leftIndex; i <= rightIndex; i++) {
				arrayCounting[array[i]]++; 
			}
			
			for (int j = 1; j < arrayCounting.length; j++) {
				arrayCounting[j] += arrayCounting[j - 1];
			}
			
			Integer[] copy = Arrays.copyOf(array, array.length);
			
			for (int k = rightIndex; k >= leftIndex ; k--) {
				Integer number = copy[k];
				Integer index = --arrayCounting[number] + leftIndex;
				array[index] = number;
			}
		}
		
	}
	
	public int max(Integer[] array) {
		int max = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[max]) {
				max = i;
			}
		}
		
		return array[max];
	}
}
