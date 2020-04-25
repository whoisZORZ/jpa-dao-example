package book;

import book.model.Book;
import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BookGenerator {

    private static final Faker faker = new Faker(new Locale("en"));

    public static Book createBook() {

        Date date = faker.date().past(50000, TimeUnit.DAYS);
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Book book = Book.builder()
                .isbn13(faker.code().isbn13())
                .author(faker.book().author())
                .title(faker.book().title())
                .format(faker.options().option(Book.Format.class))
                .publisher(faker.book().publisher())
                .publicationDate(localDate)
                .pages(faker.number().randomDigitNotZero())
                .available(faker.bool().bool())
                .build();

        return book;

    }

}
