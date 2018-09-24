package com.zek.restonspringwebmvc.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Auther zhangkai
 * @DateTime 2018/9/9 下午4:35
 */
public class Test {

    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
        String[] res;
//
//        int _str_arr_size = 0;
//        _str_arr_size = Integer.parseInt(in.nextLine().trim());
//        String[] _str_arr = new String[_str_arr_size];
//        String _str_arr_item;
//        for(int _str_arr_i = 0; _str_arr_i < _str_arr_size; _str_arr_i++) {
//            try {
//                _str_arr_item = in.nextLine();
//            } catch (Exception e) {
//                _str_arr_item = null;
//            }
//            _str_arr[_str_arr_i] = _str_arr_item;
//        }

        String[] _str_arr = new String[]{"a"};

        res = char_count(_str_arr);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }


    static String[] char_count(String[] str_arr) {
        if (str_arr != null && str_arr.length > 0) {
            List<String> list = new ArrayList<>();
            int count = 1;
            String item = "";
            for (int i = 0; i < str_arr.length; i++) {
                if ("".equals(item)) {
                    item = str_arr[i];
                    list.add(item);
                } else {
                    if (str_arr[i].equals(item)) {
                        count++;
                    } else {
                        list.add(count + "");
                        item = str_arr[i];
                        list.add(item);
                        count = 1;
                    }
                }
                if (i == str_arr.length - 1) {
                    list.add(count + "");
                }
            }

            return list.toArray(new String[]{});
        }else {
            return new String[]{};
        }
    }
}
