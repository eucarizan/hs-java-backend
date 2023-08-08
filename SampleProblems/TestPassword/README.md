# Method as sources

## Definition
There is a utility method that evaluates a password strength. A password is considered strong if its length is at least 8 characters and it contains at least one uppercase character, one lowercase character, one digit and one special character. A medium strength password is also at least 8 characters and contains alphabetic characters and at least one digit. Any other password is considered to be weak:

```java
enum PasswordStrength { STRONG, MEDIUM, WEAK}

class PasswordUtils {

    public static PasswordStrength getStrength(String password) {
        final String length = ".{8,}";              // at least 8 chars long
        final String lowercase = "(?=.*[a-z])";     // at least one lowercase char
        final String uppercase = "(?=.*[A-Z])";     // at least one uppercase char
        final String digit = "(?=.*\\d)";           // at least one digit
        final String special = "(?=.*[ !@#$%^&*])"; // at least one of these special chars

        if (password.matches(lowercase + uppercase + digit + special + length)) {
            return PasswordStrength.STRONG;
        } else if (password.matches(lowercase + digit + length)) {
            return PasswordStrength.MEDIUM;
        } else if (password.matches(uppercase + digit + length)) {
            return PasswordStrength.MEDIUM;
        } else {
            return PasswordStrength.WEAK;
        }
    }
}
```

Some team member wrote a few unit tests for it using @MethodSource to generate arguments for the method in test:

```java
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SnippetTests {

    @ParameterizedTest
    @MethodSource("provideStrongPasswords")
    void testStrongPasswords(String password) {
        assertEquals(PasswordStrength.STRONG, PasswordUtils.getStrength(password));
    }

    @ParameterizedTest
    @MethodSource("provideWeakPasswords")
    void testMediumPasswords(String password) {
        assertEquals(PasswordStrength.MEDIUM, PasswordUtils.getStrength(password));
    }

    @ParameterizedTest
    @MethodSource("provideMediumPasswords")
    void testWeakPasswords(String password) {
        assertEquals(PasswordStrength.WEAK, PasswordUtils.getStrength(password));
    }

    static List<String> provideStrongPasswords() {
        return List.of("aN we2aM", "*****Jj0", "Ux134!&");
    }

    static List<String> provideMediumPasswords() {
        return List.of("QWERTY2", "Admin01", "2418^ax00");
    }

    static List<String> provideWeakPasswords() {
        return List.of("password", "f8HdA*", "Y20220101");
    }
}
```

Look carefully at these test methods and argument sources and select all correct statements about them.

## Question
Select one or more options from the list
- Tests won't compile because of incorrectly specified method sources
- Some tests will pass and some will fail
- All tests will pass successfully
- All tests will compile
- All tests will fail

## Answer
- All tests will compile
- All tests will fail

## Tags
- testing tools and libraries
- errorless code
- parameterized test