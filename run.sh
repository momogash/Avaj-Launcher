#!/bin/bash
find . -name "*.class" -delete
find  . -name '*.java' > sources.txt
javac -sourcepath . @sources.txt
java Simulator/Simulator scenario.txt

