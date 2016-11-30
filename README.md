Spock Testing Workshop
======================
Just a project I use in exercises about testing Java projects with [Spock] and [Groovy].

Project Setup with Maven
------------------------
In order to get [Spock] into our Maven project, we need to do the following in our [pom.xml].

1. Add Groovy as a (test) dependency (see [pom.xml](pom.xml#L27-L32):
2. Add Spock dependency (see [pom.xml](pom.xml#L34-L39):
3. Add compiler configuration for Groovy since Maven’s default only compiles Java (see [pom.xml](pom.xml#L94-L120))
4. Make Maven aware of `/src/test/groovy` being a test source directory since Maven’s default is `/src/test/java` (see [pom.xml](pom.xml#L76-L77))
5. Make Maven Surefire plugin aware of files ending with `*Spec` are test class files since Surefire’s default is `*Test` (see [pom.xml](pom.xml#L122-L133)) 
6. Add CGLib and Objenesis in order to be able to Mock classes (see [pom.xml](pom.xml#L41-L57))

Part 1: Blocks, Expectations and Pending Features
-------------------------------------------------
Read the [Spock Primer] to learn about the basic [Spock] terminology, fixture and feature methods, blocks and expectations.

Note that in contrast to the [Spock Primer], I prefer using `given` instead of `setup` for I like my test to be as close to natural language as possible and `setup` does not sound very natural to me.

Also I don't like block comments to stay in the test after it has been implemented (as suggested in the [Specifications as Documentation] section) for I want the *code* to be self-explanatory.

Then try to do the following objectives:
- [ ] The method `isOfAge` method in [User] is not implemented properly yet. However there is a test in [UserSpec] which is annotated with `@PendingFeature`. Change `isOfAge`, in order to make the test's statement be true. Once you did, remove the annotation.
- [ ] The test uses `given`, `when` and `then`. Try to make it shorter using an `expect` block.
- [ ] Our current implementation of [User] allows to create users who were not born yet. Write a `@PendingFeature` that expects the constructor of [User] to throw an `IllegalArgumentExpecption` if the given birthday in not in the past.
- [ ] Change the constructor to make the feature no longer pending and remove the annotation.
- [ ] Write another feature method that specifies that no exception in thrown if the birthday is in the past.

Helpful Resources and Further Reading
-------------------------------------
* [Spock Framework Reference Documentation]
* [Groovy documentation]



[Groovy]: <http://www.groovy-lang.org/>
[Groovy documentation]: <http://www.groovy-lang.org/documentation.html>
[Specifications as Documentation]: <http://spockframework.org/spock/docs/1.1-rc-3/spock_primer.html#specs-as-doc>

[Spock]: <http://spockframework.org/>
[Spock Framework Reference Documentation]: <http://docs.spockframework.org/>
[Spock Primer]: <http://spockframework.org/spock/docs/1.1-rc-3/spock_primer.html>

[pom.xml]: <pom.xml>

[User]: <src/main/java/de/assertagile/workshop/spocktesting/User.java>
[UserSpec]: <src/test/groovy/de/assertagile/workshop/spocktesting/UserSpec.groovy>
[UserEntity]: <src/main/java/de/assertagile/workshop/spocktesting/UserEntity.java>
[UserRepository]: <src/main/java/de/assertagile/workshop/spocktesting/UserRepository.java>
[UserService]: <src/main/java/de/assertagile/workshop/spocktesting/UserService.java>
