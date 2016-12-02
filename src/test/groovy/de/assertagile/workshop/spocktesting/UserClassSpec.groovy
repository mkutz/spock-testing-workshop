package de.assertagile.workshop.spocktesting

import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDate

class UserClassSpec extends Specification {

    @Subject
    User user

    def "isOfAge should return true if the user's birthday is 18 years ago"() {
        given:
        user = new User("jdoe", "John", "Doe", LocalDate.now().minusYears(18))

        expect:
        boolean result = user.isOfAge()
    }

    def "isOfAge should return true uf the user's birthday is more than 18 years ago"() {
        // TODO implement this
    }
}
