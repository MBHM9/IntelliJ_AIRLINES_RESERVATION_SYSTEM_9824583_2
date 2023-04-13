import java.util.Scanner;

public class Main {
    public static void main(String[] args) {




        Scanner input = new Scanner(System.in);
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("           WELCOME TO AIRLINES RESERVATION SYSTEM");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        while(true) {
            System.out.println("........................MENU OPTIONS......................");
            System.out.println("<1> Sign in");
            System.out.println("<2> Sign up");
            String menu_get = input.next();

            if (menu_get.equals("1")) {////////////<1> Sign in

            }else if(menu_get.equals("2")){////////////<2> Sign up

            }else {
                System.out.println("Wrong!");
            }
        }
    }
}
