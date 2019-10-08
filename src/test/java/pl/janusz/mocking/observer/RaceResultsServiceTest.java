package pl.janusz.mocking.observer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by Janusz Kacki on 08/10/2019. Project; bielmarcus
 */
public class RaceResultsServiceTest {

    private RaceResultsService sut;
    private Message message;
    private Client clientA;
    private Client clientB;

    @Before
    public void setUp() throws Exception {

        clientA = Mockito.mock(Client.class);
        clientB = Mockito.mock(Client.class);
        message = Mockito.mock(Message.class);

        sut = new RaceResultsService();
    }

    @Test
    public void manySunscribersShouldReceiveMessage() {

        sut.addsubscriber(clientA);
        sut.addsubscriber(clientB);

        sut.send(message);

        Mockito
                .verify(clientA)
                .receive(message);

        Mockito
                .verify(clientB)
                .receive(message);
    }

    @Test
    public void shouldBePossibleToRemoveSubscriber() {

        sut.addsubscriber(clientA);
        sut.addsubscriber(clientB);
        sut.removeSubscriber(clientB);

        sut.send(message);

        Mockito
                .verify(clientA, Mockito.times(1))
                .receive(message);

        Mockito
                .verify(clientB, Mockito.times(0))
                .receive(message);
    }

    @Test
    public void shouldSendMessagesToSubscribedClientsOnly() {

        sut.addsubscriber(clientA);

        sut.send(message);

        Mockito
                .verify(clientA, Mockito.times(1))
                .receive(message);

        Mockito
                .verify(clientB, Mockito.times(0))
                .receive(message);
    }

    @Test
    public void subscribedClientShouldReceiveMessageOnlyOnce() {

        sut.addsubscriber(clientA);
        sut.addsubscriber(clientA);

        sut.send(message);

        Mockito
                .verify(clientA, Mockito.times(1))
                .receive(message);
    }

    @Test
    public void subscribedClinetShouldReceiveMessage() {

        sut.addsubscriber(clientA);
        sut.send(message);

        Mockito
                .verify(clientA)
                .receive(message);
    }
}