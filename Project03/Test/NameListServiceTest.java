package Project03.Test;

import Project03.Domain.Employee;
import Project03.Service.NameListService;
import Project03.Service.TeamException;
import org.testng.annotations.Test;

public class NameListServiceTest {
    @Test
    public void getAllEmployees(){
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for(int i=0;i< employees.length;i++){
            System.out.println(employees[i]);
        }
    }

    @Test
    public void getEmployee(){
        NameListService service = new NameListService();
        try{
            Employee employee = service.getEmpolyee(100);
            System.out.println(employee);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }
    }


}
