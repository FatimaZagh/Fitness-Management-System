package najah.edu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subscription_Mang {
    private String adminPage;
  
    private Map<String, SubscriptionPlan> subscriptionPlans = new HashMap<>();
    private SubscriptionPlan selectedPlan;
    private List<String> subscriptionStatistics = new ArrayList<>();

    static class SubscriptionPlan {
        String name;
        double price;
        List<String> features;

        public SubscriptionPlan(String name, double price, List<String> features) {
            this.name = name;
            this.price = price;
            this.features = features;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Price: $" + price + ", Features: " + features;
        }
    }

    
    @Given("the {string} subscription exists")
    public void the_subscription_exists(String planName) {
        if (!subscriptionPlans.containsKey(planName)) {
            List<String> features = new ArrayList<>();
            features.add("Feature A");
            features.add("Feature B");
            SubscriptionPlan newPlan = new SubscriptionPlan(planName, 49.99, features);
            subscriptionPlans.put(newPlan.name, newPlan);
            System.out.println("Initialized subscription plan: " + newPlan);
        } else {
            System.out.println("Subscription plan already exists: " + subscriptionPlans.get(planName));
        }
    }

    
    @Given("the admin is on the Subscription Management page")
    public void the_admin_is_on_the_subscription_management_page() {
        adminPage = "Subscription Management";
        // Ensure at least one subscription plan exists for later scenarios
        if (!subscriptionPlans.containsKey("Gold Plan")) {
            List<String> features = new ArrayList<>();
            features.add("Feature A");
            features.add("Feature B");
            SubscriptionPlan newPlan = new SubscriptionPlan("Gold Plan", 49.99, features);
            subscriptionPlans.put(newPlan.name, newPlan);
            System.out.println("Initialized subscription plan: " + newPlan);
        }
        System.out.println("Admin is on the Subscription Management page.");
    }

    @When("provides valid details \\(e.g., name, price, features)")
    public void provides_valid_details_e_g_name_price_features() {
        List<String> features = new ArrayList<>();
        features.add("Feature A");
        features.add("Feature B");
        SubscriptionPlan newPlan = new SubscriptionPlan("Gold Plan", 49.99, features);
        subscriptionPlans.put(newPlan.name, newPlan);
        System.out.println("New subscription plan created: " + newPlan);
    }

    @Then("the system creates a new subscription plan")
    public void the_system_creates_a_new_subscription_plan() {
        System.out.println("Subscription plans available:");
        subscriptionPlans.forEach((name, plan) -> System.out.println(plan));
    }

    @Then("displays a success message: {string}")
    public void displays_a_success_message(String message) {
        System.out.println(message);
    }

    @When("the admin selects an existing subscription plan")
    public void the_admin_selects_an_existing_subscription_plan() {
        selectedPlan = subscriptionPlans.get("Gold Plan");
        if (selectedPlan != null) {
            System.out.println("Selected subscription plan: " + selectedPlan);
        } else {
            throw new IllegalStateException("Subscription plan not found.");
        }
    }

    @When("updates the price or features")
    public void updates_the_price_or_features() {
        if (selectedPlan != null) {
            selectedPlan.price = 59.99; // Updated price
            selectedPlan.features.add("Feature C"); // Add a new feature
            System.out.println("Subscription plan updated: " + selectedPlan);
        } else {
            throw new IllegalStateException("No plan selected for updating.");
        }
    }

    @Then("the system updates the plan successfully")
    public void the_system_updates_the_plan_successfully() {
        System.out.println("Updated subscription plans:");
        subscriptionPlans.forEach((name, plan) -> System.out.println(plan));
    }

    @Then("the system displays statistics such as the most popular subscription plans")
    public void the_system_displays_statistics_such_as_the_most_popular_subscription_plans() {
        subscriptionStatistics.add("Gold Plan: 100 subscribers");
        subscriptionStatistics.add("Silver Plan: 80 subscribers");
        subscriptionStatistics.add("Bronze Plan: 50 subscribers");
        System.out.println("Subscription Statistics:");
        subscriptionStatistics.forEach(System.out::println);
    }
}
