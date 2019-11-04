package es.urjccode.mastercloudapps.adcs.draughts.views.console;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.ResumeController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;
import es.urjccode.mastercloudapps.adcs.draughts.utils.YesNoDialog;

/**
 * ResumeView
 */
public class ResumeView {

    private static final char AFIRMATIVE = 's';
	private static final char NEGATIVE = 'n';
	private static final String QUESTION = "¿Queréis jugar otra? (" + ResumeView.AFIRMATIVE + "/" + ResumeView.NEGATIVE
			+ "): ";
	private static final String MESSAGE = "El valor tiene que ser '" + ResumeView.AFIRMATIVE + "' o '"
			+ ResumeView.NEGATIVE + "'";

    private Console console;

    private ResumeController resumeController;

    public ResumeView(ResumeController resumeController){
        this.resumeController = resumeController;
        this.console = new Console();
    }

	public void interact() {
        char answer;
        boolean correctAnswer;
        do {
            answer = this.console.readChar(ResumeView.QUESTION);
            correctAnswer = ResumeView.isAfirmative(answer) || ResumeView.isNegative(answer);
            if (!correctAnswer) {
                this.console.writeln(ResumeView.MESSAGE);
            }
        } while (!correctAnswer);
        resumeController.resume(ResumeView.isAfirmative(answer));
	}

    private static boolean isNegative(char answer) {
        return Character.toLowerCase(answer) == ResumeView.AFIRMATIVE;
    }

    private static boolean isAfirmative(char answer) {
        return Character.toLowerCase(answer) == ResumeView.AFIRMATIVE;
    }
}