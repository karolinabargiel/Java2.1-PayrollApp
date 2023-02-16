package org.example;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import static org.example.UserData.getDataFromUserDouble;
import static org.example.UserData.getDataFromUserString;

public class Company {
    List<Employee> employeeList = new ArrayList<>();


    public void addEmployeeToList() {
        boolean validationFirstName = false;
        boolean validationLastName = false;
        boolean validationSalary = false;
        String userInputFirstName;
        String userInputLastName;
        double userInputSalary = 0;

        do {
            System.out.println("First Name: ");
            userInputFirstName = getDataFromUserString();
            try {
                validationString(userInputFirstName);
            } catch (IllegalArgumentException e) {
                System.out.println("Enter value once again");
                continue;
            }
            validationFirstName = true;
        } while (!validationFirstName);

        do {
            System.out.println("Last Name: ");
            userInputLastName = getDataFromUserString();
            try {
                validationString(userInputLastName);
            }catch (IllegalArgumentException e) {
                System.out.println("Enter value once again");
                continue;
            }
            validationLastName = true;
        } while (!validationLastName);

        do {
            System.out.println("Salary: ");
            try {
                userInputSalary = getDataFromUserDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid format");
                continue;
            }
            try {
                validationDouble(userInputSalary);
            } catch (IllegalArgumentException e) {
                continue;
            }
            validationSalary = true;
        } while (!validationSalary);

        Employee employee = new Employee(userInputFirstName, userInputLastName, userInputSalary);
        employeeList.add(employee);
    }

    //opcja 2
    public void printAllEmployeesData() {
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }
    //opcja 1
    public void sumOfAllEmployeesSalary() {
        System.out.println("Sum of all employees salary: ");
        double sum = 0;
        for (Employee employee : employeeList) {
            double salaryValue = employee.getSalary();
            sum += salaryValue;
        }
        System.out.println(sum);
    }

    public void validationString(String inputString) {
        if (inputString.trim().isEmpty()) {
            System.out.println("This can't be empty");
            throw new IllegalArgumentException(inputString);
        }
    }

    public void validationDouble(double inputDouble) {
        if (inputDouble == 0) {
            System.out.println("Salary can't be 0");
            throw new IllegalArgumentException(String.valueOf(inputDouble));
        }
    }
}
