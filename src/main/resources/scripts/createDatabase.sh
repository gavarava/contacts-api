echo ------------ Create Database ------------
java -cp h2.jar org.h2.tools.RunScript -url "jdbc:h2:file:~/contactsDB" -user h2user -password h2testpassword -script scripts/createTable.sql