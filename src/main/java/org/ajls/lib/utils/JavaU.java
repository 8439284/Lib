package org.ajls.lib.utils;

import java.util.Random;

public class JavaU {

    public static int random(int min , int max){
        Random random = new Random();;
        int result = random.nextInt(max - min + 1) + min;
        return result;
    }




}
