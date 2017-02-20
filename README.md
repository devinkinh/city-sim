# city-sim

#TEST:

##Compile
###windows
`javac -cp ./junit-4.12.jar;./hamcrest-core-1.3.jar;./mockito-core-1.10.19.jar;./objenesis-2.4.jar; *.java`
### mac
 `javac -cp ./junit-4.12.jar:./hamcrest-core-1.3.jar:./mockito-core-1.10.19.jar:./objenesis-2.4.jar: *.java`

##Run
###windows
`java -cp ./junit-4.12.jar;./hamcrest-core-1.3.jar;./mockito-core-1.10.19.jar;./objenesis-2.4.jar; TestRunner`
###mac
`java -cp ./junit-4.12.jar:./hamcrest-core-1.3.jar:./mockito-core-1.10.19.jar:./objenesis-2.4.jar: TestRunner`

#SIM:
Compile: `javac *.java`

Run: `java CitySim9004 <Integer Seed>`
