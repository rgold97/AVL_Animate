# Makefile for AVLtree.java
#
PROG= BST
SRC= BST.java

$(PROG): $(SRC)
	javac $(SRC)

.PHONY: clean run

run:
	java $(PROG)

clean:
	rm -f *.class
