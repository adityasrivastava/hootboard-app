FROM ubuntu:latest

MAINTAINER Aditya Srivastava :)

RUN apt-get update && \
    apt-get -y install \
	vim \
	build-essential \
	apt-utils && rm -rf /var/lib/apt/lists/*

ADD ["./tools/apache-maven-3.5.0-bin.tar.gz","/usr/local"]
ADD ["./tools/jdk-8u131-linux-x64.tar.gz","/usr/local"]

RUN ln -s /usr/local/apache-maven-3.5.0 /usr/local/maven && ln -s /usr/local/jdk1.8.0_131 /usr/local/java

ENV JAVA_HOME=/usr/local/java
ENV M2_HOME=/usr/local/maven
ENV PATH=${PATH}:${M2_HOME}/bin:${JAVA_HOME}/bin

VOLUME /mnt/shared
VOLUME /mnt/tools

USER root
WORKDIR /root