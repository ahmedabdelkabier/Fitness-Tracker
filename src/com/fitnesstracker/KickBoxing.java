package com.fitnesstracker;

public class KickBoxing extends Sports {

    final private int caloriesBurntKick_Boxing=3;
    final private double heartRateIncrease=0.005;

    public KickBoxing(int time){
        setTime(time);
        NewHeartRateCalculation(heartRateIncrease);
        caloriesBurnt(caloriesBurntKick_Boxing);

        heartRateIncreaseCalculation(oldHeartRate,newHeartRate);
        getRateIncraseCalculation();
        getCaloriesBurnt();

        getNewHeartRateCalculation();
    }
}
