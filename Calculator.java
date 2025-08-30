import java.util.Scanner;
import java.util.InputMismatchException;
import java.text.DecimalFormat;

public class Calculator {
    private static Scanner scanner = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("#.####");
    
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();
    }
    
    public void run() {
        System.out.println("=== Enhanced Console Calculator ===");
        System.out.println("Features: Basic Math, Scientific Functions, Unit Conversions");
        System.out.println("=====================================");
        
        while (true) {
            try {
                displayMenu();
                int choice = getValidChoice();
                
                if (choice == 0) {
                    System.out.println("Thank you for using the calculator!");
                    break;
                }
                
                processChoice(choice);
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); 
            }
        }
        scanner.close();
    }
    
    private void displayMenu() {
        System.out.println("\n--- Calculator Menu ---");
        System.out.println("1. Basic Arithmetic");
        System.out.println("2. Scientific Functions");
        System.out.println("3. Unit Conversions");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private int getValidChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number!");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    private void processChoice(int choice) {
        switch (choice) {
            case 1:
                basicArithmetic();
                break;
            case 2:
                scientificFunctions();
                break;
            case 3:
                unitConversions();
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }
    private void basicArithmetic() {
        System.out.println("\n--- Basic Arithmetic ---");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Modulus (%)");
        System.out.println("6. Power (^)");
        System.out.print("Choose operation: ");
        
        int op = getValidChoice();
        if (op < 1 || op > 6) {
            System.out.println("Invalid operation choice!");
            return;
        }
        
        System.out.print("Enter first number: ");
        double num1 = getValidDouble();
        System.out.print("Enter second number: ");
        double num2 = getValidDouble();
        
        double result = performBasicOperation(op, num1, num2);
        System.out.println("Result: " + df.format(result));
    }
    
    private double performBasicOperation(int operation, double num1, double num2) {
        switch (operation) {
            case 1: return num1 + num2;
            case 2: return num1 - num2;
            case 3: return num1 * num2;
            case 4: 
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed!");
                }
                return num1 / num2;
            case 5: 
                if (num2 == 0) {
                    throw new ArithmeticException("Modulus by zero is not allowed!");
                }
                return num1 % num2;
            case 6: return Math.pow(num1, num2);
            default: throw new IllegalArgumentException("Invalid operation!");
        }
    }
    
    private void scientificFunctions() {
        System.out.println("\n--- Scientific Functions ---");
        System.out.println("1. Square Root");
        System.out.println("2. Square");
        System.out.println("3. Cube");
        System.out.println("4. Sine (degrees)");
        System.out.println("5. Cosine (degrees)");
        System.out.println("6. Tangent (degrees)");
        System.out.println("7. Natural Logarithm");
        System.out.println("8. Base-10 Logarithm");
        System.out.println("9. Exponential (e^x)");
        System.out.println("10. Absolute Value");
        System.out.print("Choose function: ");
        
        int func = getValidChoice();
        if (func < 1 || func > 10) {
            System.out.println("Invalid function choice!");
            return;
        }
        
        System.out.print("Enter number: ");
        double num = getValidDouble();
        
        double result = performScientificFunction(func, num);
        System.out.println("Result: " + df.format(result));
    }
    
    private double performScientificFunction(int function, double num) {
        switch (function) {
            case 1: 
                if (num < 0) {
                    throw new IllegalArgumentException("Cannot calculate square root of negative number!");
                }
                return Math.sqrt(num);
            case 2: return Math.pow(num, 2);
            case 3: return Math.pow(num, 3);
            case 4: return Math.sin(Math.toRadians(num));
            case 5: return Math.cos(Math.toRadians(num));
            case 6: return Math.tan(Math.toRadians(num));
            case 7: 
                if (num <= 0) {
                    throw new IllegalArgumentException("Cannot calculate logarithm of non-positive number!");
                }
                return Math.log(num);
            case 8: 
                if (num <= 0) {
                    throw new IllegalArgumentException("Cannot calculate logarithm of non-positive number!");
                }
                return Math.log10(num);
            case 9: return Math.exp(num);
            case 10: return Math.abs(num);
            default: throw new IllegalArgumentException("Invalid function!");
        }
    }
    private void unitConversions() {
        System.out.println("\n--- Unit Conversions ---");
        System.out.println("1. Temperature");
        System.out.println("2. Length");
        System.out.println("3. Weight");
        System.out.println("4. Currency (USD to others)");
        System.out.print("Choose conversion type: ");
        
        int type = getValidChoice();
        if (type < 1 || type > 4) {
            System.out.println("Invalid conversion type!");
            return;
        }
        
        switch (type) {
            case 1: temperatureConversion(); break;
            case 2: lengthConversion(); break;
            case 3: weightConversion(); break;
            case 4: currencyConversion(); break;
        }
    }
    
    private void temperatureConversion() {
        System.out.println("\n--- Temperature Conversion ---");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        System.out.print("Choose conversion: ");
        
        int conv = getValidChoice();
        if (conv < 1 || conv > 4) {
            System.out.println("Invalid conversion choice!");
            return;
        }
        
        System.out.print("Enter temperature: ");
        double temp = getValidDouble();
        
        double result = performTemperatureConversion(conv, temp);
        String unit = getTemperatureUnit(conv);
        System.out.println("Result: " + df.format(result) + " " + unit);
    }
    
    private double performTemperatureConversion(int conversion, double temp) {
        switch (conversion) {
            case 1: return (temp * 9/5) + 32; // C to F
            case 2: return (temp - 32) * 5/9; // F to C
            case 3: return temp + 273.15; // C to K
            case 4: return temp - 273.15; // K to C
            default: throw new IllegalArgumentException("Invalid conversion!");
        }
    }
    
    private String getTemperatureUnit(int conversion) {
        switch (conversion) {
            case 1: return "°F";
            case 2: return "°C";
            case 3: return "K";
            case 4: return "°C";
            default: return "";
        }
    }
    
    private void lengthConversion() {
        System.out.println("\n--- Length Conversion ---");
        System.out.println("1. Meters to Feet");
        System.out.println("2. Feet to Meters");
        System.out.println("3. Kilometers to Miles");
        System.out.println("4. Miles to Kilometers");
        System.out.println("5. Centimeters to Inches");
        System.out.println("6. Inches to Centimeters");
        System.out.print("Choose conversion: ");
        
        int conv = getValidChoice();
        if (conv < 1 || conv > 6) {
            System.out.println("Invalid conversion choice!");
            return;
        }
        
        System.out.print("Enter length: ");
        double length = getValidDouble();
        
        double result = performLengthConversion(conv, length);
        String unit = getLengthUnit(conv);
        System.out.println("Result: " + df.format(result) + " " + unit);
    }
    
    private double performLengthConversion(int conversion, double length) {
        switch (conversion) {
            case 1: return length * 3.28084; // m to ft
            case 2: return length / 3.28084; // ft to m
            case 3: return length * 0.621371; // km to mi
            case 4: return length / 0.621371; // mi to km
            case 5: return length * 0.393701; // cm to in
            case 6: return length / 0.393701; // in to cm
            default: throw new IllegalArgumentException("Invalid conversion!");
        }
    }
    
    private String getLengthUnit(int conversion) {
        switch (conversion) {
            case 1: return "ft";
            case 2: return "m";
            case 3: return "mi";
            case 4: return "km";
            case 5: return "in";
            case 6: return "cm";
            default: return "";
        }
    }
    
    private void weightConversion() {
        System.out.println("\n--- Weight Conversion ---");
        System.out.println("1. Kilograms to Pounds");
        System.out.println("2. Pounds to Kilograms");
        System.out.println("3. Grams to Ounces");
        System.out.println("4. Ounces to Grams");
        System.out.print("Choose conversion: ");
        
        int conv = getValidChoice();
        if (conv < 1 || conv > 4) {
            System.out.println("Invalid conversion choice!");
            return;
        }
        
        System.out.print("Enter weight: ");
        double weight = getValidDouble();
        
        double result = performWeightConversion(conv, weight);
        String unit = getWeightUnit(conv);
        System.out.println("Result: " + df.format(result) + " " + unit);
    }
    
    private double performWeightConversion(int conversion, double weight) {
        switch (conversion) {
            case 1: return weight * 2.20462; // kg to lb
            case 2: return weight / 2.20462; // lb to kg
            case 3: return weight * 0.035274; // g to oz
            case 4: return weight / 0.035274; // oz to g
            default: throw new IllegalArgumentException("Invalid conversion!");
        }
    }
    
    private String getWeightUnit(int conversion) {
        switch (conversion) {
            case 1: return "lb";
            case 2: return "kg";
            case 3: return "oz";
            case 4: return "g";
            default: return "";
        }
    }
    
    private void currencyConversion() {
        System.out.println("\n--- Currency Conversion (USD to others) ---");
        System.out.println("1. USD to EUR (Euro)");
        System.out.println("2. USD to GBP (British Pound)");
        System.out.println("3. USD to JPY (Japanese Yen)");
        System.out.println("4. USD to INR (Indian Rupee)");
        System.out.println("5. USD to CAD (Canadian Dollar)");
        System.out.print("Choose conversion: ");
        
        int conv = getValidChoice();
        if (conv < 1 || conv > 5) {
            System.out.println("Invalid conversion choice!");
            return;
        }
        
        System.out.print("Enter amount in USD: ");
        double amount = getValidDouble();
        
        double result = performCurrencyConversion(conv, amount);
        String currency = getCurrencySymbol(conv);
        System.out.println("Result: " + df.format(result) + " " + currency);
    }
    
    private double performCurrencyConversion(int conversion, double amount) {
        switch (conversion) {
            case 1: return amount * 0.85; 
            case 2: return amount * 0.73; 
            case 3: return amount * 110.0; 
            case 4: return amount * 75.0; 
            case 5: return amount * 1.25; 
            default: throw new IllegalArgumentException("Invalid conversion!");
        }
    }
    
    private String getCurrencySymbol(int conversion) {
        switch (conversion) {
            case 1: return "EUR";
            case 2: return "GBP";
            case 3: return "JPY";
            case 4: return "INR";
            case 5: return "CAD";
            default: return "";
        }
    }

    private double getValidDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a valid number!");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}