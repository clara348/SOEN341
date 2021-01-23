# SOEN341
Cross-Assembler Project
The purpose of this project is to use Java to create a cross-assembler that can process the CM assembly language of a Virtual machine, intended to support programming languages for embedded systems. 
Assembly language program is a text source file that contains the representation of a computer’s binary instructions – known as machine language. 
Machine language is divided into three symbolic types: labels, mnemonics, and operands. 
The code reads an assembly language source code file and creates an in-memory representation of the assembly language program. 
The assembler traverses the assembly language code to generate the machine language instructions (label, mnemonics, operands), generates a symbol table and generates an offset that can be resolved and flags offsets that must be resolved.
The assembler traverses the sequence of instructions to set the unresolved offsets.
From traversing the intermediate representation, an executable file is written.
