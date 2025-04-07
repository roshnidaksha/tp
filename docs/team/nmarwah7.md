# Nikita Marwah - Project Portfolio Page

## Overview
InternSprint is your Ultimate Internship Application Assistant. 
Navigating internship applications can be overwhelming - multiple platforms, countless CV versions, and keeping track of 
application stages can quickly become chaotic. InternSprint is here to streamline the entire process, acting as your personal 
assistant for managing and organizing internship applications efficiently. InternSprint is a CLI application used internship management.
It is written in Java, and has about 8 kLoC.
## Summary of Contributions
### Code contributed: 
[Click Here!](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2025-02-21&tabOpen=true&tabType=authorship&tabAuthor=nmarwah7&tabRepo=AY2425S2-CS2113-T11a-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)
    
### Enhancements implemented: 
1. **New Feature**: Added the ability to edit added internships and set up optional parameters

    **What it does**: allows the user to edit saved internships: either the user can edit preexisting parameters, or make use of a set of additional optional parameters like status or description.

    **Highlights**: This enhancement involved designing the implementation of optional or extended parameters requiring changes to all internship classes (software,hardware,general), and its index-based approach to update parameters was emulated in other commands such as "delete" or "my". 


2. **New Feature**: Added the ability to create user profile information

   **What it does**: allows the user to edit their profile information for use on CVs, by making use of a set of additional optional parameters. This involved implementing new command: "my".

   **Highlights**: This enhancement creating a model type called user, and its corresponding class, and restructuring the command execution logic for all commands to work with a new model type. It then required the implementation of two new commands, edit and view user profile.
It also involved JUnit Testing to validate the new commands. To achieve the CV formatting we desired I sourced, requested use of and implemented the ASCIITable library.


3. **New Feature**: Added the ability to view user profile in CV-friendly table

   **What it does**: allows the user to voew their profile information for use on CVs, by making use of a set of additional optional parameters. This involved implementing command: "view user".

   **Highlights**: To achieve the CV formatting we desired I sourced, requested use of and implemented the ASCIITable library.


4. **New Feature**: Added the commands to add three project types

    **What it does**: allows the user to add their software,hardware and general projects for use on CVs. This involved implementing three new commands: create each type of project respectively.

    **Highlights**: This enhancement creating three new command classes for add  commands respectively, and defining the parameters which would be important for a user to define for their projects.
   It also involved JUnit Testing to validate the new commands. 


5. **New Feature**: Added the command to view three project types

   **What it does**: allows the user to view separately their software,hardware and general projects for use on CVs. This involved implementing three more commands (separate from add projects), view for each type of project respectively.

   **Highlights**: This enhancement creating three new command classes for view commands respectively, and the implementation of the ASCIITable library as mentioned in feature 3.


6. **Additional Method Implementation**: Added the ability to load saved data.
    
    **What it does**: allows the user to load .json saved data through storage handler, and output corresponding load_success message.


7. **Additional Enhancement**: Added the Ui features, like ASCII art, welcome screen message and standardized Ui formatting.
    
    **What it does**: Keeps Ui cohesive. Involved reformatting the existing error messages, dividers, and welcome messages.

### Contributions to the UG: 
Was responsible for setting up and  creating the User Guide (commands were distributed according to work division), and wrote the following sections:
* Quick Start
* Edit Command Feature
* The entire user commands section:
  - Updating and viewing user profile information sections
  - Adding a general, software, hardware categories of project: project general, project software, project hardware sections
  - Viewing a general, software, hardware categories of project: view general, view software, view hardware sections
* Saving Data
* Editing Data
* FAQ

### Contributions to the DG:
For the following sections, I contributed the writeup, as well as all relevant UML diagrams (you can click on the bullet points to see them in DG):
- [Edit Command Section ](https://ay2425s2-cs2113-t11a-3.github.io/tp/DeveloperGuide.html#2-edit-an-internship)
- [UI component section](https://ay2425s2-cs2113-t11a-3.github.io/tp/DeveloperGuide.html#ui-component)
- [Create/Update User Profile section](https://ay2425s2-cs2113-t11a-3.github.io/tp/DeveloperGuide.html#5-createupdate-user-profile)
- [Add/View Projects under User Profile section](https://ay2425s2-cs2113-t11a-3.github.io/tp/DeveloperGuide.html#6-addview-projects-under-user-profile)
- [Instructions for manual testing section](https://ay2425s2-cs2113-t11a-3.github.io/tp/DeveloperGuide.html#instructions-for-manual-testing)

### Contributions to team-based tasks:
- Setting up the GitHub team org/repo 
- Maintaining the issue tracker (created issues for v1.0, v2.0, v2.1)
- Finding and incorporating ASCII table library into the product
- Managed release for v2.0
- Made page-breaks and fine-tuned PDF formatting for our final submission of UG and DG
- Helped in identifying higher than median bugs reported in PE-D for assigned group
- Created `EditCommand`, `UserProfile`,`ProjectCommand` `ViewUserCommand`and all their subclasses 


### Testing
* Edit Command
* Project General Command, Project Software Command, Project Hardware Command
* View User Command
* User Profile  Command

