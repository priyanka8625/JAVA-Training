import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

interface Bus {
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
                System.out.println(seatNo);
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
        System.out.println("Starts from: "+source+" to : "+destination);
        System.out.println("Time slots of departing from "+source);
        System.out.println("-------------------------------------------");
        int index=0;
        for(String time : timeSlots){
            System.out.println(index+". "+time);
            index++;
        }
        printAvailableSeats();
    }

    public void printAvailableSeats(){
        System.out.println("No of Avaialable seats: "+seatCount);
        System.out.println("Available seats -->");
        System.out.println("------------------------------------------");
        int seatNo = 0;
        for(boolean seat : seats){
            if(!seat){
                System.out.println(seatNo);
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
    static BusManager manager = null;

    public static BusManager getInstance(){
        if(manager != null)
            return manager;
        return new BusManager();
    }

    public void getBuses(String destination){
        if(buses.get(destination) == null){
            System.out.println("No buses available!");
            return;
        }
        System.out.println("List of buses to "+destination);
        int id=0;
        for(Bus bus : buses.get(destination)){
            System.out.println("-----------------------------------------");
            System.out.println("BUS ID : "+id++);
            bus.printBusDetails();
            System.out.println("-----------------------------------------");
        }
    }
    public Bus createBus(String busType, String busName, int seatCount, String source, String destination, String timeSlots[]){
        Bus bus = BusFactory.createBus(busType, busName, seatCount, source, destination, timeSlots);
        buses.get(destination).add(bus);
        return bus;
    }

    public void bookBus(String destination, int busId,String name, String email, String phone, String date, int seat, int time){
        buses.get(destination).get(busId).bookSeat(name, email, phone, date, seat, time);
    }

    public getBuses(){
        //bus name : src-dest
        for(Bus bus : buses.keySet()){
            
        }
    }
}


public class BusApp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //create all the buses
        BusManager manager = BusManager.getInstance();

        String[] timings = {"10.30", "4.30", "22.30"};
        //Kerala bus
        Bus KeralaSleeper = manager.createBus("Sleeper", "Kerala travels", 50, "Mumbai", "Kerala", timings);
        Bus KeralaSeater = manager.createBus("Seater", "Kerala travels", 50, "Mumbai", "Kerala", timings);
        
        //Delhi 
        String[] timings3 = {"10.30", "4.30", "22.30"};
        Bus DelhiSeater = manager.createBus("Seater", "Delhi travels", 50, "Mumbai", "Delhi", timings3);


        while(true){
            System.out.println("-------------------------------");
            System.out.println("----------- BUSES -------------");
            manager.getBuses();

            System.out.println("Enter the desination to book your bus : ");
            String destination = sc.nextLine();

            //show available buses
            manager.getBuses(destination);

            //take bus name
            System.out.println("Enter the bus id to book your ticket");
            int busId = Integer.parseInt(sc.nextLine());
            System.out.println("Enter seat no. you want to book : ");
            int seat = Integer.parseInt(sc.nextLine());
            System.out.println("Enter time slot id to book: ");
            int time = Integer.parseInt(sc.nextLine());

            //user details
            System.out.println("Enter your details-->");
            System.out.println("Enter your name: ");
            String name = sc.nextLine();
            System.out.println("Enter email: ");
            String email = sc.nextLine();
            System.out.println("Enter phone no.:");
            String phone = sc.nextLine();
            System.out.println("Enter date: ");
            String date = sc.nextLine();

            manager.bookBus(destination, busId, name, email, phone, date, seat, time);


        }
    }
}