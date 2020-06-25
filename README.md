## Online Library 

Implementation of online library.

Prerequisites
-------------
1. install gradle
1. install docker-compose
1. install git
1. clone repository: `git clone --https://github.com/PeterHolub/onlinelibrary.git`
### Database initialization

Build and run docker container with database:

```
docker-compose up
```
You should be able to connect to the database with following connectors:

- Host:       **localhost**
- Port:       **3333**
- Database:   **onlinelibrary**
- User:       **postgres**
- Password:   **postgres**

### Database table creation or update
Create and update tables with Liquibase and Gradle task
```
gradle update
```
