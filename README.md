## Simple REST API built on top of _spray_ Template Project
ref: https://github.com/spray/spray-template

This projects provides a starting point for your own microservice with spray  including following libraries and frameworks

 * subcut
 * cashbah, salat
 * spray
 * specs2
 * akka test kit

Data base

* mongoDB


Follow these steps to get started:

1. Git-clone this repository.

        $ git clone https://github.com/roshane/spray-rest-sample.git my-project

2. Change directory into your clone:

        $ cd my-project

3. Launch SBT:

        $ ./sbt

4. Compile everything and run all tests:

        > test

5. Start the application:

        > re-start

6. Browse to [http://localhost:8080](http://localhost:8080/)

7. Stop the application:

        > re-stop

8. Start hacking com.boot.ApiService

#### Initial data provided in /data folder

* to seed you mongo with intial data just run following script

    > ./save_init_data.sh


##### Building fat jar

    > assembly

#### Post man collection is also provided under doc folder

