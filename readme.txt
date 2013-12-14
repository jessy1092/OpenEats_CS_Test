How to run on localhost
1. install jdk 6+
2. change settings in /conf/securesocial.conf, making sure you edit the google clientId and clientSecret
3. go to https://cloud.google.com/console, create a project, register app and enter your correct redirect url such as http://localhost:9000/authenticate/google
4. type run in the command line and hit enter, this will start up the server at port 9000 and open a Java remote debug port at 9999
5. open http://localhost:9000 with your prefered browser

Note: You can skip step 3, I've configured a google client key and secret using my own account

How to step by step debug in IDE
1. start Eclipse
2. import existing project, pick openeats_server root folder
3. Click run -> debug configuration, double click on Remote Java Application
4. under connect tab, select openeats_server project
5. in connection properties, set host to "localhost", port tp "9999" and press debug
6. now you can set break point and start step by step debugging

How to access h2db web interface?
1. type activator
2. type h2-browser
3. change JDBC to jdbc:h2:mem:play
4. press connect
5. type run to start web server

Note: h2db is stored in memory, therefore data will lost when server restarts
Good only for dev purpose

Platform
PlatformPlay Framework 2.2.1
http://downloads.typesafe.com/typesafe-activator/1.0.9/typesafe-activator-1.0.9.zip

Used modules:
http://securesocial.ws/

Hosting options
CloudBees
http://www.cloudbees.com/
https://run.cloudbees.com/a/yuchuan1#app-manage
deploy commands: 
activator dist
bees app:deploy -t play2 -R java_version=1.7 target\universal\openeats-1.0-SNAPSHOT.zip

Possible Data Sources
Crowd Source Mobile App
https://consumer.fda.gov.tw/FoodAnalysis/ingredients.htm
http://intakes.nhri.org.tw/
