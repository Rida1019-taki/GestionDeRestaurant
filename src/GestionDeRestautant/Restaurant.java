package GestionDeRestautant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String nom;
    private List<Plats> menu;
    private List<Commandes> commandes;

    public Restaurant(String nom) {
        this.nom = nom;
        this.menu = new ArrayList<>();
        this.commandes = new ArrayList<>();
    }

    public void ajouterPlat(Plats p) {
        menu.add(p);
    }

    public List<Plats> getMenu() {
        return menu;
    }

    public Plats getPlatParNom(String nom){
        for (Plats p : menu){
            if (p.getNom().equalsIgnoreCase(nom))
                return p;
        }
        return null;
    }

    public void afficherMenu() {
        System.out.println("----- Menu du Restaurant : " + nom + " -----");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).getNom() + " - " + menu.get(i).getPrix() + " DH");
        }
    }

    public void ajouterCommande(Commandes c) {
        commandes.add(c);
    }

    public void afficherCommandes() {
        System.out.println("----- Commandes passées -----");
        for (Commandes c : commandes) {
            c.AfficherCommande();
        }
    }

    public List<Commandes> getCommandes() {
        return commandes;
    }
}
