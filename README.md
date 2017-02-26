Spock Testing Workshop
======================
Just a project I use in exercises about testing Java projects with [Spock] and [Groovy].

Project Setup with Maven
------------------------
In order to get [Spock] into our Maven project, we need to do the following in our [pom.xml].

1. Add Groovy as a (test) dependency (see [pom.xml](pom.xml#L27-L32)).
2. Add Spock dependency (see [pom.xml](pom.xml#L34-L39)).
3. Add compiler configuration for Groovy since Maven’s default only compiles Java (see [pom.xml](pom.xml#L94-L120)).
4. Make Maven aware of `/src/test/groovy` being a test source directory since Maven’s default is `/src/test/java` (see [pom.xml](pom.xml#L76-L77)).
5. Make Maven Surefire plugin aware of files ending with `*Spec` are test class files since Surefire’s default is `*Test` (see [pom.xml](pom.xml#L122-L133)).
6. Add CGLib and Objenesis in order to be able to Mock classes (see [pom.xml](pom.xml#L41-L57)).

Part 1: Blocks, Expectations and Pending Features
-------------------------------------------------
Read the [Spock Primer section] of the [Spock Framework Reference Documentation] to learn about the basic [Spock] terminology, fixture and feature methods, blocks and expectations.

Note that in contrast to the [Spock Primer][Spock Primer section], I prefer using `given` instead of `setup` for I like my test to be as close to natural language as possible and `setup` does not sound very natural to me.

Also I don't like block comments to stay in the test after it has been implemented (as suggested in [Specifications as Documentation]) for I want the *code* to be self-explanatory.

Then try to do the following objectives:
- [ ] The method `isOfAge` method in [User] is not implemented properly yet. However there is a test in [UserClassSpec] which is annotated with `@PendingFeature`. Change `isOfAge`, in order to make the test's expectation be true. Once you did, remove the annotation.<br/>
  Don't implement the method, just make the test's expectation true doing the very least necessary.
- [ ] The feature methods uses `given`, `when` and `then`. Try to make it shorter using an `expect` block.
- [ ] Our current implementation of [User] allows to create users who were not born yet. Write a `@PendingFeature` that expects that `"creating a user with a future birthday throws an IllegalArgumentExpecption"`.
- [ ] Adjust [User] to make the feature no longer pending and remove the annotation.
- [ ] Write another feature method that specifies that `"no exception in thrown if the birthday is in the past"`.

Part 2: Data Driven Testing
---------------------------
Read the [Data Driven Testing section] of the [Spock Framework Reference Documentation] to learn about `where` blocks and their data table and pipe notations and the `@Unroll` annotation.

Then try to do the following objectives:
- [ ] If you did the very least necessary in part 1, the implementation of `isOfAge` is not really how its name suggests because not only users are of age whose 18th birthday is today! Write another feature method to ensure that `"isOfAge should return true if the user's birthday is more than 18 years ago"`. Use a `where` block to test several cases.
- [ ] Add an `@Unroll` annotation to get more information about which cases have succeeded and which did not.
- [ ] Add another data driven test to test negative cases.
- [ ] Review your features and try to make more test data driven.

Part 3: Mocking and Stubbing
----------------------------
Read the [Interaction Based Testing section] of the [Spock Framework Reference Documentation] to learn about Mocks, Stubs and Spies.

Then try to do the following objectives:
- [ ] We want to write a test for the [UserService] which ensures that `"registerUser persists the user data via UserRepository"`. Use a Mock for the [UserRepository] since we don't want to test it here (and there is no implantation 😉). Feel free to use a Mock for the [User] object as well.
- [ ] We want to avoid registering users which are already registered. Write another feature method that ensures that `"registerUser does not persist user data if the user name was registered before"`. Make your test succeed, ensuring that all others still don't fail. Also we might want to throw an exception in that case.
- [ ] ...


Helpful Resources and Further Reading
-------------------------------------
* [Spock Framework Reference Documentation], especially the [Extensions section] and the [Modules section] not used in this workshop.
* [Idiomatic Spock] is a presentation by Rob Flechter about som tricks how to write Spock specifications in a better way.
* [Groovy documentation]


[Groovy]: <http://www.groovy-lang.org/>
[Groovy documentation]: <http://www.groovy-lang.org/documentation.html>

[Spock]: <http://spockframework.org/>
[Spock Framework Reference Documentation]: <http://docs.spockframework.org/>
[Spock Primer section]: <http://spockframework.org/spock/docs/1.1-rc-3/spock_primer.html>
[Specifications as Documentation section]: <http://spockframework.org/spock/docs/1.1-rc-3/spock_primer.html#specs-as-doc>
[Data Driven Testing section]: <http://spockframework.org/spock/docs/1.1-rc-3/data_driven_testing.html>
[Interaction Based Testing section]: <http://spockframework.org/spock/docs/1.1-rc-3/interaction_based_testing.html>
[Extensions section]: <http://spockframework.org/spock/docs/1.1-rc-3/extensions.html>
[Modules section]: <http://spockframework.org/spock/docs/1.1-rc-3/modules.html>

[Idiomatic Spock]: <https://github.com/robfletcher/idiomatic-spock/blob/master/Idiomatic%20Spock.pdf>

[pom.xml]: <pom.xml>

[User]: <src/main/java/de/assertagile/workshop/spocktesting/User.java>
[UserClassSpec]: <src/test/groovy/de/assertagile/workshop/spocktesting/UserClassSpec.groovy>
[UserEntity]: <src/main/java/de/assertagile/workshop/spocktesting/UserEntity.java>
[UserRepository]: <src/main/java/de/assertagile/workshop/spocktesting/UserRepository.java>
[UserService]: <src/main/java/de/assertagile/workshop/spocktesting/UserService.java>
[UserServiceClassSpec]: <src/test/groovy/de/assertagile/workshop/spocktesting/UserServiceClassSpec.groovy>
