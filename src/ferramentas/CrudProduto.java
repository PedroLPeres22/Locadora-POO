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
    //Conecta com o banco de dados
    static {
        try {
            db = FirestoreConnection.getFirestore();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }
    // Cadastra o produto no banco de dados
    public static void criarProduto(Produto produto, String collection) {
        try {
            Map<String, Object> dados = new HashMap<>();
            dados.put("nome", produto.getNome());
            dados.put("preco", produto.getPreco());
            dados.put("codigo", produto.getCodigo());
            dados.put("classInd", produto.getClassInd());
            dados.put("estaAlugado", produto.estaAlugado());
            dados.put("alugueis", produto.getAlugueis());
            dados.put("estoque", produto.getEstoque());
            //Verifica qual o tipo de produto,se é do tipo jogo ou do tipo vídeo
            if (produto instanceof Game) {
                Game g = (Game) produto;
                dados.put("publicadora", g.getPublicadora());
                dados.put("desenvolvedor", g.getDesenvolvedor());
                dados.put("plataforma", g.getPlataforma());
            }
            if (produto instanceof Video v) {
                dados.put("estudio", v.getEstudio());
                dados.put("distribuidora", v.getDistribuidora());
                dados.put("formato", v.getFormato());
                dados.put("tipoMidia", v.getTipoMidia());
                dados.put("duracao", v.getDuracao());
            }

            db.collection(collection).document(produto.getCodigo()).set(dados).get();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso", "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar produto: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Sobrecarga de método,pois o método editarProduto(); utiliza o id para identificar
    //o produto a ser editado
    public static void criarProduto(Produto produto, String collection, String id) {
        try {
            Map<String, Object> dados = new HashMap<>();
            dados.put("nome", produto.getNome());
            dados.put("preco", produto.getPreco());
            dados.put("codigo", produto.getCodigo());
            dados.put("classInd", produto.getClassInd());
            dados.put("estaAlugado", produto.estaAlugado());
            dados.put("alugueis", produto.getAlugueis());
            dados.put("estoque", produto.getEstoque());

            if (produto instanceof Game) {
                Game g = (Game) produto;
                dados.put("publicadora", g.getPublicadora());
                dados.put("desenvolvedor", g.getDesenvolvedor());
                dados.put("plataforma", g.getPlataforma());
            }
            if (produto instanceof Video v) {
                dados.put("estudio", v.getEstudio());
                dados.put("distribuidora", v.getDistribuidora());
                dados.put("formato", v.getFormato());
                dados.put("tipoMidia", v.getTipoMidia());
                dados.put("duracao", v.getDuracao());
            }

            db.collection(collection).document(id).set(dados).get();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso", "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }
    //Exclui um produto pelo id
    public static void deletarProduto(String id, String collection) {
        try {
            db.collection(collection).document(id).delete().get();
            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso", "Delete",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover produto" + e.getLocalizedMessage(), "ERRO!",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    //Edita um produto pelo id
    public static void editarProduto(String id, String collection, Produto novoProduto) {
        try {
            criarProduto(novoProduto, collection, id);
            JOptionPane.showMessageDialog(null, "Produto editado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar produto: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }
    //Busca os produtos no banco de dados, guarda-os em um ArrayList e o retorna
    public static ArrayList<Produto> listarProdutos(String collection) {
        ArrayList<Produto> produtos = new ArrayList<>();
        try {
            ApiFuture<QuerySnapshot> future = db.collection(collection).get();
            List<QueryDocumentSnapshot> documentos = future.get().getDocuments();

            for (QueryDocumentSnapshot doc : documentos) {
                if (collection.equalsIgnoreCase("jogos")) {
                    Produto produto = doc.toObject(Game.class); // Converte o documento para Produto
                    produtos.add(produto);
                }else if (collection.equalsIgnoreCase("videos")) {
                    Produto produto = doc.toObject(Video.class); // Converte o documento para Produto
                    produtos.add(produto);
                }

            }
            return produtos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
    //Este método encontra um produto utilizando o ID
    public static Produto encontrarProduto(String id, String collection) {
        try {
            DocumentSnapshot doc = db.collection("produtos").document(id).get().get();
            if (doc.exists()) {
                String tipo = doc.getString("tipo");
                if ("Game".equalsIgnoreCase(tipo)) {
                    return new Game(
                            doc.getString("nome"),
                            doc.getString("codigo"),
                            doc.getString("classInd"),
                            doc.getString("publicadora"),
                            doc.getString("desenvolvedor"),
                            doc.getString("plataforma"),
                            doc.getBoolean("estaAlugado"),
                            doc.getLong("alugueis"),
                            doc.getLong("estoque"),
                            doc.getLong("preco")
                            );
                } else {
                    return new Video(
                            doc.getString("nome"),
                            doc.getString("codigo"),
                            doc.getString("classInd"),
                            doc.getString("estudio"),
                            doc.getString("distribuidora"),
                            doc.getString("formato"),
                            doc.getString("tipoMidia"),
                            doc.getLong("duracao").intValue(),
                            doc.getBoolean("estaAlugado"),
                            doc.getLong("alugueis"),
                            doc.getLong("estoque"),
                            doc.getLong("preco")
                            );
                }
            } else {
                System.out.println("Produto não encontrado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + e.getLocalizedMessage(),
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
}
