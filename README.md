# BenekivaAutomation

The Benekiva automation appilcation is dockerized so you can run test.

## To run the application have docker installed in your system.

Clone the git repo 
```
git pull automationJava
```

1. From the root(where the docker-compose.yml file located)

2. Build Docker(This will build docker 🏭 ):
```
sudo docker-compose build 
```
3. To run docker build(will run docker images.👆 ):
```
sudo docker-compose up 
```
4. If you want to do both steps at the same time 😮 you can also do: 
```
sudo docker-compose up --build
```
5. If you want to stop any instaces of docker images🛑:
```
sudo docker-compose down
```

Run it locally aayush dai please use this command after making the testing file 

1. From the root(where the docker-compose.yml file located)

2. Build MVN package (This will build mvn package 🏭 ):
```
mvn package -DskipTest=true
```
3. To test the xml file is running (will run docker images.👆 ):


```
java -cp target/dockertest-jar-with-dependencies.jar org.testng.TestNG ./testing.xml 
```
<sub>note : sudo is used only for permission🔒 adjust to your requirements.</sub>
