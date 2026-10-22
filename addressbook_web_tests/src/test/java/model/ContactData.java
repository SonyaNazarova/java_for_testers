package model;

public record ContactData(String first_name, String middle_name, String last_name) {
    public ContactData(){
        this ("", "", "");
    }

    public ContactData withFirst_name(String first_name) {
        return new ContactData(first_name, this.middle_name, this.last_name);
    }

    public ContactData withMiddle_name(String middle_name) {
        return new ContactData(this.first_name, middle_name, this.last_name);
    }

    public ContactData withLast_name(String last_name) {
        return new ContactData(this.first_name, this.middle_name, last_name);
    }

}
