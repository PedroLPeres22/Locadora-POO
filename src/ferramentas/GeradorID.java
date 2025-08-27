package ferramentas;

public class GeradorID {
    //Gera IDs  aleatórios para os produtos
    public static String gerarID() {
        return java.util.UUID.randomUUID().toString();
    }
}
