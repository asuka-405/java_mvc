FROM archlinux:latest

RUN pacman -Sy --noconfirm && \
  pacman -S --noconfirm git base-devel

RUN git clone https://aur.archlinux.org/yay.git /tmp/yay
WORKDIR /tmp/yay
RUN useradd -m yay
RUN usermod -aG wheel yay
RUN echo '%wheel ALL=(ALL) NOPASSWD: ALL' > /etc/sudoers.d/01_wheel
RUN chown -R yay:yay /tmp/yay
USER yay
RUN makepkg -si --noconfirm
USER root
WORKDIR /
RUN rm -rf /tmp/yay
RUN userdel -r yay

RUN yay -S --noconfirm jdk17-openjdk mysql gradle
ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk
ENV PATH $JAVA_HOME/bin:$PATH

# RUN systemctl start mysqld
# RUN systemctl enable mysqld
# RUN mysql_secure_installation



WORKDIR /app
COPY ./build.gradle /app/build.gradle
COPY ./application.yml /app/application.yml
COPY ./src /app/src

# RUN mysql -e "CREATE USER 'your_sql_username'@'localhost' IDENTIFIED BY 'your_sql_password';"
# RUN mysql -e "CREATE DATABASE your_sql_database_name;"
# RUN mysql -e "GRANT ALL PRIVILEGES ON your_sql_database_name.* TO 'your_sql_username'@'localhost';"
# RUN mysql -e "FLUSH PRIVILEGES;"

RUN gradle wrapper
RUN gradle build
RUN ./gradlew build

EXPOSE 8080
CMD [ "./gradlew", "bootRun" ]