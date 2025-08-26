package ru.alexeyrand.whoistobuystore.fsm;

import ru.alexeyrand.whoistobuybase.fsm.BaseStateMachineFactory;
import ru.alexeyrand.whoistobuybase.fsm.FinalStateMachine;
import ru.alexeyrand.whoistobuybase.fsm.InitializationStateAndAction;
import ru.alexeyrand.whoistobuybase.fsm.State;
import ru.alexeyrand.whoistobuystore.entities.Publication;
import ru.alexeyrand.whoistobuystore.enums.PublicationAction;
import ru.alexeyrand.whoistobuystore.enums.PublicationState;

import java.util.List;

public class PublicationStateMachineFactory extends BaseStateMachineFactory<PublicationState, PublicationAction, Publication> {

    public PublicationStateMachineFactory(InitializationStateAndAction initializationStateAndAction) {
        super(initializationStateAndAction);
    }

    @Override
    public FinalStateMachine<PublicationState, PublicationAction, Publication> createStateMachine() {
        FinalStateMachine<PublicationState, PublicationAction, Publication> finalStateMachine = new FinalStateMachine<>();
        State<PublicationState, PublicationAction> state1 = new State<>();
        State<PublicationState, PublicationAction> state2 = new State<>();
        State<PublicationState, PublicationAction> state3 = new State<>();
        State<PublicationState, PublicationAction> state4 = new State<>();
        State<PublicationState, PublicationAction> state5 = new State<>();
        State<PublicationState, PublicationAction> state6 = new State<>();
        State<PublicationState, PublicationAction> state7 = new State<>();
        State<PublicationState, PublicationAction> state8 = new State<>();
        State<PublicationState, PublicationAction> state9 = new State<>();
        State<PublicationState, PublicationAction> state10 = new State<>();
        State<PublicationState, PublicationAction> state11 = new State<>();
        State<PublicationState, PublicationAction> state12 = new State<>();



        state1.setState(PublicationState.IDLE);
        state2.setState(PublicationState.DRAFT);
        state3.setState(PublicationState.REVIEW);
        state4.setState(PublicationState.REJECTED);
        state5.setState(PublicationState.PUBLISHED);
        state6.setState(PublicationState.RESERVED);
        state7.setState(PublicationState.AWAITING_PAYMENT);
        state8.setState(PublicationState.AWAITING_CONFIRMATION);
        state9.setState(PublicationState.AWAITING_DELIVERY);
        state10.setState(PublicationState.AWAITING_EXCHANGE);
        state11.setState(PublicationState.SOLD);
        state12.setState(PublicationState.DELETED);

        state1.setNodes(List.of(state2, state12));
        state2.setNodes(List.of(state3, state12));
        state3.setNodes(List.of(state4,state5, state12));
        state4.setNodes(List.of(state2, state12));
        state5.setNodes(List.of(state6, state7, state12));
        state6.setNodes(List.of(state7, state12));
        state7.setNodes(List.of(state8, state12));
        state8.setNodes(List.of(state9, state10, state12));
        state9.setNodes(List.of(state11, state12));
        state10.setNodes(List.of(state11, state12));

        state1.setActions(List.of(PublicationAction.EDIT));

        finalStateMachine.setHead(state1);
        return finalStateMachine;
    }

}
