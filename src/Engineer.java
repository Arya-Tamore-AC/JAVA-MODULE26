public class Engineer extends Employee{
    private String department;
    private double salary;
    private int performanceRating;

    Engineer(int employeeId,String name, String phone,String department, double salary, int performanceRating){
        super(employeeId, name, phone);
        this.department = department;
        this.salary = salary;
        this.performanceRating = performanceRating;
    }

    public String getDepartment(){
        return department;
    }
    public double getSalary(){
        return salary;
    }

    public double calculateBonus(){

        switch (performanceRating){
            case 5:
                return salary*0.20;

            case 4:
                return salary*0.15;

            case 3:
                return salary*0.10;

            case 2:
                return  salary*0.05;

            case 1:
                return salary*0.00;

            default:
                System.out.println("Not valid rating");
                return 0.0;
        }

    }
    public double getBonus(){
        return calculateBonus();
    }

    @Override
    public String toString() {
        return "Employee ID: " + getEmployeeId()
                + ", Name: " + getName()
                + ", Phone: " + getPhone()
                + ", Department: " + getDepartment()
                + ", Salary: " + getSalary()
                + ", Bonus: " + getBonus();
    }
}

