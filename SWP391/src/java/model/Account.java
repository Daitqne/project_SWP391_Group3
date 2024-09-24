package model;
import java.util.Date;
public class Account {
    int AcountID;
    String Username;
    String Password;
    String Address;
    Date Date_Of_Birth;
    String Email;
    String Full_Name;
    boolean Gender;
    String Image;
    String Identity_Card;
    String Phone_Number;
    String Register_Date;
    String Status;

    public Account() {
    }

    public Account(int AcountID, String Username, String Password, String Address, Date Date_Of_Birth, String Email, String Full_Name, boolean Gender, String Image, String Identity_Card, String Phone_Number, String Register_Date, String Status) {
        this.AcountID = AcountID;
        this.Username = Username;
        this.Password = Password;
        this.Address = Address;
        this.Date_Of_Birth = Date_Of_Birth;
        this.Email = Email;
        this.Full_Name = Full_Name;
        this.Gender = Gender;
        this.Image = Image;
        this.Identity_Card = Identity_Card;
        this.Phone_Number = Phone_Number;
        this.Register_Date = Register_Date;
        this.Status = Status;
    }

    public int getAcountID() {
        return AcountID;
    }

    public void setAcountID(int AcountID) {
        this.AcountID = AcountID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getDate_Of_Birth() {
        return Date_Of_Birth;
    }

    public void setDate_Of_Birth(Date Date_Of_Birth) {
        this.Date_Of_Birth = Date_Of_Birth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFull_Name() {
        return Full_Name;
    }

    public void setFull_Name(String Full_Name) {
        this.Full_Name = Full_Name;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getIdentity_Card() {
        return Identity_Card;
    }

    public void setIdentity_Card(String Identity_Card) {
        this.Identity_Card = Identity_Card;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String Phone_Number) {
        this.Phone_Number = Phone_Number;
    }

    public String getRegister_Date() {
        return Register_Date;
    }

    public void setRegister_Date(String Register_Date) {
        this.Register_Date = Register_Date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
}
