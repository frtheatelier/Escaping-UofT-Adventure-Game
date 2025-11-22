package interface_adapter.validate_card_answer;

import use_case.validateCardAnswer.ValidateCardAnswerInputBoundary;
import use_case.validateCardAnswer.ValidateCardAnswerInteractor;
import use_case.validateCardAnswer.ValidateCardAnswerInputData;

/**
 * Controller for the Validate Card Answer Use Case.
 */
public class ValidateCardController {
    private final ValidateCardAnswerInputBoundary interactor;

    public ValidateCardController(ValidateCardAnswerInputBoundary interactor) {
        this.interactor = interactor;
    }

    /**
     * Executes the Validate Card Answer Use Case.
     */
    public void execute(ValidateCardAnswerInputData validateInputData) {
        interactor.execute(validateInputData);
    }
}