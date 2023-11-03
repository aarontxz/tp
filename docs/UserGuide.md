---
  layout: default.md
  title: "User Guide"
  pageNav: 3
---

# Insurahub User Guide

Insurahub is a **desktop app for managing clients, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, Insurahub can get your contact management tasks done faster than traditional GUI apps. This app is mainly used by insurance agents who have many clients and tasks such as appointments to keep track of on a daily basis.

<!-- * Table of Contents -->
<page-nav-print />

---

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `insurahub.jar` from [here](https://github.com//AY2324S1-CS2103-W14-1/tp).

1. Copy the file to the folder you want to use as the _home folder_ for your App.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar insurahub.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   - `list` : Lists all contacts.

   - `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the application.
   - `addTag 1 t/classmate` : Adds a "classmate" tag to the first user in the address book.

   - `delete 3` : Deletes the 3rd contact shown in the current list.

   - `deleteTag 1 t/classmate` : Deletes the "classmate" tag from the first user in the address book if the "classmate" tag currently exists
     
   - `clear` : Deletes all contacts.
   - `filter t/friend`: Filters for all clients in the address book that contains the `friend' tag.

   - `exit` : Exits the app.

   - `file 1`: Creates a folder for the first person in the address book with the person's information

   - `preferredContact 1 pc/phone` : Highlight to show that that is the main form of contact that the client in the first index prefers.

1. Refer to the [Features](#features) below for details of each command.

---

## Features

<box type="info" seamless>

**Notes about the command format:**<br>

- Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

- Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

- Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

- Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

- Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

- If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
  </box>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Adding a new client: `addN`

Adds a new person to the address book.

Format: `add/FIRSTNAME/LASTNAME/PRIMARYPHONENUMBER/ADDRESS/EMAIL`

<box type="tip" seamless>

Examples:

- `addNewClient/Johnny/Snake/91234567/Blk 69 Geylang Street 12, #12-69/johnnythesnake12@gmail.com`
- `addNewClient/Betsy/Crowe/92222222/Newgate Prison/betsycrowe@example.com`

### Listing all persons : `list`

Shows a list of all persons in the address book.

Format: `list`

### Editing a person : `edit`

Edits an existing person in the address book.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

- Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
- At least one of the optional fields must be provided.
- Existing values will be updated to the input values.
- When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
- You can remove all the person’s tags by typing `t/` without
  specifying any tags after it.

Examples:

- `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
- `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.

### Locating persons by name: `find`

Finds persons whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

- The search is case-insensitive. e.g `hans` will match `Hans`
- The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
- Only the name is searched
- Only full words will be matched e.g. `Han` will not match `Hans`
- Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:

- `find John` returns `john` and `John Doe`
- `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### Deleting a person : `delete`

Deletes the specified person from the address book.

Format: `delete INDEX`

- Deletes the person at the specified `INDEX`.
- The index refers to the index number shown in the displayed person list.
- The index **must be a positive integer** 1, 2, 3, …​

Examples:

- `list` followed by `delete 2` deletes the 2nd person in the address book.
- `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Filtering for Persons via tag : `filter`

Filters for all persons in InsuraHub that have the tag being filtered.

Format: `filter t/TAG1 t/TAG2`

- Filters for person objects that contain all the specified tags `TAG1`, `TAG2`.
- Only person objects that contain all the specified tags will be listed in the Ui.

Examples:

- `filter` followed by `t/FRIEND` will list out all the clients that have the `friend` tag.
- `filter` followed by `t/FRIEND t/COLLEAGUE` will list out all the clients that have both the `friend` and `colleague`
tag. Clients that contain only one of either specified tags will not be shown.

### Adding a policy to a client : `addPolicy`

Adds an insurance policy to a client in InsuraHub.

Format: `addPolicy <INDEX> [pn/POLICY NAME  pd/POLICY DESCRIPTION  pv/POLICY VALUE  psd/POLICY START DATE  ped/POLICY END DATE]`

- `INDEX` must be a positive integer less than or equals to the number of clients currently shown on InsuraHub.

Examples:

- `addPolicy 1 pn/Health Insurance pd/Cancer Plan pv/2000.00 psd/2023-01-01 ped/2024-12-12 `
will add a policy with name Health Insurance and other details such as start date 2023-01-01 to the
first client currently listed on the InsuraHub Ui.

### Removing a policy from a client : `removePolicy`

Removes an existing insurance policy from a client currently listed on the Ui of InsuraHub.

Format: `removePolicy <INDEX_1> <INDEX_2>`

- `INDEX_1` must be a positive integer less than or equals to the number of clients currently shown on InsuraHub.
- `INDEX_2` must be a positive integer less than or equals to the number of policies the client specified by `INDEX_1` has.

Examples:

- `removePolicy 1 1` will remove the first policy (right-most) of the first client currently listed in the InsuraHub Ui.

### viewing policy of a client: `viewPolicy`

Creates/opens up a folder specific to a client for storing of their documents

Format 1: `viewPolicy <INDEX> <POLICY INDEX>`

- `INDEX_1` must be a positive integer less than or equals to the number of clients currently shown on InsuraHub.
- `INDEX_2` must be a positive integer less than or equals to the number of policies the client specified by `INDEX_1` has.

Examples:

- `viewPolicy 1 1` will display the first policy (right-most) that was added to the first person shown on the list.


### Adding a client preferred contact: `preferredContact`

Highlight the specific contact details of the particular client from the application.

Format 1: `preferredContact <INDEX> pc/PREFERREDCONTACT`

- **INDEX** must be a positive integer less than or equals to the number of clients currently shown on Insurahub.
- **preferred contact method** either Phone number or Email currently
- Name: Contact name of the person that is saved in the app.
- Preferred contact method:
    - Phone number
    - Email

Examples:

- `preferredContact 1 pc/phone number` will highlight the phone number of the first person in the current list shown


### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

**Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.
</box>

### Adding tags to a client object: `addTag`

Adds any number of new tags to a client object without deleting the pre-exisiting tags.

Format 1: `addTag <tag1>/<tag2> /<INDEX>`


- **INDEX** must be a positive integer less than or equals to the number of clients currently shown on Insurahub.
- **tag**: must be a valid tag in the pre-defined list implemented in the app

Examples:

- `addTag friend 1` will add the tag 'friend' to the first client on the current list.
- `addTag friend/North JohnDoe` will add the tags 'friend', 'North' to the client identified by John Doe.

### Deleting tags from a client object: `deleteTag`

Removes any number of pre-existing tags from a client object.

Format 1: `deleteTag <tag1>/<tag2> /<INDEX>`

- **INDEX** must be a positive integer less than or equals to the number of clients currently shown on Insurahub.
- **client identifier** must be one of the unique identifier of the clients in the entire client list
- - **tag**: must be a valid tag in the pre-defined list implemented in the app

Examples:

- `deleteTag friend 1` will remove the tag 'friend' from the first client on the current list.
- `deleteTag friend/North JohnDoe` will remove the tags 'friend', 'North' from the client identified by John Doe.

### Filtering for clients based on tags: `filter`

Filters and displays all clients that correspond to a specific combination/query of tags

Format 1: `filter <tag1>/<tag2>/ … /<tagn>`

- **tag**: must be a valid tag in the pre-defined list implemented in the app

Examples:

- `filter friend/south/60+` will filter for all clients with the tags 'friend', 'south', '60+'

### Storing documents of a client: `file`

Creates/opens up a folder specific to a client for storing of their documents

Format 1: `file <INDEX>`

- **INDEX** must be a positive integer less than or equals to the number of clients currently shown on Insurahub.

Examples:

- `file 1` will open up a folder that is named after the first client currently on the list and their hashcode

### Grouping client preferred meeting locations: `groupLocation`

Groups clients based on their preferred meeting locations

Format: `groupLocation` west/north/south/east/central

Examples:

- `groupLocation west` will group all clients that prefer to meet in the west region and returns a list of clients that prefer to meet in the west region

### change password: `changePassword`

Changes the required password to enter Insurahub.

Format: `changepassword op/<OLDPASSWORD> np/<NEWPASSWORD>`

Examples:

- `changepassword op/boo123 np/pass456` if the previous password is boo123, then the new password is set as pass456.
- `changepassword op/bad123 np/pass456` if the previous password is not bad123, then the password is unchanged.

### viewing policy of a client: `toggleMode`

toggles between lightMode and DarkMode, the next time InsuraHub is opened the change will be shown.

Format: `toggleMode`

Examples:

- `toggleMode` will display the mode that Insurahub will be in when it is next opened.


Examples:

- `removePolicy 1 1` will remove the first policy (right-most) that was added to the first person shown on the list.

## In Progress

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

---

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

---

## Command summary

| Action                | Format, Examples                                                                                                                                                                                                             |
|-----------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**               | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`                                                        |
| **Clear**             | `clear`                                                                                                                                                                                                                      |
| **Delete**            | `delete INDEX`<br> e.g., `delete 3`                                                                                                                                                                                          |
| **Edit**              | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`                                                                                                  |
| **Find**              | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`                                                                                                                                                                   |
| **Filter**            | `filter t/TAG1 t/TAG2`<br/> e.g., `filter t/friend t/colleague`                                                                                                                                                              |
| **List**              | `list`                                                                                                                                                                                                                       |
| **addPolicy**         | `addPolicy <INDEX> [pn/POLICY NAME  pd/POLICY DESCRIPTION  pv/POLICY VALUE  psd/POLICY START DATE  ped/POLICY END DATE]`<br/> e.g. `addPolicy 1 pn/Health Insurance pd/Cancer Plan pv/2000.00 psd/2023-01-01 ped/2024-12-12 ` |
| **removePolicy**      | `removePolicy <INDEX_1> <INDEX_2`<br/> e.g. `removePolicy 1 1`                                                                                                                                                                |
| **Help**              | `help`                                                                                                                                                                                                                       |
| **Preferred Contact** | `preferredContact INDEX pc/PREFERREDCONTACT` eg: preferredContact 1 pc/phone                                                                                                                                                 |
