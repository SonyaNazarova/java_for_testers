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

    public String nickname = new String();
    public String company = new String();
    public String title = new String();
    public String address = new String();
    public String home = new String();
    public String mobile = new String();
    public String work = new String();
    public String fax = new String();
    public String email = new String();
    public Date deprecated;
    public String email2 = new String();
    public String email3 = new String();
    public String homepage = new String();
    //public Date bday = new Date();
    //public Date bmonth = new Date();
    //public Date byear = new Date();
    //public Date aday = new Date();
    //public Date amonth = new Date();
    //public Date ayear = new Date();



        public ContactRecord(){

        }

        public ContactRecord(int id, String firstname, String middlename, String lastname){

            this.id = id;
            this.firstname = firstname;
            this.middlename = middlename;
            this.lastname = lastname;
        }
    }

