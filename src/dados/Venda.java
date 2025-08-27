package dados;

import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;

//Classe responsável por descrever os dados de uma venda/locação

public class Venda {
    private long valorTotal;
    private String codigo, idCliente, idProduto;
    private LocalDate dataLocar, dataDevol;
    // idCliente = telefone do Cliente que locou o produto
    // idProduto = codigo do Produto locado pelo Cliente
    // locados = ArrayList de produtos locados
    // valorTotal = Valor total pago para locar os produtos
    // dataLocar = data em que os produtos foram locados
    // dataDevol = data em que os produtos devem ser devolvidos

    public Venda(String idCliente, String idProduto, long valorTotal, String codigo) {
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.valorTotal = valorTotal;
        this.dataLocar = LocalDate.now();
        this.dataDevol = dataLocar.plusDays(3);
        this.codigo = codigo;
    }

    public String getCliente() {
        return idCliente;
    }

    public String getProduto(){ return idProduto; }

    public long getValorTotal() {
        return valorTotal;
    }

    public LocalDate getDataLocar() {
        return dataLocar;
    }

    public LocalDate getDataDevol() {
        return dataDevol;
    }

    public String getCodigo() { return codigo;}

    public String getIdCliente(){ return idCliente;}

    public String getIdProduto(){ return idProduto;}

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setValorTotal(long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setDataLocar(LocalDate dataLocar) {
        this.dataLocar = dataLocar;
    }

    public void setDataDevol(LocalDate dataDevol){this.dataDevol = dataDevol;}

    public void setCodigo(String codigo) { this.codigo = codigo;}

    public void setProduto(String idProduto) { this.idProduto = idProduto; }
}
