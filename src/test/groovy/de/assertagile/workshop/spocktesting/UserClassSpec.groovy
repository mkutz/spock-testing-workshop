package de.assertagile.workshop.spocktesting

import spock.lang.PendingFeature
import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDate

class UserClassSpec extends Specification {

    @Subject
    User user

    def "isOfAge should return false if the user's birthday is less than 18 years ago"() {
        given:
        user = new User("jdoe", "John", "Doe", LocalDate.now().minusYears(17))

        when:
        boolean isOfAge = user.isOfAge()

        then:
        !isOfAge
    }

    @PendingFeature
    def "isOfAge should return true if the user's birthday is 18 years ago"() {
        given:
        user = new User("jdoe", "John", "Doe", LocalDate.now().minusYears(18))

        when:
        boolean isOfAge = user.isOfAge()

        then:
        isOfAge
    }
}
