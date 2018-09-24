package com.zek.restonspringwebmvc.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Auther zhangkai
 * @DateTime 2018/9/9 下午5:01
 */
public class Test2 {

    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int josephus(int n, int m) {

        int count = 0;
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        while (list.size() > 1){

            List<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                count++;
                if (count == m) {
                    list1.add(list.get(i));
                    count = 0;
                }
            }
            list.removeAll(list1);
        }

        res = list.get(0);

        return res;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
        int res;

//        int _n;
//        _n = Integer.parseInt(in.nextLine().trim());
//
//        int _m;
//        _m = Integer.parseInt(in.nextLine().trim());

        res = josephus(50, 3);
        System.out.println(String.valueOf(res));

    }
}
