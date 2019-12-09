Backend [![CircleCI](https://circleci.com/gh/CodemonkeysOhtu/lukuvinkkikirjasto.svg?style=svg)](https://circleci.com/gh/CodemonkeysOhtu/lukuvinkkikirjasto)

Frontend [![CircleCI](https://circleci.com/gh/CodemonkeysOhtu/lukuvinkkikirjasto-frontend.svg?style=svg)](https://circleci.com/gh/CodemonkeysOhtu/lukuvinkkikirjasto-frontend)


# Lukuvinkkikirjasto

The application is a solution for storing quick bookmarks to things you want to come back later to. 

# Technology
Backend is written in Java using Spring while frontend is using Facebook's React framework. The application is hosted on Heroku and PostgreSQL is used as the database solution.
Continuous integration is set up through CircleCI. 

# Documentation

[Backlog](https://docs.google.com/spreadsheets/d/1tENnlKtYbCaMsuIFtkuLRumiq6fCyp-DeZCgLi0Ofms/edit#gid=1)

<!--- 
[Instruction manual]()

[Specification]()
-->

[Architechture description](/documentation/architecture.md)

[Frontend readme](https://github.com/CodemonkeysOhtu/lukuvinkkikirjasto-frontend/blob/master/README.md)

[Definition of done](/documentation/DOD.md)


## Build backend

```gradle build```

or

```./gradlew build```

## Deploy backend

TODO: ohjeet backendin deployaukseen esim. Herokuun

## Run development version locally

```gradle run```

or

```./gradlew run```

---------------------------
[Frontend repository](https://github.com/CodemonkeysOhtu/lukuvinkkikirjasto-frontend)

[Lukuvinkkikirjasto application](https://lukuvinkkikirjasto.netlify.com/)

[Backend in Heroku (only API)](https://lukuvinkkikirjasto-ohtu.herokuapp.com/)

[Backend unit tests](/documentation/tests/junit_test_summary.png)

[Frontend test coverage](https://lukuvinkkikirjasto-coverage.netlify.com/)

[License](LICENSE)
