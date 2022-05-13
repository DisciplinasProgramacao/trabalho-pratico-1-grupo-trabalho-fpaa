public class QuickSort {
    int partition(ItemMochila[] arr, int low, int high) {
        ItemMochila pivot = arr[high];
        int i = (low - 1); 
        for (int j = low; j < high; j++) {
            
            if ((arr[j].getValor() / arr[j].getPeso()) >= (pivot.getValor() / pivot.getPeso())) {
                i++;

               
                ItemMochila temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        ItemMochila temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void sort(ItemMochila[] arr, int low, int high) {
        if (low < high) {
            
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
}