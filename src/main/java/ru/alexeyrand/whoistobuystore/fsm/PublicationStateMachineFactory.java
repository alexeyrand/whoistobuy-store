package ru.alexeyrand.whoistobuystore.fsm;

import org.springframework.stereotype.Component;
import ru.alexeyrand.whoistobuybase.fsm.BaseStateMachineFactory;
import ru.alexeyrand.whoistobuybase.fsm.FinalStateMachine;
import ru.alexeyrand.whoistobuybase.fsm.State;
import ru.alexeyrand.whoistobuystore.entities.Publication;
import ru.alexeyrand.whoistobuystore.enums.PublicationAction;
import ru.alexeyrand.whoistobuystore.enums.PublicationState;

import java.util.List;
import java.util.Map;

public class PublicationStateMachineFactory extends BaseStateMachineFactory<PublicationState, PublicationAction, Publication> {
    private final Map<PublicationState, List<PublicationAction>> actionStatusMap;

    public PublicationStateMachineFactory() {
        actionStatusMap = createActionMap();
    }

    @Override
    public FinalStateMachine<PublicationState, PublicationAction, Publication> createStateMachine() {
        FinalStateMachine<PublicationState, PublicationAction, Publication> finalStateMachine = new FinalStateMachine<>();
        State<PublicationState, PublicationAction> state1 = new State<>();
        state1.setState(PublicationState.IDLE);
        State<PublicationState, PublicationAction> state2 = new State<>();
        state2.setState(PublicationState.DRAFT);
        State<PublicationState, PublicationAction> state3 = new State<>();
        state3.setState(PublicationState.DELETED);
        State<PublicationState, PublicationAction> state4 = new State<>();
        state4.setState(PublicationState.REVIEW);
        state2.setNodes(List.of(state3, state4));

        State<PublicationState, PublicationAction> state5 = new State<>();
        state5.setState(PublicationState.REVIEW);

        state1.setNodes(List.of(state5, state2));

        finalStateMachine.setHead(state1);
        finalStateMachine.setActionMap(createActionMap());
        return finalStateMachine;
    }

    @Override
    public Map<PublicationState, List<PublicationAction>> createActionMap() {
        return Map.of(
                PublicationState.DRAFT, List.of(PublicationAction.DELETE, PublicationAction.CREATE),
                PublicationState.REVIEW, List.of(PublicationAction.DELETE, PublicationAction.REJECT, PublicationAction.PUBLISH),
                PublicationState.REJECTED, List.of(PublicationAction.DELETE, PublicationAction.EDIT),
                PublicationState.PUBLISHED, List.of(PublicationAction.DELETE, PublicationAction.BUY, PublicationAction.ARCHIVE),
                PublicationState.SOLD_OUT, List.of(PublicationAction.DELETE, PublicationAction.ARCHIVE),
                PublicationState.ARCHIVED, List.of(PublicationAction.DELETE, PublicationAction.CREATE)
        );
    }
}
