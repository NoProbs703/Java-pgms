package mypack;

class Balance {
    String name;
    float balance;

    Balance(String s, float f) {
        name = s;
        balance = f;
    }

    void displayshow() {
        if (balance < 0) {
            System.out.println("No Balance!");
        }
        if (balance > 0) {
            System.out.println("Name: " + name);
            System.out.println("Balance: " + balance);
        }
    }
}

class AccountBalance {
    public static void main(String args[]) {
        Balance current[] = new Balance[3];
        current[0] = new Balance("A", 1000.0f);
        current[1] = new Balance("B", 2000.0f);
        current[2] = new Balance("C", -2.0f);

        for (int i = 0; i < 3; i++) {
            current[i].displayshow();
        }
    }
}
