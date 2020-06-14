package com.fitnesstracker;

public class Running extends Sports {

    final private int caloriesBurntRunning=5;
    final private double heartRateIncrease=0.003;

    public Running(int time){
        setTime(time);
        NewHeartRateCalculation(heartRateIncrease);
        caloriesBurnt(caloriesBurntRunning);

        heartRateIncreaseCalculation(oldHeartRate,newHeartRate);
        getRateIncraseCalculation();
        getCaloriesBurnt();

        getNewHeartRateCalculation();
    }
}
