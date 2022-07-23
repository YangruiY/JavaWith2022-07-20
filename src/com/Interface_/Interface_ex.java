package com.Interface_;

public class Interface_ex {
    public static void main(String[] args) {
        Usb[] usbs = new Usb[2];
        usbs[0] = new phone();
        usbs[1] = new camera();
        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();
        if (usbs[i] instanceof phone){
            ((phone) usbs[i]).call();
        }
        }
    }
}

interface Usb{
void  work();
}

class phone implements  Usb{
    public void  call(){
        System.out.println("手机正在打电话");
    }

    @Override
    public void work() {
        System.out.println("手机调用该方法");
    }
}
class  camera implements  Usb{

    @Override
    public void work() {
        System.out.println("相机调用该方法");
    }

}