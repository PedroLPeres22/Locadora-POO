//Autores
//PEDRO LEONARDO S. DA S. DE O. PERES 
//LORENZO DE OLIVEIRA E SILVA 
//GABRIEL EVANGELISTA BERTOLINO DOS SANTOS


package dados;

//Classe que define as propriedades específicas de produtos de vídeo (Filmes, 
//Séries, Boxes, etc.)

public class Video extends Produto{
    private String estudio, distribuidora, formato, tipoMidia; 
    private int duracao;
    //estudio = Estudio responsável pela produção do filme
    //distribuidora = Distribuidora responsável por fornecer o filme
    //formato = Formato em que o vídeo está disponível (VHS, CD, DVD, Blu-Ray, LaserDisc)
    //tipoMidia = Tipo de vídeo (Filme, Série, Coletânea)
    //duracao = Duração (em minutos) do vídeo
    
    public Video(String nome, String codigo, String classInd, String estudio, 
            String distribuidora, String formato, String tipoMidia, int duracao,
            boolean estaAlugado, long alugueis, long estoque, long preco) {
        super(nome, "Vídeo", codigo, classInd, estaAlugado, alugueis, estoque, preco);
        this.estudio = estudio;
        this.distribuidora = distribuidora;
        this.formato = formato;
        this.tipoMidia = tipoMidia;
        this.duracao = duracao;
    }

    // Construtor vazio necessário para o Firestore
    public Video() {
        super();
    }
    //Getters
    public String getEstudio(){
        return estudio;
    }
    public String getDistribuidora(){
        return distribuidora;
    }
    public String getFormato(){
        return formato;
    }
    public String getTipoMidia(){
        return tipoMidia;
    }
    public int getDuracao(){
        return duracao;
    }
    //Setters
    public void setEstudio(String estudio){
        this.estudio = estudio;
    }
    public void setDistribuidora(String distribuidora){
        this.distribuidora = distribuidora;
    }
    public void setFormato(String formato){
        this.formato = formato;
    }
    public void setTipoMidia(String tipoMidia){
        this.tipoMidia = tipoMidia;
    }
    public void setDuracao(int duracao){
        this.duracao = duracao;
    }
}
