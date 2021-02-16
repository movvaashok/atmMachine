# Atm Machine
# Overview
Aim of this project is to identify and dispense minimum possible currency for a given account number and amount.
# Building Jar
Maven is used as build tool in this application
1) Clone the project into your computer using ()
2) Navigate to "atmMachine" folder
3) Open command prompt and run the command **mvn clean install** ( Maven has to be installed in system to execute **mvn package** command)
   maven will run unit tests and creates a jar for the project in "target" folder
4) atmMachine-0.0.1-SNAPSHOT.jar will be created.
# Executing Jar
1) Open command prompt in the target folder
2) Run the jar file with the command **java -jar atmMachine-0.0.1-SNAPSHOT.jar**
   Instructions are displayed on the console.
# Restrictions
The account details are hard coded as per requirement doc,and it can be modified to read from config file.
