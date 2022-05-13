import java.util.ArrayList;

public class ForcaBruta {
    public Mochila forcaBruta(ItemMochila[] itens, int capacidade) {

        // seleciona todos os subconjuntos da mochila (combinacao)
        ArrayList<ItemMochila[]> subconjuntos = combinacao(itens);
        subconjuntos.toString();

        // itera sobre subconjuntos para filtrar (excluir os que excedem a capacidade) 
        // e aproveita o for para escolher a melhor solucao do problema (mochila com maior valor)
        Mochila melhorMochila = filtrar(subconjuntos, capacidade);
        melhorMochila.toString();

        return melhorMochila;
    }

    public ArrayList<ItemMochila[]> combinacao(ItemMochila[] itens) {
        ArrayList<ItemMochila[]> resultado = new ArrayList<ItemMochila[]>();
        ItemMochila[] subconjuntos;
        Combinacao comb2 = new Combinacao(itens, 0) ;
        while ( comb2.hasNext() ) {
            subconjuntos = comb2.next() ;

            // for ( ItemMochila e : subconjuntos ) {
                               
            // }
            
            resultado.add(subconjuntos);
        }
        return resultado;
    }

    public Mochila filtrar(ArrayList<ItemMochila[]> subconjuntos, int capacidade) {
        ArrayList<ItemMochila[]> subConjuntosPossiveis = new ArrayList<ItemMochila[]>();
        Mochila maiorValor = new Mochila(subconjuntos.get(0));
        for (int i = 0; i < subconjuntos.size(); i++) {
            Mochila m = new Mochila(subconjuntos.get(i));
            if (m.getPesoTotal() <= capacidade) {
                subConjuntosPossiveis.add(subconjuntos.get(i));
                if(maiorValor.getValorTotal() < m.getValorTotal()) maiorValor = m;
            }
        }

        return maiorValor;
    }
}