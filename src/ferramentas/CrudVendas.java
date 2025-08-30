//Autores
//PEDRO LEONARDO S. DA S. DE O. PERES 
//LORENZO DE OLIVEIRA E SILVA 
//GABRIEL EVANGELISTA BERTOLINO DOS SANTOS

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

    //método para criar um registro de venda no banco de dados
    public static void criarVenda(Venda venda){
        try {
            Map<String, Object> dados = new HashMap<>();
            dados.put("idCliente", venda.getIdCliente());
            dados.put("idProduto", venda.getIdProduto());
            dados.put("valorTotal", venda.getValorTotal());
            dados.put("dataLocar", venda.getDataLocar());
            dados.put("dataDevol", venda.getDataDevol());
            dados.put("codigo", venda.getCodigo());
            dados.put("colecao", venda.getColecao());
            dados.put("foiDevolvido", venda.getFoiDevolvido());
            //Salva na coleção vendas
            db.collection("vendas").document(venda.getCodigo()).set(dados).get();
            JOptionPane.showMessageDialog(null, "Venda registrada com sucesso", "Registro",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar Venda: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }
    //Sobrecarga de Método
    //Edita uma venda,sobreescrevendo-a
    public static void criarVenda(Venda venda,String id){
        try {
            Map<String, Object> dados = new HashMap<>();
            dados.put("idCliente", venda.getIdCliente());
            dados.put("idProduto", venda.getIdProduto());
            dados.put("valorTotal", venda.getValorTotal());
            dados.put("dataLocar", venda.getDataLocar());
            dados.put("dataDevol", venda.getDataDevol());
            dados.put("codigo", id);
            dados.put("colecao", venda.getColecao());
            dados.put("foiDevolvido", venda.getFoiDevolvido());
            //Salva na coleção vendas
            db.collection("vendas").document(id).set(dados).get();
            JOptionPane.showMessageDialog(null, "Venda registrada com sucesso", "Registro",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar Venda: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }
    //Remove uma venda do banco de dados
    //Esse método acessa a coleção "vendas" e deleta o documento correspondente ao id recebido
    public static void deletarVenda(String id) {
        try {
            db.collection("vendas").document(id).delete().get();
            JOptionPane.showMessageDialog(null, "Venda deletado com sucesso", "Delete",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover Venda" + e.getLocalizedMessage(), "ERRO!",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    //Busca as vendas no banco de dados, guarda-os em um ArrayList depois o retorna
    public static ArrayList<Venda> listarVendas(){
        ArrayList<Venda> listaVendas = new ArrayList<>();
        try{
            //Consulta a Coleção vendas
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
    //Busca uma venda específica no banco de dados a partir do seu id
    //Em caso de erro na consulta,exibi uma mensagem pro usuário e retorna null
    public static Venda encontrarVenda(String id){
        try{
            DocumentSnapshot doc = db.collection("vendas").document(id).get().get();
            if (doc.exists()){
                return new Venda(doc.getString("cliente"),
                        doc.getString("produto"),
                        doc.getLong("valorTotal"),
                        doc.getString("codigo"),
                        doc.getString("colecao"));

            }else{
                System.out.println("Venda não encontrada!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao buscar venda: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
    //Edita uma venda utilizando sobrecarga de métodos
    public static void editarVenda(Venda novaVenda, String idvenda) {
        try {
            criarVenda(novaVenda,idvenda);
            JOptionPane.showMessageDialog(null, "Produto editado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar produto: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }
}
