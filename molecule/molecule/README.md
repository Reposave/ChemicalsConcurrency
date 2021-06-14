#Ardo Dlamini <br>
#DLMARD001 <br>

#How to Run <br>

In the terminal, type 'make' to  compile.

'make clean' to remove class files.

to run, type the following:

```bash
	@java OS1Assignment "filename"
```

There are two Makefiles, it is easier to use the one inside the bin folder
and can be edited to take any arguments. The Makefile outside the bin folder searches for the
Makefile inside the bin folder and executes it using the command "cd bin && $(MAKE) run"

You can use these make commands from outside or inside the bin folder.
make run1: convert all the addresses in OS1testsequence.
make run2: convert all the addresses in OS1sequence.

All outputs go to "output-OS1.txt"

#ALGORITHM DESCRIPTION <br>

Program reads in one address at a time. The address is converted to binary, the offset and virtual page are obtained. The physical frame is found using the page table and virtual page number then combined with the offset to form the physical address. Addresses are output to “output-OS1.txt”

