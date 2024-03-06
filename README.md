### Env Setup

Installation

```bash
yay -S mysql jdk17-openjdk gradle
sudo systemctl start mysqld
sudo systemctl enable mysqld
sudo mysql_secure_installation
echo JAVA_HOME=/usr/lib/jvm/default >> .zshrc
echo \
  export PATH="$JAVA_HOME/bin:$PATH" \
  >> .zshrc
```

DB Creation

```
sudo mysql -u root -p
```

```sql
create database java_mvn;
create
  user 'username'@'localhost'
  identified by 'Password@123';
grant
  all privileges
  on java_mvn.*
  to 'asuka'@'localhost';
flush privileges;
```

### Plugins & Dependencies

build.gradle

```build.gradle

plugins{
  id 'java'
  id 'org.springframework.boot' version '3.2.3'
}

dependencies{
  implementation 'org.springframework.boot:spring-boot-starter-web'
  implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
  implementation 'org.mariadb.jdbc:mariadb-java-client:1.5.7'
  implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
}
```
