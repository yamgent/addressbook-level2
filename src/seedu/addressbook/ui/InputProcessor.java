package seedu.addressbook.ui;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Process the input given by the user, ignoring all whitespaces and comments if
 * encountered.
 * 
 * @author Tan Wang Leng
 */
public class InputProcessor {
    /**
     * Format of a comment input line. Comment lines are silently consumed when
     * reading user input.
     */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    private final Scanner in;

    public InputProcessor(InputStream in) {
        this.in = new Scanner(in);
    }

    /**
     * Returns an input that does not consist of whitespace or ignorable
     * elements (see {@link #shouldIgnore(String)}).
     * 
     * @return a user input
     */
    public String getUserRawInput() {
        String fullInputLine = in.nextLine();

        // silently consume all ignored lines
        while (shouldIgnore(fullInputLine)) {
            fullInputLine = in.nextLine();
        }
        return fullInputLine;
    }

    /**
     * Returns true if the user input line should be ignored. Input should be
     * ignored if it is parsed as a comment, is only whitespace, or is empty.
     *
     * @param rawInputLine full raw user input line.
     * @return true if the entire user input line should be ignored.
     */
    private boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || isCommentLine(rawInputLine);
    }

    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    private boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(InputProcessor.COMMENT_LINE_FORMAT_REGEX);
    }
}
