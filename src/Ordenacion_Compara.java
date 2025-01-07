import java.util.*;

public class Ordenacion_Compara {
    public static int bubble_sort(int[] array){
        int comparaciones = 0;
        int n = array.length;

        for(int i = 0; i < n - 1; i ++){
            for(int j = 0; j < n - i - 1; j++){
                comparaciones++;
                if (array[j] > array [j + 1]) {
                    int temporal = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporal;
                }
            }
        }
        return comparaciones;
    }

    public static int selection_sort(int[] array){
        int comparaciones = 0;
        int n = array.length;
        for (int i = 0; i < n - 1; i++){
            int indice_minimo = i;
            for(int j = i + 1; j < n; j++){
                comparaciones++;
                if (array[j] < array[indice_minimo]) {
                    indice_minimo = j;
                }
            }
            int temporal = array[indice_minimo];
            array[indice_minimo] = array[i];
            array[i] = temporal;
        }
        return comparaciones;
    }

    public static int insertion_sort(int[] array){
        int comparaciones = 0;
        int n = array.length;
        for(int i = 1; i < n; i++){
            int clave = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > clave) {
                comparaciones++;
                array[j + 1] = array[j];
                j--;
            }
            comparaciones++;
            array[j + 1] = clave;
        }
        return comparaciones;
    }
    public static int ordenar_Merge(int[] array){
        int[] temporal = new int[array.length];
        return dividir_Merge(array, temporal, 0, array.length - 1);
    }
    private static int dividir_Merge(int[] array, int[] temporal, int left, int right){
        int comparaciones = 0;
        if (left < right) {
            int medio = (left + right) / 2;
            comparaciones += dividir_Merge(array, temporal, left, medio);
            comparaciones += dividir_Merge(array, temporal, medio + 1, right);
            comparaciones += combiar_Merge(array, temporal, left, medio, right);
        }
        return comparaciones;
    }

    private static int combiar_Merge(int[] array, int[] temporal, int left, int medio, int right){
        int i = left;
        int j = medio + 1;
        int k = left;
        int comparaciones = 0;

        while (i <= medio && j <= right) {
            comparaciones++;
            if (array[i] <= array[j]) {
                temporal[k++] = array [i++];
            }else{
                temporal[k++] = array[j++];
            }
        }
        while (i <= medio) {
            temporal[k++] = array[i++];
        }
        while (j <= right) {
            temporal[k++] = array[j++];
        }
        for(i = left; i <= right; i++){
            array[i] = temporal[i];
        }
        return comparaciones;
    }

    public static void main(String[] args){
        int[] arrayOriginal = {3, 8, 12, 34, 84, 91, 110};

        System.out.println("Resultados con la lista desordenada: ");

        int[] array = {34, 8, 91, 3, 84, 12, 110};
        System.out.println("Ordenamiento Burbuja:" +bubble_sort(array.clone()) + " Comparaciones");
        System.out.println("Ordenamiento Seleccion: " + selection_sort(array.clone()) + " Comparaciones");
        System.out.println("Ordenamiento Insercion: " + insertion_sort(array.clone()) + " Comparaciones");
        System.out.println("Ordenamientos Merge: " + ordenar_Merge(array.clone()) + " Compraciones");

        System.out.println("\nResultados con la lista oredenada: ");
        System.out.println("Ordenamiento Burbuja: " + bubble_sort(arrayOriginal.clone()) + " Comparaciones");
        System.out.println("Ordenamiento Seleccion: " + selection_sort(arrayOriginal.clone()) + " Comparaciones");
        System.out.println("Ordenamiento Insercion: " + insertion_sort(arrayOriginal.clone()) + " Comparaciones");
        System.out.println("Ordenamiento Merge: " + ordenar_Merge(arrayOriginal.clone()) + " Comparaciones");

    }
}
