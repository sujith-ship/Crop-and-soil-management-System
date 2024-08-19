import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String, String> cropSoilMap1 = new HashMap<>();
    private static Map<String, String> cropDiseaseMap2 = new HashMap<>();
    private static Map<String, String> soilNutrientMap3 = new HashMap<>();
    private static Map<String, String> cropWaterRequirementMap4 = new HashMap<>();

    static {

        cropSoilMap1.put("Rice", "Clay");
        cropSoilMap1.put("Wheat", "Sandy");
        cropSoilMap1.put("Maize", "Loamy");
        cropSoilMap1.put("Soybean", "Sandy Loam");
        cropSoilMap1.put("Cotton", "Well-drained soil");
        cropSoilMap1.put("Sugarcane", "Fertile soil");


        cropDiseaseMap2.put("Rice", "Blast disease");
        cropDiseaseMap2.put("Wheat", "Powdery mildew");
        cropDiseaseMap2.put("Maize", "Downy mildew");
        cropDiseaseMap2.put("Soybean", "Soybean rust");
        cropDiseaseMap2.put("Cotton", "Cotton leaf curl virus");
        cropDiseaseMap2.put("Sugarcane", "Sugarcane mosaic virus");


        soilNutrientMap3.put("Clay", "High in nutrients");
        soilNutrientMap3.put("Sandy", "Low in nutrients");
        soilNutrientMap3.put("Loamy", "Moderate in nutrients");
        soilNutrientMap3.put("Sandy Loam", "Moderate in nutrients");
        soilNutrientMap3.put("Well-drained soil", "High in nutrients");
        soilNutrientMap3.put("Fertile soil", "High in nutrients");


        cropWaterRequirementMap4.put("Rice", "High water requirement");
        cropWaterRequirementMap4.put("Wheat", "Moderate water requirement");
        cropWaterRequirementMap4.put("Maize", "Moderate water requirement");
        cropWaterRequirementMap4.put("Soybean", "Low water requirement");
        cropWaterRequirementMap4.put("Cotton", "Moderate water requirement");
        cropWaterRequirementMap4.put("Sugarcane", "High water requirement");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter crop type (Rice, Wheat, Maize, Soybean, Cotton, Sugarcane): ");
        String cropType = scanner.nextLine();

        System.out.println("Enter soil type (Clay, Sandy, Loamy, Sandy Loam, Well-drained soil, Fertile soil): ");
        String soilType = scanner.nextLine();

        String recommendedCrop = getRecommendedCrop(soilType);
        String recommendedSoil = getRecommendedSoil(cropType);
        String diseaseIdentification = getDiseaseIdentification(cropType);
        String soilNutrientLevel = getSoilNutrientLevel(soilType);
        String waterRequirement = getWaterRequirement(cropType);

        System.out.println("Recommended crop for " + soilType + " soil: " + recommendedCrop);
        System.out.println("Recommended soil for " + cropType + " crop: " + recommendedSoil);
        System.out.println("Disease identification for " + cropType + " crop: " + diseaseIdentification);
        System.out.println("Soil nutrient level for " + soilType + " soil: " + soilNutrientLevel);
        System.out.println("Water requirement for " + cropType + " crop: " + waterRequirement);
    }

    private static String getRecommendedCrop(String soilType) {
        for (Map.Entry<String, String> entry : cropSoilMap1.entrySet()) {
            if (entry.getValue().equals(soilType)) {
                return entry.getKey();
            }
        }
        return "No recommendation found";
    }

    private static String getRecommendedSoil(String cropType) {
        return cropSoilMap1.getOrDefault(cropType, "No recommendation found");
    }

    private static String getDiseaseIdentification(String cropType) {
        return cropDiseaseMap2.getOrDefault(cropType, "No disease found");
    }

    private static String getSoilNutrientLevel(String soilType) {
        return soilNutrientMap3.getOrDefault(soilType, "No nutrient information found");
    }

    private static String getWaterRequirement(String cropType) {
        return cropWaterRequirementMap4.getOrDefault(cropType, "No water requirement found");
    }
}
