package org.example;

import java.util.Scanner;

public class RentOrOwnCalculator {
    //Properties
    Scanner userInput = new Scanner(System.in);
    public int costOfHome;
    public int costToRent;
    public int rentRatio;
    public double mortgageRate;
    public int downPayment;
    public int lengthOfMortgage;
    public int loanAmount;
    public int action;
    public String again;

    //Constructors
    public RentOrOwnCalculator(){
        this.costOfHome = costOfHome;
        this.costToRent = costToRent;
    }

    //Getter Setters
    public void setCostOfHome(int costOfHome) {
        this.costOfHome = costOfHome;
    }

    public void setCostToRent(int costToRent) {
        this.costToRent = costToRent;
    }


    //Methods
    public void run(){
        banner();
        System.out.println();
        do {

            System.out.println("Calculator selection");
            System.out.println("(1) Rent or own calculator");
            System.out.println("(2) Monthly mortgage calculator");
            System.out.print("Please enter the calculator you would like to use: ");
            action = userInput.nextInt();

            if(action == 1){
                System.out.print("Please enter the cost of the home you wish to purchase: ");
                costOfHome = userInput.nextInt();
                System.out.print("Please enter your monthly rent: ");
                costToRent = userInput.nextInt() * 12;

                rentRatio = costOfHome / costToRent;
                System.out.println("******* Your \"Rent Ratio\" is: " + rentRatio + " *********");
                System.out.println("A rent ratio of 18 or higher is considered an indication to rent a home versus buying a similar home.");
                System.out.println();
                if(rentRatio < 18){
                    System.out.println("Congratulations buying a home makes more sense than renting right now!");;
                } else {
                    System.out.println("Renting a home is more financially wise than to purchase right now.");
                    System.out.println();
                }
            } else if(action == 2){
                System.out.print("Please enter the cost of the home you wish to purchase: ");
                costOfHome = userInput.nextInt();
                System.out.print("Please enter the current mortgage rate available to you: ");
                mortgageRate = userInput.nextDouble();
                System.out.print("Please enter the down payment percentage you will use: ");
                downPayment = userInput.nextInt();
                System.out.print("Please enter the length of the mortgage you prefer in years: ");
                lengthOfMortgage = userInput.nextInt();

                loanAmount = costOfHome - downPayment;
                System.out.println();

                System.out.println();
                double monthly = calculateMonthlyPayment(this.loanAmount, this.mortgageRate, this.lengthOfMortgage);
                System.out.println("Your monthly payments would be: " + String.format("%.2f", monthly));
                System.out.println();
                System.out.print("Would you like to use the calculator again? (Y/N) ");
                again = userInput.nextLine();

            }
        } while (action != 1 || action != 2); {
            System.out.println("Invalid entry please try again");
        }

    }

    public static double calculateMonthlyPayment(double loanAmount, double mortgageRate, int lengthOfMortgage) {
        // Convert annual interest rate to monthly interest rate
        double monthlyInterestRate = (mortgageRate * 0.01) / 12.0;
        // Convert loan term in years to number of payments
        int numberOfPayments = lengthOfMortgage * 12;

        // Calculate monthly payment using the formula
        double monthlyPayment = loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        return monthlyPayment;
        }

    public void banner(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~Rent or Own Calculator~~~~~");
        System.out.println("~~~~Should you rent a home?~~~~~");
        System.out.println("~~~~~~~Or should you own?~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
