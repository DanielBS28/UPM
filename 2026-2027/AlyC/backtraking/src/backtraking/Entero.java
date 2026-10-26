package backtraking;

public class Entero {
    // Atributo encapsulado que guarda el valor int
    private int valor;

    // Constructor para inicializar el objeto con un valor
    public Entero(int valor) {
        this.valor = valor;
    }

    // Método para obtener el valor actual
    public int getValor() {
        return valor;
    }

    // Método para modificar el valor (lo que permite el cambio por referencia)
    public void setValor(int valor) {
        this.valor = valor;
    }

    // Método opcional para facilitar la impresión del objeto
    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
