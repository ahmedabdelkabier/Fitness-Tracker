package com.fitnesstracker;

public class ActivityResult extends Sports {

    int totalCalories;
    double totalHeartRate;
    static int repeatSportsCaloriesSw = 0, repeatSportsCaloriesR = 0, repeatSportsCaloriesK = 0, repeatSportsCaloriesS = 0;
    static double repeatSportsRateIncreseSw = 0, repeatSportsRateIncreseR = 0, repeatSportsRateIncreseK = 0, repeatSportsRateIncreseS = 0;
    int caloriesSw, caloriesR, caloriesK, caloriesS;
    double heartSw, heartR, heartK, heartS;

   public String swimming(Swimming swim) {
        caloriesSw = swim.getCaloriesBurnt();
        heartSw = swim.getRateIncraseCalculation();
        caloriesSw += repeatSportsCaloriesSw;

        repeatSportsCaloriesSw = caloriesSw;
        heartSw += repeatSportsRateIncreseSw;
        repeatSportsRateIncreseSw = heartSw;
        return ("Swimming Burnt Calories: " + caloriesSw + "\n" + "Swimming Heart Beat: " + heartSw + " beat / min");
    }

    public String running(Running run) {
        caloriesR = run.getCaloriesBurnt();
        heartR = run.getRateIncraseCalculation();
        caloriesR += repeatSportsCaloriesR;

        repeatSportsCaloriesR = caloriesR;
        heartR += repeatSportsRateIncreseR;
        repeatSportsRateIncreseR = heartR;
        return ("Running Burnt Calories: " + caloriesR + "\nRunning Heart Beat: " + heartR + " beat / min");
    }

    public String kick(KickBoxing boxing) {
        caloriesK = boxing.getCaloriesBurnt();
        heartK = boxing.getRateIncraseCalculation();
        caloriesK += repeatSportsCaloriesK;

        repeatSportsCaloriesK = caloriesK;
        heartK += repeatSportsRateIncreseK;
        repeatSportsRateIncreseK = heartK;
        return ("Kick Boxing Burnt Calories: " + caloriesK + "\nKick Boxing Beat: " + heartK + " beat / min");
    }

    public String srength(StrengthTraining strength) {
        caloriesS = strength.getCaloriesBurnt();
        heartS = strength.getRateIncraseCalculation();
        caloriesS += repeatSportsCaloriesS;

        repeatSportsCaloriesS = caloriesS;
        heartS += repeatSportsRateIncreseS;
        repeatSportsRateIncreseS = heartS;
        return ("Strength Burnt Calories: " + caloriesS + "\nStrength Heart Beat: " + heartS + " beat / min");
    }
    public String totalResult() {
        totalCalories = caloriesSw + caloriesR + caloriesK + caloriesS;
        return ("Total Calories Burnt: " + totalCalories + "\nTotal Heart Rate: ~" + newHeartRate + " beat / min");
    }

    public double[] sortedResult() {
        double[] array = {caloriesSw,caloriesR,caloriesK,caloriesS};
        int n = array.length;
        double temp=0;

        for (int i=0;i<n-1;i++)
        {
            if(array[i]<array[i+1]) {
                temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
        return array;
    }
}