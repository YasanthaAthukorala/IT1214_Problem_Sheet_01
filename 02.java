class Vehicle{
    private String licensePlate,ownerName;
    private int hoursParked;
    
    public Vehicle(String licensePlate,String ownerName,int hoursParked){
        this.licensePlate=licensePlate;
        this.ownerName=ownerName;
        this.hoursParked=hoursParked;

    }
    public String getLicensePlate(){
        return licensePlate;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public int getHoursParked(){
        return hoursParked;
    }
    public void setLicensePlate(String licensePlate){
        this.licensePlate=licensePlate;
    }
    public void setOwnerName(String ownerName){
        this.ownerName=ownerName;
    }
    public void setHoursParked(String HoursParked){
        this.hoursParked=hoursParked;
    }
    public String toString(){
        return "License: "+ licensePlate +",Owner: "+ ownerName +",Hours: "+hoursParked;
    }
}
class ParkingLot{
    private Vehicle[] vehicles;
    private int count;

    public ParkingLot(){
        vehicles=new Vehicle[5];
        count=0;
    }
    public void parkVehicle(Vehicle v){
        if(count<vehicles.length){
            vehicles[count]=v;
            count++;
            System.out.println("Vehicle parked: "+v.getLicensePlate());
        } else {
            System.out.println("parking lot is full!");

        }
    }
    public void removeVehicle(String licensePlate){
    boolean found=false;
    for(int i = 0; i < count; i++){
    if(vehicles[i].getLicensePlate().equals(licensePlate)){
    for(int j = i; j < count-1; j++){
    vehicles[j] = vehicles[j + 1];
    }
    vehicles[--count] = null;
    count--;
    found=true;
    break;
    }
 }
 if(!found){
    System.out.println("Vehicles with license plate " + licensePlate + "not found.");
    }
}
public void displayVehicles(){
    if(count==0){
        System.out.println("No vehicle parks.");
    } else {
        for(int i = 0; i<count; i++){
        System.out.println(vehicles[i]);
            }
        }
    }
}
class parkingLotTracker{
    public static void main(String[] args){
    ParkingLot plt = new ParkingLot();

    plt.parkVehicle(new Vehicle("ABC123","Jhon Doe",2));
    plt.parkVehicle(new Vehicle("XYZ789","Jane Smith",4));
    plt.parkVehicle(new Vehicle("LMN456","bOB brown",1));

    plt.removeVehicle("XYZ789");
    plt.displayVehicles();
    }
}