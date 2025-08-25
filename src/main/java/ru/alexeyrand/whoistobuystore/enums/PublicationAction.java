package ru.alexeyrand.whoistobuystore.enums;

import ru.alexeyrand.whoistobuybase.fsm.ActionWithState;

public enum PublicationAction implements ActionWithState<PublicationState> {

    EDIT(PublicationState.DRAFT),
    CREATE(PublicationState.REVIEW),
    REJECT(PublicationState.REJECTED),
    PUBLISH(PublicationState.PUBLISHED),
    RESERVE(PublicationState.RESERVED),
    PAY(PublicationState.AWAITING_PAYMENT),
    CONFIRM(PublicationState.AWAITING_CONFIRMATION),
    SEND(PublicationState.AWAITING_DELIVERY),
    EXCHANGE(PublicationState.AWAITING_EXCHANGE),
    CANCEL(PublicationState.CANCELED),
    COMPLETION(PublicationState.SOLD),
    ARCHIVE(PublicationState.ARCHIVED),
    DELETE(PublicationState.DELETED);

    private PublicationState publicationState;

    PublicationAction(PublicationState publicationState) {
        this.publicationState = publicationState;
    }

    @Override
    public PublicationState getState() {
        return publicationState;
    }

    @Override
    public void setState(PublicationState state) {
        this.publicationState = state;
    }
//
//    static {
//        for (PublicationAction action : PublicationAction.values()) {
//            action.publicationState = PublicationState.valueOf(action.stateName);
//        }
//    }
}
