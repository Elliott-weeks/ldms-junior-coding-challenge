# Technical Challenge

```
TIMEBOX: 3-4 hours
STACK: Java/Spring Boot
TESTS: Enough to showcase what good testing looks like to you
DOCS: Nice to have, not mandatory
```

## Overview

For a recent requirement we needed to find the actual interest rate for a given set of inputs whereby the future value
of a loan would (effectively) be 0.

This general class of challenges can be generalised as root-finding problems, with
the [Bisection Method](https://en.wikipedia.org/wiki/Bisection_method)
being one of the simpler versions.

This challenge is to implement the root-finding algorithm as outlined on the page above, as well as a small RESTful API
to interact with it.

We have provided a basic project containing a Spring Boot set-up with an empty `BisectionMethod.findRoot(...)` method
and a basic test matching the example on the Wikipedia page to help kick things off.

It is important to note that this is by no means a test with a single correct answer in terms of structure and code,
we're wanting to get a sense for how you take a set of requirements and spike a holistic solution that demonstrates your
craftsmanship and approach to building software.

## The Challenge

Within the provided skeleton project, fulfil the following requirements:

- Implement the empty `BisectionMethod.findRoot(...)` method as per the details on
  the [Bisection Method](https://en.wikipedia.org/wiki/Bisection_method) page
- Extend the test suite to add a few tests of your own exercising the code, the existing one will start passing once
  `BisectionMethod.findRoot(...)` is implemented
- Implement a RESTful API endpoint that receives an `a` and `b` value and utilises
  `BisectionMethod.findRoot(...)` to return the root if found or an error if unsuccessful

## Getting Started

The project uses [Maven](https://maven.apache.org/) to manage build and dependencies.

From the root of the project execute:

- `./mvnw test` to execute the test suite
- `./mvnw spring-boot:run` to run the project
- `./mvnw package` to compile and package, the JAR will be available in `target/`

Or alternatively build, test, and run using the IDE of your choice, e.g. IntelliJ.

If you are not overly familiar with Spring Boot and testing within it the following resources may be of use:

- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [A Guide to JUnit 5](https://www.baeldung.com/junit-5)
- [AssertJ - Fluent assertions for java](https://assertj.github.io/doc/)

If you are not overly familiar with Git the following resources may be of use:

- [Hello World](https://guides.github.com/activities/hello-world/)
- [An Intro to Git and GitHub for Beginners (Tutorial)](https://product.hubspot.com/blog/git-and-github-tutorial-for-beginners)

## Submitting Your Challenge

- Please submit your challenge as a git repository (**please do not fork this one!**).
- You can either create a repository on your favourite git hosting provider (GitHub, GitLab, BitBucket) and share the
  link.
- Or send the whole repository, zipped (including the .git directory!). Please include any build and run instructions.
