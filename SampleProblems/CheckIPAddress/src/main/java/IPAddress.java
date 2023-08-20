public class IPAddress {
    public static String check(String address) {
        String regex = "^(([01]?[0-9]?[0-9]|25[0-5]|[2][0-4][0-9])\\.){3}([01]?[0-9]?[0-9]|25[0-5]|[2][0-4][0-9])$";

        return address.matches(regex) ? "YES" : "NO";
    }
}
