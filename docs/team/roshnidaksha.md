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
   To manage the list of internships, I created the `InternshipList` class, achieving better encapsulation and separation of concerns.


2. **New feature:** Added the ability to add an interview to an internship.
[(#92)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/92)

    * **What it does**: allows the users to add an interview to an internship.
    * **Highlights**: The user can add an interview with a variety of parameters, including the date, start time, end time, 
   type of interview, interviewer email and notes.
   Only the first 4 are mandatory parameters, and the rest are optional.
    * **Contributions**: Created the `AddInterviewCommand` class.

**NOTE:** For both the features above, the command takes care to not add any duplicate internships or interviews to the list.
[(#113)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/113)
[(#120)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/120)

<div style="page-break-after: always;"></div>

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
   order and case of parameters into consideration. This is more user-friendly. 
   It also handles invalid commands and parameters, returning appropriate error messages.
    * **Contributions**: Created the `CommandParser` class to handle the command line arguments.


5. **Additional Enhancement:** Created a parser to handle date and time.
[(#74)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/74)

    * **What it does**: The parser takes the date and time in different formats and parses them into a standard format.
    * **Highlights**: The parser makes use of external libraries like [Natty](https://mvnrepository.com/artifact/com.joestelmach/natty) 
   and [PrettyTime](https://mvnrepository.com/artifact/org.ocpsoft.prettytime/prettytime) to handle the date and time parsing.
   It is capable of handling natural language inputs and parsing them to correct java date and time objects.
    * **Contributions**: Created the `DateTimeParser` class to handle the date and time.

**Contributions to team-based tasks :**
* Updated `.gitignore` to ignore data and log files. [(#232)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/233)
* Managed release for v1.0 and v2.1.
* Initialised the project with the following classes: [(#17)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/17)
  * Created `Ui` class with commonly used methods.
  * Created `InternSprintExceptionMessages` and `InternSprintMessages` classes to store the exception messages and
    other messages used in the application.
* Created `Command` and `CommandResult` classes to manage the command execution and result.
[(#17)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/17)
* Created `Storage` interface and singleton `StorageManager` class to handle storage of different kinds of data. 
[(#126)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/126)

  * Wrote the skeleton code for `fromJSON` and `toJSON` methods to handle JSON parsing using [JSON in Java](https://mvnrepository.com/artifact/org.json/json)
  external library. The same format was used to save other information.
  [(#56)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/56)
  * Implemented `createfile()` and `save()` methods of `InternshipStorageHandler` to save internship data in JSON format.
  [(#24)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/24)
  [(#133)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/133)

* Referred to [ASCII Table](https://mvnrepository.com/artifact/de.vandermeer/asciitable) implementation from `view project` commands to display interview rounds in a more intuitive
format while describing an internship. [(#237)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/237)
* Maintaining the issue tracker: Authored 40+ issues and assigned them appropriately among a total of 120+ issues.

**Testing**
* Add Internship Commands [(#28)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/28) [(#96)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/96/files)
* Command Parser [(#96)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/96/files)
* DateTimeParser [(#74)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/133)

**PRs Reviewed:**
[(#18)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/18)
[(#29)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/29)
[(#35)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/35)
[(#37)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/37)
[(#77)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/77)
[(#79)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/79)
[(#80)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/80)
[(#85)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/85)
[(#98)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/98)
[(#104)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/104)
[(#115)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/115)
[(#124)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/124)
[(#155)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/155)

**Bug Fixes:**
[(#168)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/168)
[(#184)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/184)
[(#210)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/210)
[(#211)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/211)
[(#217)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/217)
[(#222)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/222)

<div style="page-break-after: always;"></div>

**Contributions to Documentation:**
* **User Guide**
  * Adding internships: software, hardware and general [(#72)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/72)
  * Date and Time formats [(#111)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/111)
  * Command Summary [(#137)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/137)
* **Developer Guide**
  * Realigned and resized images for better visibility [(#167)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/167)
  * Architecture [(#144)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/144)
  * Logic Component [(#102)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/102)
  * Add new internship [(#102)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/102)
  * Logging guide, Product scope, User Stories, Non-Functional Requirements, Glossary [(#144)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/144)

**Extracts from Developer Guide:**

*Architecture Diagram*

<img src="../images/OverallArchitecture.png" alt="OverallArchitecture" width="40%">

*Command Parser Class Diagram*

<img src="../images/CommandParserClassUML.png" alt="CommandParserClassUML" width="100%">

<div style="page-break-after: always;"></div>

*Command Class Overview Sequence Diagram*

<img src="../images/CommandClassOverview.png" alt="CommandClassOverview" width="100%">

*Sequence Diagrams showing the flow of execution for adding an internship*

<img src="../images/AddInternshipImages/AddCommandSequenceDiagramOverview.png" alt="AddCommandSequenceDiagramOverview" width="50%">
<img src="../images/AddInternshipImages/AddCommandSequenceDiagramAlternateFrameOne.png" alt="AddCommandSequenceDiagramOverview" width="60%">

<div style="page-break-after: always;"></div>

<img src="../images/AddInternshipImages/AddCommandSequenceDiagramAlternateFrameTwo.png" alt="AddCommandSequenceDiagramOverview" width="100%">
