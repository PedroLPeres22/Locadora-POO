//Autores
//PEDRO LEONARDO S. DA S. DE O. PERES 
//LORENZO DE OLIVEIRA E SILVA 
//GABRIEL EVANGELISTA BERTOLINO DOS SANTOS

package dados;

import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;

//Classe responsável por descrever os dados de uma venda/locação

public class Venda {
    private long valorTotal;
    private String codigo, idCliente, idProduto, dataLocar, dataDevol, colecao;
    private LocalDate hoje;
    private LocalDate daquiTresDias;
    private boolean foiDevolvido;
    // idCliente = telefone do Cliente que locou o produto
    // idProduto = codigo do Produto locado pelo Cliente
    // locados = ArrayList de produtos locados
    // valorTotal = Valor total pago para locar os produtos
    // dataLocar = data em que os produtos foram locados
    // dataDevol = data em que os produtos devem ser devolvidos
    // foiDevolvido = booleano para verificar se um produto foi devolvido

    public Venda(){
    }

    public Venda(String idCliente, String idProduto, long valorTotal, String codigo, String colecao){
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.valorTotal = valorTotal;
        this.hoje = LocalDate.now();
        this.daquiTresDias = hoje.plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataLocar = hoje.format(formatter);
        this.dataDevol = daquiTresDias.format(formatter);
        this.codigo = codigo;
        this.colecao = colecao;
        foiDevolvido = false;
    }

    //Getters
    public long getValorTotal() {return valorTotal;}
    public String getDataLocar() {return dataLocar;}
    public String getDataDevol() {return dataDevol;}
    public String getCodigo() { return codigo;}
    public String getIdCliente(){ return idCliente;}
    public String getIdProduto(){ return idProduto;}
    public String getColecao() { return colecao; }
    public boolean getFoiDevolvido() { return foiDevolvido;}

    //Setters
    public void setIdCliente(String idCliente) {this.idCliente = idCliente;}
    public void setValorTotal(long valorTotal) {this.valorTotal = valorTotal;}
    public void setDataLocar(String dataLocar){this.dataLocar = dataLocar;}
    public void setColecao(String colecao) {this.colecao = colecao;}
    public void setDataDevol(String dataDevol){this.dataDevol = dataDevol;}
    public void setCodigo(String codigo) {this.codigo = codigo;}
    public void setProduto(String idProduto) {this.idProduto = idProduto; }
    //Toggle
    public void toggleFoiDevolvido(){this.foiDevolvido = !this.foiDevolvido;}
}

