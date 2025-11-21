package GestionDeRestautant;

import java.util.ArrayList;
import java.util.List;

public class Commandes {
    private int commandeId;
    private Clients clients;
    private Serveurs serveurs;
    private List<Plats> plats;

    public Commandes(int commandeId, Clients clients, Serveurs serveurs) {
        this.commandeId = commandeId;
        this.clients = clients;
        this.serveurs = serveurs;
        this.plats = new ArrayList<>();
    }

    public int getCommandeId() { return commandeId; }

    public void AjouterPlats(Plats p){
        plats.add(p);
    }

    public double CalculerTotal(){
        double total = 0;
        for (Plats p : plats){
            total += p.getPrix();
        }
        return total;
    }

    public void AfficherCommande(){
        System.out.println("Commande " + commandeId);
        System.out.println("Client : " + clients.getNom());
        System.out.println("Serveur : " + serveurs.getNom());

        System.out.println("Plats :");
        for (Plats p : plats) {
            System.out.println(" - " + p.getNom() + " : " + p.getPrix());
        }

        System.out.println("Total : " + CalculerTotal() + " DH");
    }
}
