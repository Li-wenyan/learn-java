//自定义异常


//class MyException extends RuntimeException    MyException是运行时异常/非受查异常
//class MyException extends Exception   MyException是编译时异常/受查异常
/*class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

class UserException extends Exception {
    public UserException(String message) {
        super(message);
    }
}
class  PasswordException extends Exception {
    public PasswordException(String message) {
        super(message);
    }
}

public class TestDemo2 {
    private static String userName = "admin";
    private static String password = "123456";

    public static void main(String[] args) {
        try {
            login("admin","123456");
        }catch (UserException | PasswordException passwordException) {
            passwordException.printStackTrace();
        }*//*catch (UserException userException) {
            userException.printStackTrace();
        }*//*
    }
    public static void login(String userName,String password) throws UserException,PasswordException {
        if(!TestDemo2.userName.equals(userName)) {
            throw new UserException("用户名错误");
        }
        if(!TestDemo2.password.equals(password)) {
            throw new PasswordException("密码错误");
        }
        System.out.println("登录成功");
    }






    public static void func(int a) {
        try {
            if(a == 10) {
                throw new MyException("wuli加油");//自定义异常
            }
        }catch(MyException e) {
            e.printStackTrace();
            System.out.println("捕获MyException异常");
        }

    }
    public static void main1(String[] args) {
        func(10);
    }
}*/


import java.util.Scanner;

public class TestDemo2 {

    private static void testMethod(){

        System.out.println("testMethod");

    }

    public static void main(String[] args) {

        //((TestDemo2)null).testMethod();
        //getCustomerInfo();
        Scanner scanner = new Scanner(System.in);
        int a= scanner.nextInt();
        int b= scanner.nextInt();
        int ret = a > b ? a : b;
        int tmp = ret;
        while(true) {
            if(ret % a == 0 && ret % b == 0) {
                System.out.println(ret);
                break;
            }
            ret += tmp;
        }
    }
    /*public static void getCustomerInfo() {

        try {

            // do something that may cause an Exception
            int[] array = {1,2,3,4};
            System.out.println(array[100]);

        } catch (java.io.FileNotFoundException ex) {

            System.out.print("FileNotFoundException!");

        } catch (java.io.IOException ex) {

            System.out.print("IOException!");

        } catch (java.lang.Exception ex) {

            System.out.print("Exception!");

        }

    }*/

}

