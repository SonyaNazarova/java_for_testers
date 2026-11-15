package manager.hbm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;


@Entity
    @Table(name = "addressbook")
    public class ContactRecord {



        @Id
        public int id;

        public String firstname;

        public String middlename;

        public String lastname;
    public String home;
    public String mobile;
    public String work;
    public String address;
    public String email;
    public String email2;
    public String email3;




    public String nickname = new String();
    public String company = new String();
    public String title = new String();
    //public String address = new String();
    //public String home = new String();
    //public String mobile = new String();
    //public String work = new String();
    public String fax = new String();
    //public String email = new String();
    public Date deprecated;
    //public String email2 = new String();
    //public String email3 = new String();
    public String homepage = new String();
    //public Date bday = new Date();
    //public Date bmonth = new Date();
    //public Date byear = new Date();
    //public Date aday = new Date();
    //public Date amonth = new Date();
    //public Date ayear = new Date();



        public ContactRecord(){

        }

        public ContactRecord(int id, String firstname, String middlename, String lastname, String home, String mobile, String work, String address, String email, String email2, String email3){

            this.id = id;
            this.firstname = firstname;
            this.middlename = middlename;
            this.lastname = lastname;
            this.home = home;
            this.mobile = mobile;
            this.work = work;
            this.address = address;
            this.email = email;
            this.email2 = email2;
            this.email3 = email3;


        }
    }

