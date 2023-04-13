public class Flight_schedule {

    private String flight_id;
    private String origin;
    private String destination;
    private int date_year;
    private int date_month;
    private int date_date;
    private int time_H;
    private int time_M;
    private int price;
    private int seats;
    private int id_passenger;

    public Flight_schedule(String flight_id, String origin, String destination, int date_year, int date_month, int date_date, int time_H, int time_M, int price, int seats, int id_passenger) {
        this.flight_id = flight_id;
        this.origin = origin;
        this.destination = destination;
        this.date_year = date_year;
        this.date_month = date_month;
        this.date_date = date_date;
        this.time_H = time_H;
        this.time_M = time_M;
        this.price = price;
        this.seats = seats;
        this.id_passenger = id_passenger;
    }

    public String getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDate_year() {
        return date_year;
    }

    public void setDate_year(int date_year) {
        this.date_year = date_year;
    }

    public int getDate_month() {
        return date_month;
    }

    public void setDate_month(int date_month) {
        this.date_month = date_month;
    }

    public int getDate_date() {
        return date_date;
    }

    public void setDate_date(int date_date) {
        this.date_date = date_date;
    }

    public int getTime_H() {
        return time_H;
    }

    public void setTime_H(int time_H) {
        this.time_H = time_H;
    }

    public int getTime_M() {
        return time_M;
    }

    public void setTime_M(int time_M) {
        this.time_M = time_M;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getId_passenger() {
        return id_passenger;
    }

    public void setId_passenger(int id_passenger) {
        this.id_passenger = id_passenger;
    }

    @Override
    public String toString() {
        return "Flight_schedule{" +
                "flight_id='" + flight_id + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", date_year=" + date_year +
                ", date_month=" + date_month +
                ", date_date=" + date_date +
                ", time_H=" + time_H +
                ", time_M=" + time_M +
                ", price=" + price +
                ", seats=" + seats +
                ", id_passenger=" + id_passenger +
                '}';
    }
}
