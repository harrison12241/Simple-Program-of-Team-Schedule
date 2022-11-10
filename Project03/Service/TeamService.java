package Project03.Service;

import Project03.Domain.Architect;
import Project03.Domain.Designer;
import Project03.Domain.Employee;
import Project03.Domain.Programmer;

public class TeamService {
    private static int counter = 1;// for member id
    private final int max_number=5;
    private Programmer[] team = new Programmer[max_number];
    private int total;

    public TeamService(){};

    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for(int i=0;i<team.length;i++){
            team[i] = this.team[i];
        }
        return team;
    }

    public void addNumber(Employee e) throws TeamException {
        if(total>=max_number){
            throw new TeamException("Max number reach!");
        }
        if(!(e instanceof Programmer)){
            throw new TeamException("Not exact person we want!");
        }
        if(isExist(e)){
            throw new TeamException("You already in!");
        }
        Programmer p = (Programmer) e; // 强转
        if(p.getStatus().getNAME().equals("BUSY")){
            throw new TeamException("You already in another time!");
        }else if("VOCATION".equals(p.getStatus().getNAME())){
            throw new TeamException("You already on vocation!");
        }

        int numOfArch = 0, numOfDes = 0, numOfProg=0;
        for(int i=0;i<team.length;i++){
            if(team[i] instanceof Architect){
                numOfArch++;
            }else if(team[i] instanceof Designer){
                numOfDes++;
            }else if(team[i] instanceof Programmer){
                numOfProg++;
            }
        }

        if(p instanceof Architect){
            if(numOfArch>=1){
                throw new TeamException("Only one Archi can in the team");
            }else if(p instanceof Designer){
                if(numOfDes>=2){
                    throw new TeamException("Only two Des can in the team");
                }
            }else if(p instanceof Programmer){
                if(numOfProg>=3){
                    throw new TeamException("Only three Prog can in the team");
                }
            }
        }

        team[total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberID(counter++);


    }
    // to check whether the person is already exist in the team
    private boolean isExist(Employee e){
        for(int i=0;i<total;i++){
            return team[i].getId() == e.getId();
        }
        return false;
    }

    public void removeNumber(int memberID) throws TeamException {
        int i =0;
        for(;i< team.length;i++) {
            if(team[i].getMemberID()==memberID){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if(total == i){
            throw new TeamException("Not in the list");
        }
        for(int j=i+1;j<team.length;j++){
            team[j-1] = team[i];
        }
        team[--total] = null;
    }
}
