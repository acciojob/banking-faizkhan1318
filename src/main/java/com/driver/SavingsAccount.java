package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;
    public int nWithdraws;
    public double getRate(){
        return rate;
    }
    public void setRate(double rate){
        this.rate=rate;
    }
    public double getMaxWithdrawalLimit(){
        return maxWithdrawalLimit;
    }
    public void setMaxWithdrawalLimit(double maxWithdrawalLimit){
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }
    public int getnWithdraws() {
        return nWithdraws;
    }
    public void setnWithdraws(int nWithdraws) {
        this.nWithdraws = nWithdraws;
    }


    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default

        super(name, balance, 0.0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
        this.nWithdraws = 0;
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(nWithdraws >= maxWithdrawalLimit){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        if(amount > super.getBalance()){
            throw new Exception("Insufficient Balance");
        }
        super.setBalance(super.getBalance()-amount);
        nWithdraws++;
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
//        return super.getBalance() + rate * years * super.getBalance();
        double amount=(years*super.getBalance()*1)/100;
        return amount;
    }
    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
         return super.getBalance() * Math.pow( 1 + rate/times, times*years);
//        double ci=this.getBalance()*Math.pow(1+(rate / 100),years);
//        return ci;
    }

}
