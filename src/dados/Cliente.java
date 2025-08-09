package dados;

public class Cliente {
    private String nome, endereco, telefone;
    private long multaAtraso;
    private boolean atrasoDevol;
    private static double valorMulta;
    //nome = Nome do cliente
    //endereco = Endereço do cliente
    //telefone = Telefone do cliente
    //multaAtraso = Valor da multa de atraso atual do cliente
    //atrasoDevol = Indica se o cliente atrasou alguma devolução
    //valorMulta = Valor da multa por dia de atraso;
    
    public Cliente(String nome, String endereco, String telefone){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.multaAtraso = 0;
        this.atrasoDevol = false;
    }
    
    //Getters
    public String getNome(){
        return nome;
    }
    public String getEndereco(){
        return endereco;
    }
    public String getTelefone(){
        return telefone;
    }
    public long getMultaAtraso(){
        return multaAtraso;
    }
    public boolean getAtrasoDevol(){
        return atrasoDevol;
    }
    
    //Setters
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public void setMultaAtraso(long multaAtraso){
        this.multaAtraso = multaAtraso;
    }
    public void setAtrasoDevol(boolean atrasoDevol){
        this.atrasoDevol = atrasoDevol;
    }
    
    //Métodos static
    public static void setValorMulta(double novaMulta){
        valorMulta = novaMulta;
    }
    public static double getValorMulta(){
        return valorMulta;
    }
    
    //Métodos avulsos
    public void addMulta(){
        this.multaAtraso+=valorMulta;
    }
}
