import java.util.Random;

public class Main {
    public static void main(String[] args) {
        boolean stop = false;
        // começa pelo tamanho 15 (para não estourar a memória)
        int quantidadeItens = 15; 
        while(stop == false){

            // gera itens da mochila            
            int capacidade = (quantidadeItens * 3) + 1;
            ItemMochila[] test = geradorItens(capacidade, quantidadeItens);
            System.out.println("Itens: ");
            
            for ( ItemMochila it : test ) {
                System.out.println(it.toString());
            }
            
            // começa a contagem do tempo
            long start = System.currentTimeMillis();
            long end = start + 4 * 1000; // maximo de tempo de 4 segundos
            // forca bruta
            ForcaBruta fb = new ForcaBruta();
            Mochila solucaoBruta = fb.forcaBruta(test, capacidade);
            System.out.println("Solucao forca bruta: "+solucaoBruta.toString());
            
            // guloso
            Guloso g = new Guloso();
            Mochila solucaoGulosa = g.guloso(test, capacidade);
            System.out.println("Solucao Guloso: "+solucaoGulosa.toString());
            
            // compara o tempo gasto para verificar se foi mais de 4 segundos
            if(System.currentTimeMillis() >= end) stop = true;
            else quantidadeItens++;
            
        }
        System.out.println("Quantidade max de itens:"+(quantidadeItens - 1));
        System.exit(0);
    }


    public static ItemMochila[] geradorItens(int capacidade, int quantidadeItens){
        // ArrayList<ItemMochila> itensGerados = new ArrayList<ItemMochila>();
        ItemMochila[] itensGerados = new ItemMochila[quantidadeItens];
        int somaPeso = 0;
        int min = 1;
        // int minPeso = 1;
        double max = (((capacidade * 3.0) + quantidadeItens) / quantidadeItens); 
        double minPeso = (((capacidade * 3.0) - quantidadeItens) / quantidadeItens); 
        // double minPeso = (max  / (max / quantidadeItens)) - (max / quantidadeItens); 
        // System.out.println("Max: "+(int)max+", Min: "+(int)minPeso);
        // double minPeso = (max  / (quantidadeItens / 3.0));
        for(int i = 0; i < quantidadeItens; i++){
            Random rPeso = new Random();
            Random rValor = new Random();
            ItemMochila im = new ItemMochila(rValor.nextInt(11) + min, rPeso.ints((int)minPeso, (int)max).findFirst().getAsInt());
            itensGerados[i] = im;
            somaPeso += im.getPeso();
        }
        // System.out.println("Soma Peso: "+somaPeso+", Valor ideal: "+(capacidade * 3));
        return itensGerados;
    }
}