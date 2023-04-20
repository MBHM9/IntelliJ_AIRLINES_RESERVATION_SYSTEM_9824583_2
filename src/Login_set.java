import java.util.Arrays;

public class Login_set {
    private Passenger_data[] Passenger_data;
    private Admin_data[] Admin_data;

    public Login_set(Passenger_data[] passenger_data, Admin_data[] admin_data) {
        Passenger_data = passenger_data;
        Admin_data = admin_data;
    }

    public Passenger_data[] getPassenger_data() {
        return Passenger_data;
    }

    public void setPassenger_data(Passenger_data[] passenger_data) {
        Passenger_data = passenger_data;
    }

    public Admin_data[] getAdmin_data() {
        return Admin_data;
    }

    public void setAdmin_data(Admin_data[] admin_data) {
        Admin_data = admin_data;
    }



    public Passenger_data find_user (String user_f, String pass_f){
        for (int i = 0; i < Passenger_data.length; i++) {
            if(Passenger_data[i]!=null && Passenger_data[i].getUser().equals(user_f) && Passenger_data[i].getPass().equals(pass_f) ){
                return Passenger_data[i];
            }
        }
        return null;
    }

    public int find_user_id_num (String user_f, String pass_f){
        for (int i = 0; i < Passenger_data.length; i++) {
            if(Passenger_data[i]!=null && Passenger_data[i].getUser().equals(user_f) && Passenger_data[i].getPass().equals(pass_f) ){
                return i;
            }
        }
        return 1000000;
    }

    public Admin_data find_admin (String admin_user_f, String admin_pass_f){
        for (int i = 0; i < Admin_data.length; i++) {
            if(Admin_data[i]!=null && Admin_data[i].getUser_admin().equals(admin_user_f) && Admin_data[i].getPass_admin().equals(admin_pass_f) ){
                return Admin_data[i];
            }
        }
        return null;
    }



    public Passenger_data change_pass_user (String user_f, String pass_f){
        for (int i = 0; i < Passenger_data.length; i++) {
            if(Passenger_data[i]!=null && Passenger_data[i].getUser().equals(user_f)){
                Passenger_data[i].setPass(pass_f);
                return Passenger_data[i];
            }
        }
        return null;
    }

    public boolean check_new_user (String user_n){
        for (int i = 0; i < Passenger_data.length; i++) {
            if( Passenger_data[i]!=null && Passenger_data[i].getUser().equals(user_n) ){
                return false;
            }
        }
        return true;
    }

    public void set_ticket(String user_t, String ticket_id){
        for (int i = 0; i < Passenger_data.length; i++) {
            if( Passenger_data[i]!=null && Passenger_data[i].getUser().equals(user_t) ){
                String[] tickets = Passenger_data[i].getTickets();
                for (int j = 0; j < tickets.length; j++) {
                    if(tickets[j] == null){
                        tickets[j] = ticket_id;
                        j = tickets.length;
                    }
                }
            }
        }
    }


    public int find_space (){
        for (int i = 0; i < Passenger_data.length; i++) {
            if( Passenger_data[i] == null){
                return i;
            }
        }
        return 0;
    }



    public Passenger_data add_charge(String user_ac , int charge_var){
        for (int i = 0; i < Passenger_data.length; i++) {
            if(Passenger_data[i]!=null && Passenger_data[i].getUser().equals(user_ac)){
                int charge = Passenger_data[i].getCharge();
                Passenger_data[i].setCharge(charge+charge_var);
                return Passenger_data[i];
            }
        }
        return null;
    }




    @Override
    public String toString() {
        return "Login_set{" +
                "Passenger_data=" + Arrays.toString(Passenger_data) +
                ", Admin_data=" + Arrays.toString(Admin_data) +
                '}';
    }
}
