import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class DayCareWorker {
    private String Name;
    private float Salary;

    private ArrayList<Child> childrenInGroup;

    public String getName(){
        return Name;
    }
    public float getSalary(){
        return Salary;
    }



    public DayCareWorker(float startingPay, String name){
        this.Name = name;
        this.Salary = startingPay;
        childrenInGroup = new ArrayList<Child>();
    }

    public void performanceReview(){
        Random randGenerator = new Random();
        int upperbound = 6;
        var randNum = randGenerator.nextInt(upperbound);
        if(randNum == 0){
            randNum = randNum + 1;
        }
        System.out.println(randNum); //delete when done
        if(randNum == 1){
            System.out.println("Based on review no salary increase occured");
        }
        if(randNum == 2){
            Salary = (Salary + (Salary * .01f));
            System.out.println("Based on review, salary has increased to " + Salary);
        }
        if(randNum == 3){
            Salary = (Salary + (Salary * .025f));
            System.out.println("Based on review, salary has increased to " + Salary);
        }
        if(randNum == 4){
            Salary = (Salary + (Salary * .035f));
            System.out.println("Based on review, salary has increased to " + Salary);
        }
        if(randNum == 5){
            Salary = (Salary + (Salary * .05f));
            System.out.println("Based on review, salary has increased to " + Salary);
        }

    }

    public void performFireDrill(){
        for(Child kid: childrenInGroup){
            System.out.println(kid.getName() + " is safe.");
        }
        System.out.println("The children are all safe.");

    }

    public boolean addChild(Child newKid){
        return childrenInGroup.add(newKid);
    }

    public Optional<Child> removeChild(int daycareID){
        for(var child: childrenInGroup){
            if(child.getID() == daycareID){
                childrenInGroup.remove(child);
                return Optional.of(child);
            }
        }
        return Optional.empty();
    }


}
