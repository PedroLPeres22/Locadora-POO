import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import ferramentas.FirestoreConnection;
import dados.Cliente;

public class TesteSalvarCliente {
    public static void main(String[] args) throws Exception {
        Firestore db = FirestoreConnection.getFirestore();

        // Criando um cliente
        Cliente cliente = new Cliente("João Silva", "Rua A, 123", "99999-9999");

        // Salvando no Firestore (coleção "clientes")
        CollectionReference clientes = db.collection("clientes");
        ApiFuture<DocumentReference> future = clientes.add(cliente);

        // Pega o ID gerado automaticamente
        String idGerado = future.get().getId();
        System.out.println("Cliente salvo com ID: " + idGerado);
    }
}
