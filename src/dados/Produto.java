package dados;

//Classe que define características gerais dos produtos sendo locados

public class Produto {
    private String nome, tipo, codigo, classInd;
    private boolean estaAlugado;
    private long alugueis, estoque, preco;
    // nome = Título do produto
    // tipo = Tipo do produto (Game ou Vídeo)
    // codigo = ID do produto no BD 
    // classInd = Classificação Indicativa
    // estaAlugado = Indica se o item está alugado atualmente
    // alugueis = Indica o número de vezes que o produto foi alugado
    // estoque = Indica o número de cópias no estoque da locadora
    // preco = Preço do aluguel do produto
    
    public Produto(String nome, String tipo, String codigo, String classInd,
            boolean estaAlugado, long alugueis, long estoque, long preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.codigo = codigo;
        this.estaAlugado = false;
        this.alugueis = 0;
        this.estoque = estoque;
        this.classInd = classInd;
        this.preco = preco;
    }

    // Construtor vazio necessário para o Firestore
    public Produto() {
    }
    //Getters
    public String getNome(){
        return nome;
    }
    public String getTipo(){
        return tipo;
    }
    public String getCodigo(){
        return codigo;
    }
    public boolean estaAlugado(){
        return estaAlugado;
    }
    public long getAlugueis(){
        return alugueis;
    }
    public long getEstoque(){
        return estoque;
    }
    
    public long getPreco() {
        return preco;
    }

    public String getClassInd() {
        return classInd;
    }
    //Setters
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public void setAlugadoStatus(boolean estaAlugado){
        this.estaAlugado = estaAlugado;
    }
    public void setAlugueis(long alugueis){
        this.alugueis = alugueis;
    }
    public void setEstoque(long estoque){
        this.estoque = estoque;
    }

    public void setPreco(long preco) {
        this.preco = preco;
    }

    public void setClassInd(String classInd) {
        this.classInd = classInd;
    }
    
    public void updateAlugueis(){
        alugueis++;
    }
}
