package de.assertagile.workshop.spocktesting

import spock.lang.Specification


class TestSpec extends Specification {

    def "test"() {
        expect:
        "abcdc" - "c" - "c" == "abd"
    }
}