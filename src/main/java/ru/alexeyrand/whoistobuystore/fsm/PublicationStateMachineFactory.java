package ru.alexeyrand.whoistobuystore.fsm;

import org.springframework.stereotype.Component;
import ru.alexeyrand.whoistobuybase.fsm.BaseStateMachineFactory;
import ru.alexeyrand.whoistobuybase.fsm.FinalStateMachine;

import ru.alexeyrand.whoistobuybase.fsm.State;
import ru.alexeyrand.whoistobuybase.services.Historical;
import ru.alexeyrand.whoistobuystore.entities.Publication;
import ru.alexeyrand.whoistobuystore.enums.PublicationAction;
import ru.alexeyrand.whoistobuystore.enums.PublicationState;

import java.util.List;

@Component
public class PublicationStateMachineFactory extends BaseStateMachineFactory<PublicationState, PublicationAction, Publication> {


    @Override
    public FinalStateMachine<PublicationState, PublicationAction, Publication> defineStateMachine() {
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

    @Override
    public void init() {
        PublicationAction.EDIT.setState(PublicationState.DRAFT);
        PublicationAction.CREATE.setState(PublicationState.REVIEW);
        PublicationAction.REJECT.setState(PublicationState.REJECTED);
        PublicationAction.PUBLISH.setState(PublicationState.PUBLISHED);
        PublicationAction.RESERVE.setState(PublicationState.RESERVED);
        PublicationAction.PAY.setState(PublicationState.AWAITING_PAYMENT);
        PublicationAction.CONFIRM.setState(PublicationState.AWAITING_CONFIRMATION);
        PublicationAction.SEND.setState(PublicationState.AWAITING_DELIVERY);
        PublicationAction.EXCHANGE.setState(PublicationState.AWAITING_EXCHANGE);
        PublicationAction.CANCEL.setState(PublicationState.CANCELED);
        PublicationAction.COMPLETION.setState(PublicationState.SOLD);
        PublicationAction.ARCHIVE.setState(PublicationState.ARCHIVED);
        PublicationAction.DELETE.setState(PublicationState.DELETED);

        PublicationState.IDLE.setActionList(List.of(PublicationAction.EDIT));
        PublicationState.DRAFT.setActionList(List.of(PublicationAction.CREATE, PublicationAction.DELETE));
        PublicationState.REVIEW.setActionList(List.of(PublicationAction.REJECT, PublicationAction.PUBLISH, PublicationAction.DELETE));
        PublicationState.REJECTED.setActionList(List.of(PublicationAction.EDIT, PublicationAction.DELETE));
        PublicationState.PUBLISHED.setActionList(List.of(PublicationAction.RESERVE, PublicationAction.PAY, PublicationAction.ARCHIVE, PublicationAction.DELETE));
        PublicationState.RESERVED.setActionList(List.of(PublicationAction.PAY, PublicationAction.DELETE));
        PublicationState.ARCHIVED.setActionList(List.of(PublicationAction.DELETE));
        PublicationState.AWAITING_PAYMENT.setActionList(List.of(PublicationAction.CONFIRM, PublicationAction.DELETE));
        PublicationState.AWAITING_CONFIRMATION.setActionList(List.of(PublicationAction.SEND, PublicationAction.EXCHANGE, PublicationAction.DELETE));
        PublicationState.AWAITING_EXCHANGE.setActionList(List.of(PublicationAction.COMPLETION, PublicationAction.CANCEL, PublicationAction.DELETE));
        PublicationState.AWAITING_DELIVERY.setActionList(List.of(PublicationAction.COMPLETION, PublicationAction.CANCEL, PublicationAction.DELETE));
        PublicationState.CANCELED.setActionList(List.of(PublicationAction.PUBLISH, PublicationAction.DELETE));
        PublicationState.SOLD.setActionList(List.of(PublicationAction.DELETE));
        PublicationState.DELETED.setActionList(List.of());
    }

}
