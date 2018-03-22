# geek_trust_code
Geek Trust Program Challenges 

Minimum Tools Requirement.
Jdk 1.8
maven 2

For execution of any problem , I have used exec-maven-plugin . One can easily exec a program using 'mvn exec:java' command or use different test cases.

Change the main class name value in pom.xml to excute problem2
<mainClass>in.geektrust.lengaburu.traffic.LengaburuTrafficProblem2</mainClass>

To test try mvn -Dtest=TestSimulator test or mvn -Dtest=TestSimulator2 test or mvn -Dtest=TestTieSimulator

Improvements made for lengaburu-traffic:
1. Added test cases for domain classes .
2. Added Context for the application for better OO Modeling.
3. Generic method for determining best orbit.
4. Improved Naming Convention.
5. Added behaviour to domain classes.
6. removed old unused classes and packages.
