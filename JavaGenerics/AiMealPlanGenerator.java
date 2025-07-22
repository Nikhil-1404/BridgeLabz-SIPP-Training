import java.util.*;

// ---------- MealPlan Interface ----------
interface MealPlan {
    String getMealType();
    List<String> getMeals();
}

// ---------- Subtypes of MealPlan ----------
class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }

    public List<String> getMeals() {
        return Arrays.asList("Paneer Curry", "Dal Tadka", "Veg Biryani");
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }

    public List<String> getMeals() {
        return Arrays.asList("Tofu Stir Fry", "Chickpea Salad", "Vegan Smoothie");
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto";
    }

    public List<String> getMeals() {
        return Arrays.asList("Grilled Chicken", "Avocado Bowl", "Boiled Eggs");
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein";
    }

    public List<String> getMeals() {
        return Arrays.asList("Egg Whites", "Protein Shake", "Chicken Breast");
    }
}

// ---------- Generic Meal<T extends MealPlan> Class ----------
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void displayPlan() {
        System.out.println("Meal Plan Type: " + mealPlan.getMealType());
        System.out.println("Meals Included: " + mealPlan.getMeals());
    }

    public T getMealPlan() {
        return mealPlan;
    }
}

// ---------- Generic Method to Generate Meal Plan ----------
class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        System.out.println("Generating personalized " + mealPlan.getMealType() + " meal plan...");
        return new Meal<>(mealPlan);
    }
}

// ---------- Main Class ----------
public class AiMealPlanGenerator{
    public static void main(String[] args) {
        // Create different types of meal plans
        VegetarianMeal veg = new VegetarianMeal();
        VeganMeal vegan = new VeganMeal();
        KetoMeal keto = new KetoMeal();
        HighProteinMeal highProtein = new HighProteinMeal();

        // Generate and display meal plans
        System.out.println("----- Personalized Meal Plans -----");

        Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMealPlan(veg);
        vegMeal.displayPlan();

        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(vegan);
        veganMeal.displayPlan();

        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(keto);
        ketoMeal.displayPlan();

        Meal<HighProteinMeal> highProteinMeal = MealPlanGenerator.generateMealPlan(highProtein);
        highProteinMeal.displayPlan();
    }
}
