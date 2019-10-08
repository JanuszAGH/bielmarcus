package pl.janusz.mocking.messenger;

import com.sun.javafx.tools.ant.DeployFXTask;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 08/10/2019. Project; bielmarcus
 */
public class MessengerTest {

    private MailServer mailServer;
    private TemplateEngine templateEngine;
    private Client client;
    private Template template;
    private Messenger sut;
    private String CLIENT_EMAIL;
    private String MESSAGE_CONTENT;

    @Before
    public void setUp() throws Exception {

        mailServer = Mockito.mock(MailServer.class);
        templateEngine = Mockito.mock(TemplateEngine.class);
        client = Mockito.mock(Client.class);
        template = Mockito.mock(Template.class);

        sut = new Messenger(templateEngine, mailServer);

        Mockito
                .when(client.getEmail())
                .thenReturn(CLIENT_EMAIL);
        Mockito
                .when(templateEngine.prepareMessage(template, client))
                .thenReturn(MESSAGE_CONTENT);
    }

    @Test
    public void shouldSendMEssage() {

        sut.sendMessage(client, template);

        Mockito
                .verify(mailServer, Mockito.times(1))
                .send(CLIENT_EMAIL, MESSAGE_CONTENT);
    }
}