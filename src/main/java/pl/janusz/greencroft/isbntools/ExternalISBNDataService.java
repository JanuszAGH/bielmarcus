package pl.janusz.greencroft.isbntools;

/**
 * Created by Janusz Kacki on 18/10/2019. Project; bielmarcus
 */
public interface ExternalISBNDataService {

    Book lookup(String isbn);
}
