# mssql_backup
An useful tool to run backup on your SQL Server© 

With this **open source** tool, you can easly run backup of your sql server databases.
It's compiled with Java 11 (LTS) and you have to run it via CLI.
Tt works perfectly as on a Linux system as on Windows and you can install Oracle Java or open-JDK-11.

## Configuration file
It's necessary to configure a config.properties file with administrative database credentials.
It's safe to run as **user** the jar file, but database credentials need admin privileges.

That's a sample

```bash
#Thu Jan 06 17:54:33 CET 2022
db_user=sa
db_pass=
db_host=
db_port=1433
db_name=master

#ServerPath 
server_path=Z:/backup # or server_path=/home/backup if you run on linux
backuplist=
```

## Requirements
Java© 11

See Oracle©  website
https://www.oracle.com/it/java/technologies/javase/jdk11-archive-downloads.html

on linux (Debian or Ubuntu)

```bash
sudo apt-get update
sudo apt-get intall default-jdk
```


## Setup
Use the flag **-h** to display the help menu:
```bash
java -jar mssql_backup-2.0-cli-lite-jar-with-dependencies.jar -h
```

```bash
$ java -jar target/mssql_backup-2.0-cli-lite-jar-with-dependencies.jar -h
*******************************************************
Developed under GPLv3 License
Stefano Perrini e Damiano Improta
Free for home and commercial purpose.
VERSION: 2.0.28
*******************************************************
Usage: java -jar mssqlbackup.jar [OPTION]
Usage: java -jar mssqlbackup.jar -bl [DBNAME]... [DBNAME]...
Example: java -jar mssqlbackup.jar -bl database1 database2 database3
Example: java -jar mssqlbackup.jar -h (to display help menu)

Option selection and interpretation

-h       --help                  to display this "help" menu
-?                               to display this "help" menu
-v       --version               to display version
-a       --all                   to Backup of all DB accessible with your credentials
-l       --list                  to List all DB accessible with your credentials
-bl      --backuplist            to Backup a specified list all DB accessible with your credentials

```

Run the tool with flag **--init** to generate a **config.properties** file ready to be completed with your data

```bash
java -jar mssql_backup-2.0-cli-lite-jar-with-dependencies.jar --init
```

Run the tool without any argument to check the database connection

```bash
$ java -jar target/mssql_backup-2.0-cli-lite-jar-with-dependencies.jar
DB Connection in progress...
VERSIONE: Microsoft SQL Server 2014 (SP3-GDR) (KB4583463) - 12.0.6164.21 (X64)
        Nov  1 2020 04:25:14
        Copyright (c) Microsoft Corporation
        Enterprise Edition (64-bit) on Windows©  NT 6.3 <X64> (Build 9600: )
```

If the server informations are displayed, you are ready to run your backups.


## How it works

To backup all databases of your server run:
```bash
java -jar mssql_backup-2.0-cli-lite-jar-with-dependencies.jar --all
```

but you can provide a list of database name if you want to backup a specific subset 
```bash
java -jar mssql_backup-2.0-cli-lite-jar-with-dependencies.jar --bl database1 database2 database3
```

or you can configure the list inside the **config.properties** file like this

```bash
backuplist=database1, database2, database3
```

then execute the command only with the flag **-bl** without any other argument
```bash
java -jar mssql_backup-2.0-cli-lite-jar-with-dependencies.jar --bl
```

## Schedule a job
I do not want to explain hot windows scheduler works...
but I can remind to you how can create a cronjob on a Linux Os

to create a new scheduling
```bash
crontab -e
```

Example of scheduling every 19.00am and every 8.00pm backup for every database on your server
```bash
0 10,20 * * * java -jar /path/with/the/tool/mssql_backup-2.0-cli-lite-jar-with-dependencies.jar --a
```

## Authors
[Stefano Perrini](https://www.linkedin.com/in/stefano-perrini-560962194/) aka La Matrigna

[Damiano Improta](https://www.linkedin.com/in/damiano-improta-b85514157/) aka Drizella