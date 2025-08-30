//Autores
//PEDRO LEONARDO S. DA S. DE O. PERES 
//LORENZO DE OLIVEIRA E SILVA 
//GABRIEL EVANGELISTA BERTOLINO DOS SANTOS

package ferramentas;

public class GeradorID {
    //Gera IDs  aleatórios para os produtos
    public static String gerarID() {
        return java.util.UUID.randomUUID().toString();
    }
}
