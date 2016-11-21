cmake_minimum_required(VERSION 3.6)
project(CSD_training_prj)
include_directories("$ENV{CPPUTEST_HOME}/include")
include_directories("./")
include_directories("./src")
include_directories("./tst")
link_directories("$ENV{CPPUTEST_HOME}/lib")
link_libraries("$ENV{CPPUTEST_HOME}/lib/libCppUTest.a")
link_libraries("$ENV{CPPUTEST_HOME}/lib/libCppUTestExt.a")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11 -lCppUTest -lCppUTestExt")


set(SOURCE_FILES
    build/ComponentMakefile
    build/MakefileWorker.mk
    src/CircularBuffer.cpp
    src/CircularBuffer.h
    src/One.cpp
    src/One.h
    src/Printer.cpp
    src/Printer.h
    tst/AllTests.cpp
    tst/AllTests.h
    tst/CircularBufferTest.cpp
    tst/MockDocumentationTest.cpp
    tst/MockPrinter.h
    tst/OneTest.cpp
    tst/PrinterTest.cpp
    )

add_executable(CSD_training_prj ${SOURCE_FILES})