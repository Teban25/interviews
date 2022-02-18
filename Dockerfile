FROM amazoncorretto:11

LABEL com.example.interviews.author="David Gomez"

COPY target/interviews-0.0.1-SNAPSHOT.jar interviews.jar

ENTRYPOINT [ "java" , "-jar", "interviews.jar"]