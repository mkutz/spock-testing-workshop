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


Objectives
----------
- [ ] Implement the method `isOfAge` method in [User] *test driven* using Spock.

Helpful Resources and Further Reading
-------------------------------------
* [Spock manual]
* [Groovy documentation]


[Groovy]: <http://www.groovy-lang.org/>
[Groovy documentation]: <http://www.groovy-lang.org/documentation.html>

[Spock]: <https://github.com/spockframework/spock>
[Spock manual]: <http://docs.spockframework.org/>

[pom.xml]: <pom.xml>

[User]: <src/main/java/de/assertagile/workshop/spocktesting/User.java>
[UserEntity]: <src/main/java/de/assertagile/workshop/spocktesting/UserEntity.java>
[UserRepository]: <src/main/java/de/assertagile/workshop/spocktesting/UserRepository.java>
[UserService]: <src/main/java/de/assertagile/workshop/spocktesting/UserService.java>
