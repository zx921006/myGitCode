package factory.abstractFactoryTest;



public class testUserFactory extends UserAbstractFactory {
    @Override
    Register register() {
        return new testRegister();
    }

    @Override
    Room createRoom() {
        return new testRoom();
    }
}
