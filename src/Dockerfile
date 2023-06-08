FROM openjdk:17
WORKDIR /app
COPY src/app/src
RUN javac -cp /src/main.java
CMD ["java","-cp", "src" , "Main"]