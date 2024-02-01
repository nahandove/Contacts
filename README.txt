Project assignment from JetBrains Academy (www.hyperskill.org), Java Developer track.

Summary: A phone book application in Java. The user can add, update, search, and delete
personal and business contact records, as well as save and load contact records from files.

"Contacts" is a phone book application that can be directly used from the command line. The
user can start with a clean slate, or supply a specific file containing old records using
the arguments "open {file name}". If a file name is supplied, the file can be used to save
all records after closing the application, or to load existing records for further
processing.

Upon starting the application, the main menu is displayed:

[menu] Enter action (add, list, search, count, exit):

The user can select from any of the commands and process their phone book records in an
infinite loop until "exit" is entered from the main menu page. 5 commands are available in
the main menu: add, list, search, count, and exit. If the user enters any other command, the 
program returns the error message: "Unknown command" and the user is presented with the menu
again.

-- Main menu commands

1. add

The program prompts the user to enter the type of contact. Two types of contacts are 
available: person and organization. The program will show different prompts depending on user
selection. After the user answer all prompts for the contact, the new contact is added to
the phone book and automatically saved to the file (if a file exists).

a. Adding a person (> represents user input)

An example of adding a person, including bad inputs: 

Enter the type (person, organization): > person
Enter the name: > John
Enter the surname: > Smith
Enter the birth date: >
Bad birth date!
Enter the gender (M, F): >
Bad gender!
Enter the number: > +0 (123) 456-789-ABcd
One record added

As shown in the above example, the program is able to continue even when the user enters
invalid input. Any of the invalid inputs would be shown as [no data] in the record and can be
updated in the future. 

b. Adding an organization (> represents user input)

An example of adding an organization:

Enter the type (person, organization): > organization
Enter the organization name: > Lucky Pizza Shop
Enter the address: > Wall St. 1
Enter the number: > +0 (123) 456-789-9999
One record added.

c. Validating user input in add command

The program validates all fields when adding a contact. Invalid entries do not stop the
the program--instead, the program prints an error message and the user can continue to
input other fields. All invalid inputs show up as [no data] for the specific field when
the record is displayed.

c1. Verifying phone number (for person and organization):

A phone number must fit the below criteria to be added to the records. If the number does not
fit all the below criteria, an error message "Wrong number format!" is shown and [no data]
will be used as a placeholder for the contact record unless corrected by future edits.

	-The phone number can be split into groups using space or dash. One group is also
	possible
	-The phone number can include a plus symbol at the beginning.
	-The first or second group can be wrapped in parentheses, but there should only be
	one group wrapped in parenthesis. No parenthesis is also possible
	-A group can contain numbers, uppercase, or lowercase English letters. Each group
	should be at least 2 symbols in length except the first group, which can be 1 symbol
	long.

c2. Verifying gender (for person)

Only M or F in uppercase are considered valid entries. An error message "Bad gender!" will
be printed for other entries and [no data] will be used as placeholder for the gender field.

c3. Verifying birth date (for person)

A person's birth date must be entered in the format YYYY-MM-dd, for instance 1994-01-25. If
the birth date format is wrong, or if invalid dates are entered, the message, "Bad birth
date!" is displayed and [no data] would be used as placeholder for the birth date field.

d. Time stamp

A time stamp for the first creation of the contact is made after all fields are entered
(whether valid or not). This will be displayed when a specific contact is displayed.

2. list

The list command brings up the full contacts list ordered by time of entry. Both persons and
organizations are listed. Then, the list menu prompt is shown to the user (details see --List
menu commands).

3. search

When the user chooses the search command, the program prompts the user to enter a keyword.
The program then find all the contacts whose content contain the keyword (case insensitive),
and displays "found {number} results" where {number} is the number of matching contacts, and
a list of matching contacts ordered by time of entry. Then, the search menu prompt is shown
to the user (details see --Search menu commands).

4. count

The count command displays the number of contacts currently in the phone book, in the format:
The Phone Book has {number} contact.

5. exit

The exit command is used to close the program. If a file is supplied, all the changes made
to the phone book are automatically saved to the file.

-- List menu commands

After the user selected list from the main menu and the program printed the list of all
contacts, the user is presented with the list menu prompt:

[list] Enter action ([number], back): 

The user can either enter "back" to return to the main menu, or enter the number of the
contact in the list. If the user enters a number, the program brings up the full details
of the contact and also presents the user with the Record menu (details see --Record menu
commands).

-- Search menu commands

After the user selected search from the main menu and the keyword for the search prompt,
and the program returns a list of matches from the search, the user is presented with the
search menu prompt:

[search] Enter action ([number], back, again):

The user returns to the main menu with the "back" command, or can re-do the search command
by entering "again". If the user finds the record they want, they can enter the number of
the specific contact to see the full details. The program then presents the user with the
Record menu (details see --Record menu commands).

-- Record menu commands

After the user selected a number from the List or Search menu command prompt, the user is
presented with a detailed record. Example format for person and organization is seen below:

Name: Alice
Surname: Jones
Birth date: [no data]
Gender: F
Number: +123 4567899
Time created: 2024-01-24T11:11
Time last edit: 2024-01-24T11:11

Organization Name: Lucky Pizza Shop
Address: Wall St. 1
Number: +0 (123) 0800-0000
Time created: 2024-01-25T15:28
Time last edit: 2024-01-31T20:20

After the detailed record, the user is presented with the Record menu in the following 
format:

[record] Enter action (edit, delete, menu):

1. edit

The user edits the current record. The program lists all the available fields to edit: name,
surname, borth date, gender, and number for persons, and name, address, and phone number for
organizations. The user is prompted to select a field (say birth date for Alice). Once the
user makes the selection, the program prompts the user to enter new information for the field
(say 1994-01-10). Now Alice's birth date above is updated and in future queries, Alice's 
record will show the new birth date. 

For all edits, a time stamp is created after the edit is finished, and will be shown as "Time
last edit" in the contact's record. The phone book with the new edit is automatically saved
to the file if a file is provided.

2. delete

The current record is deleted from the phone book and will no longer show up in future 
listings. The phone book without the deleted entry is automatically saved to the file if a 
file is provided.

3. menu

The command returns the user to the main menu.

January 31th, 2024--description by E. Hsu (nahandove@gmail.com)