package Package;

public class Device implements Runnable {
    private String name;
    private String type;
    Device(String name , String type){
        this.name=name;
        this.type=type;
    }
    public void setName(String name){
        this.name=name;

    }
    public void setType(String type){
        this.type=type;

    }
    public String getName(){
        return name;

    }
    public String getType(){
        return type;

    }

    @Override
    public void run() {
        System.out.println("- Connection " + Thread.currentThread().getName()  + ": "
                + name + " Login");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println( "- Connection " + Thread.currentThread().getName() + ": " + name + " Performs online activity");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "- Connection " + Thread.currentThread().getName() + ": " + name + " Logged out");

    }
}
