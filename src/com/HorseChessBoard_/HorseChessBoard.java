package com.HorseChessBoard_;

import java.awt.*;
import java.util.ArrayList;

public class HorseChessBoard {

    //定义属性
    private static int x = 6; // 行
    private static int y = 6; // 列
    private static int [][] chessBoard = new int [y][x];
    private static boolean [] visited = new boolean[x * y];
    private static boolean finished = false;

    public static void main(String[] args) {



        int row =5;
        int col =5;
        long start = System.currentTimeMillis();
        traversalChessBoard(chessBoard,row-1,col-1,1);
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end -start));

        for (int [] rows:chessBoard) {
            for (int step :rows) {  //step 表示马儿走的第几步
                System.out.print(step +"\t");
            }
            System.out.println();
        }

    }
//下一步可以走的位置有哪些(point 表示 x,y)
    public static ArrayList<Point> next(Point curpoint){
        //创建一个ArrayList
        ArrayList<Point> points = new ArrayList<>();
        //创建一个point对象(点/位置)
        Point point = new Point();
        //判断在curpoint 是否可以走如下位置，可以的话就将该点(Point) 放到 points 中

        //判断5是否可以走
        if ((point.x = curpoint.x-2) >= 0&&(point.y = curpoint.y -1) >= 0){
            points.add(new Point(point));
        }
        //判断6是否可以走
        if ((point.x = curpoint.x-1) >= 0&&(point.y = curpoint.y -2) >= 0){
            points.add(new Point(point));
        }
        //判断7是否可以走
        if ((point.x = curpoint.x+1) < x&(point.y = curpoint.y -2) >= 0){
            points.add(new Point(point));
        }
        //判断0是否可以走
        if ((point.x = curpoint.x + 2) < x&&(point.y = curpoint.y -1) >= 0){
            points.add(new Point(point));
        }
        //判断1是否可以走
        if ((point.x = curpoint.x + 2) < x&&(point.y = curpoint.y +1) < y){
            points.add(new Point(point));
        }
        //判断2是否可以走
        if ((point.x = curpoint.x + 1) < x&&(point.y = curpoint.y +2) < y){
            points.add(new Point(point));
        }
        //判断3是否可以走
        if ((point.x = curpoint.x -1) >= 0&&(point.y = curpoint.y +2) < y){
            points.add(new Point(point));
        }
        //判断4是否可以走
        if ((point.x = curpoint.x - 2) >= 0&&(point.y = curpoint.y +1) < y){
            points.add(new Point(point));
        }
        return points;
    }

    //核心算法
        //遍历棋盘，如果遍历成功，就将finished 设置为 true,并将马儿的每一步都记录到chessBoard
    public static void traversalChessBoard(int [][] chessBoard , int row ,int col ,int step){

        chessBoard[row][col] = step;
        visited[row * x + col] = true;
        ArrayList<Point> next = next(new Point(col, row));
        //遍历
        while (!next.isEmpty()){
            Point remove = next.remove(0);
            //判断该位置是是否走过，没有的话就进行递归遍历
            if (!visited[remove.y * x + remove.x]){
                //递归遍历
                traversalChessBoard(chessBoard, remove.y, remove.x, step+1);
            }
        }

        //退出while,看看是否成功,没成功就进行回溯
        if (step < x*y && !finished){
            chessBoard[row][col] = 0;
            visited[row * col] = false;
        }else{
            finished = true;
        }
    }

}
