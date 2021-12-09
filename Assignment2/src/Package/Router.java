package Package;

public class Router {
    private Semaphore semaphore;
    public  int connectionNumber;
    public  Device [] connectedDevices ;
    public  Device [] waitingDevices ;

    public Router(int connectionNum) {
        this.connectionNumber = connectionNum;
        this.connectedDevices = new Device[connectionNum];
        semaphore=new Semaphore(connectionNumber);
    }

    public int occupyConnection (){
        int connectionNumber=0;
        for(int i=1; i <= connectedDevices.length;i++) {

        }
        return connectionNumber;
    }

    public void releaseConnection (int connectionNumber){
        connectedDevices[connectionNumber+1]=null;
        semaphore.remove();
    }

}
