package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase{
    @Test
    public void canRemoveContact() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("contact first name", "contact middle name ", "contact last name"));
        }
        app.contacts().removeContact();

    }

    @Test
    void canRemoveAllContactsAtOnce (){
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("contact first name", "contact middle name ", "contact last name"));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0, app.contacts().getCount());
    }
}
