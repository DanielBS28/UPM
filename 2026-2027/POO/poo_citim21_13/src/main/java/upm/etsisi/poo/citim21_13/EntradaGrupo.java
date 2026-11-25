package upm.etsisi.poo.citim21_13;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EntradaGrupo extends Entrada {

    private Grupo grupo;
    private final List<EntradaIndividual> entradasIndividuales;

    public EntradaGrupo(String identificador, LocalDate fecha, double precioBase, Grupo grupo) {
        super(identificador, fecha, precioBase);
        this.grupo = grupo;
        this.entradasIndividuales = new ArrayList<>();

        double descuento = calcularDescuento(grupo.getMiembros().size());

        for (Usuario usuario : grupo.getMiembros().values()) {
            String idDerivado = identificador + ":" + usuario.getDni();
            EntradaIndividual entradaIndividual = new EntradaIndividual(
                    idDerivado,
                    fecha,
                    precioBase,
                    usuario,
                    descuento,
                    true
            );
            this.entradasIndividuales.add(entradaIndividual);
        }
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public List<EntradaIndividual> getEntradasIndividuales() {
        return Collections.unmodifiableList(entradasIndividuales);
    }

    @Override
    public boolean esEntradaGrupo() {
        return true;
    }

    @Override
    public boolean perteneceAGrupo(Grupo grupoBuscado) {
        if (this.grupo == null || grupoBuscado == null) {
            return false;
        }
        return this.grupo.getIdentificador().equals(grupoBuscado.getIdentificador());
    }

    @Override
    public void desvincularGrupo(Grupo grupoEliminado) {
        if (perteneceAGrupo(grupoEliminado)) {
            this.grupo = null;
        }
    }

    @Override
    public List<Entrada> getEntradasGestionadas() {
        List<Entrada> todas = new ArrayList<>();
        todas.add(this);
        todas.addAll(entradasIndividuales);
        return Collections.unmodifiableList(todas);
    }

    public static double calcularDescuento(int numMiembros) {
        if (numMiembros < 3) {
            return 0.0;
        } else if (numMiembros <= 5) {
            return 0.10;
        } else if (numMiembros <= 10) {
            return 0.20;
        } else {
            return 0.50;
        }
    }

    @Override
    public double getPrecio() {
        double total = 0.0;
        for (EntradaIndividual entrada : entradasIndividuales) {
            total += entrada.getPrecio();
        }
        return total;
    }

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        for (EntradaIndividual entrada : entradasIndividuales) {
            if (entrada.getUsuario() != null) {
                usuarios.add(entrada.getUsuario());
            }
        }
        return Collections.unmodifiableList(usuarios);
    }

    @Override
    public boolean contieneUsuario(Usuario usuarioBuscado) {
        for (EntradaIndividual entrada : entradasIndividuales) {
            if (entrada.contieneUsuario(usuarioBuscado)) {
                return true;
            }
        }
        return false;
    }
}