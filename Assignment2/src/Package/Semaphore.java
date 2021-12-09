package Package;
public class Semaphore {
    protected int value = 0 ;

    protected Semaphore()
    {
        value = 0 ;
    }
    protected Semaphore(int initial)
    {
        value = initial ;
    }


    public synchronized void add(Device device) throws InterruptedException
    {
        value-- ;
        if (value < 0){
            for (int i = 0; i < Network.devices.size(); i++) {
                if(Network.devices.get(i).getName()==device.getName()){
                    for (int j = 0; j <Network.connectionNumber; j++) {
                        if(Network.connections[j]==""||Network.connections[j]==null){
                            Network.connections[i]=device.getName();

                            break;
                        }}
                }}// set the Device into connections


            System.out.println("- "+ device.getName() + " ( " + device.getType()+ " )" + " Arrived and waiting");
            wait();
        }else{
            System.out.println(device.getName() + " ( " + device.getType()+ " )" + " Arrived");
        }
    }
    public synchronized void remove(Device device)
    {
        value++ ;
        if (value <= 0)
            notify() ;
        System.out.println( "- Connection " + Network.connectionNumber(device.getName()) + ": " + device.getName() + " Logged out");
    }
}


