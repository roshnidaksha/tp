package seedu.internsprint.userProfile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import seedu.internsprint.handler.Parser;

public class UserProfile {
    public static String name;
    public static String yearlyGoals;
    public static String monthlyGoals;
    public static ArrayList<String> preferredIndustries;
    public static ArrayList<String> preferredCompanies;
    public static ArrayList<String> preferredRoles;
    public static String targetStipendRange;
    public static LocalDateTime[] internshipDateRange;

    public UserProfile() {
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
        UserProfile.preferredIndustries = Parser.splitToWords(preferredIndustriesString);
    }

    public ArrayList<String> getPreferredCompanies() {
        return preferredCompanies;
    }

    public void setPreferredCompanies(String preferredCompaniesString) {
        UserProfile.preferredCompanies = Parser.splitToWords(preferredCompaniesString);
    }

    public ArrayList<String> getPreferredRoles() {
        return preferredRoles;
    }

    public void setPreferredRoles(String preferredRolesString) {
        UserProfile.preferredRoles = Parser.splitToWords(preferredRolesString);
    }

    public String getTargetStipendRange() {
        return targetStipendRange;
    }

    public void setTargetStipendRange(String targetStipendRange) {
        UserProfile.targetStipendRange = targetStipendRange;
    }

    public LocalDateTime[] getInternshipDateRange() {
        return internshipDateRange;
    }

    public void setInternshipDateRange(LocalDateTime[] internshipDateRange) {
        UserProfile.internshipDateRange = internshipDateRange;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (name != null) sb.append("Name: ").append(name);
        if (preferredIndustries != null) sb.append(", Preferred Industries: ").append(preferredIndustries);
        if (preferredCompanies != null) sb.append(", Preferred Companies: ").append(preferredCompanies);
        if (preferredRoles != null) sb.append(", Preferred Roles: ").append(preferredRoles);
        if (targetStipendRange != null) sb.append(", Target Stipend Range: ").append(targetStipendRange);
        if (internshipDateRange != null) sb.append(", Internship Date Range: ")
                                            .append(Arrays.toString(internshipDateRange));
        if (monthlyGoals != null) sb.append(", Monthly Goals: ").append(monthlyGoals);
        if (yearlyGoals != null) sb.append(", Yearly Goals: ").append(yearlyGoals);
        return sb.toString();
    }


}
