import java.util.ArrayList;

public class Mochila {

    private int pesoTotal;
    private int valorTotal;
    private ArrayList<ItemMochila> itens;

    Mochila(){
        this.valorTotal = 0;
        this.pesoTotal = 0;
        this.itens = new ArrayList<ItemMochila>();
    }

    Mochila(ItemMochila[] itens){
        this.valorTotal = 0;
        this.pesoTotal = 0;
        this.itens = new ArrayList<ItemMochila>();
        for(int i = 0; i < itens.length; i++){
            this.itens.add(itens[i]);
            this.valorTotal += itens[i].getValor();
            this.pesoTotal += itens[i].getPeso();
        }
    }

    public void addItem(ItemMochila i){
        this.itens.add(i);
        pesoTotal += i.getPeso();
        valorTotal += i.getValor();
    }


    public int getPesoTotal() {
        return this.pesoTotal;
    }

    public int getValorTotal() {
        return this.valorTotal;
    }

    public ArrayList<ItemMochila> getItens() {
        return this.itens;
    }

    public void setItens(ArrayList<ItemMochila> itens) {
        this.itens = itens;
        for(int i = 0; i < this.itens.size(); i++){
            this.pesoTotal += this.itens.get(i).getPeso();
            this.valorTotal += this.itens.get(i).getValor();
        }
    }

    @Override
    public String toString() {
        return "{" +
            " pesoTotal='" + getPesoTotal() + "'" +
            ", valorTotal='" + getValorTotal() + "'" +
            ", itens='" + getItens() + "'" +
            "}";
    }

}