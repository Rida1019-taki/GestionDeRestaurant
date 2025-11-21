package GestionDeRestautant;

public class SpecifiquePlats extends Plats{
    private String typeDePlats;

    public SpecifiquePlats(String nom, double prix, String typeDePlats) {
        super(nom, prix);
        this.typeDePlats = typeDePlats;
    }

    @Override
    public void AfficherPlats(){
        System.out.println("Plat Spécial : " + getNom() +
                " | Type : " + typeDePlats +
                " | Prix : " + getPrix());
    }
}
