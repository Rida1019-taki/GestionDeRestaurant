package GestionDeRestautant;

public class Plats {
    private String nom;
    private double prix;

    public Plats(String nom , double prix){
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() { return nom; }
    public double getPrix() { return prix; }

    public void AfficherPlats(){
        System.out.println("Plat : " + nom + " / Prix : " + prix + " DH");
    }
}
