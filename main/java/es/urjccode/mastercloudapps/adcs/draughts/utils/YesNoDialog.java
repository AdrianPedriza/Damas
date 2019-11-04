package es.urjccode.mastercloudapps.adcs.draughts.utils;

/**
 * YesNoDialog
 */
public class YesNoDialog {

    private static final char AFIRMATIVE = 'y';

    private static final char NEGATIVE = 'n';

    private static final String QUESTION = "? (" + YesNoDialog.AFIRMATIVE + "/" + YesNoDialog.NEGATIVE + "): ";

    private static final String MESSAGE = "The value must be '" + YesNoDialog.AFIRMATIVE + "' or '"
            + YesNoDialog.NEGATIVE + "'";

    private static boolean isAfirmative(char answer) {
        return Character.toLowerCase(answer) == YesNoDialog.AFIRMATIVE;
    }

    private static boolean isNegative(char answer) {
        return Character.toLowerCase(answer) == YesNoDialog.NEGATIVE;
    }


    public boolean read(String title) {
        assert title != null;
        char answer;
        boolean correctAnswer;
        do {
            answer = new Console().readChar(title + YesNoDialog.QUESTION);
            correctAnswer = YesNoDialog.isAfirmative(answer) || YesNoDialog.isNegative(answer);
            if (!correctAnswer) {
                new Console().writeln(YesNoDialog.MESSAGE);
            }
        } while (!correctAnswer);
        return YesNoDialog.isAfirmative(answer);
    }
}