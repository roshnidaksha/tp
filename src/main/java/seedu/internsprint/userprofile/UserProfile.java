package seedu.internsprint.userprofile;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.internsprint.handler.CommandParser;
import seedu.internsprint.project.ProjectList;
import seedu.internsprint.util.InternSprintLogger;

/**
 * Stores basic user profile to customize application for user.
 */
public class UserProfile {
    public static String name;
    public static String yearlyGoals;
    public static String monthlyGoals;
    public static ArrayList<String> preferredIndustries;
    public static ArrayList<String> preferredCompanies;
    public static ArrayList<String> preferredRoles;
    public static String targetStipendRange;
    public static String internshipDateRange;
    private static final Logger logger = InternSprintLogger.getLogger();
    public final ProjectList projects;

    public UserProfile() {
        projects = new ProjectList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        UserProfile.name = name;
    }

    public String getYearlyGoals() {
        return yearlyGoals;
    }

    public void setYearlyGoals(String yearlyGoals) {
        UserProfile.yearlyGoals = yearlyGoals;
    }

    public String getMonthlyGoals() {
        return monthlyGoals;
    }

    public void setMonthlyGoals(String monthlyGoals) {
        UserProfile.monthlyGoals = monthlyGoals;
    }

    public ArrayList<String> getPreferredIndustries() {
        return preferredIndustries;
    }

    public void setPreferredIndustries(String preferredIndustriesString) {
        UserProfile.preferredIndustries = CommandParser.splitToWords(preferredIndustriesString);
    }

    public ArrayList<String> getPreferredCompanies() {
        return preferredCompanies;
    }

    public void setPreferredCompanies(String preferredCompaniesString) {
        UserProfile.preferredCompanies = CommandParser.splitToWords(preferredCompaniesString);
    }

    public ArrayList<String> getPreferredRoles() {
        return preferredRoles;
    }

    public void setPreferredRoles(String preferredRolesString) {
        UserProfile.preferredRoles = CommandParser.splitToWords(preferredRolesString);
    }

    public String getTargetStipendRange() {
        return targetStipendRange;
    }

    public void setTargetStipendRange(String targetStipendRange) {
        UserProfile.targetStipendRange = targetStipendRange;
    }

    public String getInternshipDateRange() {
        return internshipDateRange;
    }

    public void setInternshipDateRange(String internshipDateRange) {
        UserProfile.internshipDateRange = internshipDateRange;
    }

    /**
     * Return basic formatted string of User Profile to user for updates
     * @return String of user profile
     */
    @Override
    public String toString() {
        logger.log(Level.INFO, "Returning basic string for user profile");

        StringBuilder sb = new StringBuilder();
        if (name != null){
            sb.append("Name: ").append(name);
        }
        if (preferredIndustries != null){
            sb.append(", Preferred Industries: ").append(preferredIndustries);
        }
        if (preferredCompanies != null){
            sb.append(", Preferred Companies: ").append(preferredCompanies);
        }
        if (preferredRoles != null){
            sb.append(", Preferred Roles: ").append(preferredRoles);
        }
        if (targetStipendRange != null){
            sb.append(", Target Stipend Range: ").append(targetStipendRange);
        }
        if (internshipDateRange != null){
            sb.append(", Internship Date Range: ").append(internshipDateRange);
        }
        if (monthlyGoals != null){
            sb.append(", Monthly Goals: ").append(monthlyGoals);
        }
        if (yearlyGoals != null){
            sb.append(", Yearly Goals: ").append(yearlyGoals);
        }
        return sb.toString().replaceFirst("^,\\s*", "");
    }

    /**
     * Returns more CV-style formatted string to user in terminal
     * @return CV-formatted string to user
     */
    public String toExtendedString() {
        logger.log(Level.INFO, "Returning advanced formatted string for user profile");
        StringBuilder sb = new StringBuilder();

        if (name != null) {
            sb.append("--------------------------------------------------\n");
            sb.append("Name: ").append(name).append("\n");
            sb.append("--------------------------------------------------\n");
        }

        if (preferredIndustries != null && !preferredIndustries.isEmpty()) {
            sb.append("\nPreferred Industries:\n");
            sb.append("--------------------------------------------------\n");
            for (String industry : preferredIndustries) {
                sb.append(String.format("| %-40s |\n", industry.trim()));
            }
            sb.append("--------------------------------------------------\n");
        }

        if (preferredCompanies != null && !preferredCompanies.isEmpty()) {
            sb.append("\nPreferred Companies:\n");
            sb.append("--------------------------------------------------\n");
            for (String company : preferredCompanies) {
                sb.append(String.format("| %-40s |\n", company.trim()));
            }
            sb.append("--------------------------------------------------\n");
        }

        if (preferredRoles != null && !preferredRoles.isEmpty()) {
            sb.append("\nPreferred Roles:\n");
            sb.append("--------------------------------------------------\n");
            for (String role : preferredRoles) {
                sb.append(String.format("| %-40s |\n", role.trim()));
            }
            sb.append("--------------------------------------------------\n");
        }

        if (targetStipendRange != null) {
            sb.append("\nTarget Stipend Range:\n");
            sb.append("--------------------------------------------------\n");
            sb.append(String.format("| %-40s |\n", targetStipendRange));
            sb.append("--------------------------------------------------\n");
        }

        if (internshipDateRange != null) {
            sb.append("\nInternship Date Range:\n");
            sb.append("--------------------------------------------------\n");
            sb.append(String.format("| %-40s |\n", internshipDateRange));
            sb.append("--------------------------------------------------\n");
        }

        if (monthlyGoals != null && !monthlyGoals.isEmpty()) {
            sb.append("\nMonthly Goals:\n");
            sb.append("--------------------------------------------------\n");

            sb.append(String.format("| %-40s |\n", monthlyGoals.trim()));

            sb.append("--------------------------------------------------\n");
        }

        if (yearlyGoals != null && !yearlyGoals.isEmpty()) {
            sb.append("\nYearly Goals:\n");
            sb.append("--------------------------------------------------\n");
            sb.append(String.format("| %-40s |\n", yearlyGoals.trim()));

            sb.append("--------------------------------------------------\n");
        }

        return sb.toString();
    }


}
