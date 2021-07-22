package LMS;



public class members_ref {
    String ID,Name,Grade,Section,Batch,Address;
    public members_ref(String ID,String Name,String Grade,String Section,String Batch,String Address){
        this.ID=ID;
        this.Name=Name;
        this.Grade=Grade;
        this.Section=Section;
        this.Batch=Batch;
        this.Address=Address;
    }
     public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String Section) {
        this.Section = Section;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String Batch) {
        this.Batch = Batch;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
        

}
