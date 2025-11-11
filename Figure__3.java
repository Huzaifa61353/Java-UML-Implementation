import java.util.*;

public class Fig3 {
    public static void main(String[] args) {
        System.out.println("=== Fig 3: Dependency Inversion Principle ===");
        Company gameDev = new GameDevCompany();
        gameDev.createSoftware();

        Company outsource = new OutsourcingCompany();
        outsource.createSoftware();
    }
}

// ---------- Helper Classes ----------
interface Employee {
    void doWork();
}

class Designer implements Employee {
    public void doWork() { System.out.println("Designer is creating designs."); }
}

class Artist implements Employee {
    public void doWork() { System.out.println("Artist is drawing visuals."); }
}

class Programmer implements Employee {
    public void doWork() { System.out.println("Programmer is coding features."); }
}

class Tester implements Employee {
    public void doWork() { System.out.println("Tester is testing the application."); }
}

abstract class Company {
    public abstract List<Employee> getEmployees();

    public void createSoftware() {
        List<Employee> employees = getEmployees();
        for (Employee e : employees) e.doWork();
    }
}

class GameDevCompany extends Company {
    public List<Employee> getEmployees() {
        return Arrays.asList(new Designer(), new Artist());
    }
}

class OutsourcingCompany extends Company {
    public List<Employee> getEmployees() {
        return Arrays.asList(new Programmer(), new Tester());
    }
}
