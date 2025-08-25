package ru.alexeyrand.whoistobuystore.enums;

import ru.alexeyrand.whoistobuybase.fsm.ActionWithState;

public enum PublicationAction implements ActionWithState<PublicationState> {

    EDIT(),
    CREATE(),
    REJECT(),
    PUBLISH(),
    RESERVE(),
    PAY(),
    CONFIRM(),
    SEND(),
    EXCHANGE(),
    CANCEL(),
    COMPLETION(),
    ARCHIVE(),
    DELETE();

    private PublicationState publicationState;

    PublicationAction() {
    }

    @Override
    public PublicationState getState() {
        return publicationState;
    }

    @Override
    public void setState(PublicationState state) {
        this.publicationState = state;
    }

}
