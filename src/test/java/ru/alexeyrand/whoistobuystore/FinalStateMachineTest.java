package ru.alexeyrand.whoistobuystore;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.alexeyrand.whoistobuybase.fsm.FinalStateMachine;
import ru.alexeyrand.whoistobuystore.entities.Publication;
import ru.alexeyrand.whoistobuystore.enums.PublicationAction;
import ru.alexeyrand.whoistobuystore.enums.PublicationState;
import ru.alexeyrand.whoistobuystore.enums.TestEnum;
import ru.alexeyrand.whoistobuystore.enums.TestEnum2;
import ru.alexeyrand.whoistobuystore.fsm.PublicationStateMachineFactory;

public class FinalStateMachineTest {

    @Test
    public void helperTest() {
        Publication publication = new Publication();
        publication.setPublicationState(PublicationState.RESERVED);
        TestEnum s = TestEnum.A;
        TestEnum2 s2 = TestEnum2.AA;
        PublicationState b = PublicationState.AWAITING_PAYMENT;
        PublicationAction as = PublicationAction.EDIT;
        PublicationStateMachineFactory factory = new PublicationStateMachineFactory();
        FinalStateMachine<PublicationState, PublicationAction, Publication> fsm = factory.createStateMachine();
        Publication res = fsm.moveToState(publication, PublicationAction.PAY);
        Assertions.assertEquals(res.getCurrentState(), PublicationState.AWAITING_PAYMENT);

    }
}
