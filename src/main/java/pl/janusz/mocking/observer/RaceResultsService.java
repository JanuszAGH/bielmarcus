package pl.janusz.mocking.observer;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Janusz Kacki on 08/10/2019. Project; bielmarcus
 */
public class RaceResultsService {

    private Collection<Client> clients = new HashSet<>();

    public void addsubscriber(Client client) {

        this.clients.add(client);
    }

    public void send(Message message) {

        for (Client client : clients)
            client.receive(message);
    }

    public void removeSubscriber(Client client) {

        this.clients.remove(client);
    }
}
