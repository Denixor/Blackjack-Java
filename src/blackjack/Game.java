package blackjack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static int game(){
        int winner = 0;
        ArrayList<Integer> playerHand = new ArrayList<Integer>();
        ArrayList<Integer> tableHand = new ArrayList<Integer>();

        // Players Buys Initial Cards
        for(int i = 0; i < Constants.INITIAL_CARDS; i++){
            int card = buyCard();
            System.out.println("Você comprou a carta: " + card);
            playerHand.add(card);
        }
        // Table Buys Initial Cards
        for(int i = 0; i < Constants.INITIAL_CARDS; i++){
            int card = buyCard();
            System.out.println("A mesa comprou a carta: " + card);
            tableHand.add(card);
        }
        // Game Loops
        while (true){
            // Total
            int playerTotal = total(playerHand);
            int tableTotal = total(tableHand);
            System.out.println("Você tem um total de: " + playerTotal);
            System.out.println("A mesa tem um total de: " + tableTotal);

            // Winner
            if(playerTotal > 21){System.out.println("Você passou de 21");break;}
            if(tableTotal > 21){System.out.println("Eu passei de 21");winner=1;break;}
            if(playerTotal == 21){System.out.println("Você atingiu 21, parabéns você venceu!");winner=1;break;}
            if(tableTotal == 21){System.out.println("Eu atingi 21, eu ganhei! ");break;}

            // Player Choices
            System.out.println("1- Comprar Carta, 2- Segurar Mão, 3- Desistir");
            Scanner myObj = new Scanner(System.in);
            int playerChoise = myObj.nextInt();
            if(playerChoise == 1){
                int card = buyCard();
                System.out.println("Você comprou a carta: " + card);
                playerHand.add(card);
            } else if (playerChoise == 2) {
                while(true){
                    if(tableTotal < 16){
                        int card = buyCard();
                        System.out.println("A mesa comprou a carta: " + card);
                        tableHand.add(card);
                    }
                    break;
                }
                if(playerTotal >= tableTotal){
                    System.out.println("Parabéns você ganhou, seu total foi: " + playerTotal);
                    System.out.println("E o meu total foi: " + tableTotal);
                    winner=1;
                    break;
                } else {
                    System.out.println("Eu ganhei, seu total foi: " + playerTotal);
                    System.out.println("E o meu total foi: " + tableTotal);
                    break;
                }

            } else if (playerChoise == 3) {
                System.out.println("Então eu ganhei!");
                break;
            } else {
                System.out.println("Opção Invalida");
            }

        }

        // winner = 0 player loses
        // winner = 1 player wins
        return winner;
    }
    public static int buyCard() {
        Random random = new Random();
        int newCard = 0;
        while(newCard == 0){
            newCard = random.nextInt(Constants.MAX_CARD_DECK);
        }
        return newCard;
    }
    public static int total(ArrayList<Integer> hand){
        int result = 0;
        for(int i = 0; i < hand.size(); i++){
            result += hand.get(i);
        }
        return result;
    }
}
