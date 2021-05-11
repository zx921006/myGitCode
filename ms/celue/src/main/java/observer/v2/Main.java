package observer.v2;

public class Main {
    public static void main(String[] args) {
        Childer childer = new Childer();
        while (!childer.isCry()){
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
            System.out.println("observing...");
        }
    }
}
class Childer{
    private boolean cry = false;

    public boolean isCry(){return cry;}

    public void wakeUp(){
        System.out.println("wakeUp wu ......");
        cry=true;
    }
}
