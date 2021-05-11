package factory.abstractFactoryTest;


public class Main {
    public static void main(String[] args) {
        NomarlFactory nomarlFactory = new NomarlFactory();
        Room room = nomarlFactory.createRoom();
        Register register = nomarlFactory.register();
        room.room();
        register.Register();
        testUserFactory testUserFactory = new testUserFactory();
        testUserFactory.createRoom().room();
        testUserFactory.register().Register();
    }
}
