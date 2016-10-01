## Simple REST API built on topof _spray_ Template Project

This projects provides a starting point for your own _spray-routing_ endeavors.
There are 8 branches, providing templates for _spray-routing_ on

* _spray-can_, Scala 2.9 + Akka 2.0 + spray 1.0 (the `on_spray-can_1.0` branch)
* _spray-can_, Scala 2.10 + Akka 2.1 + spray 1.1 (the `on_spray-can_1.1` branch)
* _spray-can_, Scala 2.10 + Akka 2.2 + spray 1.2 (the `on_spray-can_1.2` branch)
* _spray-can_, Scala 2.10 + Akka 2.3 + spray 1.3 (the `on_spray-can_1.3` branch)
* _spray-can_, Scala 2.11 + Akka 2.3 + spray 1.3 (the `on_spray-can_1.3_scala-2.11` branch)
* _Jetty_, Scala 2.9 + Akka 2.0 + spray 1.0 (the `on_jetty_1.0` branch)
* _Jetty_, Scala 2.10 + Akka 2.1 + spray 1.1 (the `on_jetty_1.1` branch)
* _Jetty_, Scala 2.10 + Akka 2.2 + spray 1.2 (the `on_jetty_1.2` branch)
* _Jetty_, Scala 2.10 + Akka 2.3 + spray 1.3 (the `on_jetty_1.3` branch)
* _Jetty_, Scala 2.11 + Akka 2.3 + spray 1.3 (the `on_jetty_1.3_scala-2.11` branch)


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

8. Initial data available in data/todo_items.js

        > mongo todo_items.js
