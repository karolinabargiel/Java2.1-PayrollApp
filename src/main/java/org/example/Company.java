package org.example;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import static org.example.UserData.getDataFromUserDouble;
import static org.example.UserData.getDataFromUserString;

public class Company {
    List<Employee> employeeList = new ArrayList<>();

    public void addEmployeeToList() {
        boolean validation = false;

        System.out.println("Imię: ");
        String userInputFirstName = getDataFromUserString();
        try {
            validationString(userInputFirstName);
        } catch (IllegalArgumentException e) {
            System.out.println("Enter value once again");
        }
        System.out.println("Nazwisko: ");
        String userInputLastName = getDataFromUserString();
        validationString(userInputLastName);
        System.out.println("Zarobki: ");
        double userInputSalary = 0;
        try {
            userInputSalary = getDataFromUserDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid format");
        }
        validationDouble(userInputSalary);
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
