package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager manager) {
        super(manager);


    }

    public void createContact(ContactData contact) {
        openContactsPage();
        fillContactForm(contact);
        submitContactCreation();
        returnToContactsPage();
    }

    private void returnToContactsPage()  {
        click(By.linkText("add next"));

    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.first_name());
        type(By.name("middlename"),  contact.middle_name());
        type(By.name("lastname"),  contact.last_name());
    }


    private void openContactsPage() {
        if (!manager.isElementPresent(By.name("firstname"))) {
            click(By.linkText("add new"));
        }
    }



    private void openHomePage() {
        click(By.linkText("home"));
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        removeSelectedContact();
        returnToHomePage();
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    private void removeSelectedContact() {
        click(By.name("delete"));
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    public int getCount() {
        openHomePage();
        return  manager.driver.findElements(By.name("selected[]")).size();
    }
    public void removeAllContacts() {
        openHomePage();
        selectAllContacts();
        removeSelectedContact();
    }

    private void selectAllContacts() {
        click(By.id("MassCB"));
    }

    public List<ContactData> getList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var lines = manager.driver.findElements(By.cssSelector("tr:has(input[name='selected[]'])"));
        for (var line : lines) {
            var first_name = line.findElement(By.cssSelector("td:nth-child(3)")).getText();
            var checkbox = line.findElement(By.name("selected[]"));
            var last_name = line.findElement(By.cssSelector("td:nth-child(2)")).getText();
            var id = checkbox.getAttribute("id");
            contacts.add(new ContactData().withId(id).withFirst_name(first_name).withMiddle_name("").withLast_name(last_name));

        }
        return contacts;
    }

}
