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
            app.hbm().createContact(new ContactData("", "contact first name", "contact middle name", "contact last name", "src/test/resources/images/avatar.png", "1234568", "989565656", "89862656", "contact address", "contact email", "contact email2", "contact email3"));
        }
        var  contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
            Stream.of(contact.home(), contact.mobile(), contact.work())
                    .filter(s -> s != null && !"".equals(s))
                    .collect(Collectors.joining("\n"))
        ));
        app.contacts().homePage();
        var phones = app.contacts().getPhones();
        Assertions.assertEquals(expected, phones);

    }

    @Test
    void testAddress() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "contact first name", "contact middle name", "contact last name", "src/test/resources/images/avatar.png", "1234568", "989565656", "89862656", "contact address", "contact email", "contact email2", "contact email3"));
        }
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.address())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        app.contacts().homePage();
        var address = app.contacts().getAddress();
        Assertions.assertEquals(expected, address);


    }

    @Test
    void testEmails() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "contact first name", "contact middle name", "contact last name", "src/test/resources/images/avatar.png", "1234560", "989565656", "89862656", "contact address", "contact email", "contact email2", "contact email3"));
        }
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.email(), contact.email2(), contact.email3())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        app.contacts().homePage();
        var emails = app.contacts().getEmails();
        Assertions.assertEquals(expected, emails);


    }




}
