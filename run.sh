#!/bin/bash

# Compile code
javac src/main/*.java -d classes/
# Run code (Main class)
java -cp classes/ main.Main