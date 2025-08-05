package ferramentas;

public class VerificarDados {
    
    //Verifica se a String do telefone possui 14 caracteres exatos 
    //não possui letras ou símbolos inválidos e se está no formato
    //(XX)XXXXX-XXXX
    public static boolean verifTel(String telefone){
        if(telefone.isBlank()){return false;}
        return telefone.matches("\\(\\d{2}\\)\\d{5}-\\d{4}");
    }
    
}
