import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
class SaveEmployeeTask implements Runnable {

    ArrayList<Employee> employees;

    SaveEmployeeTask(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public void run() {

        // TASK STARTS HERE

        try {
            FileWriter fw = new FileWriter("employee.txt");

            for (Employee e : employees) {
                fw.write("Name: " + e.getName() + "\n");
                fw.write("ID: " + e.getEmployeeId() + "\n");
            }

            fw.close();

            System.out.println("Employees saved");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        HashSet<Integer> employeeIds = new HashSet<>();
        int choice;


        do {

            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5.sort employees:");
            System.out.println("6.new to old employees");
            System.out.println("7.save file");
            System.out.println("8.read file");
            System.out.println("9.first 10 roll no.: ");
            System.out.println("10.print only student names:");
            System.out.println("11. Exit");
            System.out.println("-----------------------");

            System.out.println("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int type;
                    System.out.println("1. Add Engineer");
                    System.out.println("2. Add HR");
                    System.out.println("3. Back");

                    type = sc.nextInt();

                    switch (type) {
                        case 1:
                            System.out.println("Enter employee Id: ");
                            int id = sc.nextInt();

                            if (employeeIds.contains(id)) {
                                System.out.println("Employee ID already exists!");
                            } else {
                                sc.nextLine();

                                System.out.println("Enter Name: ");
                                String name = sc.nextLine();


                                System.out.println("Enter phone no: ");
                                String phone = sc.nextLine();

                                System.out.println("Enter Department: ");
                                String department = sc.nextLine();

                                System.out.println("Enter salary:");
                                double salary = sc.nextDouble();

                                System.out.println("Enter performance rating:");
                                int rating = sc.nextInt();

                                Engineer e = new Engineer(id, name, phone, department, salary, rating);

                                employees.add(e);
                                employeeIds.add(id);
                                break;
                            }

                    }
                    break;
                case 2:
                    System.out.println("=======Employee details=========");
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    break;


                case 3:
                    System.out.println("enter employeeId to search: ");
                    int newId = sc.nextInt();
                    for (Employee employee : employees) {
                        if (employeeIds.contains(newId)) {
                            System.out.println("Employee exists");
                        } else {
                            System.out.println("Employee not found");
                        }
                    }
                    break;


                case 4:

                    System.out.println("Enter employee id to delete");
                    int removeId = sc.nextInt();

                    if (employeeIds.contains(removeId)) {

                        Iterator<Employee> iterator = employees.iterator();

                        while (iterator.hasNext()) {

                            Employee employee = iterator.next();

                            if (employee.getEmployeeId() == removeId) {
                                iterator.remove();
                                break;
                            }
                        }

                        employeeIds.remove(removeId);

                        System.out.println("Employee is removed");

                    } else {
                        System.out.println("Employee ID not found");
                    }

                    break;


                case 5:
                    Collections.sort(employees);

                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    break;


                case 6:
                    Comparator<Employee> myId = new Comparator<Employee>() {

                        @Override
                        public int compare(Employee e1, Employee e2) {
                            return Integer.compare(
                                    e1.getEmployeeId(),
                                    e2.getEmployeeId()
                            );
                        }
                    };

                    employees.sort(myId);

                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    break;

                case 7:
                   SaveEmployeeTask task = new SaveEmployeeTask(employees);
                   Thread t1 = new Thread(task);
                   t1.start();

                case 8:
                    try{
                        BufferedReader br = new BufferedReader(new FileReader ("employee.txt") );
                        String line;
                        while((line = br.readLine()) != null){
                            System.out.println(line);

                        }
                        br.close();
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 9:
                    employees.stream()
                            .filter(e -> e.getEmployeeId() > 100)
                            .sorted()
                            .forEach(e -> System.out.println(e));


                case 10:
                    employees.stream()
                            .map(name-> name.getName())
                            .sorted()
                            .forEach(name-> System.out.println("name: "+ name));

                case 11:
                    System.out.println("The End");
                    break;

                default:
                    System.out.println("Not valid");


        }

        }while (choice != 11);
        sc.close();
    }
}