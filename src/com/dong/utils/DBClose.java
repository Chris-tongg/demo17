package com.dong.utils;

public class DBClose {
    public static void closeAll(AutoCloseable ... closeables){
        for (AutoCloseable i:closeables){
            if (i!=null){
                try {
                    i.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
