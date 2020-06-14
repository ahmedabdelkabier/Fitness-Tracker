package com.fitnesstracker;

public class Swimming extends Sports {

    final private int caloriesBurntSwimming=4;
    final private double heartRateIncrease=0.002;

    public Swimming(int time){
        setTime(time);
        NewHeartRateCalculation(heartRateIncrease);
        caloriesBurnt(caloriesBurntSwimming);

        heartRateIncreaseCalculation(oldHeartRate,newHeartRate);
        getRateIncraseCalculation();
        getCaloriesBurnt();

        getNewHeartRateCalculation();
    }
}




