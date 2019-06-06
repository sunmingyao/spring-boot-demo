package com.example.demo;

import org.springframework.web.servlet.DispatcherServlet;

/**
 * @Auther: sunmingyao
 * @Date: 2019/2/15 14 26
 * @Description:
 */
public  class Test {

    public static void main(String[] args) {

        int j = 0;
        for (int i = 0; i < 100; i++) {

            j=j++;
        }

        System.out.println(j);
    }

}
