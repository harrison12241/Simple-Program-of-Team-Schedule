package Project03.View;

import Project03.Domain.Employee;
import Project03.Domain.Programmer;
import Project03.Service.NameListService;
import Project03.Service.TeamException;
import Project03.Service.TeamService;

public class TeamView {
    private NameListService service = new NameListService();
    private TeamService teamService = new TeamService();

    char menu =0;
    public void enterMainMenu(){
        boolean loopFlag = true;
        if(menu !='1'){
            listAllEmployees();
        }
        while (loopFlag){
            System.out.print("1-Team_List 2-Add_Number 3-Delete_number 4-Exit Please choose(1-4)");
            menu = TSUtility.readMenuSelection();
            switch (menu){
                case'1':
                    getTeam();
                    break;
                case'2':
                    addNumber();
                    break;
                case'3':
                    deleteNumber();
                    break;
                case '4':
                    System.out.println("Are you sure to Exit? (Y/N)");
                    char in = TSUtility.readConfirmSelection();
                    if(in == 'Y'){
                        loopFlag = false;
                    }
                    break;
            }
        }

    }

    public void listAllEmployees(){
        Employee[] employees = service.getAllEmployees();
        System.out.println("Show all Team numbers");
        System.out.println("--------------------------------Team Schedule--------------------------------");
        System.out.println("ID\tName\tAge\tSalary\tPosition\tStatus\tBonus\tStock\tEquipment");
        for (int i=0;i< employees.length;i++){
            System.out.println(employees[i]);
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    public void getTeam(){

        System.out.println("----------------------------------Team List----------------------------------");
        Programmer[] team = teamService.getTeam();
        if(team==null||team.length==0){
            System.out.println("No person in the team right now");
        }else {
            System.out.print("TID/ID\tName\tAge\tSalary\tPosition\tStatus\tBonus\tStock\n");
            for(int i=0;i< team.length;i++){
                System.out.println(team[i].getDetailTeam());
            }
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    public void addNumber(){
        System.out.println("----------------------------------Team List----------------------------------");
        System.out.println("Input the Employee ID:");
        int id = TSUtility.readInt();
        try{
            Employee emp = service.getEmpolyee(id);
            teamService.addNumber(emp);
            System.out.println("Successful");

        }catch (TeamException e){
            e.printStackTrace();
        }
        TSUtility.readReturn();
        System.out.println("-----------------------------------------------------------------------------");

    }

    public void deleteNumber(){
        System.out.println("--------------------------------Delete Number--------------------------------");
        System.out.println("Input the Employee Member ID:");
        int id = TSUtility.readInt();
        System.out.println("Are you sure?(Y/N)");
        char isDelete = TSUtility.readConfirmSelection();
        if(isDelete=='N'){
            return;
        }
        try{
            teamService.removeNumber(id);
            System.out.println("Successful");
        }catch (TeamException e){
            e.printStackTrace();
        }
        TSUtility.readReturn();
        System.out.println("-----------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        TeamView t = new TeamView();
        t.enterMainMenu();

    }


}
