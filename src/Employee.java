import java.util.Comparator;

public class Employee implements Comparable<Employee> {


    private int employeeId;
    private String name;
    private String phone;


    Employee(int employeeId, String name, String phone) {
        this.employeeId = employeeId;
        this.name = name;

        if (phone.length() == 10) {
            this.phone = phone;
        } else {
            System.out.println("Invalid number");
        }
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.name);
    }



        @Override
        public String toString() {
            return "employeeId" + employeeId + "name" + name + "phone" + phone;
        }
    }







