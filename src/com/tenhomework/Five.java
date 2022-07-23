package com.tenhomework;

public class Five {
    public static void main(String[] args) {
        Color green = Color.GREEN;
         green.show();
        switch(green){
            case RED:
                System.out.println("red");
                break;
            case BLUE:
                System.out.println("blue");
                break;
            case BLACK:
                System.out.println("black");
                break;
            case GREEN:
                System.out.println("green");
                break;
            case YELLOW:
                System.out.println("yellow");
                break;
            default:
                System.out.println("nothing");
                break;
        }
    }
}
enum Color implements inter{
    RED(255,0,0),BLUE(0,0,255),
    BLACK(0,0,0),YELLOW(255,255,0),
    GREEN(0,255,0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println(redValue +"," + greenValue + "," + blueValue);
    }
}

interface inter{
    public void show();
}