public class Fig2 {
    public static void main(String[] args) {
        System.out.println("=== Fig 2: Composition Principle ===");
        Transport t1 = new Transport(new CombustionEngine(), new Human());
        t1.deliver("Warehouse A", "Tools");

        Transport t2 = new Transport(new ElectricEngine(), new Robot());
        t2.deliver("Factory B", "Batteries");
    }
}

// ---------- Helper Classes ----------
interface Engine {
    void move();
}

class CombustionEngine implements Engine {
    public void move() { System.out.println("Combustion engine moving..."); }
}

class ElectricEngine implements Engine {
    public void move() { System.out.println("Electric engine moving silently..."); }
}

interface Driver {
    void navigate(String destination);
}

class Robot implements Driver {
    public void navigate(String destination) { System.out.println("Robot navigating to " + destination); }
}

class Human implements Driver {
    public void navigate(String destination) { System.out.println("Human driving to " + destination); }
}

class Transport {
    private Engine engine;
    private Driver driver;

    public Transport(Engine engine, Driver driver) {
        this.engine = engine;
        this.driver = driver;
    }

    public void deliver(String destination, String cargo) {
        System.out.println("Delivering " + cargo + " to " + destination);
        engine.move();
        driver.navigate(destination);
    }
}
