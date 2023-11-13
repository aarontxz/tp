package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;

import static seedu.address.logic.commands.CommandTestUtil.VALID_HEALTH_INSURANCE_POLICY;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_POLICY;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getOtherTypicalAddressBook;

public class  ViewPolicyCommandTest {
    private Model model = new ModelManager(getOtherTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_View_Health_Insurance_Policy_Successful() throws Exception {
        Person person = model.getFilteredPersonList().get(1);
        ViewPolicyCommand viewPolicyCommand = new ViewPolicyCommand(INDEX_SECOND_PERSON, INDEX_FIRST_POLICY);
        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setPerson(model.getFilteredPersonList().get(1), person);
        assertCommandSuccess(viewPolicyCommand, model, VALID_HEALTH_INSURANCE_POLICY, expectedModel);
    }
}
