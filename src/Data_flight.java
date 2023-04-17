import java.util.Arrays;

public class Data_flight {

    private Flight_schedule[] Flight_schedule;

    public Data_flight(Flight_schedule[] flight_schedule) {
        Flight_schedule = flight_schedule;
    }

    public Flight_schedule[] getFlight_schedule() {
        return Flight_schedule;
    }

    public void setFlight_schedule(Flight_schedule[] flight_schedule) {
        Flight_schedule = flight_schedule;
    }

    public boolean check_schedule_id(String id_check){
        for (int i = 0; i < Flight_schedule.length; i++) {
            if(Flight_schedule[i]!=null && Flight_schedule[i].getFlight_id() == id_check){
                return false;
            }
        }
        return true;
    }

    public int find_space_schedule (){
        for (int i = 0; i < Flight_schedule.length; i++) {
            if( Flight_schedule[i] == null){
                return i;
            }
        }
        return 0;
    }



    @Override
    public String toString() {
        return "Data_flight{" +
                "Flight_schedule=" + Arrays.toString(Flight_schedule) +
                '}';
    }
}
