import java.util.Arrays;

public class Passenger_data {

    private String user;
    private String pass;
    private int charge;
    private String[] tickets;

    public Passenger_data(String user, String pass, int charge, String[] tickets) {
        this.user = user;
        this.pass = pass;
        this.charge = charge;
        this.tickets = tickets;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public String[] getTickets() {
        return tickets;
    }

    public void setTickets(String[] tickets) {
        this.tickets = tickets;
    }


    @Override
    public String toString() {
        return "Passenger_data{" +
                "user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", charge=" + charge +
                ", tickets=" + Arrays.toString(tickets) +
                '}';
    }
}
