compilation process

1) set path=c:\jdk1.3\bin;%path%;.;

2) set classpath=c:\jsdk2.1\servlet.jar;%classpath%;.;

3) javac -d c:\jsdk2.1\httproot\webapp\servlets *.java

4) copy *.html c:\jsdk2.1\httproot

before running

start->  settings ---> controlpanel 

double click on odbc datasources 

click add   select microsoft AccessDriver(*.mdb)  the click finish

in data source name text box enter "schedule"

then click on 'select' select the schedule.mdb file from the directory where it located

running

c:\>jsdk2.1>runner

go to internet explorer

on location bar give "http://localhost:8080/home.html"

