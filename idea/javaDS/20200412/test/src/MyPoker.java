import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MyPoker {
    static class Card {
        public String suit;
        public String rank;

        public Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString() {
            //return "(" + suit + rank + ")";
            //String.format()是静态方法，可以像C语言中的printf一样构造格式化字符串
            return String.format("(%s%s)",suit,rank);
        }
    }
    //创建一副牌
    public static List<Card> creakPoker () {
        String[] suits = {"♠","♣","♥","♦"};
        List<Card> poker = new ArrayList<>();
        for(int i = 0 ; i < 4 ; i++) {
            for (int j = 2; j <= 10; j++) {
                Card card = new Card(suits[i],String.valueOf(j));
                poker.add(card);
            }
            poker.add(new Card(suits[i],"J"));
            poker.add(new Card(suits[i],"Q"));
            poker.add(new Card(suits[i],"K"));
            poker.add(new Card(suits[i],"A"));
        }
        return poker;
    }
    //洗牌
    public static void shuffle(List<Card> poker) {
        Random random = new Random();
        for (int i = poker.size()-1; i > 0; i--) {
            int r = random.nextInt(i);
            swap(poker,i,r);
        }
    }
    public static void swap(List<Card> poker, int i,int j){
        Card tmp = poker.get(i);
        poker.set(i,poker.get(j));
        poker.set(j,tmp);
    }

    public static void main(String[] args) {
        //1,创建牌
        List<Card> poker = creakPoker();
        System.out.println(poker);

        //2，洗牌
        shuffle(poker);
        //Collections.shuffle(poker);
        System.out.println(poker);
        //3，发牌
        List<List<Card>> players = new ArrayList<List<Card>>();
        List<Card> players1 = new ArrayList<>();
        List<Card> players2 = new ArrayList<>();
        List<Card> players3 = new ArrayList<>();
        /*ArrayList<ArrayList<Card>> players = new ArrayList<ArrayList<Card>>();
        ArrayList<Card> players1 = new ArrayList<>();
        ArrayList<Card> players2 = new ArrayList<>();
        ArrayList<Card> players3 = new ArrayList<>();*/
        players.add(players1);
        players.add(players2);
        players.add(players3);
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 3 ; j++) {
                List<Card> player = players.get(j);
                Card topCard = poker.remove(0);
                player.add(topCard);
            }
        }
        System.out.println("玩家1的手牌：");
        System.out.println(players1);
        System.out.println("玩家2的手牌：");
        System.out.println(players2);
        System.out.println("玩家3的手牌：");
        System.out.println(players3);
        System.out.println(poker);
    }
}
