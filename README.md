Greenfield Java 2013
================

Greenfield Java project template for 2013.

To build, just do...

   maven clean package

To run and view on your localhost:8080, just do...

   ./go.sh

...and you can see the server up and running.

Start hacking!  :)

This project assumes that you have installed MongoDB.  I do my work primarily on Mac OS X and Windows 8.

For Mac OS X, I install MongoDB and Node (NPM) via [Homebrew](http://brew.sh/).

    brew update
    brew install mongodb
    brew install node

This project is based on a combination of the following:

* [Apache Maven](http://maven.apache.com/)
* [DropWizard](http://dropwizard.codahale.com/)
* [Twitter](Bootstrap http://getbootstrap.com/)
* [Angular Seed](https://github.com/angular/angular-seed)
* [AngularJS](http://angularjs.org/)
* [Yeoman](http://yeoman.io/)

npm install -g generator-angular  # install generator
yo angular                        # scaffold out a AngularJS project
bower install angular-ui          # install a dependency for your project from Bower
grunt test                        # test your app
grunt server                      # preview your app
grunt                             # build the application for deployment

Here are a few of the main libraries of interest:

* [Jackson](https://github.com/FasterXML/jackson)
* [MongoJack](http://mongojack.org/)

To be added: 

* Basic MongoDB integration
* Fix test suite to use a single DropWizard server instance instead of starting/shutting each test
[per Piotr's blog](http://pio-tech.blogspot.com/2013/02/continous-integration-with-dropwizard.html)
* Integrate [Karma](http://karma-runner.github.io/) tests into the build, with dev-friendly start/stop

