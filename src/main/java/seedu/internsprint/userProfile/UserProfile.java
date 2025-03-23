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

    public String toString() {
        return "Name: " + name + ", Preferred Industries: " + preferredIndustries
                + ", Preferred Companies: " + preferredCompanies + ", Preferred Roles: " + preferredRoles
                + ",  Target Stipend Range: " + targetStipendRange
                + ",  Internship Date Range: " + Arrays.toString(internshipDateRange)
                + ",  Monthly Goals: " + monthlyGoals
                + ",  Yearly Goals: " + yearlyGoals;
    }
}
