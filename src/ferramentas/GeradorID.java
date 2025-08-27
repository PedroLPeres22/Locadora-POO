package ferramentas;

public class GeradorID {
    public static String gerarID() {
        return java.util.UUID.randomUUID().toString();
    }
}
