class Ticket{
    private int ticketNumber;
    private String customerName;
    private int seatNumber;



    public Ticket(int ticketNumber,String customerName,int seatNumber){
    this.ticketNumber=ticketNumber;
    this.customerName=customerName;
    this.seatNumber=seatNumber;
}

    public int getTicketNumber(){
     return ticketNumber;
}
 public String getCustomerName(){
    return customerName;
 }
public int getSeatNumber(){
    return seatNumber;
}
 public void setTicketNumber(int ticketNumber){
    this.ticketNumber=ticketNumber;
}
public void setCustomerName(String customerName){
    this.customerName=customerName;
}
public void setSeatNumber(int seatNumber){
    this.seatNumber=seatNumber;
}
public String toString(){
 return "Ticket No: " + ticketNumber + ", Customer Name: "+customerName+ ", +Seat No: "+seatNumber;
}

}



class BookingSystem{
private Ticket[] tickets = new Ticket[10];
private int count=0;

public void bookTicket(int ticketNumber,String customerName,int seatNumber){
if(count>=tickets.length){
System.out.println("All seats are booked. ");
return;
}
for(int i=0; i<count; i++){
if(tickets[i].getSeatNumber() == seatNumber){
 System.out.println("Seat No: "+seatNumber+" is already booked");
return;
}
}
tickets[count++]=new Ticket(ticketNumber,customerName,seatNumber);
 }
public void cancelTicket(int ticketNumber){
    for (int i=0; i<count; i++){
    if(tickets[i].getTicketNumber()==ticketNumber){
    for(int j=i; j<count-1; j++){
    tickets[j] = tickets[j+1];
}
tickets[--count]=null;
return;
}
}
System.out.println("TicketNumber: "+ticketNumber+" not found.");
}
public void displayAllBookedTickets(){
for(int i=0; i<count; i++){
 System.out.println(tickets[i]);
}
 }

}

class TicketBookingSystem{
public static void main(String[] args){
    BookingSystem tbs=new BookingSystem();

        tbs.bookTicket(1, "Alice", 1);
        tbs.bookTicket(2, "Bob", 2);
        tbs.bookTicket(3, "Charlie", 3);


        tbs.cancelTicket(2);
        tbs.bookTicket(4, "David", 2);

        tbs.displayAllBookedTickets();

 }

}
