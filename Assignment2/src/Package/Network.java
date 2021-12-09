package Package;

import java.util.ArrayList;
import java.util.Scanner;

public class Network {
    public  static int connectionNumber;
    public static String [] connections ;
    static ArrayList<Device>  devices = new ArrayList<Device>();
    public static void main(String[] args) {
        ArrayList<Device> devices = new ArrayList<Device>();
        Scanner input = new Scanner(System.in);
        System.out.println("What is the number of WI-FI Connections?");
        int N = input.nextInt();
        Router router = new Router(N,devices);
        System.out.println("What is the number of devices Clients want to connect?");
        int TC = input.nextInt();
        for (int i = 0 ; i < TC;i++){
            String name;
            String type ;
            name = input.next();
            type = input.next();
            Device device = new Device(name,type);
            devices.add(device);

        }
        for (int i = 0; i < devices.size(); i++) {
            String name ;
            name= String.valueOf(i+1);
            Thread t1 = new Thread(devices.get(i), name);
            t1.start();

        }
    }
    public static int connectionNumber(String name){
        for (int i = 0; i <Network.connectionNumber ; i++) {
            if(Network.connections[i]==name){
                return (i+1);
            }}

        return -1;
    }// return connection number to the device if found >>>>
}

