package Project03.Domain;

import Project03.Service.Status;

public class Programmer extends Employee{
    private int memberID;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer(int id, String name, int age, double salary,Equipment equipment){
        super(id,name,age,salary);
        this.equipment =equipment;
    };
    public Programmer(){};

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String toString(){
        return super.toString() + "\tProgrammer\t" + status + "\t\t\t" + equipment.getDescription();
    }

    public String getDetailTeam(){
        return memberID + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\tProgrammer";
    }
}
