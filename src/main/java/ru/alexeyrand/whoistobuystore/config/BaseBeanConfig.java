package ru.alexeyrand.whoistobuystore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.alexeyrand.whoistobuybase.fsm.FinalStateMachine;
import ru.alexeyrand.whoistobuybase.rest.WitbHttpClient;
import ru.alexeyrand.whoistobuybase.services.Historical;
import ru.alexeyrand.whoistobuystore.entities.Publication;
import ru.alexeyrand.whoistobuystore.enums.PublicationAction;
import ru.alexeyrand.whoistobuystore.enums.PublicationState;
import ru.alexeyrand.whoistobuystore.fsm.PublicationStateMachineFactory;


@Configuration
public class BaseBeanConfig {

    @Bean
    public WitbHttpClient witbHttpClient() {
        return new WitbHttpClient();
    }

    @Bean
    public FinalStateMachine<PublicationState, PublicationAction, Publication> publicationStateMachine(PublicationStateMachineFactory factory) {
        FinalStateMachine<PublicationState, PublicationAction, Publication> fsm = factory.createStateMachine();
        fsm.setHistorical(true);
        return fsm;
    }

}
