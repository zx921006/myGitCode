package factory.factory;



/**
 * 简易工厂的可扩展不行 每一次新增一个交通工具得新家一个方法
 */
public class SimpleVehicleFactory {
    public Car createCar(){
        //可以给汽车加权限
        return new Car();
    }
    public Plane creatrPlane(){
        return new Plane();
    }
}
