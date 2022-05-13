public class ItemMochila {
    
    private int peso;
    private int valor;

    public ItemMochila(int valor, int peso) {
        this.peso = peso;
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }    

    @Override
    public String toString() {
        return "Item{" + "peso=" + peso + ", value=" + valor + '}';
    }
    
}