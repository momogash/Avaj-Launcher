#!/bin/bash

find . -name *.java > sources.txt
javac -sourcepath . @sources.txt
cd avaj_launcher/src/
java launcher.Stimulator $1