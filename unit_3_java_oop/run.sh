#!/bin/sh

cd hw_1
mvn clean package
java -jar ./target/unit_3_java_oop.jar

cd ../

cd hw_2
mvn clean package
java -jar ./target/unit_3_java_oop.jar

cd ../

cd hw_3
mvn clean package
java -jar target/unit_3_java_oop.jar