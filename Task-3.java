import java.util.Scanner;

class Nummy {
    String name;
    String username;
    String password;
    String accountNo;
    float balance = 1000000f;
    int transactions = 0;
    String transactionHistory = "";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Name: ");
        this.name = sc.nextLine();
        System.out.print("\nEnter Your Username: ");
        this.username = sc.nextLine();
        System.out.print("\nEnter Your Password: ");
        this.password = sc.nextLine();
        System.out.print("\nEnter Your Account Number: ");
        this.accountNo = sc.nextLine();
        System.out.println("\nYou have Successfully Registered!!!");
        System.out.println("Kindly Login!!!");
    }

    public boolean login() {
        boolean isLoggedIn = false;
        Scanner sc = new Scanner(System.in);
        while (!isLoggedIn) {
            System.out.print("\nEnter Your Username: ");
            String enteredUsername = sc.nextLine();
            if (enteredUsername.equals(username)) {
                while (!isLoggedIn) {
                    System.out.print("\nEnter Your Password: ");
                    String enteredPassword = sc.nextLine();
                    if (enteredPassword.equals(password)) {
                        System.out.print("\nYou have Logged in Successfully!!!");
                        isLoggedIn = true;
                    } else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            } else {
                System.out.println("\nUsername not found");
            }
        }
        return isLoggedIn;
    }

    public void withdraw() {
        System.out.print("\nEnter amount to withdraw: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if (balance >= amount) {
                transactions++;
                balance -= amount;
                System.out.println("\nWithdraw Successful");
                String str = amount + " Rs Withdrawn\n";
                transactionHistory = transactionHistory.concat(str);

            } else {
                System.out.println("\nInsufficient Balance");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deposit() {
        System.out.print("\nEnter amount to deposit: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if (amount <= 1000000f) {
                transactions++;
                balance += amount;
                System.out.println("\nSuccessfully Deposited");
                String str = amount + " Rs deposited\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nSorry. The Maximum Limit is Rs.1000000.00 only");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Recipient's Name: ");
        String recipient = sc.nextLine();
        System.out.print("\nEnter amount to transfer: ");
        float amount = sc.nextFloat();
        try {
            if (balance >= amount) {
                if (amount <= 50000f) {
                    transactions++;
                    balance -= amount;
                    System.out.println("\nSuccessfully Transferred to " + recipient);
                    String str = amount + " Rs transferred to " + recipient + "\n";
                    transactionHistory = transactionHistory.concat(str);
                } else {
                    System.out.println("\nSorry. The Maximum Limit is Rs.50000.00 only");
                }
            } else {
                System.out.println("\nInsufficient Balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkBalance() {
        System.out.println("\n" + balance + " Rs");
    }

    public void transactionHistory() {
        if (transactions == 0) {
            System.out.println("\nEmpty");
        } else {
            System.out.println("\n" + transactionHistory);
        }
    }
}

class Task-3 {
    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if (flag && (input > limit || input < 1)) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("\n---------- WELCOME TO SBI ATM SYSTEM ----------\n");
        System.out.println("1. Register \n2. Exit");
        System.out.print("Enter Your Choice: ");
        int choice = takeIntegerInput(2);
        if (choice == 1) {
           Nummy bankAccount = new Nummy();
            bankAccount.register();
            while (true) {
                System.out.println("\n1. Login \n2. Exit");
                System.out.print("Enter Your Choice: ");
                int ch = takeIntegerInput(2);
                if (ch == 1) {
                    if (bankAccount.login()) {
                        System.out.println("\n\n---------- WELCOME BACK " + bankAccount.name + " ----------\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1. Withdraw \n2. Deposit \n3. Transfer \n4. Check Balance \n5. Transaction History \n6. Exit");
                            System.out.print("\nEnter Your Choice: ");
                            int c = takeIntegerInput(6);
                            switch (c) {
                                case 1:
                                    bankAccount.withdraw();
                                    break;
                                case 2:
                                    bankAccount.deposit();
                                    break;
                                case 3:
                                    bankAccount.transfer();
                                    break;
                                case 4:
                                    bankAccount.checkBalance();
                                    break;
                                case 5:
                                    bankAccount.transactionHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
