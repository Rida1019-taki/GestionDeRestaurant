package GestionDeRestautant;

public class Serveurs {
    protected int id;
    protected String nom;

    public Serveurs(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void prendreCommande(Commandes c) {
        System.out.println("Serveur " + nom + " a pris la commande " + c.getCommandeId());
    }
}
