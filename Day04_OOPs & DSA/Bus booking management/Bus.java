import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface Bus {
    void bookSeat(String userName, String email, String phone, String date, int seatNo, int timeSlot);
    int getSeatCount();
    void printBusDetails();
    void printAvailableSeats();
    void printAvailableTimes();
} 

abstract class BusBookingDetails implements Bus{
    Map<String, List<Object>> bookings;
    int seatCount;
    boolean[] seats;
    String timeSlots[];
    String seatType;
    String source;
    String destination;
    String busName;

    public boolean isAvailable(int seatNo){
        if(!seats[seatNo])
            return true;
        return false;
    }
}

class SleeperBus extends BusBookingDetails{
    SleeperBus(String busName, int seatCount, String source, String destination, String timeSlots[]){
        this.seatCount = seatCount;
        this.seatType = "Sleeper";
        this.source = source;
        this.destination = destination;
        this.timeSlots = timeSlots;
        this.busName = busName;
    }
    public void bookSeat(String userName, String email, String phone, String date, int seatNo, int timeSlot){

        if(!isAvailable(seatNo)){
            System.out.println("Seat is already booked!");
            return;
        }

        List<Object> userDetails= new ArrayList<>();
        userDetails.add(userName);
        userDetails.add(phone);
        userDetails.add(date);
        userDetails.add(seatNo);
        userDetails.add(timeSlot);

        //book the seat in seats array
        seats[seatNo] = true;
        seatCount--;

        //add the entry of user
        bookings.put(email, userDetails);

        System.out.println("Seat no. "+seatNo+" booked!");
    }

    public int getSeatCount(){
        return seatCount;
    }

    public void printBusDetails(){
        System.out.println("---------- !! Bus Name : "+busName+" !! ----------");
        System.out.println("No of Available seats : "+seatCount);
        System.out.println("Starts from: "+source+" to : "+destination);
        System.out.println("Time slots of departing from "+source);
        System.out.println("-------------------------------------------");
        int index=0;
        for(String time : timeSlots){
            System.out.println(index+". "+time);
            index++;
        }
    }

    public void printAvailableSeats(){
        System.out.println("No of Avaialable seats: "+seatCount);
        System.out.println("Available seats -->");
        System.out.println("------------------------------------------");
        int seatNo = 0;
        for(boolean seat : seats){
            if(!seat){
                System.out.println(busName+"-N"+seatNo);
            }
            seatNo++;
        }
    }

    public void printAvailableTimes(){
        System.out.println("Time slots of departing from "+source);
        int index=0;
        for(String time : timeSlots){
            System.out.println(index+". "+time);
            index++;
        }
    }
}

class SeaterBus extends BusBookingDetails{
    SeaterBus(String busName, int seatCount, String source, String destination, String timeSlots[]){
        this.seatCount = seatCount;
        this.seatType = "Seater";
        this.source = source;
        this.destination = destination;
        this.timeSlots = timeSlots;
        this.busName = busName;
    }
    public void bookSeat(String userName, String email, String phone, String date, int seatNo, int timeSlot){

        if(!isAvailable(seatNo)){
            System.out.println("Seat is already booked!");
            return;
        }

        List<Object> userDetails= new ArrayList<>();
        userDetails.add(userName);
        userDetails.add(phone);
        userDetails.add(date);
        userDetails.add(seatNo);
        userDetails.add(timeSlot);

        //book the seat in seats array
        seats[seatNo] = true;
        seatCount--;

        //add the entry of user
        bookings.put(email, userDetails);

        System.out.println("Seat no. "+seatNo+" booked!");
    }

    public int getSeatCount(){
        return seatCount;
    }

    public void printBusDetails(){
        System.out.println("---------- !! Bus Name :"+busName+"!! ----------");
        System.out.println("No of Available seats : "+seatCount);
        System.out.println("Starts from: "+source+" to : "+destination);
        System.out.println("Time slots of departing from "+source);
        System.out.println("-------------------------------------------");
        int index=0;
        for(String time : timeSlots){
            System.out.println(index+". "+time);
            index++;
        }
    }

    public void printAvailableSeats(){
        System.out.println("No of Avaialable seats: "+seatCount);
        System.out.println("Available seats -->");
        System.out.println("------------------------------------------");
        int seatNo = 0;
        for(boolean seat : seats){
            if(!seat){
                System.out.println(busName+"-N"+seatNo);
            }
            seatNo++;
        }
    }

    public void printAvailableTimes(){
        System.out.println("Time slots of departing from "+source);
        int index=0;
        for(String time : timeSlots){
            System.out.println(index+". "+time);
            index++;
        }
    }
}

class BusFactory {
    Bus bus;
    public static Bus createBus(String busType, String busName, int seatCount, String source, String destination, String timeSlots[]){
        if(busType.equalsIgnoreCase("Sleeper")){
            return new SleeperBus(busName, seatCount, source, destination, timeSlots);
        }else if(busType.equalsIgnoreCase("Seater")){
            return new SeaterBus(busName, seatCount, source, destination, timeSlots);
        }
        return null;
    }
} 

class BusManager {
    Map<String, List<Bus>> buses;
    BusManager manager = null;

    public void createBusManager(){
        if(manager != null)
            return;
        manager = new BusManager();
    }

    public void getBuses(String destination){
        if(buses.get(destination) == null){
            System.out.println("No buses available!");
            return;
        }
        System.out.println("List of buses to "+destination);
        for(Bus bus : buses.get(destination)){
            bus.printBusDetails();
        }
    }
    public Bus createBus(String busType, String busName, int seatCount, String source, String destination, String timeSlots[]){
        return BusFactory.createBus(busType, busName, seatCount, source, destination, timeSlots);
    }
}


public BusApp{
    
}