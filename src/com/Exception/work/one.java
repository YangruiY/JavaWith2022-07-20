package com.Exception.work;

public class one {
    public static void main(String[] args) {
        //验证输入参数
        try {
            if(args.length != 2){
                throw  new ArrayIndexOutOfBoundsException("参数个数不对");
            }
            int a =Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);

            double res = cal(a,b);
            System.out.println("结果是 = " + res);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println( e.getMessage());
        } catch (NumberFormatException e){
            System.out.println("参数数据格式不正确");
        }catch (ArithmeticException e){
            // PS
            // 如果a b是double类型，name就算是0/0.0那么也不会出现   "出现/0异常"  的输出
            // 只有int 才会输出 "出现/0异常"，
            // 也就是说只有 int 才会有/0 异常
            System.out.println("出现/0异常");
        }
    }
    public static double cal(int a,int b){
        return a/b;
    }
}
