package org.example;


import java.util.InputMismatchException;
import java.util.Scanner;

public class PayrollApp {
    public void appMenu() {
        System.out.println("""
                Choose action:
                1 - Print sum of all employees salary
                2 – Display all employees data
                3 – Add new employee
                4 – End program""");
    }
    public void run() {
        Company company = new Company();
        System.out.println("Podaj dane 5 pracowników.");
        for (int num = 2; num > 0; --num) {
            company.addEmployeeToList();


        }
        chooseOption(company);
    }

    private void chooseOption(Company company) {
        int userInput = 0;
        do {
            appMenu();
            Scanner scan = new Scanner(System.in);
            try {
                userInput = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid format");
                continue;
            }
            switch (userInput) {
                case 1 -> company.sumOfAllEmployeesSalary();
                case 2 -> company.printAllEmployeesData();
                case 3 -> company.addEmployeeToList();
                case 4 -> System.out.println("Goodbye my love :*");
                default -> System.out.println("Available values: 1, 2, 3, 4");
            }
        } while (userInput != 4);
    }
}
