package ru.alexeyrand.whoistobuystore;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.alexeyrand.whoistobuybase.fsm.FinalStateMachine;
import ru.alexeyrand.whoistobuystore.entities.Publication;
import ru.alexeyrand.whoistobuystore.enums.PublicationAction;
import ru.alexeyrand.whoistobuystore.enums.PublicationState;
import ru.alexeyrand.whoistobuystore.fsm.InitializationPublicationStateAndAction;
import ru.alexeyrand.whoistobuystore.fsm.PublicationStateMachineFactory;

public class FinalStateMachineTest {

    @Test
    public void helperTest() {
        Publication publication = new Publication();
        publication.setPublicationState(PublicationState.RESERVED);
        PublicationStateMachineFactory factory = new PublicationStateMachineFactory(new InitializationPublicationStateAndAction());
        FinalStateMachine<PublicationState, PublicationAction, Publication> fsm = factory.createStateMachine();
        Publication res = fsm.moveToState(publication, PublicationAction.PAY);
        Assertions.assertEquals(res.getState(), PublicationState.AWAITING_PAYMENT);

    }
}
