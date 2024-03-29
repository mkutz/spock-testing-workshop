# Spock Testing Workshop [![Build](https://github.com/mkutz/spock-testing-workshop/actions/workflows/build.yml/badge.svg)](https://github.com/mkutz/spock-testing-workshop/actions/workflows/build.yml)

Workshop for testing Java projects with [Spock] and [Groovy].


## Project Setup with Maven

In order to get [Spock] into our Maven project, we need to do the following in our [pom.xml].

1. Add Groovy and Spock as (test) dependencies (see [pom.xml](pom.xml#L41-L46)) and (see [pom.xml](pom.xml#L48-L52)).
   Note that the version tags can be omitted due to the dependency management (see [pom.xml](pom.xml#L21-L39)).
2. Add ByteBuddy and Objenesis in order to be able to Mock classes (see [pom.xml](pom.xml#L54-L70)).
3. Make Maven aware of `/src/test/groovy` being a test source directory since Maven’s default is `/src/test/java` (see [pom.xml](pom.xml#L88-L89)).
4. Add the [GMavenPlus] plugin, to compile your Groovy sources and configure the maven-compiler-plugin (see [pom.xml](pom.xml#L92-L115)).
5. Make Maven Surefire plugin aware of files ending with `*Spec` are test class files since Surefire’s default is `*Test` (see [pom.xml](pom.xml#L117-L128)).


## Project Setup with Gradle

In order to get [Spock] into our Gradle project, we need to do the following in our [build.gradle].

1. Add the Groovy plugin (see [build.gradle](build.gradle#L3)).
2. Add Groovy as a `testImplementation` dependency (see [build.gradle](build.gradle#L12)).
3. Add Groovy and Spock dependency (see [build.gradle](build.gradle#L12-L16)).
4. Add ByteBuddy and Objenesis in order to be able to Mock classes (see [build.gradle](build.gradle#L18-19)).
5. Configure Gradle to use JUnit 5 (see [build.gradle](build.gradle#L27-29))


## Part 1: Blocks, Expectations and Pending Features

Read the [Spock Primer section] of the [Spock Framework Reference Documentation] to learn about the basic [Spock] terminology, fixture and feature methods, blocks and expectations.

I personally don't like block comments to stay in the test after it has been implemented (as suggested in the [Specifications as Documentation section]) for I want the *code* to be self-explanatory.
Hence, in this workshop we won't use that feature.

Then try to do the following objectives:

- [ ] The method `isOfAge` method in [User] is not implemented properly yet.
  However, there is a test in [UserClassSpec] which is annotated with `@PendingFeature`.\
  Use the commented out code in `isOfAge`, in order to make the test's expectation be true.
  Once you did, remove the annotation.
- [ ] The feature methods uses `given`, `when` and `then`.
  Try to make it shorter using an `expect` block.
- [ ] Our current implementation of [User] allows to create users who were not born yet.
  Write a `@PendingFeature` that expects that `"creating a user with a future birthday throws an IllegalArgumentException"`.
- [ ] Adjust [User] to make the feature no longer pending and remove the annotation.
- [ ] Write another feature method that specifies that `"no exception in thrown if the birthday is in the past"`.


## Part 2: Data Driven Testing

Read the [Data Driven Testing section] of the [Spock Framework Reference Documentation] to learn about `where` blocks and their data table and pipe notations and the `@Unroll` annotation.

Then try to do the following objectives:

- [ ] You might have noticed, that the implementation of `isOfAge` is not really how its name suggests because not only users are of age whose 18th birthday is today!
  Write another feature method to ensure that `"isOfAge should return true if the user's birthday is more than 18 years ago"`.
  Use a `where` block to test several cases.
- [ ] Use [Unrolled Iteration Names] to get better test result output.
- [ ] Add another data driven test `"isOfAge should return false if the user's birthday is less than 18 years ago"` to test negative cases.
- [ ] Review your features and try to make more test data driven.


## Part 3: Mocking and Stubbing

Read the [Interaction Based Testing section] of the [Spock Framework Reference Documentation] to learn about Mocks, Stubs and Spies.

Then try to do the following objectives:

- [ ] We want to write a test for the [UserService] which ensures that `"registerUser persists the user data via UserRepository"`.
  Use a Mock for the [UserRepository] since we don't want to test it here (and there is no implantation 😉).
  Feel free to use a Mock for the [User] object as well, but I'd generally not recommend to mock simple classes as this.
- [ ] We want to avoid registering users which are already registered.
  Write another feature method that ensures that `"registerUser does not persist user data if the user name was registered before"`.
  Make your test succeed, ensuring that all others still don't fail.
  Also, we might want to throw an exception in that case.
- [ ] ...


## Helpful Resources and Further Reading

* [Spock Framework Reference Documentation], especially the [Extensions section] and the [Modules section] not used in this workshop.
* [Idiomatic Spock] is a presentation by Rob Flechter about some tricks how to write Spock specifications in a better way.
* [Groovy documentation]


[GMavenPlus]: <https://github.com/groovy/GMavenPlus>

[Groovy]: <http://www.groovy-lang.org/>
[Groovy documentation]: <http://www.groovy-lang.org/documentation.html>

[Spock]: <http://spockframework.org/>
[Spock Framework Reference Documentation]: <http://docs.spockframework.org/>
[Spock Primer section]: <http://spockframework.org/spock/docs/2.3/spock_primer.html>
[Specifications as Documentation section]: <http://spockframework.org/spock/docs/2.3/spock_primer.html#specs-as-doc>
[Data Driven Testing section]: <http://spockframework.org/spock/docs/2.3/data_driven_testing.html>
[Unrolled Iteration Names]: <https://spockframework.org/spock/docs/2.3/data_driven_testing.html#_unrolled_iteration_names>
[Interaction Based Testing section]: <http://spockframework.org/spock/docs/2.3/interaction_based_testing.html>
[Extensions section]: <http://spockframework.org/spock/docs/2.3/extensions.html>
[Modules section]: <http://spockframework.org/spock/docs/2.3/modules.html>

[Idiomatic Spock]: <https://github.com/robfletcher/idiomatic-spock/blob/master/Idiomatic%20Spock.pdf>

[pom.xml]: <pom.xml>

[User]: <src/main/java/io/github/mkutz/workshop/spocktesting/User.java>
[UserClassSpec]: <src/test/groovy/io/github/mkutz/workshop/spocktesting/UserClassSpec.groovy>
[UserEntity]: <src/main/java/io/github/mkutz/workshop/spocktesting/UserEntity.java>
[UserRepository]: <src/main/java/io/github/mkutz/workshop/spocktesting/UserRepository.java>
[UserService]: <src/main/java/io/github/mkutz/workshop/spocktesting/UserService.java>
[UserServiceClassSpec]: <src/test/groovy/io/github/mkutz/workshop/spocktesting/UserServiceClassSpec.groovy>
