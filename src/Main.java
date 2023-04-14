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

        Login_set Login_set = new Login_set(Passenger_data, Admin_data);
        Passenger_data Passenger_login = new Passenger_data(null, null, 0, null);
        Admin_data Admin_data_Login = new Admin_data(null, null);

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
                System.out.println("Enter user:");
                String user_enter = input.next();
                System.out.println("Enter pass:");
                String pass_enter = input.next();
                Passenger_login = Login_set.find_user(user_enter, pass_enter);
                if (Passenger_login == null) {
                    Admin_data_Login = Login_set.find_admin(user_enter, pass_enter);
                    if(Admin_data_Login == null){
                        System.out.println("user not found!");
                    }else{
                        /////////////start admin menu
                        System.out.println("444444444444");
                    }
                }
            }else if(menu_get.equals("2")){////////////<2> Sign up
                System.out.println("Enter your user name:");
                String user_new = input.next();
                boolean check_user = Login_set.check_new_user(user_new);
                if(check_user == true){/////////////add user
                    System.out.println("Enter your user password:");
                    String pass_new = input.next();
                    int free_space = Login_set.find_space();
                    Passenger_data[free_space] = new Passenger_data(user_new, pass_new, 0, null);
                    System.out.println("welcome to airline\nUser : "+Passenger_data[free_space].getUser()+"\nPass : "+Passenger_data[free_space].getPass());
                }else {
                    System.out.println("The username is already used!");
                }
            }else {
                System.out.println("Wrong!");
            }
        }
    }
}
