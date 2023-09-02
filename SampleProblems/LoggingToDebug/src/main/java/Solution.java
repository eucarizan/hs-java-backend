import org.slf4j.*;

public class Solution {
    private static final Logger LOG = LoggerFactory.getLogger(Solution.class);
    public static int add(int arg1, int arg2) {
        int sum = arg1 + arg2;

        LOG.debug("arg1={}, arg2={}, sum={}", arg1, arg2, sum);

        return sum;
    }
}
