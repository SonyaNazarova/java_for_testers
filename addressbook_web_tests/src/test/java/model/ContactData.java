package model;

public record ContactData(
        String id,
        String first_name,
        String middle_name,
        String last_name,
        String photo,
        String home,
        String mobile,
        String work,
        String address,
        String email,
        String email2,
        String email3) {
    public ContactData(){
        this ("", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.first_name, this.middle_name, this.last_name, this.photo, this.home, this.mobile, this.work, this.address, this.email, this.email2, this.email3);
    }

    public ContactData withFirst_name(String first_name) {
        return new ContactData(this.id, first_name, this.middle_name, this.last_name, this.photo, this.home, this.mobile, this.work, this.address, this.email, this.email2, this.email3);
    }

    public ContactData withMiddle_name(String middle_name) {
        return new ContactData(this.id, this.first_name, middle_name, this.last_name, this.photo, this.home, this.mobile, this.work, this.address, this.email, this.email2, this.email3);
    }

    public ContactData withLast_name(String last_name) {
        return new ContactData(this.id, this.first_name, this.middle_name, last_name, this.photo, this.home, this.mobile, this.work, this.address, this.email, this.email2, this.email3);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.first_name, this.middle_name, this.last_name, photo, this.home, this.mobile, this.work, this.address, this.email, this.email2, this.email3);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.id, this.first_name, this.middle_name, this.last_name, this.photo, home, this.mobile, this.work, this.address, this.email, this.email2, this.email3);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.first_name, this.middle_name, this.last_name, this.photo, this.home, mobile, this.work, this.address, this.email, this.email2, this.email3);
    }

    public ContactData withWork(String work) {
        return new ContactData(this.id, this.first_name, this.middle_name, this.last_name, this.photo, this.home, this.mobile, work, this.address, this.email, this.email2, this.email3);
    }

    public ContactData withAddress (String address) {
        return new ContactData(this.id, this.first_name, this.middle_name, this.last_name, this.photo, this.home, this.mobile, this.work, address, this.email, this.email2, this.email3);
    }

    public ContactData withEmail (String email) {
        return new ContactData(this.id, this.first_name, this.middle_name, this.last_name, this.photo, this.home, this.mobile, this.work, this.address, email, this.email2, this.email3);
    }

    public ContactData withEmail2 (String email2) {
        return new ContactData(this.id, this.first_name, this.middle_name, this.last_name, this.photo, this.home, this.mobile, this.work, this.address, this.email, email2, this.email3);
    }

    public ContactData withEmail3 (String email3) {
        return new ContactData(this.id, this.first_name, this.middle_name, this.last_name, this.photo, this.home, this.mobile, this.work, this.address, this.email, this.email2, email3);
    }





}
