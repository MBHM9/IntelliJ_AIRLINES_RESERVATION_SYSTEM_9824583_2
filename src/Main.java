import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Flight_schedule[] Flight_schedule = new Flight_schedule[100000];


        Flight_schedule[0] = new Flight_schedule("WX-12", "Yazd", "Tehran", 1402, 5, 2, 12, 15, 700000, 100,1);
        Flight_schedule[1] = new Flight_schedule("GA-12", "Tehran", "Esfahan", 1402, 12, 11, 10, 15, 400000, 50,1);
        Flight_schedule[2] = new Flight_schedule("CA-24", "Esfahan", "yazd", 1402, 5, 12, 15, 30, 650000, 0,1);
        Flight_schedule[3] = new Flight_schedule("CB-45", "Esfahan", "yazd", 1402, 5, 12, 20, 15, 750000, 50,1);
        Flight_schedule[4] = new Flight_schedule("CR-32", "Esfahan", "yazd", 1402, 5, 12, 22, 0, 800000, 20,1);

        Passenger_data[] Passenger_data = new Passenger_data[1000000];
        String[][] tickets_array = new String[1000000][200];
        Passenger_data[0] = new Passenger_data("mohammad", "1234", 500000, tickets_array[0]);
        Passenger_data[1] = new Passenger_data("Ali", "5863", 1500, tickets_array[1]);

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
                                int loc_id = Data_flight.find_schedule(edit_id);
                                if(loc_id == 1000000){
                                    System.out.println("Flight ID not found!");
                                }else{
                                    boolean edit_flight = true;
                                    while (edit_flight) {
                                        System.out.println("ID : " + Flight_schedule[loc_id].getFlight_id());
                                        System.out.println("<1> origin : " + Flight_schedule[loc_id].getOrigin());
                                        System.out.println("<2> destination : " + Flight_schedule[loc_id].getDestination());
                                        System.out.println("<3> date : " + Flight_schedule[loc_id].getDate_year() + "/" + Flight_schedule[loc_id].getDate_month() + "/" + Flight_schedule[loc_id].getDate_date());
                                        System.out.println("<4> time : " + Flight_schedule[loc_id].getTime_H() + ":" + Flight_schedule[loc_id].getTime_M());
                                        System.out.println("<5> price : " + Flight_schedule[loc_id].getPrice());
                                        System.out.println("<6> seats : " + Flight_schedule[loc_id].getSeats());
                                        System.out.println("<0> out edit");
                                        System.out.println("Enter edit field:");
                                        String field_edit = input.next();
                                        if (field_edit.equals("1")) { ///////////origin edit
                                            System.out.println("Enter new origin :");
                                            String new_origin_edit = input.next();
                                            Flight_schedule[loc_id].setOrigin(new_origin_edit);
                                        } else if (field_edit.equals("2")) { ///////////destination edit
                                            System.out.println("Enter new destination :");
                                            String new_destination_edit = input.next();
                                            Flight_schedule[loc_id].setDestination(new_destination_edit);
                                        } else if (field_edit.equals("3")) { ///////////date edit
                                            System.out.println("Enter new date by format 14XX/XX/XX :");
                                            String new_date_edit = input.next();
                                            char[] new_date_format_edit = new_date_edit.toCharArray();
                                            int new_year_edit = (new_date_format_edit[0]-48)*1000 + (new_date_format_edit[1]-48)*100 + (new_date_format_edit[2]-48)*10 + (new_date_format_edit[3]-48)*1;
                                            int new_month_edit = (new_date_format_edit[5]-48)*10 + (new_date_format_edit[6]-48)*1;
                                            int new_day_edit = (new_date_format_edit[8]-48)*10 + (new_date_format_edit[9]-48)*1;
                                            Flight_schedule[loc_id].setDate_year(new_year_edit);
                                            Flight_schedule[loc_id].setDate_month(new_month_edit);
                                            Flight_schedule[loc_id].setDate_date(new_day_edit);
                                        } else if (field_edit.equals("4")) { ///////////time edit
                                            System.out.println("Enter new time by format XX:XX :");
                                            String new_time_edit = input.next();
                                            char[] new_time_format_edit = new_time_edit.toCharArray();
                                            int new_hour_edit = (new_time_format_edit[0]-48)*10 + (new_time_format_edit[1]-48)*1;
                                            int new_min_edit = (new_time_format_edit[3]-48)*10 + (new_time_format_edit[4]-48)*1;
                                            Flight_schedule[loc_id].setTime_M(new_min_edit);
                                            Flight_schedule[loc_id].setTime_H(new_hour_edit);
                                        } else if (field_edit.equals("5")) { ///////////price edit
                                            System.out.println("Enter new price flight :");
                                            int new_price_edit = input.nextInt();
                                            Flight_schedule[loc_id].setPrice(new_price_edit);
                                        } else if (field_edit.equals("6")) { ///////////seats edit
                                            System.out.println("Enter new number of seats flight :");
                                            int new_seats_edit = input.nextInt();
                                            Flight_schedule[loc_id].setSeats(new_seats_edit);
                                        } else if (field_edit.equals("0")) { ///////////Esc edit
                                            edit_flight = false;
                                        }
                                    }
                                }
                            } else if (enter_option_admin.equals("3")) {/////////////<3> Remove
                                System.out.println("Enter ID flight:");
                                String edit_id = input.next();
                                int loc_id_remove = Data_flight.find_schedule(edit_id);
                                if(loc_id_remove == 1000000){
                                    System.out.println("Flight ID not found!");
                                }else {
                                    System.out.println("ID : " + Flight_schedule[loc_id_remove].getFlight_id());
                                    System.out.println("origin : " + Flight_schedule[loc_id_remove].getOrigin());
                                    System.out.println("destination : " + Flight_schedule[loc_id_remove].getDestination());
                                    System.out.println("date : " + Flight_schedule[loc_id_remove].getDate_year() + "/" + Flight_schedule[loc_id_remove].getDate_month() + "/" + Flight_schedule[loc_id_remove].getDate_date());
                                    System.out.println("time : " + Flight_schedule[loc_id_remove].getTime_H() + ":" + Flight_schedule[loc_id_remove].getTime_M());
                                    System.out.println("price : " + Flight_schedule[loc_id_remove].getPrice());
                                    System.out.println("seats : " + Flight_schedule[loc_id_remove].getSeats());

                                    System.out.println("if you want remove flight press YES/NO");
                                    String remove_ok = input.next();
                                    if(remove_ok.equals("YES")) {
                                        Flight_schedule[loc_id_remove]  = null;
                                        System.out.println("flight removed successfully");
                                    }
                                }
                            }else if(enter_option_admin.equals("4")){/////////////<4> Flight schedule
                                System.out.println("Enter origin :");
                                String search_origin = input.next();
                                System.out.println("Enter destination :");
                                String search_destination = input.next();
                                System.out.println("Enter date flight by format 14XX/XX/XX :");
                                String search_date = input.next();
                                char[] search_date_format = search_date.toCharArray();
                                int search_year = (search_date_format[0]-48)*1000 + (search_date_format[1]-48)*100 + (search_date_format[2]-48)*10 + (search_date_format[3]-48)*1;
                                int search_month = (search_date_format[5]-48)*10 + (search_date_format[6]-48)*1;
                                int search_day = (search_date_format[8]-48)*10 + (search_date_format[9]-48)*1;
                                System.out.println("|FlightId   |Origin        |Destination   |Date         |Time     |Price     |Seats|");
                                System.out.println("....................................................................................");
                                boolean search_ok = false;
                                for (int i = 0; i < Flight_schedule.length; i++) {
                                    if(Flight_schedule[i]!=null && Flight_schedule[i].getOrigin().equals(search_origin) && Flight_schedule[i].getDestination().equals(search_destination) && Flight_schedule[i].getDate_year() == search_year && Flight_schedule[i].getDate_month() == search_month && Flight_schedule[i].getDate_date() == search_day) {
                                        search_ok = true;
                                        String show_price = String.format("%d",Flight_schedule[i].getPrice());
                                        String show_Seats = String.format("%d",Flight_schedule[i].getSeats());
                                        String show_search = String.format("|%-11s|%-14s|%-14s|%d-%02d-%02d   |%02d:%02d    |%-10s|%-5s|", Flight_schedule[i].getFlight_id(), Flight_schedule[i].getOrigin(), Flight_schedule[i].getDestination(), Flight_schedule[i].getDate_year(), Flight_schedule[i].getDate_month(), Flight_schedule[i].getDate_date(), Flight_schedule[i].getTime_H(), Flight_schedule[i].getTime_M(), show_price, show_Seats);
                                        System.out.println(show_search);
                                        System.out.println("....................................................................................");
                                    }
                                }

                                if(search_ok == false){
                                    System.out.println("not found!");
                                }
                            }
                        }
                    }
                } else {
                    /////////////start passenger menu
                    int id_num_search = Login_set.find_user_id_num(user_enter, pass_enter);
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
                            System.out.println("Enter origin :");
                            String search_origin = input.next();
                            System.out.println("Enter destination :");
                            String search_destination = input.next();
                            System.out.println("Enter date flight by format 14XX/XX/XX :");
                            String search_date = input.next();
                            char[] search_date_format = search_date.toCharArray();
                            int search_year = (search_date_format[0]-48)*1000 + (search_date_format[1]-48)*100 + (search_date_format[2]-48)*10 + (search_date_format[3]-48)*1;
                            int search_month = (search_date_format[5]-48)*10 + (search_date_format[6]-48)*1;
                            int search_day = (search_date_format[8]-48)*10 + (search_date_format[9]-48)*1;
                            System.out.println("|FlightId   |Origin        |Destination   |Date         |Time     |Price     |Seats|");
                            System.out.println("....................................................................................");
                            boolean search_ok = false;
                            for (int i = 0; i < Flight_schedule.length; i++) {
                                if(Flight_schedule[i]!=null && Flight_schedule[i].getOrigin().equals(search_origin) && Flight_schedule[i].getDestination().equals(search_destination) && Flight_schedule[i].getDate_year() == search_year && Flight_schedule[i].getDate_month() == search_month && Flight_schedule[i].getDate_date() == search_day) {
                                    search_ok = true;
                                    String show_price = String.format("%d",Flight_schedule[i].getPrice());
                                    String show_Seats = String.format("%d",Flight_schedule[i].getSeats());
                                    String show_search = String.format("|%-11s|%-14s|%-14s|%d-%02d-%02d   |%02d:%02d    |%-10s|%-5s|", Flight_schedule[i].getFlight_id(), Flight_schedule[i].getOrigin(), Flight_schedule[i].getDestination(), Flight_schedule[i].getDate_year(), Flight_schedule[i].getDate_month(), Flight_schedule[i].getDate_date(), Flight_schedule[i].getTime_H(), Flight_schedule[i].getTime_M(), show_price, show_Seats);
                                    System.out.println(show_search);
                                    System.out.println("....................................................................................");
                                }
                            }

                            if(search_ok == false){
                                System.out.println("not found!");
                            }


                            } else if (enter_option_user.equals("3")) {///////////<3> Booking ticket
                            System.out.println("Enter ID flight:");
                            String Booking_id = input.next();
                            int loc_id_Booking = Data_flight.find_schedule(Booking_id);
                            if(loc_id_Booking == 1000000){
                                System.out.println("Flight ID not found!");
                            }else {
                                System.out.println("ID : " + Flight_schedule[loc_id_Booking].getFlight_id());
                                System.out.println("origin : " + Flight_schedule[loc_id_Booking].getOrigin());
                                System.out.println("destination : " + Flight_schedule[loc_id_Booking].getDestination());
                                System.out.println("date : " + Flight_schedule[loc_id_Booking].getDate_year() + "/" + Flight_schedule[loc_id_Booking].getDate_month() + "/" + Flight_schedule[loc_id_Booking].getDate_date());
                                System.out.println("time : " + Flight_schedule[loc_id_Booking].getTime_H() + ":" + Flight_schedule[loc_id_Booking].getTime_M());
                                System.out.println("price : " + Flight_schedule[loc_id_Booking].getPrice());
                                System.out.println("seats : " + Flight_schedule[loc_id_Booking].getSeats());
                                System.out.println("if you want reserved this flight for "+Flight_schedule[loc_id_Booking].getPrice()+"Tomans press YES/NO");
                                String Booking_ok = input.next();
                                if(Booking_ok.equals("YES")){
                                    if(Flight_schedule[loc_id_Booking].getSeats() >= 1) {
                                        if (Passenger_login.getCharge() >= Flight_schedule[loc_id_Booking].getPrice()) {
                                            int old_charge_booking = Passenger_login.getCharge();
                                            old_charge_booking = old_charge_booking - Flight_schedule[loc_id_Booking].getPrice();
                                            Passenger_login.setCharge(old_charge_booking);
                                            int old_seats_booking = Flight_schedule[loc_id_Booking].getSeats();
                                            Flight_schedule[loc_id_Booking].setSeats(old_seats_booking - 1);
                                            int old_passnum = Flight_schedule[loc_id_Booking].getId_passenger();
                                            String ID_user_flight =  String.format("%sTARS%05d", Flight_schedule[loc_id_Booking].getFlight_id(), old_passnum);
                                            Flight_schedule[loc_id_Booking].setId_passenger(old_passnum + 1);
                                            Login_set.set_ticket(Passenger_login.getUser(), ID_user_flight);
                                            System.out.println("Ticket  "+ID_user_flight+"     purchase was successful ");
                                        }else {
                                            System.out.println("Sorry your account balance is not enough to buy tickets");
                                        }
                                    }else {
                                        System.out.println("Sorry this flight seats are full!");
                                    }
                                }
                            }
                        } else if (enter_option_user.equals("4")) {///////////<4> Ticket cancellation
                            System.out.println("Enter ticket id to cancelling (10% of the ticket price will be deducted");
                            String cancelling_id = input.next();
                            boolean check_cancelling = false;
                            for (int i = 0; i < tickets_array[id_num_search].length; i++) {
                                if(cancelling_id.equals(tickets_array[id_num_search][i])){
                                    check_cancelling = true;
                                    String[] t_ids = tickets_array[id_num_search][i].split("TARS"); ///// to airline.....
                                    int ID_num_cancelling = Data_flight.find_schedule(t_ids[0]);
                                    System.out.println("ID : " + Flight_schedule[ID_num_cancelling].getFlight_id());
                                    System.out.println("origin : " + Flight_schedule[ID_num_cancelling].getOrigin());
                                    System.out.println("destination : " + Flight_schedule[ID_num_cancelling].getDestination());
                                    System.out.println("date : " + Flight_schedule[ID_num_cancelling].getDate_year() + "/" + Flight_schedule[ID_num_cancelling].getDate_month() + "/" + Flight_schedule[ID_num_cancelling].getDate_date());
                                    System.out.println("time : " + Flight_schedule[ID_num_cancelling].getTime_H() + ":" + Flight_schedule[ID_num_cancelling].getTime_M());
                                    System.out.println("Are you sure? press YES/NO");
                                    String cancelling_check_ok = input.next();
                                    if(cancelling_check_ok.equals("YES")){
                                        tickets_array[id_num_search][i] = null;
                                        int old_seats_cancelling = Flight_schedule[ID_num_cancelling].getSeats();
                                        Flight_schedule[ID_num_cancelling].setSeats(old_seats_cancelling + 1);
                                        int price_cancelling = Flight_schedule[ID_num_cancelling].getPrice();
                                        price_cancelling = price_cancelling - price_cancelling/10;
                                        int charge_cancelling = Passenger_login.getCharge();
                                        Passenger_login.setCharge(charge_cancelling + price_cancelling);
                                        System.out.println("Ticket cancellation was successful");
                                        i = tickets_array[id_num_search].length;
                                    }
                                }
                            }
                            if(check_cancelling == false){
                                System.out.println("ticket not found!");
                            }
                        } else if (enter_option_user.equals("5")) {///////////<5> Booked ticket
                            boolean reserved_out = false;
                            for (int i = 0; i < tickets_array[id_num_search].length; i++) {
                                if(tickets_array[id_num_search][i] == null){
                                    i = tickets_array[id_num_search].length;
                                }else {
                                    String[] t_ids = tickets_array[id_num_search][i].split("TARS"); ///// to airline.....
                                    int ID_num = Data_flight.find_schedule(t_ids[0]);
                                    System.out.println(tickets_array[id_num_search][i]+" :");
                                    System.out.println("ID : " + Flight_schedule[ID_num].getFlight_id());
                                    System.out.println("origin : " + Flight_schedule[ID_num].getOrigin());
                                    System.out.println("destination : " + Flight_schedule[ID_num].getDestination());
                                    System.out.println("date : " + Flight_schedule[ID_num].getDate_year() + "/" + Flight_schedule[ID_num].getDate_month() + "/" + Flight_schedule[ID_num].getDate_date());
                                    System.out.println("time : " + Flight_schedule[ID_num].getTime_H() + ":" + Flight_schedule[ID_num].getTime_M());
                                    System.out.println("..........................................................");
                                    reserved_out = true;
                                }
                            }
                            if(reserved_out == false){
                                System.out.println("Reserved tickets are not available");
                            }

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
                    Passenger_data[free_space] = new Passenger_data(user_new, pass_new, 0, tickets_array[free_space]);
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
