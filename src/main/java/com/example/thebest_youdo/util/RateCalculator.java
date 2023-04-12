package com.example.thebest_youdo.util;

public class RateCalculator {
    public static Float calc(int rateFromClient, float rateFromDB, long countFromDB) {

        if (rateFromDB == 0.0f) {
            return (float) rateFromClient;
        } else {
            int temp = (int) (rateFromDB * countFromDB);
            countFromDB++;
            return (float) (temp + rateFromClient) / countFromDB;
        }
    }
}
