public class BankCard {
    public static String findNetwork(String card) {
        final int visaMasterLength = 16;
        final int amexLength = 15;
        String visaRegex = "^4\\d*";
        String masterCardRegex =
                "((^5[1-5])|(^27[01][0-9])|(^2720)|(^222[1-9])|(^22[3-9][0-9])|(^2[3-6][0-9][0-9]))\\d*";
        String americanExpressRegex = "(^3[4-7])\\d*";

        // String visaRegex = "^4[0-9]{15}$";
        // String masterCardRegex =
        // "^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$";
        // String americanExpressRegex = "^3[47][0-9]{13}$";

        if (card.matches(visaRegex) && card.length() == visaMasterLength) {
            return "Visa";
        } else if (card.matches(masterCardRegex) && card.length() == visaMasterLength) {
            return "MasterCard";
        } else if (card.matches(americanExpressRegex) && card.length() == amexLength) {
            return "AmericanExpress";
        }

        return "Card number does not exist";
    }
}
