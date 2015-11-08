package com.mik;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        System.out.println("Salut! Svp repondez aux questions"); //informations du joueur//


        String firstName = getName("Quel est votre prénom?");


        String lastName = getName("Quel est votre nom de famille?");


        int age = getAge();


        Player player1 = new Player(firstName, lastName, age);

        displayPlayer(player1);

////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Maintenant, parlons de la partie! Veuillez repondre aux questions SVP");

        PlayedGame.Difficulty difficulty = getDifficulty();

        boolean iswon = getVictory();

        int timeSpent = getTime();

        playerChoice();


    }


    public static void displayPlayer(Player player) {   //Display the player info, Affiche l'info du joueur//

        System.out.println("Nom: " + player.lastName);
        System.out.println("Prénom: " + player.firstName);
        System.out.println("Âge: " + player.age);


    }

    public static String getName(String question) {    //Ask and verify names, Demande et vérifie les noms//
        Scanner entree = new Scanner(System.in);
        while (true) {
            System.out.println(question);
            String name = entree.nextLine();
            if (name.length() > 2 && name.length() < 257)
                return name;
            System.out.println("Entrée invalide");
        }
    }

    public static int getAge() {                            //Ask and verify age, Demande et vérifie l'age //
        Scanner entree = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Quel est votre age");
                String age = entree.nextLine();
                int ageInt = Integer.parseInt(age);
                if (ageInt > 9 && ageInt < 91)
                    return ageInt;
                System.out.println("Entrée invalide");
            }
        } catch (Exception e) {
            System.out.println("Oups! Veuillez entrez un nombre entre 10 et 90 svp ");
        }


        return getAge();
    }

    public static void displayGame() {
        System.out.println("la difficulté était " + getDifficulty());
    }


    public static PlayedGame.Difficulty getDifficulty() {
        Scanner entree = new Scanner(System.in);
        PlayedGame.Difficulty finalDif = PlayedGame.Difficulty.unknown;
        while (true) {
            System.out.println("Quel Niveau avez vous choisi? 1 = Facile, 2 = Moyen, 3 =Difficile ");
            String dif = entree.nextLine();
            int difInt = Integer.parseInt(dif);

            if (difInt == 1) {
                finalDif = PlayedGame.Difficulty.easy;
                return finalDif;
            }

            if (difInt == 2) {
                finalDif = PlayedGame.Difficulty.medium;
                return finalDif;
            }

            if (difInt == 3) {
                finalDif = PlayedGame.Difficulty.hard;
                return finalDif;
            } else {
                System.out.println("Veuillez choisir une difficultée entre 1 et 3 SVP.");
                return getDifficulty();
            }
        }
    }

    public static boolean getVictory() {
        Scanner entree = new Scanner(System.in);
        while (true) {
            System.out.println("Avez vous gagné? SVP répondez par oui ou par non");
            String boolVic = entree.nextLine();

            if (boolVic =="oui" || boolVic =="OUI") {

                System.out.println("Félicitations!");
                return true;
            }
            if (boolVic == "non" || boolVic == "NON") {
                return false;
            } else {
                System.out.println("Désolé je n'ai pas compris! Repondez par oui ou par non SVP.");
                return getVictory();
            }

        }


    }


    public static int getTime() {
        Scanner entree = new Scanner(System.in);
        while (true) {
            System.out.println("Good Job! Maintenant, combien de temps vous à t'il fallu pour cette victoire? (temps en minutes)");
            int gameTime = entree.nextInt();
            System.out.println("Donc la partie vous a pris " + gameTime + " Minutes.");
            return gameTime;
        }


    }

    public static void playerChoice(){
        System.out.println("Maintenant, Que désirez vous faire?");
        System.out.println(" ");
        System.out.println("1 = ajouter une autre partie");
        System.out.println("2 = Voir vos informations personelles");
        System.out.println("3 = Voir les informations de parties");

        Scanner entree = new Scanner(System.in);

        int whatNow = entree.nextInt();

        if (whatNow == 1){

        }
        if (whatNow == 2){
            displayPlayer();
            playerChoice();
        }
        if(whatNow == 3){
            displayGame();
            playerChoice();
        }
        else {
            System.out.println("Oops, veuillez choisir un des trois choix en utilisant leur numero correspondant.");
            playerChoice();
        }

    }
}

