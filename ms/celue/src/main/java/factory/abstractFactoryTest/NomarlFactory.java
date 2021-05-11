package factory.abstractFactoryTest;


public class NomarlFactory extends UserAbstractFactory {
    @Override
    Register register() {
        return new NomRegister();
    }

    @Override
    Room createRoom() {
        return new NomRoom();
    }
}
