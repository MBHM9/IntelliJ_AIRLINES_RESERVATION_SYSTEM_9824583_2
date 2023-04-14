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

    public Passenger_data change_pass_user (String user_f, String pass_f){
        for (int i = 0; i < Passenger_data.length; i++) {
            if(Passenger_data[i]!=null && Passenger_data[i].getUser().equals(user_f)){
                Passenger_data[i].setPass(pass_f);
                return Passenger_data[i];
            }
        }
        return null;
    }

    public Passenger_data add_user (String user_a, String pass_a){
        int len = Passenger_data.length;
        for (int i = 0; i < len; i++) {
            if(Passenger_data[i]!=null && Passenger_data[i].getUser().equals(user_a) && Passenger_data[i].getPass().equals(pass_a)){
                return null;
            }
        }
        Passenger_data[len].setUser(user_a);
        Passenger_data[len].setPass(pass_a);
        Passenger_data[len].setCharge(0);
        Passenger_data[len].setTickets(null);
        return Passenger_data[len];
    }








    @Override
    public String toString() {
        return "Login_set{" +
                "Passenger_data=" + Arrays.toString(Passenger_data) +
                ", Admin_data=" + Arrays.toString(Admin_data) +
                '}';
    }
}
