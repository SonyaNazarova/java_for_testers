package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactInGroup extends TestBase{
    @Test
    public void addContactInGroup() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "contact first name", "contact middle name", "contact last name", "src/test/resources/images/avatar.png"));
        }
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var oldGroups = app.hbm().getGroupList();
        var group = oldGroups.get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        var allContacts = app.hbm().getContactList();
        allContacts.removeAll(oldRelated);
        if (allContacts.isEmpty()) {
            app.hbm().createContact(new ContactData("", "first", "middle", "last", "src/test/resources/images/avatar.png"));
            allContacts = app.hbm().getContactList();
            allContacts.removeAll(oldRelated);
        }
        var contact = allContacts.get(0);
        app.contacts().addContact(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        var expectedList = new ArrayList<>(oldRelated);
        expectedList.add(contact);

        Comparator<ContactData> compareById = (o1, o2) -> Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        newRelated.sort(compareById);
        expectedList.sort(compareById);

        Assertions.assertEquals(newRelated, expectedList);

        Assertions.assertEquals(app.hbm().getGroupList(), oldGroups);
    }

    @Test
    public void removeContactFromGroup() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "contact first name", "contact middle name", "contact last name", "src/test/resources/images/avatar.png"));
        }
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var oldGroups = app.hbm().getGroupList();
        var group = oldGroups.get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        if (oldRelated.isEmpty()) {
            var contactToAdd = app.hbm().getContactList().get(0);
            app.contacts().addContact(contactToAdd, group);
            oldRelated = app.hbm().getContactsInGroup(group);
        }
        var contactToRemove = oldRelated.get(0);
        app.contacts().removeContactFromGroup(contactToRemove, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        var expectedList = new ArrayList<>(oldRelated);
        expectedList.remove(contactToRemove);

        Comparator<ContactData> compareById = (o1, o2) -> Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        newRelated.sort(compareById);
        expectedList.sort(compareById);

        Assertions.assertEquals(newRelated, expectedList);

        Assertions.assertEquals(app.hbm().getGroupList(), oldGroups);
    }

    }

