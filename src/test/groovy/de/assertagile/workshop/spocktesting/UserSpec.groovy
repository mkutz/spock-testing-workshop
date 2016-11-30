package de.assertagile.workshop.spocktesting

import spock.lang.PendingFeature
import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDate

class UserSpec extends Specification {

    @Subject
    User user

    @PendingFeature
    def "isOfAge should return true if the user's birthday is 18 years ago"() {
        given:
        user = new User("jdoe", "John", "Doe", LocalDate.now().minusYears(18))

        when:
        boolean result = user.isOfAge()

        then:
        result
    }
}
