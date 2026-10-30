package tests;

import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{


    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var first_name: List.of("", "contact first name")){
            for (var middle_name: List.of("", "contact middle name")){
                for (var last_name: List.of("", "contact last name")){
                    result.add(new ContactData().withFirst_name(first_name).withMiddle_name(middle_name).withLast_name(last_name).withPhoto(null));
                }
            }
        }
        for (int i = 0 ; i < 3; i++){
            result.add(new ContactData()
                    .withFirst_name(CommonFunctions.randomString(i*10))
                    .withMiddle_name(CommonFunctions.randomString(i*10))
                    .withLast_name(CommonFunctions.randomString(i*10))
                    .withPhoto(randomFile("src/test/resources/images")));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void CanCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);

        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size()-1).id()).withMiddle_name("").withPhoto(""));
        expectedList.sort(compareById);

        Assertions.assertEquals(newContacts, expectedList);
    }


}
