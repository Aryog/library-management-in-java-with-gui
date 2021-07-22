package LMS;

public class issue_ref{
    String Book,Author,STUID,Issuedto,Grade,Issuedate,Returndate;
    public issue_ref(String Book,String Author,String STUID,String Issuedto,String Grade,String Issuedate,String Returndate){
        this.Book=Book;
        this.Author=Author;
        this.STUID=STUID;
        this.Issuedto=Issuedto;
        this.Grade=Grade;
        this.Issuedate=Issuedate;
        this.Returndate=Returndate;
    }
     public String getBook() {
        return Book;
    }

    public void setBook(String Book) {
        this.Book = Book;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getSTUID() {
        return STUID;
    }

    public void setSTUID(String STUID) {
        this.STUID = STUID;
    }

    public String getIssuedto() {
        return Issuedto;
    }

    public void setIssuedto(String Issuedto) {
        this.Issuedto = Issuedto;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

    public String getIssuedate() {
        return Issuedate;
    }

    public void setIssuedate(String Issuedate) {
        this.Issuedate = Issuedate;
    }
    public String getReturndate() {
        return Returndate;
    }

    public void setReturndate(String Returndate) {
        this.Returndate = Returndate;
    }
    
        
    
}
