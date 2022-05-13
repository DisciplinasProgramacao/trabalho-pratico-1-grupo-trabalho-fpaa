public class Guloso {
    public Mochila guloso(ItemMochila[] itens, int capacidade){
        
        // ordena itens pela razao de valor sobre peso
        ItemMochila[] ordenados = ordena(itens);
        ordenados.toString();

        Mochila melhorMochila = new Mochila(); // deduzida selecionando os primeiros itens ordenados que cabem
        for(int i = 0; i < ordenados.length; i++){
            if(melhorMochila.getPesoTotal() + ordenados[i].getPeso() <= capacidade) melhorMochila.addItem(ordenados[i]);
        }

        return melhorMochila;
    }

    public ItemMochila[] ordena(ItemMochila[] itens){
        QuickSort qs = new QuickSort();
        qs.sort(itens, 0, itens.length - 1);

        return itens;
    }
}
