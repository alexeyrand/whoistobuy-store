package ru.alexeyrand.whoistobuystore.fsm;

import org.springframework.stereotype.Component;
import ru.alexeyrand.whoistobuybase.fsm.InitializationStateAndAction;
import ru.alexeyrand.whoistobuystore.enums.PublicationAction;
import ru.alexeyrand.whoistobuystore.enums.PublicationState;

import java.util.List;

@Component
public class InitializationPublicationStateAndAction implements InitializationStateAndAction {
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
