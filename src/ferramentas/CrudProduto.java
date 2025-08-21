package ferramentas;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.database.*;
import dados.*;

import javax.swing.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class CrudProduto {
    private static Firestore db;


    static {
        try {
            db = FirestoreConnection.getFirestore();
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }


    public static void criarProduto(Produto produto, String collection){
        try {
            Map<String, Object> dados = new HashMap<>();
            dados.put("nome", produto.getNome());
            dados.put("preco", produto.getPreco());
            dados.put("codigo", produto.getCodigo());
            dados.put("classInd", produto.getClassInd());
            dados.put("estaAlugado", produto.estaAlugado());
            dados.put("alugueis", produto.getAlugueis());
            dados.put("estoque", produto.getEstoque());
            dados.put("preco", produto.getPreco());

            if (produto instanceof Game) {
                Game g = (Game) produto;
                dados.put("publicadora", g.getPublicadora());
                dados.put("desenvolvedor", g.getDesenvolvedor());
                dados.put("plataforma", g.getPlataforma());
            }
            if (produto instanceof Video) {
                Video v = (Video) produto;
                dados.put("estudio", v.getEstudio());
                dados.put("distribuidora", v.getDistribuidora());
                dados.put("formato", v.getFormato());
                dados.put("tipoMidia", v.getTipoMidia());
                dados.put("duracao", v.getDuracao());
            }

            db.collection(collection).document(produto.getCodigo()).set(dados).get();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso", "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao criar produto: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void criarProduto(Produto produto, String collection, String id){
        try {
            Map<String, Object> dados = new HashMap<>();
            dados.put("nome", produto.getNome());
            dados.put("preco", produto.getPreco());
            dados.put("codigo", produto.getCodigo());
            dados.put("classInd", produto.getClassInd());
            dados.put("estaAlugado", produto.estaAlugado());
            dados.put("alugueis", produto.getAlugueis());
            dados.put("estoque", produto.getEstoque());
            dados.put("preco", produto.getPreco());

            if (produto instanceof Game) {
                Game g = (Game) produto;
                dados.put("publicadora", g.getPublicadora());
                dados.put("desenvolvedor", g.getDesenvolvedor());
                dados.put("plataforma", g.getPlataforma());
            }
            if (produto instanceof Video) {
                Video v = (Video) produto;
                dados.put("estudio", v.getEstudio());
                dados.put("distribuidora", v.getDistribuidora());
                dados.put("formato", v.getFormato());
                dados.put("tipoMidia", v.getTipoMidia());
                dados.put("duracao", v.getDuracao());
            }

            db.collection(collection).document(id).set(dados).get();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso", "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao criar produto: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void deletarProduto(String id,String collection){
        try{
            db.collection(collection).document(id).delete().get();
            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso", "Delete",
                                            JOptionPane.INFORMATION_MESSAGE );
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao remover produto"+e.getLocalizedMessage(),"ERRO!",JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void editarProduto(String id, String collection, Produto novoProduto){
            try{
                criarProduto(novoProduto, collection, id);
                JOptionPane.showMessageDialog(null,"Produto editado com sucesso");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro ao editar produto: " + e.getLocalizedMessage(),
                        "ERRO!", JOptionPane.WARNING_MESSAGE);
            }
    }

    public static void listarProdutos(String collection){
        try{
            ApiFuture<QuerySnapshot> future = db.collection(collection).get();
            List<QueryDocumentSnapshot> documentos = future.get().getDocuments();

            for(QueryDocumentSnapshot doc : documentos){
                System.out.println(doc.getId() + "=> " + doc.getData());
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void encontrarProduto(String id){
        try{

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao procurar o produto: "+e.getLocalizedMessage(),"ERRO!",JOptionPane.WARNING_MESSAGE);
        }
    }
}
