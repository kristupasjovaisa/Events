# Overview

Simple Spring MVC application where authorized users are able to view, create, edit and delete events. Authorization is handled with the help of Spring Security framework.

# Breakdown

## Entities
`EventEntity` - entity that represents event data to be stored to `PostgreSQL` database.
`UserEntity` - entity that represents user data to be stored to `PostgreSQL` database.
There are many-to-many (`UserEntity.events` (all the events where user participes) <=> `EventEntity.users`(all the members of the event)) and one-to-many (`UserEntity.createdEvents`(all the created events by the user) <=> `EventEntity.owner` (the owner of the event)) relationships between the entities.

## Repositories
`UserRepository` - JPA repository to operate with user entities.
`EventRepository` - JPA repository to operate with event entities.

## Services
`UserService` - service that handles CRUD operations using `UserRepository`.
`EventService` - service that handles CRUD operations using `EventRepository`.
`LoginService` - service to get `UserDetails` by user nickname.

## Controllers
`UserController` - controller to operate with user DTO objects using `UserService` and render register view. 
`EventController` - controller to operate with event DTO objects using `EventService` and render views for the events where they are added, viewed or edited. 
`IndexController` - controller that renders index view.

## DTO
`AddUserDto` - DTO object for adding an user.
`UpdateUserDto` - DTO object for updating an user.
`UserDto` - DTO object for reading an user.
`UserDetails` - DTO object that implements `UserDetails` interface and contains information about the current user.
`AddEventDto` - DTO object for adding an event.
`EventDto` - DTO object for reading an event.
`UpdateDto` - DTO object for updating an event.

## HTML
`add-event` - view where users can create an event.
`events` - view where all the events are displayed.
`index` - welcome page.
`list-event` - events detail page.
`register-success` - view that is displayed for user after a successful registration.
`signup-form` - view where users can register an account.
`update-event` - view where users can edit their created event.
`login` - view where user can login.

# Technologies

- Spring MVC
- Spring Security
- Thymeleaf
- PostgreSQL
- Gradle

# Tests

Unit tests are done for `UserService` and `EventService` using JUnit and Mockito.

# To be done (ongoing work on the dev branch)

- Spring MVC migration to Spring RESTful web service
- Spring Profiles
- Spring Security Roles and Permissions
- Localization
- Thymeleaf replaced with React