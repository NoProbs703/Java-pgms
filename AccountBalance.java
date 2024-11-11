package mypack;

class Balance {
    String name;
    double balance;

    Balance(String s, double f) {
        name = s;
        balance = f;
    }

    void displayshow() {
        if (balance < 0) {
            System.out.println("Account " + name + " has insufficient balance!");
        } else if (balance > 0) {
            System.out.println("Name: " + name);
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("Account " + name + " has a zero balance.");
        }
    }
}

class AccountBalance {
    public static void main(String args[]) {
        Balance current[] = new Balance[3];
        current[0] = new Balance("A", 1000.0);  
        current[1] = new Balance("B", 2000.0);  
        current[2] = new Balance("C", -2.0);    

        for (int i = 0; i < 3; i++) {
            current[i].displayshow();
        }
    }
}
