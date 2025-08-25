package ru.alexeyrand.whoistobuystore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.alexeyrand.whoistobuybase.fsm.FinalStateMachine;
import ru.alexeyrand.whoistobuybase.rest.WitbHttpClient;
import ru.alexeyrand.whoistobuystore.entities.Publication;
import ru.alexeyrand.whoistobuystore.enums.PublicationAction;
import ru.alexeyrand.whoistobuystore.enums.PublicationState;
import ru.alexeyrand.whoistobuystore.fsm.InitializationPublicationStateAndAction;
import ru.alexeyrand.whoistobuystore.fsm.PublicationStateMachineFactory;


@Configuration
public class BaseBeanConfig {

    @Bean
    public WitbHttpClient witbHttpClient() {
        return new WitbHttpClient();
    }

    @Bean
    public FinalStateMachine<PublicationState, PublicationAction, Publication> publicationStateMachine(
            InitializationPublicationStateAndAction initializationPublicationStateAndAction) {
        PublicationStateMachineFactory factory = new PublicationStateMachineFactory(initializationPublicationStateAndAction);
        return factory.createStateMachine();
    }

}
