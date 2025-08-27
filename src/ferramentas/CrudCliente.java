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
    // Conecta com banco de dados
    static {
        try {
            db = FirestoreConnection.getFirestore();
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }
    //Cadastra o cliente no Banco de Dados
    public static void criarCliente(Cliente cliente){
        try {
            Map<String, Object> dados = new HashMap<>();
            dados.put("nome", cliente.getNome());
            dados.put("endereco", cliente.getEndereco());
            dados.put("telefone", cliente.getTelefone());
            dados.put("multaAtraso", cliente.getMultaAtraso());
            dados.put("atrasoDevol", cliente.getAtrasoDevol());
            dados.put("locados", cliente.getLocados());
            //Acessa a coleção clientes e cadastra o novo cliente
            db.collection("clientes").document(cliente.getTelefone()).set(dados).get();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }
    //Lista todos os clientes do banco de dados
    public static ArrayList<Cliente> listarCliente(){
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        try{
            //Acessa a coleção clientes do banco de dados
            ApiFuture<QuerySnapshot> future = db.collection("clientes").get();
            List<QueryDocumentSnapshot> documentos = future.get().getDocuments();
            //Converte cada documento em um Objeto Cliente
            for(QueryDocumentSnapshot doc : documentos){
                Cliente cliente = doc.toObject(Cliente.class); // Converte o documento para Cliente
                listaClientes.add(cliente);
            }
            return listaClientes;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao listar Clientes: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
    //Encontra o cliente pelo telefone
    public static Cliente encontrarCliente(String telefone){
        try{
            //Acessa a coleção clientes do banco de dados
            DocumentSnapshot doc = db.collection("clientes").document(telefone).get().get();
            if (doc.exists()){
                return new Cliente(doc.getString("nome"),
                                   doc.getString("endereco"),
                                   doc.getString("telefone"));

            }else{
                //Se o documento não existir, informa que o cliente não foi encontrado e retorna null
                System.out.println("Cliente não encontrado!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
    //Remove um cliente utilizando o telefone como referência
    public static void deletarCliente(String telefone){
        try{
            //Acessa a coleção clientes do banco de dados
            db.collection("clientes").document(telefone).delete().get();
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso", "Delete",
                    JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao remover cliente" + e.getLocalizedMessage(), "ERRO!",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
