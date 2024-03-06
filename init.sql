create database java_mvn;
create
  user 'username'@'localhost'
  identified by 'Password@123';
grant
  all privileges
  on java_mvn.*
  to 'asuka'@'localhost';
flush privileges;