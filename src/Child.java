import java.util.Scanner;

public class Child {
    public static boolean getID;
    private int age;
    private boolean siblingInProgram;
    private int yearsOfAttendance;
    private String name;
    private int daycareID;
    private static int nextID = 1000;

    public Child(String Name, boolean siblingPlan, int currentAge){
        this.name = Name;
        this.siblingInProgram = siblingPlan;
        this.age = currentAge;
        yearsOfAttendance = 0;
        daycareID = nextID;
        nextID = nextID++;
    }

    public double CalculateBill(){
        var rate = 0.0;
        if(age <= 1){
            rate = 400;}
        if(age <= 2 && age >= 1){
            rate = 300;}
        if(age <= 4 && age >= 3){
            rate = 200;}
        if(age > 4){
            rate = 150;
        }
        System.out.println("Your child's rate is $" + rate + ".");
        if(siblingInProgram){
            rate = rate - (rate * 0.1);
            System.out.println("Since your child has a sibling in the program their new rate is $" + rate + ".");
            if(yearsOfAttendance > 0){
                rate = rate - (yearsOfAttendance * 10);
                System.out.println("Your child has also been in the day care for " + yearsOfAttendance +
                        " years, they have receive a new rate of $" + rate + ".");
            }
        }
        else
            System.out.println("Unfortunately your child has not received additional discounts.");
        return rate;
    }

    public void addYearsofAttendance(){
        yearsOfAttendance = yearsOfAttendance +1;
    }

    public void addYear(){
        age = age +1;
    }
    public String getName(){ return name;}
    public int getAge(){return age;}

    public int getID(){
        return nextID;}
}

