import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private ArrayList<Child> Students;
    private ArrayList<DayCareWorker> Employees;

    private DayCareWorker currentlySelectedWorker;
    private Child currentlySelectedChild;

    public static void main(String[] args){
        var myDayCare = new Main();
        myDayCare.RunDayCare();
    }

    public Main(){
        Students = new ArrayList<Child>();
        Employees = new ArrayList<DayCareWorker>();
    }

    public void RunDayCare(){
        var userInput = new Scanner(System.in);
        while(true){
            printMenu();
            var input = userInput.nextInt();
            switch(input){
                case 1:
                    admitChild(userInput);
                    break;
                case 2:
                    addWorker(userInput);
                    break;
                case 3:
                    sendStudentsToSchool();
                    break;
                case 4:
                    for(DayCareWorker D: Employees){
                        D.performFireDrill();
                    }
                    break;
                case 5:
                    System.exit(0);
                case 6:
                    endOfYear();
                    break;
                case 7:
                    doAccouting();
                    break;
            }
        }
    }

    private void printMenu(){
        System.out.println("Select the number of the option you would like to execute.");
        System.out.println("[1] Admit Child");
        System.out.println("[2] Hire Worker");
        System.out.println("[3] Students go to school");
        System.out.println("[4] Run a fire drill");
        System.out.println("[5] Escape");
        System.out.println("[6] End of year");
        System.out.println("[7] Do Accounting");
        System.out.print("Option number: ");
    }

    private void addWorker(Scanner passedUserInput){
        passedUserInput.nextLine();
        System.out.print("Enter a new worker's name: ");
        var name = passedUserInput.nextLine();

        System.out.print("Enter the worker's starting pay: ");
        var pay = passedUserInput.nextFloat();

        currentlySelectedWorker = new DayCareWorker(pay, name);
        Employees.add(currentlySelectedWorker);
        randomWorker();
        System.out.println("Created new selected customer with name " + currentlySelectedWorker.getName() + " and starting pay of "
                + currentlySelectedWorker.getSalary() + ".");
    }

    private void sendStudentsToSchool(){
        var leavingChildren = new ArrayList<Child>();
        for(var child : Students){
            if(child.getAge()>6)
                leavingChildren.remove(child);
        }
        for(var students : leavingChildren){
            Students.remove(students);
            for(var employees : Employees){
                employees.removeChild(students.getID());
            }
        }

    }

    private void randomWorker(){
        var randGen = new Random();
        var randnum = randGen.nextInt(Employees.size());
        DayCareWorker worker = Employees.get(randnum);
        worker.addChild(currentlySelectedChild);
    }

    private void admitChild(Scanner passedUserInput){
        passedUserInput.nextLine();
        System.out.print("Enter a new child's name: ");
        var name = passedUserInput.nextLine();

        System.out.print("Does the child have a sibling in the program (true/false): ");
        var sibling = passedUserInput.nextBoolean();

        System.out.print("Enter the child's age: ");
        var age = passedUserInput.nextInt();

        currentlySelectedChild = new Child(name, sibling, age);
        Students.add(currentlySelectedChild);

        System.out.println("Created new selected child with name " + currentlySelectedChild.getName() + " and age of "
                + currentlySelectedChild.getAge() + ".");
    }

    private void endOfYear(){
        for(var child : Students){
            child.addYear();
            child.addYearsofAttendance();
        }
        System.out.println("Years of attendance increased.");
        for(var employee : Employees){
            employee.performanceReview();
        }
        System.out.println("Completed end of year functions.");
    }

    private void doAccouting(){
        var profit = 0.0;
        var losses = 0.0;
        for(var children : Students){
            profit = profit + children.CalculateBill();
        }
        for(var employee : Employees){
            losses = losses + employee.getSalary();
        }
        var totalRevenue = profit - losses;
        System.out.println("The total profits are $" + totalRevenue);

    }



}

