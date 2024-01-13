import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeInterfaceImplementation implements EmployeeInterface {
    Connection con;
    @Override
    public void CreateEmployee(EmployeeDetails emp) {
        con = DatabaseConnect.CreateDBConnection();
        String query = "insert into employee_details values(?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,emp.getId());
            pstm.setString(2,emp.getName());
            pstm.setDouble(3,emp.getSalary());
            pstm.setInt(4,emp.getAge());
            int count = pstm.executeUpdate();
            if(count!=0) System.out.println("Employee inserted successfully !!");
        }
        catch (Exception e){ e.printStackTrace();}
    }

    @Override
    public void DisplayEmployee() {
        con= DatabaseConnect.CreateDBConnection();
        String query="select * from employeedatabase.employee_details";
        System.out.println("Employee Details :");
        System.out.println("----------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Salary","Age");
        System.out.println("----------------------------------------------");
        try {
            Statement st=con.createStatement();
            ResultSet result =st.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("----------------------------------------------");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void ShowEmployeeBasedOnId(int id) {
        con = DatabaseConnect.CreateDBConnection();
        String query= "select * from employeedatabase.employee_details where id="+id;
        try {
            Statement st= con.createStatement();
            ResultSet result= st.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
               // System.out.println("----------------------------------------------");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void UpdateEmployee(int id, String name) {
        con = DatabaseConnect.CreateDBConnection();
        String query = "update employee_details set name =? where id=?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int count=pstm.executeUpdate();
            if (count!=0){
                System.out.println("Employee details updated successfully!!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void DeleteEmployee(int id) {
        con= DatabaseConnect.CreateDBConnection();
        String query="delete from employee_details where id=?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,id);
            int count= pstm.executeUpdate();
            if (count!=0){
                System.out.println("Employee deleted Successfully!!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
