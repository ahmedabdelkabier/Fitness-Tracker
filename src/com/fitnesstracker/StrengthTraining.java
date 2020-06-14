package com.fitnesstracker;

public class StrengthTraining extends Sports {

    final private int caloriesBurntStrength=5;
    final private double heartRateIncrease=0.006;

    public StrengthTraining(int time){
        setTime(time);
        NewHeartRateCalculation(heartRateIncrease);
        caloriesBurnt(caloriesBurntStrength);

        heartRateIncreaseCalculation(oldHeartRate,newHeartRate);
        getRateIncraseCalculation();
        getCaloriesBurnt();

        getNewHeartRateCalculation();
    }
}
