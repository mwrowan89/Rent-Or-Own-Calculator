package org.example;

public class FixedRate implements Mortgage {

    private double loanAmount;
    private double mortgageRate;
    private int lengthOfMortgage;

    public FixedRate(double loanAmount, double mortgageRate, int lengthOfMortgage) {
        this.loanAmount = loanAmount;
        this.mortgageRate = mortgageRate;
        this.lengthOfMortgage = lengthOfMortgage;
    }

    @Override
    public double calculateMonthlyPayment() {
        double monthlyInterestRate = mortgageRate / 12 / 100;
        int numberOfPayments = lengthOfMortgage * 12;
        double denominator = 1.0;
        for (int i = 0; i < numberOfPayments; i++) {
            denominator *= (1 + monthlyInterestRate);
        }
        return loanAmount * (monthlyInterestRate / denominator);
    }
}
