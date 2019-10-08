package pl.janusz.mocking.messenger;

/**
 * Created by Janusz Kacki on 08/10/2019. Project; bielmarcus
 */
public interface TemplateEngine {

    String prepareMessage(Template template, Client client);
}
