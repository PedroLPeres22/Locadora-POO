package dados;

import java.util.ArrayList;

//Classe responsável por descrever os dados de uma venda/locação

public class Venda {
    private Cliente cliente;
    private long valorTotal;
    private String dataLocar, dataDevol;
    // cliente = Cliente que locou o produto
    // locados = ArrayList de produtos locados
    // valorTotal = Valor total pago para locar os produtos
    // dataLocar = data em que os produtos foram locados
    // dataDevol = data em que os produtos devem ser devolvidos

    public Venda(Cliente cliente, long valorTotal, String dataLocar,
            String dataDevol) {
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.dataLocar = dataLocar;
        this.dataDevol = dataDevol;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public long getValorTotal() {
        return valorTotal;
    }

    public String getDataLocar() {
        return dataLocar;
    }

    public String getDataDevol() {
        return dataDevol;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setValorTotal(long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setDataLocar(String dataLocar) {
        this.dataLocar = dataLocar;
    }
}
