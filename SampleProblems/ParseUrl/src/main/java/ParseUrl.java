import java.util.ArrayList;
import java.util.List;

public class ParseUrl {
    public static List<String> parse(String url) {
        String[] urlParts = url.split("\\?");

        if (urlParts.length == 1) {
            return List.of();
        }

        String[] params = urlParts[1].split("&");

        List<String> paramList = new ArrayList<>();
        String password = "";

        for (String p : params) {
            String[] parts = p.split("=");
            String paramName = parts[0];
            String paramValue;

            if (parts.length == 1) {
                paramValue = "not found";
            } else {
                paramValue = parts[1];
            }

            if ("pass".equals(paramName) && !"not found".equals(paramValue)) {
                password = paramValue;
            }

            paramList.add(String.join(" : ", paramName, paramValue));
        }

        if (!password.isEmpty()) {
            paramList.add(String.join(" : ", "password", password));
        }

        return paramList;
    }
}
