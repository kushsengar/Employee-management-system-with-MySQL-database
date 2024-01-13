import java.util.Scanner;

public class EmployeeDetails {
    private int id;
    private String name;
    private double salary;
    private int age;

    public EmployeeDetails() {
    }

    public EmployeeDetails(int id, String name, double salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        String name;
        int id;
        EmployeeInterfaceImplementation eip= new EmployeeInterfaceImplementation();
        System.out.println("Welcome to Employee management App");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Add Employee\n" +
                    "2. show all Employees\n" +
                    "3. Show employee based on id\n"+
                    "4. Update the employee\n"  +
                    "5. Delete the Employee\n");

            System.out.println("ENTER CHOICE:");

            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    EmployeeDetails emp = new EmployeeDetails();
                    System.out.println("Enter ID :");
                     id = sc.nextInt();
                    System.out.println("Enter name :");
                     name = sc.next();
                    System.out.println("Enter salary :");
                    double salary = sc.nextDouble();
                    System.out.println("Enter age :");
                    int age = sc.nextInt();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    eip.CreateEmployee(emp);
                    break;
                case 2: eip.DisplayEmployee();
                break;
                case 3:
                    System.out.println("Enter ID for Employee details :");
                    int empid=sc.nextInt();
                    eip.ShowEmployeeBasedOnId(empid);
                    break;
                case 4:
                    System.out.println("Enter Id to update details :");
                    int empid1 = sc.nextInt();
                    System.out.println("Enter the new name :");
                    name = sc.next();
                    eip.UpdateEmployee(empid1,name);
                    break;
                case 5:
                    System.out.println("Enter the id to delete :");
                    id= sc.nextInt();
                    eip.DeleteEmployee(id);
                    break;
                case 6:
                    System.out.println("Thank you for using our APP!!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice!!");

            }
        }while(true);

    }
}