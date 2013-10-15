Greenfield Java 2013
================

Greenfield Java project template for 2013.

To build, just do...

   maven clean package

To run and view on your localhost:8080, just do...

   ./go.sh

...and you can see the server up and running.

Start hacking!  :)

This project is based on a combination of the following:

* [Apache Maven](http://maven.apache.com/)
* [DropWizard](http://dropwizard.codahale.com/)
* [Twitter](Bootstrap http://getbootstrap.com/)
* [Angular Seed](https://github.com/angular/angular-seed)
* [AngularJS](http://angularjs.org/)

To be added: 

* Basic MongoDB integration
* Fix test suite to use a single DropWizard server instance instead of starting/shutting each test
[per Piotr's blog](http://pio-tech.blogspot.com/2013/02/continous-integration-with-dropwizard.html)
* Integrate [Karma](http://karma-runner.github.io/) tests into the build, with dev-friendly start/stop

