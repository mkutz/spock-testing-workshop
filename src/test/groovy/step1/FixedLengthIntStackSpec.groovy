package step1

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class FixedLengthIntStackSpec extends Specification {

    @Subject
    FixedLengthIntStack stack = new FixedLengthIntStack(10)

    def "a new stack is empty"() {
        expect: 'stack has no items'
    }

    def "pushing and item increases the stack size by one"(){
        when: "add one item"
        then: "stack size is 1 larger than before"
    }

    def "popping an item from a stack with items decreases its size by one"() {
        given: "a stack with 5 items"
        when: "pop one item"
        then: "stack size has decreased by one"
    }

    def "pushing an item and then popping it returns the same item"() {
        given: "an item"
        when: "pushing it"
        and: "popping it"
        then: "popped item is the same as initial item"
    }

    def "popping an empty stack leads to an IndexOutOfBoundsException"() {
        when: "pop one item"
        then: "IndexOutOfBoundsException is thrown"
    }

    def "pushing an item on a full stack leads to an IndexOutOfBoundsException"() {
        given: "a full stack"
        when: "add one item"
        then: "IndexOutOfBoundsException is thrown"
    }

    @Unroll("A stack with #elements items has size #expected")
    def "size corresponds with element count"(List<Integer> elements, int expected) {
        given: "a stack with elements"
        expect: "stack size corresponds with element count "
        where:
        elements | expected
        []       | 0
    }
}
