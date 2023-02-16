package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PayrollApp {

    public static final int NUMBER_OF_EMPLOYEES_TO_PROVIDE = 1;

    public void run() {
        Company company = new Company();
        System.out.println("Welcome in Payroll App. Provide data of " + NUMBER_OF_EMPLOYEES_TO_PROVIDE + " employees.");
        for (int num = NUMBER_OF_EMPLOYEES_TO_PROVIDE; num > 0; --num) {
            company.addEmployeeToList();
        }
        chooseOption(company);
    }

    private void chooseOption(Company company) {
        int userInput = 0;
        do {
            printMenu();
            Scanner scan = new Scanner(System.in);
            try {
                userInput = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid format. Please provide numeric value.");
                continue;
            }
            switch (userInput) {
                case 1 -> company.sumOfAllEmployeesSalary();
                case 2 -> company.printAllEmployeesData();
                case 3 -> company.addEmployeeToList();
                case 4 -> System.out.println("Goodbye");
                default -> System.out.println("Available values: 1, 2, 3, 4");
            }
        } while (userInput != 4);
    }

    public void printMenu() {
        System.out.println("""
                ***************
                Choose action:
                1 - Print sum of all employees salary
                2 – Display all employees data
                3 – Add new employee
                4 – End program
                ***************""");
    }
}
