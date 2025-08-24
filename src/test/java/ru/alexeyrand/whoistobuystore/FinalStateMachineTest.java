package ru.alexeyrand.whoistobuystore;


import org.junit.jupiter.api.Test;
import ru.alexeyrand.whoistobuybase.fsm.FinalStateMachine;
import ru.alexeyrand.whoistobuystore.entities.Publication;
import ru.alexeyrand.whoistobuystore.enums.PublicationAction;
import ru.alexeyrand.whoistobuystore.enums.PublicationState;
import ru.alexeyrand.whoistobuystore.fsm.PublicationStateMachineFactory;

public class FinalStateMachineTest {

    @Test
    public void helperTest() {
        Publication publication = new Publication();
        publication.setPublicationState(PublicationState.DELETED);

        PublicationStateMachineFactory factory = new PublicationStateMachineFactory();
        FinalStateMachine fsm = factory.createStateMachine();
        fsm.transfer(publication, PublicationAction.CREATE);
        System.out.println(factory);

    }
}
