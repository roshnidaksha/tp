package seedu.internsprint.internship;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;

import static seedu.internsprint.util.InternSprintExceptionMessages.MISSING_REQUIRED_PARAMETERS;

public class SoftwareInternship extends Internship {
    private String techStack;

    public SoftwareInternship(String companyName, String role, String techStack) {
        super(companyName, role);
        if (techStack == null || techStack.isBlank()) {
            throw new IllegalArgumentException(String.format(MISSING_REQUIRED_PARAMETERS, "/tech"));
        }
        this.techStack = techStack;
    }

    public SoftwareInternship(String companyName, String role, String techStack, String eligibility,
                              String description, String status, String expectations) {
        super(companyName, role, eligibility, description, status, expectations);
        if (techStack == null || techStack.isBlank()) {
            throw new IllegalArgumentException(String.format(MISSING_REQUIRED_PARAMETERS, "/tech"));
        }
        this.techStack = techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    @Override
    public String toString() {
        return "Company: " + companyName + ", Role: " + role + ", Tech: " + techStack;
    }

    @Override
    public ArrayList<String> toDescription() {
        ArrayList<String> internshipString = super.toDescription();
        internshipString.add("Tech Stack: " + techStack);
        return internshipString;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        SoftwareInternship softwareInternship = (SoftwareInternship) obj;
        return companyName.equals(softwareInternship.getCompanyName())
                && role.equals(softwareInternship.getRole())
                && techStack.equals(softwareInternship.getTechStack());
    }

    @Override
    public JSONObject toJson() {
        Map<String, Object> orderedMap = new LinkedHashMap<>();
        orderedMap.put("type", "software");
        orderedMap.put("companyName", companyName);
        orderedMap.put("role", role);
        orderedMap.put("techStack", techStack);
        return new JSONObject(orderedMap);
    }

    public static SoftwareInternship fromJson(JSONObject json) {
        return new SoftwareInternship(
                json.getString("companyName"),
                json.getString("role"),
                json.getString("techStack"),
                json.optString("eligibility", ""),
                json.optString("description", ""),
                json.optString("status", ""),
                json.optString("expectations", "")
        );
    }

    @Override
    public String getType() {
        return "software";
    }

    public String getTechStack() {
        return techStack;
    }
}
