package factory.factory;



public class CarFactory {
    public Car createCar(){
        System.out.println("开启car创建日志");
        return new Car();
    }
}
