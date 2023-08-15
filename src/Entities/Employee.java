package Entities;

import java.util.List;

public class Employee {
    private Integer id;
    private String name;
    private Double salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void salaryIncrease (double percentage){
        this.salary += salary/100*percentage;
    }

    public String toString() {
        return id + " " + name + " " + String.format("%.2f",salary)+"\n";
    }
    public static boolean hasId(List<Employee> list, int id) {
        Employee employee = list.stream().filter(x -> x.getId()==id).findFirst().orElse(null);
        return employee != null;
    }
}
