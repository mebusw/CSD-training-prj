#Set this to @ to keep the makefile quiet
ifndef SILENCE
        SILENCE = @
endif

#--- Inputs ----#
COMPONENT_NAME = CSD
CPPUTEST_HOME = ..

CPPUTEST_USE_EXTENSIONS = Y
CPP_PLATFORM = Gcc

# This line is overriding the default new macros.  This is helpful
# when using std library includes like <list> and other containers
# so that memory leak detection does not conflict with stl.
# CPPUTEST_MEMLEAK_DETECTOR_NEW_MACRO_FILE = -include ApplicationLib/ExamplesNewOverrides.h
SRC_DIRS = \
        ApplicationLib

TEST_SRC_DIRS = \
        AllTests

INCLUDE_DIRS =\
  .\
  ApplicationLib\
  $(CPPUTEST_HOME)/include\

CPPUTEST_HOME = /usr/local/Cellar/cpputest/3.8/


CPPUTEST_WARNINGFLAGS = -Wall -Wswitch-default

# CPPUTEST_LIB_LINK_DIR = ./lib
# CPPUTEST_LIB_DIR = .
include ./build/MakefileWorker.mk


