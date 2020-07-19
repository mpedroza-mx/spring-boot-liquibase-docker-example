# Create Tables and Data

This project will generate the medical-consultory tables with all the data required


### Creating tables and data

Execute the following maven command:

```
mvn resources:resources liquibase:update
```

##Step 1

You will need to update the following file
```
+---src
|   +---main
|   |   \---resources
|   |       |   liquibase.properties <-------------------------- THIS FILE 
```


With the following content
```
url=jdbc:mysql://localhost:3306/medical-consultory
username=root
password=root
outputChangeLogFile=src/main/resources/liquibase-outputChangeLog.xml
dropFirst= true
dataDir=src/main/resources/data
verbose=true
```

Now you will have to execute the following maven command which will allow you to generate the database structure
```
mvn resources:resources liquibase:generateChangeLog
```

##Step 2

Now we have to export the database data  to do that you will have to update the liquibase.properties files with the following content
```
url=jdbc:mysql://localhost:3306/medical-consultory
username=root
password=root
outputChangeLogFile=src/main/resources/liquibase-outputChangeLogData.xml
dropFirst= true
dataDir=src/main/resources/data
verbose=true
diffTypes=data 
```

Now you will have to execute the following maven command which will allow you to generate the database structure
```
mvn resources:resources liquibase:generateChangeLog
```


##Step 3

You will have to copy the changeSet nodes from liquibase-outputChangeLogData.xml to liquibase-outputChangeLog.xml and that is all with this you already have the necessary to create a database will all the data
