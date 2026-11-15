package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase{


    @Test
    void testPhones() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "contact first name", "contact middle name", "contact last name", "src/test/resources/images/avatar.png", "", "", ""));
        }
        var  contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
            Stream.of(contact.home(), contact.mobile(), contact.work())
                    .filter(s -> s != null && !"".equals(s))
                    .collect(Collectors.joining("\n"))
        ));
        var phones = app.contacts().getPhones();
        Assertions.assertEquals(expected, phones);

    }
}
