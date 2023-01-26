#!/bin/bash

NODE_NAME=$1

function line() {
	for ((i=0;i<${#MESSAGE}; i++))
	do
		echo -n "+"
	done
	echo ""
}

MESSAGE="+ creazione nodo $1 completata +"
line 
echo ${MESSAGE}
line
