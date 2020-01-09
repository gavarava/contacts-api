#!/bin/bash
ls -lrt
echo ------------ Run Database Server ------------
java -cp h2.jar org.h2.tools.Server &

echo ------------ Start Contacts Application ------------
java -cp contacts-app.jar:h2.jar com.contactsapp.ContactsApplication server config.yaml
