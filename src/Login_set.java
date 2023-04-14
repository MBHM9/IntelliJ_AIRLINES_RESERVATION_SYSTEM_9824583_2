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












    @Override
    public String toString() {
        return "Login_set{" +
                "Passenger_data=" + Arrays.toString(Passenger_data) +
                ", Admin_data=" + Arrays.toString(Admin_data) +
                '}';
    }
}
