package com.tenhomework;

public class Four {
    public static void main(String[] args) {
        Car car = new Car(12);
        car.getAir().flow();
        Car car1 = new Car(-1);
        car1.getAir().flow();
        Car car2 = new Car(89);
        car2.getAir().flow();
    }
}

class Car{
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }
    class Air{
        public void flow() {
            if (temperature > 40) {
                System.out.println("吹冷风");
            } else if (temperature < 0) {
                System.out.println("吹热风");
            } else {
                System.out.println("关闭空调");
            }
        }

    }
    public Air getAir(){
        return new Air();
    }

}