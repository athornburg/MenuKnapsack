This is a solution to the Menu Knapsack problem.
================================================

Pre-Reqs
--------
[Maven](http://maven.apache.org/)
[Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk7u7-downloads-1836413.html)

Run java -version and mvn -version

Building
--------

1. git clone https://github.com/athornburg/MenuKnapsack.git
2. cd MenuKnapsack
1. Ensure text documents are in the MenuKnapsack/src/main/resources folder in the project.
3. mvn clean
4. mvn package
5. For output with repitition: sh target/bin/MenuKnapsack -r menu.txt
6. For output without repitition: sh target/bin/MenuKnapsack -n menu.txt