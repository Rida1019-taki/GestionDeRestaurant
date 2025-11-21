package GestionDeRestautant;

public class ServeurVIP extends Serveurs {

    private String premuimService;

    public ServeurVIP(int id, String nom, String premuimService) {
        super(id, nom);
        this.premuimService = premuimService;
    }

    public void serviceVIP() {
        System.out.println("SERVICE VIP par " + nom + " : " + premuimService);
    }
}
