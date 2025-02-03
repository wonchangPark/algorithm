package lv2.brute_force_search;

import java.util.HashMap;
import java.util.Map;

public class Test {

    // Map to hold the mappings
    private static final Map<String, ComplaintCategory> inputToCategoryMap = new HashMap<>();

    static {
        // Initialize the map during class loading
        for (ComplaintCategory category : ComplaintCategory.values()) {
            String inputCode = generateCode(category);
            inputToCategoryMap.put(inputCode, category);
        }
    }

    // Method to generate the code for each ComplaintCategory
    private static String generateCode(ComplaintCategory category) {
        StringBuilder codeBuilder = new StringBuilder();

        ComplaintCategory current = category;
        while (current.getParentCategory().isPresent()) {

            int orderIndex = current.getParentCategory().get().getChildCategories().indexOf(current);
            if(current.getChildCategories().isEmpty()) {
                codeBuilder.append(category.getParentCategory().get().getChildCategories().indexOf(current)+1);
            } else {
                codeBuilder.insert(0, (char) ('A' + orderIndex));
            }

            current = current.getParentCategory().get();
        }

        return codeBuilder.toString();
    }

    // Method to get the ComplaintCategory based on input code
    public static ComplaintCategory getCategoryByInput(String inputCode) {
        return inputToCategoryMap.get(inputCode);
    }

    public static void main(String[] args) {
        // Example input
        String inputCode = "AA1";

        // Get the mapped category
        ComplaintCategory category = getCategoryByInput(inputCode);

        // Print the result
        if (category != null) {
            System.out.println("Input Code: " + inputCode);
            System.out.println("Mapped Category: " + category.name());
        } else {
            System.out.println("Invalid Input Code: " + inputCode);
        }
    }
}

