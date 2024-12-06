# Exercise 2

Install guide:

Install:

JDK

Node.js

Maven

IntelliJ

Open a project with IntelliJ and run mvn clean install

Run test on Exercise2 

Explanation: 

ApiUtils create to easily make api calls and verify successfully works

SignUpHelper to serialize to Json the SignUp body

In this project I implemented chainable to improve readability  

BaseTest class set all driver and test properties, the initial idea was create an application properties
to read from them and add support for CI but I didn't have enough time

Apart from that I created a method based on current time to create a new user each execution, because there isn't an API call to delete user
and it would make the test not automatically re-runnable 


