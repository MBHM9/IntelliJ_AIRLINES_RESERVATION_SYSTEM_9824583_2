import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Flight_schedule[] Flight_schedule = new Flight_schedule[100000];


        //Flight_schedule[0] = new Flight_schedule("WX-12", "Yazd", "Tehran", 1402, 5, 2, 12, 15, 700, 100,0);
        //Flight_schedule[1] = new Flight_schedule("GA-12", "Yazd", "Esfahan", 1402, 5, 5, 22, 30, 400, 50,0);

        Passenger_data[] Passenger_data = new Passenger_data[1000000];
        Passenger_data[0] = new Passenger_data("mohammad", "1234", 5000, null);
        Passenger_data[1] = new Passenger_data("Ali", "5863", 1500, null);

        Admin_data[] Admin_data = new Admin_data[10];
        Admin_data[0] = new Admin_data("admin1", "123456");
        Admin_data[1] = new Admin_data("admin2", "78910");

        Login_set Login_set = new Login_set(Passenger_data, Admin_data);
        Passenger_data Passenger_login = new Passenger_data(null, null, 0, null);
        Admin_data Admin_data_Login = new Admin_data(null, null);

        Data_flight Data_flight = new Data_flight(Flight_schedule);

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
                    } else {
                        /////////////start admin menu
                        boolean admin_menu = true;
                        while (admin_menu) {
                            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                            System.out.println("                     ADMIN MENU OPTION");
                            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                            System.out.println("..........................................................");
                            System.out.println("<1> Add");
                            System.out.println("<2> Update");
                            System.out.println("<3> Remove");
                            System.out.println("<4> Flight schedule");
                            System.out.println("<0> Sign out");
                            String enter_option_admin = input.next();
                            if (enter_option_admin.equals("0")) {/////////////<0> Sign out
                                admin_menu = false;
                            } else if (enter_option_admin.equals("1")) {/////////////<1> Add
                                boolean add_id_flight = true;
                                while (add_id_flight) {
                                    System.out.println("<0> go to admin menu");
                                    System.out.println("Enter ID flight:");
                                    String new_id = input.next();
                                    if(new_id.equals("0")) {
                                        add_id_flight = false;
                                    } else if (Data_flight.check_schedule_id(new_id) == true) {
                                        int free_space_schedule = Data_flight.find_space_schedule();
                                        System.out.println("Enter origin flight "+new_id+" :");
                                        String new_origin = input.next();
                                        System.out.println("Enter destination flight "+new_id+" :");
                                        String new_destination = input.next();
                                        System.out.println("Enter date flight by format 14XX/XX/XX :");
                                        String new_date = input.next();
                                        System.out.println("Enter time flight by format XX:XX :");
                                        String new_time = input.next();
                                        System.out.println("Enter price flight :");
                                        int new_price = input.nextInt();
                                        System.out.println("Enter number of seats flight :");
                                        int new_seats = input.nextInt();
                                        char[] new_date_format = new_date.toCharArray();
                                        int new_year = (new_date_format[0]-48)*1000 + (new_date_format[1]-48)*100 + (new_date_format[2]-48)*10 + (new_date_format[3]-48)*1;
                                        int new_month = (new_date_format[5]-48)*10 + (new_date_format[6]-48)*1;
                                        int new_day = (new_date_format[8]-48)*10 + (new_date_format[9]-48)*1;
                                        char[] new_time_format = new_time.toCharArray();
                                        int new_hour = (new_time_format[0]-48)*10 + (new_time_format[1]-48)*1;
                                        int new_min = (new_time_format[3]-48)*10 + (new_time_format[4]-48)*1;
                                        System.out.println("ID : "+new_id);
                                        System.out.println("origin : "+new_origin);
                                        System.out.println("destination : "+new_destination);
                                        System.out.println("date : "+new_year+"/"+new_month+"/"+new_day);
                                        System.out.println("time : "+new_hour+":"+new_min);
                                        System.out.println("price : "+new_price);
                                        System.out.println("seats : "+new_seats);
                                        System.out.println("if values are true press YES/NO");
                                        String new_data_set_ok = input.next();
                                        if(new_data_set_ok.equals("YES")){
                                            System.out.println("saving...");
                                            Flight_schedule[free_space_schedule] = new Flight_schedule(new_id, new_origin, new_destination, new_year, new_month, new_day, new_hour, new_min, new_price, new_seats,1);
                                            System.out.println(new_id+" is saved");
                                        } else{
                                            System.out.println("Try again");
                                        }
                                    } else {
                                        System.out.println("Flight ID is already used! Try again");
                                    }
                                }
                            } else if (enter_option_admin.equals("2")) {/////////////<2> Update
                                System.out.println("Enter ID flight:");
                                String edit_id = input.next();

                            }
                        }
                    }
                } else {
                    /////////////start passenger menu
                    boolean passenger_menu = true;
                    while (passenger_menu) {
                        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                        System.out.println("                  PASSENGER MENU OPTION");
                        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                        System.out.println("..........................................................");
                        System.out.println("<1> Change password");
                        System.out.println("<2> Search flight tickets");
                        System.out.println("<3> Booking ticket");
                        System.out.println("<4> Ticket cancellation");
                        System.out.println("<5> Booked ticket");
                        System.out.println("<6> Add charge");
                        System.out.println("<0> Sign out");
                        String enter_option_user = input.next();
                        if (enter_option_user.equals("0")) {/////////////<0> Sign out
                            passenger_menu = false;
                        } else if (enter_option_user.equals("1")) {///////////<1> Change password
                            System.out.println("Enter old password:");
                            String old_pass = input.next();
                            if(old_pass.equals(Passenger_login.getPass())){
                                System.out.println("Enter new password:");
                                String new_pass = input.next();
                                Passenger_login = Login_set.change_pass_user(user_enter, new_pass);
                                System.out.println("Password changed\nnew password : "+new_pass);
                            }else {
                                System.out.println("old pass is wrong!");
                            }
                        } else if (enter_option_user.equals("2")) {///////////<2> Search flight tickets

                        } else if (enter_option_user.equals("3")) {///////////<3> Booking ticket

                        } else if (enter_option_user.equals("4")) {///////////<4> Ticket cancellation

                        } else if (enter_option_user.equals("5")) {///////////<5> Booked ticket

                        } else if (enter_option_user.equals("6")) {///////////<6> Add charge
                            System.out.println("account credit : "+Passenger_login.getCharge());
                            System.out.println("Enter the amount of your credit increase:");
                            int charge_new = input.nextInt();
                            Passenger_login = Login_set.add_charge(Passenger_login.getUser(), charge_new);
                            System.out.println("New account credit : "+Passenger_login.getCharge());
                        } else {
                            System.out.println("Wrong operand try again!");
                        }
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
