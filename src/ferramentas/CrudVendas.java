package ferramentas;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.database.*;
import dados.*;

import javax.swing.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class CrudVendas {
    private static Firestore db;
    //Conecta com o Banco de dados
    static {
        try {
            db = FirestoreConnection.getFirestore();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }
    //
    public static void criarVenda(Venda venda){
        try {
            Map<String, Object> dados = new HashMap<>();
            dados.put("cliente", venda.getIdCliente());
            dados.put("produto", venda.getIdProduto());
            dados.put("valorTotal", venda.getValorTotal());
            dados.put("dataLocar", venda.getDataLocar());
            dados.put("dataDevol", venda.getDataDevol());
            //Salva na coleção vendas
            db.collection("vendas").document(venda.getCodigo()).set(dados).get();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso", "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar produto: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void deletarVenda(String id) {
        try {
            db.collection("vendas").document(id).delete().get();
            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso", "Delete",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover produto" + e.getLocalizedMessage(), "ERRO!",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static ArrayList<Venda> listarVendas(){
        ArrayList<Venda> listaVendas = new ArrayList<>();
        try{
            ApiFuture<QuerySnapshot> future = db.collection("vendas").get();
            List<QueryDocumentSnapshot> documentos = future.get().getDocuments();

            for(QueryDocumentSnapshot doc : documentos){
                Venda venda = doc.toObject(Venda.class); // Converte o documento para Cliente
                listaVendas.add(venda);
            }
            return listaVendas;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao listar Vendas: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static Venda encontrarVenda(String id){
        try{
            DocumentSnapshot doc = db.collection("vendas").document(id).get().get();
            if (doc.exists()){
                return new Venda(doc.getString("cliente"),
                        doc.getString("produto"),
                        doc.getLong("valorTotal"),
                        doc.getString("codigo"));

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
