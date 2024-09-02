import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int Add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            String delimiterPart = numbers.substring(2, delimiterIndex);
            delimiter = parseDelimiters(delimiterPart);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String[] parts = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num < 0) {
                negatives.add(num);
            }
            if (num <= 1000) {
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }

        return sum;
    }

    private String parseDelimiters(String delimiterPart) {
        StringBuilder delimiterPattern = new StringBuilder();
        Matcher matcher = Pattern.compile("\\[(.*?)\\]").matcher(delimiterPart);
        while (matcher.find()) {
            if (delimiterPattern.length() > 0) {
                delimiterPattern.append("|");
            }
            delimiterPattern.append(Pattern.quote(matcher.group(1)));
        }
        return delimiterPattern.toString();
    }
}
