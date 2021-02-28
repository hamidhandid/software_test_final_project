[![Issues][issues-shield]][issues-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]

# Software test course final project - Fall 2020

## Description
This project is a calculator tester with Appium. The calculator that is used in this project, is the main calculator of Android 8.0 on an emulator with API 26 .

## Requirements
* Java 8 or above.
* Android Sdk
* Appium
* Emulator with API 26 (Android 8.0)

## Files
* Main.java: this java file makes a new CalculatorTest instance and test all operators of a calculator with each choice approach.
If you want to know about Each Choice approach read [this](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&ved=2ahUKEwi03uv3rI3vAhUI8hQKHXPRBisQFjAAegQIBBAD&url=https%3A%2F%2Fwww.cs.montana.edu%2Fcourses%2Fse422%2FcurrentLectures%2FCh4.pdf&usg=AOvVaw2Jz1ldDyq6m9PEQ00zQUuS) file.
* AppTest.java: this java file open virtual device and calculator on Android 8.0 .
* CalculatorTest.java: this file has functions of testing functions and equations on calculator.

## How to Run
1. run Appium and click on "Start Server"
2. run Emulator with API 26
3. run below code
```bash
git clone https://github.com/hamidhandid/software_test_final_project
cd software_test_final_project
mkdir lib
cd lib
wget https://www.dropbox.com/s/4bdumn56ob8v3k9/lib.zip?dl=1
unzip lib.zip
rm lib.zip
cd ../src
javac -cp ".;../lib/*" Main.java
java Main
cd ..
```

[issues-shield]: https://img.shields.io/github/issues/hamidhandid/software_test_final_project
[issues-url]: https://github.com/hamidhandid/software_test_final_project/issues
[forks-shield]: https://img.shields.io/github/forks/hamidhandid/software_test_final_project
[forks-url]: https://github.com/hamidhandid/software_test_final_project/network/members
[stars-shield]: https://img.shields.io/github/stars/hamidhandid/software_test_final_project
[stars-url]: https://github.com/hamidhandid/software_test_final_project/stargazers
