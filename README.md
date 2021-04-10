### Setup of Hibernate (Ubuntu & PopOS)
 
1. Install MySQL
    - https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-20-04
    #### Using the service
    - service mysql status
    - service mysql stop
    - service mysql start 
    - sudo /usr/bin/mysql -u root -p (using mysql command line)
   
   #### Creating DB and a new user
   - https://www.digitalocean.com/community/tutorials/how-to-create-a-new-user-and-grant-permissions-in-mysql-de 
   - https://docs.rackspace.com/support/how-to/install-mysql-server-on-the-ubuntu-operating-system/
   
2. Installing and connecting DBeaver to the new DB
   - By connecting to the database set by 'Driver'
     - allowPublicKeyRetrieval=true
     - useSSL=false

3. Adding Hibernate Dependency to POM

4. Adding MySQL Connector Java to POM

5. Add Hibernate Config File (since Hibernate uses JDBC drivers to connect to the database)




   
   

    

   


