# jmeter-java-dsl-sample

This is a sample project only containing a
simple [jmeter-java-dsl](https://abstracta.github.io/jmeter-java-dsl) test to hit fake
site (https://myservice) which can help starting a performance testing project from scratch.

Check [jmeter-java-dsl user guide](https://abstracta.github.io/jmeter-java-dsl/guide) for more
details jmeter-java-dsl and usage on existing Java projects.

## Pre requisites

* Java 11+
* Maven 3.5+

## Contents

| File                                                                                          | Description                                                                                                                                                                                                                 |
|-----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [pom.xml](pom.xml)                                                                            | [Maven pom file](https://maven.apache.org/pom.html) which defines id for generated artifact, dependencies, way of building & testing project, and some other general aspects.                                               |
| [PerformanceTest.java](src/test/java/us/abstracta/jmeter/javadsl/sample/PerformanceTest.java) | Class containing one simple example of performance test. You may create a many JUnit tests as you want in one or multiple classes. Feel free to rename package according to your company or domain (eg: com.github.myuser). |
| [log4j2.xml](src/test/resources/log4j2.xml)                                                   | [Log4j2 configuration file](https://logging.apache.org/log4j/2.x/manual/configuration.html) which allows tuning level (info, warn, debug), loggers (per package & class name) and destination of logs (stdout, file, etc).  |

## Executing tests

To execute the tests use IDE integrated features or use maven:

```bash
mvn clean test
```