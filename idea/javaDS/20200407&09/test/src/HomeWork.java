/*public class HomeWork {
    String str = new String("good");
    char[ ] ch = { 'a' , 'b' , 'c' };
    public static void main(String args[]){
        HomeWork ex = new HomeWork();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }
    public void change(String str,char ch[ ]){
        str = "test ok";
        ch[0] = 'g';
    }
}*/
public class HomeWork{
    /*public static boolean isAdmin(String userId){
        return userId.toLowerCase()=="admin";
    }
    public static void main(String[] args){
        //System.out.println(isAdmin("Admin"));
        String s1="abc"+"def";//1
        String s2=new String(s1);//2
        if(s1.equals(s2))//3
            System.out.println(".equals succeeded");//4
        if(s1==s2)//5
            System.out.println("==succeeded");//6
    }*/
    public static int MyCompareTo(String stra,String strb) {
        int len1 = stra.length();
        int len2 = strb.length();
        int ret = len1 < len2 ? len1 : len2;
        char v1[] = stra.toCharArray();
        char v2[] = strb.toCharArray();
        for (int i = 0; i < ret; i++) {
            if(v1[i] != v2[i]) {
                return v1[i]-v2[i];
            }
        }
        return len1-len2;
    }
    public static void main(String[] args) {
        String str1 = "abce";
        String str2 = "abcd";
        System.out.println(MyCompareTo(str1,str2));
    }
}
