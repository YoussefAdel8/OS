package Package;

import java.util.ArrayList;

public class Router {
    private Semaphore semaphore;
    public  int connectionNumber;
    public  Device [] connectedDevices ;
    public  Device [] waitingDevices ;
    public  ArrayList<Device> devices = new ArrayList<Device>();

    public Router(int connectionNum ,ArrayList<Device> devices) {
        this.connectionNumber = connectionNum;
        this.connectedDevices = new Device[connectionNum];
        semaphore=new Semaphore(connectionNumber);
    }
    public  void  occupyConnection (Device device) throws InterruptedException{

        semaphore.add(device);
        System.out.println("- Connection " + Network.connectionNumber(device.getName()) + ": " + device.getName() + " Occupied");
        Thread t=new Thread(device);
        t.start();
        releaseConnection(device);

    }//add to the connections list then active it

    public  void releaseConnection (Device device){

        for (int i = 0; i < Network.connectionNumber; i++) {
            if(Network.connections[i]==device.getName()){
                Network.connections[i]="";
            }}
        semaphore.remove(device);

    }//release connection then remove it for the connections

}
