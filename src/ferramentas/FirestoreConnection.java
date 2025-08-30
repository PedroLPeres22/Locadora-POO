//Autores
//PEDRO LEONARDO S. DA S. DE O. PERES 
//LORENZO DE OLIVEIRA E SILVA 
//GABRIEL EVANGELISTA BERTOLINO DOS SANTOS


package ferramentas;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;

public class FirestoreConnection {
    //Realiza a conexão com o banco de dados
    private static Firestore db;

    public static Firestore getFirestore() throws IOException {
        if (db == null) {
            //Lê o arquivo credencial do banco de dados Firebase
            FileInputStream serviceAccount = new FileInputStream("serviceAccountKey.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            db = FirestoreClient.getFirestore();
        }
        return db;
    }
}
