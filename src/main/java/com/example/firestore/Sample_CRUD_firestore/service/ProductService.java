package com.example.firestore.Sample_CRUD_firestore.service;

import com.example.firestore.Sample_CRUD_firestore.entity.Product;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class ProductService {

    public String productSave(Product product) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiCollection = firestore.collection("root").document(product.getName()).set(product);

        return apiCollection.get().getUpdateTime().toString();
    }

    public Product getProduct(String name) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference  = firestore.collection("root").document(name);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = apiFuture.get();

        Product product = null;
        if(documentSnapshot.exists()) {
            product = documentSnapshot.toObject(Product.class);
            return product;
        } else {
            return null;
        }
    }

    public String productUpdate(Product product) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiCollection = firestore.collection("root").document(product.getName()).set(product);

        return apiCollection.get().getUpdateTime().toString();
    }

    public String productDelete(String name) {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiCollection = firestore.collection("root").document(name).delete();

        return "Product ID "+name+" has been successfully deleted";
    }
}
