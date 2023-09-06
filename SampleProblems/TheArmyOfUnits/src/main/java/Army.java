public class Army {
    public static String withUnits(int num) {
        return num >= 1000 ? "legion" : num >= 250 ? "zounds" : num >= 20 ? "throng" : num > 0 ? "pack" : "no army";
    }
}
