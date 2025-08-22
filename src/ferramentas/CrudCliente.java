package ferramentas;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import dados.Cliente;
import dados.Game;
import dados.Produto;
import dados.Video;

import javax.swing.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CrudCliente {
    private static Firestore db;

    static {
        try {
            db = FirestoreConnection.getFirestore();
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void criarCliente(Cliente cliente){
        try {
            Map<String, Object> dados = new HashMap<>();
            dados.put("nome", cliente.getNome());
            dados.put("endereco", cliente.getEndereco());
            dados.put("telefone", cliente.getTelefone());
            dados.put("multaAtraso", cliente.getMultaAtraso());
            dados.put("atrasoDevol", cliente.getAtrasoDevol());
            dados.put("locados", cliente.getLocados());

            db.collection("clientes").document(cliente.getTelefone()).set(dados).get();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static String listarCliente(){
        try{
            ApiFuture<QuerySnapshot> future = db.collection("clientes").get();
            List<QueryDocumentSnapshot> documentos = future.get().getDocuments();

            for(QueryDocumentSnapshot doc : documentos){
                return doc.getId() + "=> " + doc.getData();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao listar Clientes: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static Cliente encontrarCliente(String telefone){
        try{
            DocumentSnapshot doc = db.collection("produtos").document(telefone).get().get();
            if (doc.exists()){
                return new Cliente(doc.getString("nome"),
                                   doc.getString("endereco"),
                                   doc.getString("telefone"));

            }else{
                System.out.println("Cliente não encontrado!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
}
