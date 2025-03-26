package seedu.internsprint.userprofile;

import java.util.ArrayList;

import seedu.internsprint.handler.CommandParser;
import seedu.internsprint.project.ProjectList;

public class UserProfile {
    public static String name;
    public static String yearlyGoals;
    public static String monthlyGoals;
    public static ArrayList<String> preferredIndustries;
    public static ArrayList<String> preferredCompanies;
    public static ArrayList<String> preferredRoles;
    public static String targetStipendRange;
    public static String internshipDateRange;
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

    @Override
    public String toString() {
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

    public String toExtendedString() {
        StringBuilder sb = new StringBuilder();

        // Add Name Section
        if (name != null) {
            sb.append("--------------------------------------------------\n");
            sb.append("Name: ").append(name).append("\n");
            sb.append("--------------------------------------------------\n");
        }

        // Add Preferred Industries Section
        if (preferredIndustries != null && !preferredIndustries.isEmpty()) {
            sb.append("\nPreferred Industries:\n");
            sb.append("--------------------------------------------------\n");
            for (String industry : preferredIndustries) {
                sb.append(String.format("| %-40s |\n", industry.trim()));
            }
            sb.append("--------------------------------------------------\n");
        }

        // Add Preferred Companies Section
        if (preferredCompanies != null && !preferredCompanies.isEmpty()) {
            sb.append("\nPreferred Companies:\n");
            sb.append("--------------------------------------------------\n");
            for (String company : preferredCompanies) {
                sb.append(String.format("| %-40s |\n", company.trim()));
            }
            sb.append("--------------------------------------------------\n");
        }

        // Add Preferred Roles Section
        if (preferredRoles != null && !preferredRoles.isEmpty()) {
            sb.append("\nPreferred Roles:\n");
            sb.append("--------------------------------------------------\n");
            for (String role : preferredRoles) {
                sb.append(String.format("| %-40s |\n", role.trim()));
            }
            sb.append("--------------------------------------------------\n");
        }

        // Add Target Stipend Range Section
        if (targetStipendRange != null) {
            sb.append("\nTarget Stipend Range:\n");
            sb.append("--------------------------------------------------\n");
            sb.append(String.format("| %-40s |\n", targetStipendRange));
            sb.append("--------------------------------------------------\n");
        }

        // Add Internship Date Range Section
        if (internshipDateRange != null) {
            sb.append("\nInternship Date Range:\n");
            sb.append("--------------------------------------------------\n");
            sb.append(String.format("| %-40s |\n", internshipDateRange));
            sb.append("--------------------------------------------------\n");
        }

        // Add Monthly Goals Section
        if (monthlyGoals != null && !monthlyGoals.isEmpty()) {
            sb.append("\nMonthly Goals:\n");
            sb.append("--------------------------------------------------\n");

            sb.append(String.format("| %-40s |\n", monthlyGoals.trim()));

            sb.append("--------------------------------------------------\n");
        }

        // Add Yearly Goals Section
        if (yearlyGoals != null && !yearlyGoals.isEmpty()) {
            sb.append("\nYearly Goals:\n");
            sb.append("--------------------------------------------------\n");
            sb.append(String.format("| %-40s |\n", yearlyGoals.trim()));

            sb.append("--------------------------------------------------\n");
        }

        return sb.toString();
    }


}
