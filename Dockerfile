FROM openjdk:11
VOLUME [ "/tmp" ]
EXPOSE 8761
ADD ./target/item-0.0.1-SNAPSHOT.jar item.jar
ENTRYPOINT [ "java", "-jar", "item.jar" ]