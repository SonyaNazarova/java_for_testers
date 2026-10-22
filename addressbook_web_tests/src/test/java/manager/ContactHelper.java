package manager;

import model.ContactData;
import org.openqa.selenium.By;

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


}
