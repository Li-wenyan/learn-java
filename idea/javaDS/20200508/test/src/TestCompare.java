import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card implements Comparable<Card> {
    public String rank;
    public String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        //1.看看 this和obj身份是否相同
        if(this == obj) {
            return true;
        }
        //2.如果obj为null，一定不相等
        if(obj == null) {
            return false;
        }
        //3.obj的类型能否强转成Card
        if(!(obj instanceof Card)) {
            return false;
        }
        //4，类型转换，把参数转成Card类型
        Card other = (Card) obj;
        //前4步都是固定套路

        //5.真正进行按照指定规则比较
        return this.rank.equals(other.rank);
    }

    @Override
    public int compareTo(Card o) {
        //this,o
        //this  < o,返回 < 0
        //this  > o,返回 > 0
        //this 和 o相等,返回  0
        //定义比较规则：扑克牌的点数来比较
        int rank1 = this.convertRank();
        int rank2 = o.convertRank();
       /* //升序排序
        return rank1 - rank2;*/
        //降序排序
        return rank2 - rank1;
    }
    private int convertRank() {
        //把String类型的rank转成int值
        //J=>11
        if ("A".equals(rank)) {
            return 14;
        }
        if("K".equals(rank)) {
            return 13;
        }
        if("Q".equals(rank)) {
            return 12;
        }
        if("J".equals(rank)) {
            return 11;
        }
        return Integer.parseInt(rank);
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}
public class TestCompare {
    public static void main(String[] args) {
        Card card1 = new Card("4", "♥");
        Card card2 = new Card("10", "♠");
        Card card3 = card1;
        //==始终比较的是两个对象的身份，比较的是两个引用中保存的地址的值
        /*System.out.println(card1);
        System.out.println(card2);*/
        /*System.out.println(card1 == card2);
        System.out.println(card1 == card3);*/
       /* System.out.println(card1.equals(card2));
        System.out.println(card1.equals(card3));*/
        System.out.println(card1.compareTo(card2));
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("A", "红桃"));
        cards.add(new Card("J", "红桃"));
        cards.add(new Card("K", "红桃"));
        cards.add(new Card("10", "红桃"));
        Collections.sort(cards);
        System.out.println(cards);

    }
}
