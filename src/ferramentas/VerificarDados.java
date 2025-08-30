//Autores
//PEDRO LEONARDO S. DA S. DE O. PERES 
//LORENZO DE OLIVEIRA E SILVA 
//GABRIEL EVANGELISTA BERTOLINO DOS SANTOS

package ferramentas;

public class VerificarDados {

    // Verifica se a String do telefone possui 14 caracteres exatos,
    // não possui letras ou símbolos inválidos e se está no formato
    // (XX)XXXXX-XXXX
    public static boolean verifTel(String telefone) {
        if (telefone.isBlank()) {
            return false;
        }
        return telefone.matches("\\(\\d{2}\\)\\d{5}-\\d{4}");
    }

    // verifica se algum campo está vazio
    public static boolean estaVazio(String string) {
        if (string.isBlank()) {
            return false;
        } else
            return true;

    }
    //verifica se String e um numero
    public static boolean eNumero(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(texto.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
