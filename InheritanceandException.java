class WrongAgeException extends Exception {
    public WrongAgeException(String message) {
        super(message);
    }
}

class InvalidSonAgeException extends Exception {
    public InvalidSonAgeException(String message) {
        super(message);
    }
}

class Father {
    int age;

    // Constructor
    public Father(int age) throws WrongAgeException {
        if (age < 0) {
            throw new WrongAgeException("Father's age cannot be negative.");
        }
        this.age = age;
    }
}

class Son extends Father {
    int sonAge;

    // Constructor
    public Son(int fatherAge, int sonAge) throws WrongAgeException, InvalidSonAgeException {
        super(fatherAge); // Call Father constructor
        if (sonAge < 0) {
            throw new WrongAgeException("Son's age cannot be negative.");
        }
        if (sonAge >= fatherAge) {
            throw new InvalidSonAgeException("Son's age cannot be greater than or equal to Father's age.");
        }
        this.sonAge = sonAge;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Creating Father with age 40...");
            Father father = new Father(40);

            System.out.println("Creating Son with age 20...");
            Son son = new Son(40, 20); // Valid case
            System.out.println("Father's Age: " + father.age + ", Son's Age: " + son.sonAge);

            System.out.println("\nAttempting to create Son with age 45...");
            Son invalidSon = new Son(40, 45); // Invalid case
        } catch (WrongAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (InvalidSonAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\nAttempting to create Father with age -10...");
        try {
            Father invalidFather = new Father(-10); // Invalid case
        } catch (WrongAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
