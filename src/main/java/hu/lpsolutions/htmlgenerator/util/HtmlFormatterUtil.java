package hu.lpsolutions.htmlgenerator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlFormatterUtil {
    // formázás nélkül is lefutna a html, csak belerakattam egy ilyet hogy értelmezhetőbb legyen a válasz.

    public static String formatHtml(String unformattedHtml) {
        // Define a regular expression pattern to match HTML tags
        String pattern = "(<[^>]+>)([^<]*)";
        Pattern htmlPattern = Pattern.compile(pattern);
        Matcher matcher = htmlPattern.matcher(unformattedHtml);

        // Append new lines and indentation before each tag
        StringBuilder formattedHtml = new StringBuilder();
        int indentation = 0;
        while (matcher.find()) {
            String tag = matcher.group(1);
            String content = matcher.group(2);
            if (tag.startsWith("</")) {
                indentation--;
            }
            formattedHtml.append("\n");
            for (int i = 0; i < indentation; i++) {
                formattedHtml.append("  ");
            }
            formattedHtml.append(tag).append(content);
            if (!tag.startsWith("</")) {
                indentation++;
            }
        }

        // Return the formatted HTML string
        return formattedHtml.toString();
    }
}
