package www.projetotaurus.com.br.taurusfinal;

/**
 * Created by LuaNote on 16/05/2017.
 */

public class ListMarca {
    private String nome;
    private String datacadastro;

    public ListMarca(String nome, String datacadastro) {
        this.nome = nome;
        this.datacadastro = datacadastro;
    }

    public String getNome() {
        return nome;
    }

    public String getDatacadastro() {
        return datacadastro;
    }
}
