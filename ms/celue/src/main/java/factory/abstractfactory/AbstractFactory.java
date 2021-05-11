package factory.abstractfactory;



public abstract class AbstractFactory {
    abstract Food createFood();

    abstract Vehicle createVehicle();

    abstract Weapon createWeapon();

    abstract Moveable create();
}
