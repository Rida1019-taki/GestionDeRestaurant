package GestionDeRestautant;

import java.util.ArrayList;
import java.util.List;

public class Clients {
    private int id;
    private String nom;
    private List<Commandes> commandes = new ArrayList<>();

    public Clients(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }

    public void AjouterCommande(Commandes c){
        if (!commandes.contains(c)) {
            commandes.add(c);
            System.out.println("La commande a été ajoutée.");
        } else {
            System.out.println("Cette commande existe déjà.");
        }
    }

    public void AfficherCommande(){
        System.out.println("Client : " + nom + " (ID : " + id + ")");
        for (Commandes cmd : commandes){
            cmd.AfficherCommande();
        }
    }
}
