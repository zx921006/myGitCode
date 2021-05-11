package observer.v3;

public class Main {
    public static void main(String[] args) {
        Childer childer = new Childer();
        childer.wakeUp();
    }
}
class Childer {
    private boolean cry = false;
    Dad dad = new Dad();
    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        System.out.println("wakeUp wu ......");
        cry = true;
        dad.feed();
    }
}
class Dad{
    public void feed(){
        System.out.println("dad feeding ....");
    }
}