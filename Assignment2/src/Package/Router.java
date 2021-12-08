package Package;

public class Router {
    private Semaphore semaphore;
    public  int connectionNumber;
    public  int [] connections ;


    public Router(int connectionNum) {
        this.connectionNumber = connectionNum;
        this.connections = new int[connectionNum];
        semaphore=new Semaphore(connectionNumber);
    }

    public int occupyConnection (){
        int connectionNumber=0;
        for(int i=1; i <= connections.length;i++) {
            if( connections[i]==0){
                connections[i]=i;
                connectionNumber=i;
                break;
            }
        }
        return connectionNumber;
    }

    public void releaseConnection (int connectionNumber){
        connections[connectionNumber+1]=0;
        semaphore.remove();
    }

}
