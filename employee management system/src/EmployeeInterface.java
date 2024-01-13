public interface EmployeeInterface  {

    //create employee
    public void CreateEmployee(EmployeeDetails emp);
    //show all employee
    public void DisplayEmployee();
    //show employee based on id
    public void ShowEmployeeBasedOnId(int id);
    //update employee
    public void UpdateEmployee(int id,String name);
    //delete employee
    public void DeleteEmployee(int id);
}
