# Manikanda Durairaj Prathistta - Project Portfolio Page

By: Manikanda Durairaj Prathistta (@prathisttam)

## Project: InternSprint

InternSprint is your Ultimate Internship Application Assistant.

Navigating internship applications can be overwhelming - multiple platforms, countless CV versions, and keeping track of
application stages can quickly become chaotic. InternSprint is here to streamline the entire process, acting as your personal
assistant for managing and organizing internship applications efficiently. InternSprint is a CLI application used internship management.

### Summary of Contributions

## Code Contributed:

Check out my contributions to InternSprint at the [TP Dashboard](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/?search=prathisttam&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2025-02-21&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

## Enhancements implemented 

1. **New feature:** Added the ability to list all internships added.

    * **What it does**: Allows the users to list all internships they have added.
    * **Highlights**: The internships are segregated and displayed according to the three categories of software, hardware and general. The company, role and department of each internship is shown. The command does not take in any additional flags. 
    * **Contributions**: Created the `listCommand` class.

2. **New feature:** Added the ability to view the description of any particular internship from the list.

    * **What it does**: Allows users to view the detailed description of any internship and based on its index in the list
    * **Highlights**: After validating and parsing the user input (which includes the internship type and index), this feature uses the internship map to retrieve the appropriate list of internships. The parsed internship type serves as the key to this map.
    * **Contributions**: Created the `DescriptionCommand` class.

3. **New feature:** Added an Interview class that models the concept of an interview.

    * **What it does**: It models the concept of an interview to allow users to add interviews for each internship. 
    * **Highlights**: 
      * Handles both required parameters(date, start time, end time, type) and optional parameters(interviewer email, notes)
      * Supports the creation of multiple interview rounds for a particular internship
    * **Contributions**:
      * Created the `interview` class and Designed the core attributes needed for it.
      * Created constructors to accommodate compulsory and mandatory parameters and handled all possible exceptions across the class.

4. **New feature:** Added the function to sort interviews.

    * **What it does**: It sorts interviews based on the dates and start-timings 
    * **Highlights**: 
      * It displays the sorted interviews in an ASCII table for easier for better user readability
    * **Contributions**: 
       * Created the `sort interviews` class
       * Created a helper class, `InterviewEntry`, to encapsulate both the internship and its associated interview into a single object. This design aids in the collection and sorting of multiple rounds of interviews by flattening the nested data structure.

5. **Additional Enhancement:** Created a centralised logger for the application

   * **What it does**: The centralised logger serves as a single configuration point for all logging throughout the application. As creating multiple logger instances across each classes might lead to unnecessary resource usage, this centralized logger ensures that logging is efficiently managed, reducing overhead.
   * **Highlights**: 
     * Logger uses a singleton approach to configure the logger only once, maintaining consistency throughout application. 
     * Allows user to set the logging threshold and format for console and file handler across the whole application.
   * **Contributions**:
     * Created the `InternSprintLogger` class and set up dual logging outputs by creating separate consoleHandler and FileHandler. ConsoleHandler is ideal for debugging when log output needs to be seen immediately while fileHandler is essential for persistent storage of logs to later review.
     * I developed proactive file management to ensure the log file and its directories are created automatically if not already preset to prevent runtime errors.

Note: For all the command classes and interview class, JUNIT tests, assertions and logging was implemented. SLAP was also utilised to my best ability.

**Contributions to Documentation:**
* **User Guide**
 * Added documentation for the features `list`, `description` and `sort interviews` commands
**Developer Guide:**
 * Model Component: [(#155)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/155)
 * List all internships: [(#155)](https://github.com/AY2425S2-CS2113-T11a-3/tp/pull/155)

**Extracts from Developer Guide**

*Model Diagrams*
 
Internships and Interview Diagram
<img src="../images/ModelImages/Model_UML_Pt1.png" alt="Internships&Interviews">

User Profile and Projects Diagram
<img src="../images/ModelImages/Model_UML_Pt2.png" alt="UserProfile&Projects">

**Contributions to team-based tasks:**
 * Created the centralised logger to keep track of logging's across the application
 * Did the model segment of the DG where I encapsulated the logic for how data is created, modified and sored in our application. I used class diagrams to depict how the different classes are structured and related.
 * Helped to resize, reformat and re-upload `delete` command sequence diagrams.



