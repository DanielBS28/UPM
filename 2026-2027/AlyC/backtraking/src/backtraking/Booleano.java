package backtraking;

public class Booleano {
    // Atributo encapsulado que guarda el valor boolean
    private boolean valor;

    // Constructor para inicializar el objeto con un valor
    public Booleano(boolean valor) {
        this.valor = valor;
    }

    // Método para obtener el valor actual
    public boolean getValor() {
        return valor;
    }

    // Método para modificar el valor (permite el cambio por referencia)
    public void setValor(boolean valor) {
        this.valor = valor;
    }

    // Método para invertir el valor actual (operación NOT)
    public void invertir() {
        this.valor = !this.valor;
    }

    // Método opcional para facilitar la impresión del objeto
    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
