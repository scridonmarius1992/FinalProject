package finalproject.base;
import org.apache.commons.lang3.RandomStringUtils;


public class ValueGenerator {

    public String generate(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public String generateAlphabetic(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String generateNumeric(int length) {
        return RandomStringUtils.randomNumeric(length);
    }
}

