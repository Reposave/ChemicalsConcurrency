# Program MakeFIle
# Ardo Dlamini
# 09 March 2020
# Major Makefile

JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=../src
BINDIR=../bin
DOCDIR=../doc

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=BarrierReusable.class\
		Carbon.class\
		Hydrogen.class\
		Propane.class\
		RunSimulation.class\
		
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class

docs:	
	javadoc -classpath $(BINDIR) -d $(DOCDIR) $(SRCDIR)/*.java
run1:
	 @java molecule.RunSimulation "24" "9"
run2:
	 @java molecule.RunSimulation "32" "12"
run3:
	 @java molecule.RunSimulation "31" "12"
run4:
	 @java molecule.RunSimulation "31" "11"
run5:
	 @java molecule.RunSimulation "40" "15"
run6:

run7:

run8:
	
