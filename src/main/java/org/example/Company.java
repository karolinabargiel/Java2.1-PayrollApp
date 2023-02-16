package org.example;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import static org.example.ScannerUtil.getDataFromUserDouble;
import static org.example.ScannerUtil.getDataFromUserString;

public class Company {
    List<Employee> employeeList = new ArrayList<>();

    public void addEmployeeToList() {
        double userInputSalary;
        String userInputFirstName = getStringFromUser("First Name: ");
        String userInputLastName = getStringFromUser("Last Name: ");
        userInputSalary = getDoubleFromUser();
        Employee employee = new Employee(userInputFirstName, userInputLastName, userInputSalary);
        employeeList.add(employee);
    }

    private double getDoubleFromUser() {
        boolean isValidate = false;
        double userInputSalary = 0;
        do {
            System.out.println("Salary: ");
            try {
                userInputSalary = getDataFromUserDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid format. Provide numeric value");
                continue;
            }
            try {
                validationDouble(userInputSalary);
            } catch (IllegalArgumentException e) {
                continue;
            }
            isValidate = true;
        } while (!isValidate);
        return userInputSalary;
    }

    private String getStringFromUser(String infoToPrint) {
        boolean isValidate = false;
        String stringFromUser;
        do {
            System.out.println(infoToPrint);
            stringFromUser = getDataFromUserString();
            try {
                validationString(stringFromUser);
            } catch (IllegalArgumentException e) {
                continue;
            }
            isValidate = true;
        } while (!isValidate);
        return stringFromUser;
    }

    public void printAllEmployeesData() {
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

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
            System.out.println("This field cannot be empty. Enter value once again.");
            throw new IllegalArgumentException(inputString);
        }
    }

    public void validationDouble(double inputDouble) {
        if (inputDouble == 0) {
            System.out.println("Salary can't be 0. Provide value once again.");
            throw new IllegalArgumentException(String.valueOf(inputDouble));
        }
    }
}
