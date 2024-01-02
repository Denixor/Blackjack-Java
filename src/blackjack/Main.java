package blackjack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int credit = Constants.INITIAL_CREDIT;
        System.out.println("Bem vindo a minha mesa de Blackjack");
        while (true) {
            if(credit == 0){System.out.println("Você ficou sem credito, Fim de jogo!"); break;}
            System.out.println("Você tem um total de: " + credit + " de credito!");
            System.out.println("1- Jogar, 2- Sair");
            System.out.println("Você deseja: ");
            int playerChoice = myObj.nextInt();
            if (playerChoice == 1){
                // Game
                System.out.println("Você deseja apostar quanto credito?");
                int gameBid;
                while(true) {
                    gameBid = myObj.nextInt();
                    if(gameBid > credit){
                        System.out.println("Você não tem esse credito!");
                        System.out.println("Você tem: " + credit + " Quer apostar quanto: ");
                    } else {
                        break;
                    }
                }
                // Colocar jogo aqui com o bid
                int game = Game.game();
                if(game == 0){
                    System.out.println("Você perdeu: " + gameBid + " Creditos!");
                    credit -= gameBid;
                }
                if(game == 1){
                    System.out.println("Você ganhou: " + gameBid + " Creditos!");
                    credit += gameBid;
                }
            } else if (playerChoice == 2) {
                // Exit
                System.out.println("Obrigado por jogar, Seu credito final foi: " + credit);
                break;
            } else {
                System.out.println("Opção Invalida");
            }
        }
    }
}