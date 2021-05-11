package factory.abstractfactory;



public class Main {
    public static void main(String[] args) {
        ModernFactory f = new ModernFactory();
        Vehicle vehicle = f.createVehicle();
        vehicle.go();
        Weapon w = f.createWeapon();
        w.shoot();
        Food food = f.createFood();
        food.printName();
    }
}
