package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && array.length > 1) {	
			int[] arrayCounting = new int[max(array) - min(array) + 1];
			
			int min = (-1) * min(array);
			
			for (int i = leftIndex; i <= rightIndex; i++) {
				arrayCounting[array[i] + min]++; 
			}
			
			for (int j = 1; j < arrayCounting.length; j++) {
				arrayCounting[j] += arrayCounting[j - 1];
			}
			
			Integer[] copy = Arrays.copyOf(array, array.length);
			
			for (int k = rightIndex; k >= leftIndex ; k--) {
				Integer number = copy[k];
				Integer index = --arrayCounting[number + min] + leftIndex;
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
	
	public int min(Integer[] array) {
		int min = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[min]) {
				min = i;
			}
		}
		
		return array[min];
	}
	
}
