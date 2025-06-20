public class UnitConvertor2 {
    public static double convertFarhenheitToCelsius(double farhenheit) {
        return (farhenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFarhenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {
        System.out.println("100 Fahrenheit to Celsius: " + convertFarhenheitToCelsius(100));
        System.out.println("37 Celsius to Fahrenheit: " + convertCelsiusToFarhenheit(37));
        System.out.println("150 pounds to kilograms: " + convertPoundsToKilograms(150));
        System.out.println("68 kilograms to pounds: " + convertKilogramsToPounds(68));
        System.out.println("10 gallons to liters: " + convertGallonsToLiters(10));
        System.out.println("15 liters to gallons: " + convertLitersToGallons(15));
    }
}
