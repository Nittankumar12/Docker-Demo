# Docker-Demo
Docker Demo Project- single container, multi containers, docker volumes, docker images etc


ocker uses Components: 
1. Docker engine: creating,managing containers
2. Containers
3. Image: lightweight or blueprint of a container
4. Docker file: Docker file we have to create and do configuration
5. Docker hub: docker hub contains most of the images like tomcat server, mongoDB
6. Volumes: to store data permanently 


Download docker and setting it up

1. Docker images can run through the docker desktop as well as cli
2. Docker containers automatically created when we run an image

CLI Commands to use image and containers of docker

1. To view all images  - $ docker images
2. To view all containers -> $docker ps -a
3. To run a image -> $docker run "image-name"
4. to delete an image -> $docker rmi "image-id"
5. to delete an container -> $ docker rm "container-id"
if you tries to delete a image whose containers is being used, it will give an error.

6. to get help -> $docker help

when you want to create containers according to your need 

7. to pull an image  -> $docker pull "image-name"
8. to create a container -> $docker create "image-name"
by checking containers you can find its id, $docker ps -a
9. to run the container -> $docker start "container-id"
10. to stop the container -> $ docker stop "container-id"
11. to pause container -> $docker pause "container-id"

12. to get about docker status -> $docker ps


Daemon responsible to get image, run containers, pull image etc.  also k/as Docker d

when we want to connect jdk and containerized a java project

13. $docker search jdk -> to search jdk
14. $docker search openjdk -> then we'll find jdks 
15.$docker pull openjdk:22-jdk

16. when we run this jdk it will give us jshell on which we can java code -> 
 $docker run openjdk:22-jdk
 But in this case it runs and exited we want that it remains there
 
17. we use command -> $docker run -it openjdk:22-jdk

So this is the jdk running on a container
 

Pack a project, create its container and create it image and using that image we can run our project anywhere


1. Firstly create a spring boot project 
2. Go to your pom.xml file you can change name of file that you'll be getting as jar <finalname>finalname</finalname>
3. Now after creation go to Maven and create package of maven and then you'll get a package in your target package named as "finalname.jar"
4. This jar file can be executed on other systems.

Run jar file on system
1. open terminal and pass command $java -jar target/"finalname".jar
2. We got a running app now we have to put this in the container
3. go to terminal -> $docker ps and we get a openjdk running
4. $docker ps exec "names" ls -a , it will list all folders of jdk
5. we can use tmp/ folder -> $docker exec "containername" ls /tmp
6. $docker cp target/"finalname".jar "contianername":/tmp, it will copy your code to the container
7.  Now we have to create the image of the container so that we can use it
8.  $docker commit "containername" packagename/"finalname".jar, create the image of it
9. But it runs default command i.e its running jshell but we want to run our project, we can check this by -> $docker ps
10. Running command is: jshell, the proper command should be:
$docker commit --change='CMD["java","-jar","/tmp/finalname.jar"] containername packagename/finalname:v2
11. Now its running code but its running on docker port 8080, not on machine port
12. $docker run -p 8080:8080 packagename/finalname:v2, it runs your project on machine port 8080 


But this includes so many steps, we can do this by using creating a new dockerfile in our project 

The content is: 
FROM openjdk:22-jdk
ADD target/rest-demo.jar rest-demo.jar
ENTRYPOINT["java","-jar","/rest-demo.jar"]

$docker build -t packagename/rest-demo:v3 . ,, will create image of it that we can use
Now we can run our image by using terminal or cli
This method reduces our effort to create containers and write lengthy commands 


