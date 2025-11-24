package GestionDeRestautant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Restaurant restaurant = new Restaurant("Slak Ajmai");
    static List<Clients> clients = new ArrayList<>();
    static List<Serveurs> serveurs = new ArrayList<>();
    static String choice;

    public static void initialiserMenu() {
        restaurant.ajouterPlat(new Plats("Tacos", 35));
        restaurant.ajouterPlat(new Plats("Burger Fromage", 45));
        restaurant.ajouterPlat(new Plats("Pizza Poulet", 60));
        restaurant.ajouterPlat(new Plats("Sandwich Mixte", 25));
        restaurant.ajouterPlat(new SpecifiquePlats("Salade Healthy", 30, "Végétarien"));
    }

    public static void menu() {
        System.out.println("\n===== MENU PRINCIPAL - Gestion de Restaurant =====");

        System.out.println(". Gestion du Restaurant");
        System.out.println("    1. Afficher le menu des plats");

        System.out.println(". Gestion des Clients");
        System.out.println("    2. Ajouter un client");
        System.out.println("    3. Afficher les clients");

        System.out.println(". Gestion des Commandes");
        System.out.println("    4. Passer une commande");
        System.out.println("    5. Afficher toutes les commandes");

        System.out.println(". Quitter");
        System.out.println("    0. Quitter l'application");

        System.out.print("\nEntrez votre choix : ");
        choice = scanner.nextLine();
    }

    public static void main(String[] args) {

        System.out.println("=== Système de Gestion de Restaurant ===");

        // Initialiser menu automatiquement
        initialiserMenu();

        while (true) {
            menu();

            switch (choice) {

                case "1":
                    restaurant.afficherMenu();
                    break;

                case "2":
                    System.out.print("ID Client : ");
                    int idC = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nom Client : ");
                    String nomC = scanner.nextLine();

                    clients.add(new Clients(idC, nomC));
                    System.out.println("Client ajoute.");
                    break;


                case "3":
                    for (Clients c : clients) {
                        System.out.println("Client ID :" + c.getId() + " | Nom : " + c.getNom());
                    }
                    break;


                case "4":

                    if (clients.isEmpty()) {
                        System.out.println("Aucun client trouvé.");
                        break;
                    }

                    System.out.println("=== Passer une commande ===");


                    System.out.print("ID Client : ");
                    int idClient = scanner.nextInt();
                    scanner.nextLine();

                    Clients client = null;
                    for (Clients c : clients) {
                        if (c.getId() == idClient) {
                            client = c;
                            break;
                        }
                    }

                    if (client == null) {
                        System.out.println("Client introuvable !");
                        break;
                    }

                    Serveurs serveur;
                    if (serveurs.isEmpty()) {
                        serveur = new Serveurs(1, "messi");
                        serveurs.add(serveur);
                    } else {
                        serveur = serveurs.get(0);
                    }

                    Commandes commande = new Commandes(restaurant.getCommandes().size() + 1, client, serveur);

                    System.out.println("\n--- Choisir les plats ---");

                    List<Plats> menu = restaurant.getMenu();
                    for (int i = 0; i < menu.size(); i++) {
                        System.out.println((i + 1) + ". " + menu.get(i).getNom() + " - " + menu.get(i).getPrix() + " DH");
                    }


                    while (true) {
                        System.out.print("Numéro du plat (0 = stop) : ");
                        int num = scanner.nextInt();

                        if (num == 0) break;

                        if (num < 1 || num > menu.size()) {
                            System.out.println("Numéro incorrect !");
                            continue;
                        }

                        Plats plat = menu.get(num - 1);
                        commande.AjouterPlats(plat);
                        System.out.println("Plat ajouté !");
                    }

                    scanner.nextLine(); // flush


                    restaurant.ajouterCommande(commande);
                    client.AjouterCommande(commande);
                    serveur.prendreCommande(commande);

                    System.out.println("Commande effectuée !");
                    break;

                case "5":
                    restaurant.afficherCommandes();
                    break;

                case "0":
                    System.out.println("Merci d'avoir utilisé l'application !");
                    return;

                default:
                    System.out.println("Option invalide !");
            }
        }
    }
}
