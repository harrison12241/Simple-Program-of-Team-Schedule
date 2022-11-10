package Project03.Domain;

public class Architect extends Designer{
    private int stock;

    public Architect(){};
    public Architect(int id, String name,int age,double salary,Equipment equipment,double bonus,int stock){
        super(id,name,age,salary,equipment,bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetail() + "\tArchitect\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
    }

    public String getDetailTeam(){
        return getMemberID() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\tArchitect\t" + getBonus() + "\t" + getStock();
    }
}
