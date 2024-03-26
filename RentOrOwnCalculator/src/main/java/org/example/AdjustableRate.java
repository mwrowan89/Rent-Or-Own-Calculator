package org.example;

public class AdjustableRate implements Mortgage {
    private double loanAmount;
    private double initialRate;
    private double adjustmentInterval;
    private double adjustmentRateCap;
    private int lengthOfMortgage;

    public AdjustableRate(double loanAmount, double initialRate, double adjustmentInterval, double adjustmentRateCap, int lengthOfMortgage) {
        this.loanAmount = loanAmount;
        this.initialRate = initialRate;
        this.adjustmentInterval = adjustmentInterval;
        this.adjustmentRateCap = adjustmentRateCap;
        this.lengthOfMortgage = lengthOfMortgage;
    }

    @Override
    public double calculateMonthlyPayment() {
        double monthlyInterestRate = initialRate / 12 / 100;
        int numberOfPayments = lengthOfMortgage * 12;

        double monthlyPayment = 0.0;
        for(int i = 0;i < numberOfPayments; i++){
            if((i+1) % (adjustmentInterval * 12) == 0) {
                double newRate = Math.min(initialRate + adjustmentRateCap, initialRate * 2);
                monthlyInterestRate = newRate / 12 / 100;
            }
            monthlyPayment += loanAmount * (monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, - numberOfPayments)));
        }
        return monthlyPayment;
    }
}
