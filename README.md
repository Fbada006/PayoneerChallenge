[![Android CI](https://github.com/Fbada006/PayoneerChallenge/actions/workflows/main.yml/badge.svg)](https://github.com/Fbada006/PayoneerChallenge/actions/workflows/main.yml)

# Android Developer Test for Payoneer Germany

This is an app that I have written as an interview for the role of Android Developer for Payoneer Germany. Essentially, the task requires parsing of data from an API and displaying the data in a list with some nice additions.

## Author

- [Ferdinand Bada](https://www.github.com/fbada006)

  
## Run Locally

Clone the project from GitHub and open it using Android Studio. This project was developed using Android Studio 4.2.1 so make sure your IDE is updated. After cloning, make sure your device has internet connectivity and run the project.

  
  ## Running tests
  
The tests in this code are unit tests only. UI tests have not been included because of the issue to do with launching fragments using FragmentScenario and Hilt. A workaround exists for Kotlin but I have been unable to replicate it in Java as of yet. In any case, the logic has been tested properly so this is acceptable. Jun use the default run confirguration from Android Studio and you should see them passing.
  
## Tech Stack

**Language:** 100% Java

**MVVM Design Pattern:** As recommended by Google including tools like ViewModels, LiveData

**Dependency Injection:** Using the newly released Dagger Hilt library from Google

**Testing:** Has been handled through libs like Truth, Mockito, and JUnit

**Threading:** RxJava2 together with a helper library to convert observables to LiveData in line with the MVVM Design Pattern








  
## Documentation

The project is relatively straightforward. The app gets the data from the provided API using `RxJava2`, which also handles setting the UI states of the app. The state and data are handled by a helper `Resource` class and `enums`, which is then exposed to the UI as an observable `LiveData`. Using a simple switch statement, we then update the UI accordingly.

  
