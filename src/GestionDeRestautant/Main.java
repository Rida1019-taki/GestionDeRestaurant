package GestionDeRestautant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Restaurant restaurant = new Restaurant("Hunger Killer Station");
    static List<Clients> clients = new ArrayList<>();
    static List<Serveurs> serveurs = new ArrayList<>();

    public static void initialiserMenu() {
        restaurant.ajouterPlat(new Plats("Tacos", 35));
        restaurant.ajouterPlat(new Plats("Burger Fromage", 45));
        restaurant.ajouterPlat(new Plats("Pizza Poulet", 60));
        restaurant.ajouterPlat(new Plats("Sandwich Mixte", 25));
        restaurant.ajouterPlat(new SpecifiquePlats("Salade Healthy", 30, "Végétarien"));
    }

    public static void menu() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1. Afficher le menu des plats");
        System.out.println("2. Ajouter un client");
        System.out.println("3. Afficher les clients");
        System.out.println("4. Passer une commande");
        System.out.println("5. Afficher toutes les commandes");
        System.out.println("0. Quitter");
        System.out.print("Entrez votre choix : ");
    }

    public static void main(String[] args) {
        initialiserMenu();
        serveurs.add(new Serveurs(1, "Ahmed"));

        String choice;
        while(true) {
            menu();
            choice = scanner.nextLine();

            switch(choice) {
                case "1":
                    restaurant.afficherMenu();
                    break;

                case "2":
                    System.out.print("ID Client : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nom Client : ");
                    String nom = scanner.nextLine();

                    clients.add(new Clients(id, nom));
                    System.out.println("Client ajoute.");
                    break;

                case "3":
                    if(clients.isEmpty()) System.out.println("Aucun client.");
                    else {
                        System.out.println("\n--- Liste des clients ---");
                        for(Clients c : clients) c.AfficherCommande();
                    }
                    break;

                case "4":
                    if(clients.isEmpty()) {
                        System.out.println("Aucun client pour passer une commande.");
                        break;
                    }
                    System.out.print("ID Client : ");
                    int idClient = scanner.nextInt();
                    scanner.nextLine();

                    Clients client = null;
                    for(Clients c : clients)
                        if (c.getId() == idClient){
                            client = c;
                        }

                    if(client == null) {
                        System.out.println("Client introuvable.");
                        break;
                    }

                    Serveurs serveur = serveurs.get(0);
                    Commandes commande = new Commandes(restaurant.getMenu().size(), client, serveur);

                    restaurant.afficherMenu();

                    while(true) {
                        System.out.print("Numero du plat : ");
                        int numPlat = scanner.nextInt();
                        scanner.nextLine();
                        if(numPlat == 0) break;

                        if(numPlat < 1 || numPlat > restaurant.getMenu().size()) {
                            System.out.println("Numero invalide.");
                            continue;
                        }
                        commande.AjouterPlats(restaurant.getMenu().get(numPlat-1));
                        System.out.println("Plat ajoute.");
                    }

                    restaurant.ajouterCommande(commande);
                    client.AjouterCommande(commande);
                    serveur.prendreCommande(commande);

                    System.out.println("Commande effectuee");
                    break;

                case "5":
                    restaurant.afficherCommandes();
                    break;

                case "0":
                    return;

                default:
                    System.out.println("Choix invalide.");
            }
        }
    }
}