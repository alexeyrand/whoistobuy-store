package ru.alexeyrand.whoistobuystore.fsm;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.alexeyrand.whoistobuybase.fsm.ActionWithState;
import ru.alexeyrand.whoistobuybase.fsm.FinalStateMachine;
import ru.alexeyrand.whoistobuybase.fsm.StateWithAction;
import ru.alexeyrand.whoistobuystore.entities.Publication;
import ru.alexeyrand.whoistobuystore.enums.PublicationAction;
import ru.alexeyrand.whoistobuystore.enums.PublicationState;
import ru.alexeyrand.whoistobuystore.services.HistoryService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class FinalStateMachineTest {
    @Mock
    private HistoryService historyService;

    FinalStateMachine<PublicationState, PublicationAction, Publication> fsm;

    @BeforeEach
    public void setUp() {
        PublicationStateMachineFactory factory = new PublicationStateMachineFactory(new InitializationPublicationStateAndAction());
        fsm = factory.createStateMachine();
    }

    @Test
    public void helperTest() {
        doNothing().when(historyService).createHistory(any(), any(), any());

        Publication publication = new Publication();
        publication.setPublicationState(PublicationState.IDLE);

        fsm.setHistoricalService(historyService);

        Publication res = fsm.moveToState(publication, PublicationAction.EDIT);
        Assertions.assertEquals(PublicationState.DRAFT, res.getState());
        res = fsm.moveToState(publication, PublicationAction.CREATE);
        Assertions.assertEquals(PublicationState.REVIEW, res.getState());
        res = fsm.moveToState(publication, PublicationAction.REJECT);
        Assertions.assertEquals(PublicationState.REJECTED, res.getState());
        res = fsm.moveToState(publication, PublicationAction.EDIT);
        Assertions.assertEquals(PublicationState.DRAFT, res.getState());
        res = fsm.moveToState(publication, PublicationAction.CREATE);
        Assertions.assertEquals(PublicationState.REVIEW, res.getState());
        res = fsm.moveToState(publication, PublicationAction.PUBLISH);
        Assertions.assertEquals(PublicationState.PUBLISHED, res.getState());
    }
}
