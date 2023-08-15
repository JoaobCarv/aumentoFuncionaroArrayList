package Application;

import Entities.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Employee> employeeList = new ArrayList<>();

        System.out.println("Quantos funcionarios você possui?");
        int employeeNumber = scanner.nextInt();

        for (int i = 0; i<employeeNumber; i++){
            System.out.println();
            System.out.println("Funcionário #"+ (i+1) + ":");
            System.out.print("ID: ");
            int id = scanner.nextInt();

            while (Employee.hasId(employeeList,id)) {
                System.out.println("ID inválido, tente novamente!");
                id = scanner.nextInt();
            }
            System.out.println("Nome: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.println("Salário: ");
            double salary = scanner.nextDouble();
            Employee employee = new Employee(id,name,salary);
            employeeList.add(employee);
        }

        System.out.println();
        System.out.println("Deseja realizar um aumento?\nY-YES\nN-NO");
        char increase = scanner.next().charAt(0);
        if (increase == 'y') {
            System.out.println("Digite o ID do funcionário");
            int employeeID = scanner.nextInt();
            Employee employee = employeeList.stream().filter(x -> x.getId() == employeeID).findFirst().orElse(null);
            if (employee == null) {
                System.out.println("Funcionário não existente!");
            }
            else {
                System.out.println("Entre com a porcentagem para aumento");
                employee.salaryIncrease(scanner.nextDouble());
            }
            System.out.println("Dados atualizados!");
        }
        System.out.println("Funcionários: ID,Nome,Salário: \n" + employeeList);

        }
}
