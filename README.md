# Planetarium


This is my planetarium project which I started in 2020!

This Java program uses:
-Java: java 15 2020-09-15 (works also with openjdk)
-JavaFX: JavaFX 15
-H2 database: 1.4.200

How to start the program:

Remark:

Java is installed into the "C:\Program Files\Java\jdk-15" folder.
JavaFX is installed into the "C:\Program Files\javafx-sdk-15" folder.
H2 is installed into the "C:\Program Files\H2" folder.

The Planetarium program has been placed under my users Documents folder: "C:\Users\janfe\Documents\Planetarium".



javac -classpath "C:\Program Files\H2\bin\h2-1.4.200.jar";"C:\Users\janfe\Documents\Planetarium" --module-path "C:\Program Files\javafx-sdk-15\lib" --add-modules javafx.swing,javafx.controls,javafx.fxml Stars.java
java -cp "C:\Program Files\H2\bin\h2-1.4.200.jar";"C:\Users\janfe\Documents\Planetarium" --module-path "C:\Program Files\javafx-sdk-15\lib" --add-modules javafx.swing,javafx.controls Stars > stars.log

