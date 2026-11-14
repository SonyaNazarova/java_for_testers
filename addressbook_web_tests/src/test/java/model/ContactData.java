package model;

public record ContactData(
        String id,
        String first_name,
        String middle_name,
        String last_name,
        String photo,
        String home,
        String mobile,
        String work
) {
    public ContactData(){
        this ("", "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.first_name, this.middle_name, this.last_name, this.photo, this.home, this.mobile, this.work);
    }

    public ContactData withFirst_name(String first_name) {
        return new ContactData(this.id, first_name, this.middle_name, this.last_name, this.photo, this.home, this.mobile, this.work);
    }

    public ContactData withMiddle_name(String middle_name) {
        return new ContactData(this.id, this.first_name, middle_name, this.last_name, this.photo, this.home, this.mobile, this.work);
    }

    public ContactData withLast_name(String last_name) {
        return new ContactData(this.id, this.first_name, this.middle_name, last_name, this.photo, this.home, this.mobile, this.work);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.first_name, this.middle_name, this.last_name, photo, this.home, this.mobile, this.work);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.id, this.first_name, this.middle_name, this.last_name, this.photo, home, this.mobile, this.work);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.first_name, this.middle_name, this.last_name, this.photo, this.home, mobile, this.work);
    }

    public ContactData withWork(String work) {
        return new ContactData(this.id, this.first_name, this.middle_name, this.last_name, this.photo, this.home, this.mobile, work);
    }




}
