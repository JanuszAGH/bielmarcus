package pl.janusz.mocking.messenger;

/**
 * Created by Janusz Kacki on 08/10/2019. Project; bielmarcus
 */
public class Messenger {

    private TemplateEngine templateEngine;
    private MailServer mailServer;

    public Messenger(TemplateEngine templateEngine, MailServer mailServer) {

        this.templateEngine = templateEngine;
        this.mailServer = mailServer;
    }

    public void sendMessage(Client client, Template template) {

        String messageContent =
                templateEngine.prepareMessage(template, client);

        mailServer.send(client.getEmail(), messageContent);
    }
}
