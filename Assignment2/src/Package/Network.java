package Package;

import java.util.ArrayList;

public class Network {

    public static void main(String[] args) {
        ArrayList<Device> devices = new ArrayList<Device>();
        devices.add(new Device("c1", "mobile"));
        devices.add(new Device("c2", "phone"));
        devices.add(new Device("c3", "pc"));
        devices.add(new Device("c4", "pc"));
        for (int i = 0; i < devices.size(); i++) {
            String name ;
            name= String.valueOf(i+1);
            Thread t1 = new Thread(devices.get(i), name);
            t1.start();

        }
    }
}
