package dados;

//Classe que define propriedades específicas dos jogos eletrônicos

public class Game extends Produto{
    private String publicadora, desenvolvedor, plataforma;
    //Publicadora = Publisher do jogo
    //Desenvolvedor = Estúdio de desenvolvimento do jogo
    //Plataforma = Plataforma onde o jogo está disponível (Consoles ou PC)
    
    public Game(String nome, String codigo, String classInd, String publicadora, 
            String estudio, String plataforma, boolean estaAlugado, long alugueis,
            long estoque){
        super(nome, "Game", codigo, classInd, estaAlugado, alugueis, estoque);
        this.publicadora = publicadora;
        this.desenvolvedor = estudio;
        this.plataforma = plataforma;
    }
    
    public String getPublicadora(){
        return publicadora;
    }
    public String getDesenvolvedor(){
        return desenvolvedor;
    }
    public String getPlataforma(){
        return plataforma;
    }
    
    public void setPublicadora(String publicadora){
        this.publicadora = publicadora;
    }
    public void setDesenvolvedor(String desenvolvedor){
        this.desenvolvedor = desenvolvedor;
    }
    public void setPlataforma(String plataforma){
        this.plataforma = plataforma;
    }
    
}
