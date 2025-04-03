# Govindaraj Roshni Daksha - Project Portfolio Page

By: Govindaraj Roshni Daksha (@roshnidaksha)

## Project: InternSprint

InternSprint is your Ultimate Internship Application Assistant.

Navigating internship applications can be overwhelming - multiple platforms, countless CV versions, and keeping track of
application stages can quickly become chaotic. InternSprint is here to streamline the entire process, acting as your personal
assistant for managing and organizing internship applications efficiently. InternSprint is a CLI application used internship management.

### Summary of Contributions

## Code Contributed: 

Check out my contributions to InternSprint at the [TP Dashboard](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/?search=roshnidaksha&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2025-02-21&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

### Enhancements Implemented:  

1. **New feature:** Added the ability to add new internships to the list.
[(#17)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/17)

    * **What it does**: allows the users to add a new internship to their list of internships.
    * **Highlights**: The user can add internships with a variety of parameters, including the type of internship (software, hardware, general),
   company name, technologies required, status of internship, eligibility, role and description.
   Only the first 3 are mandatory parameters, and the rest are optional.
    * **Contributions**: I created the `AddInternshipCommand` class and its subclasses, 
   `AddSoftwareInternshipCommand`, `AddHardwareInternshipCommand` and `AddGeneralInternshipCommand`. 
   I also created the `Internship` class and its subclasses, `SoftwareInternship`, `HardwareInternship` and `GeneralInternship`. 
   I also created the `InternshipList` class to manage the list of internships.


2. **New feature:** Added the ability to add an interview to an internship.
[(#92)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/92)

    * **What it does**: allows the users to add an interview to an internship.
    * **Highlights**: The user can add an interview with a variety of parameters, including the date, start time, end time, 
   type of interview, interviewer email and notes.
   Only the first 4 are mandatory parameters, and the rest are optional.
    * **Contributions**: Created the `AddInterviewCommand` class.

**NOTE:** For both the features above, the command takes care to not add any duplicate internships or interviews to the list.


3. **New feature:** Added the function to filter internships.
[(#87)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/87)

   * **What it does**: allows the users to filter internships based on internship type, role and company name.
   * **Highlights**: The user can filter internships based on the type of internship (software, hardware, general),
   role and company name. At least one of the parameters is required to filter the internships.
   * **Contributions**: Created the `FindCommand` class.


4. **Additional Enhancement:** Created a parser to handle the command line arguments.
   [(#17)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/17)

    * **What it does**: The parser takes the command line arguments and parses them into a command object.
    * **Highlights**: The parser is able to handle different types of commands and their parameters without taking the 
   order of parameters into consideration. This is more user-friendly. 
   It also handles invalid commands and parameters.
    * **Contributions**: Created the `CommandParser` class to handle the command line arguments.


5. **Additional Enhancement:** Created a parser to handle date and time.
[(#74)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/74)

    * **What it does**: The parser takes the date and time in different formats and parses them into a standard format.
    * **Highlights**: The parser makes use of external libraries like `Natty` and `PrettyTime` to handle the date and time parsing.
   It is capable of handling natural language inputs and parsing them to correct java date and time objects.
    * **Contributions**: Created the `DateTimeParser` class to handle the date and time.

**Contributions to team-based tasks :**
* Created `Command` and `CommandResult` classes to manage the command execution and result.
[(#17)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/17)
* Created `Storage` interface to handle storage of different kinds of data.

  * Wrote the skeleton code for `fromJSON` and `toJSON` methods to handle JSON parsing using `JSON in Java` external library.
  [(#56)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/56)
  * Implemented `InternshipStorageHandler` to save internship data in JSON format.
  [(#24)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/24)
* Created `InternSprintExceptionMessages` and `InternSprintMessages` classes to store the exception messages and 
other messages used in the application.
[(#17)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/17)

**Testing**
* Add Internship Commands [(#28)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/28)

Contributions to the UG: Which sections did you contribute to the UG?
Contributions to the DG: Which sections did you contribute to the DG? Which UML diagrams did you add/updated?
Contributions to team-based tasks
Review/mentoring contributions: Links to PRs reviewed, instances of helping team members in other ways.
Contributions beyond the project team:
Evidence of helping others e.g. responses you posted in our forum, bugs you reported in other team's products,
Evidence of technical leadership e.g. sharing useful information in the forum
Keep in mind that evaluators will use the PPP to estimate your project effort. We recommend that you mention things that will earn you a fair score e.g., explain how deep the enhancement is, why it is complete, how hard it was to implement etc.

OPTIONAL Contributions to the Developer Guide (Extracts): Reproduce the parts in the Developer Guide that you wrote. Alternatively, you can show the various diagrams you contributed.
OPTIONAL Contributions to the User Guide (Extracts): Reproduce the parts in the User Guide that you wrote.