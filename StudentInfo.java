/**
 *
 * This class stores basic student info
 *
 **/

public class StudentInfo {
    private String name;
    private String birthday;
    private String eAddress;
    private double gpa;
    private String status;

    public StudentInfo() {

    }
    public StudentInfo(String name, String birthday, String eAddress, double gpa,String status) {
        this.name = name;
        this.birthday = birthday;
        this.eAddress = eAddress;
        this.gpa = gpa;
        this.status = status;

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getBday(){
        return birthday;
    }
    public void setBday(String birthday){
        this.birthday = birthday;
    }
    public String getEAddress(){
        return eAddress;
    }
    public void setEAddress(String eAddress){
        this.eAddress = eAddress;
    }
    public double getGpa(){
        return gpa;
    }
    public void setGpa(double gpa){
        this.gpa = gpa;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}
