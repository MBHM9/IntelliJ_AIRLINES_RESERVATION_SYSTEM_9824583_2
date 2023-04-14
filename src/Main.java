import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Flight_schedule[] Flight_schedule = new Flight_schedule[1000];


        Flight_schedule[0] = new Flight_schedule("WX-12", "Yazd", "Tehran", 1402, 5, 2, 12, 15, 700, 100,0);
        Flight_schedule[1] = new Flight_schedule("GA-12", "Yazd", "Esfahan", 1402, 5, 5, 22, 30, 400, 50,0);

        Passenger_data[] Passenger_data = new Passenger_data[10000];
        Passenger_data[0] = new Passenger_data("mohammad", "1234", 5000, null);
        Passenger_data[1] = new Passenger_data("Ali", "5863", 1500, null);

        Admin_data[] Admin_data = new Admin_data[10];
        Admin_data[0] = new Admin_data("admin1", "123456");
        Admin_data[1] = new Admin_data("admin2", "78910");




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
                System.out.println("Enter your user name:");
                String user_new = input.next();
                System.out.println("Enter your user password:");
                String pass_new = input.next();

            }else {
                System.out.println("Wrong!");
            }
        }
    }
}
