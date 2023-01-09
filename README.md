# HTTP Server - Java

The HTTP server in the 8th Light apprenticeship.

## Installation
- Clone this repository using `git clone --recurse-submodules git@github.com:fi-ya/http-server.git`
- Run `gradle build`

## Running the HTTP Server
- `cd` into the root folder 'http-server' then run `./gradlew run`

## Pre-requisites
- Java
- `asdf` or a similar version manager: https://asdf-vm.com/

## Dependencies
- Gradle
- JUnit

## Testing

1. Start the HTTP Server by running `./gradlew run`
2. `cd` into the `test/http_server_spec` folder
3. Run `bundle install` to install the dependencies for the testing submodule
4. Run `rake test`

You can also run the tests from a specific section of the features:
```
rake test:f1 # Run all of the tests in 01_getting_started
rake test:f2 # Run all of the tests in 02_structured_data
rake test:f3 # Run all of the tests in 03_file_server
rake test:f4 # Run all of the tests in 04_todo_list
```