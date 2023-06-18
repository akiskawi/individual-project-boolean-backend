Build Restful CRUD API for a blog using Spring Boot, Mysql, JPA and Hibernate.

## Steps to Setup

**1. Clone the application**

```bash
git clone
```

**2. Create Mysql database**

```bash
create database
```

Running : sql to build database?

[//]: # (- run `src/main/resources/create_database.sql`)

**3. Change PostgreSQL username and password as per your installation**

- open `src/main/resources/example.yml`
- change `spring.datasource.username` and `spring.datasource.password` as per your PostgreSQL installation
- change name to `src/main/resources/application.yml`

**4. Run the app using maven**

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:4000>

## Explore Rest user APIs

The app defines following CRUD APIs.

| Method | Url       | Description     | Sample Valid Request Body |
|--------|-----------|-----------------|---------------------------|
| POST   | /users    | create user     | [JSON](#create)           |
| PUT    | /users/id | Update user     | [JSON](#update)           |
| DELETE | /users/id | Delete user     |                           |
| GET    | /users    | Get all users   |                           |
| GET    | /users/id | Get single user |                           |

RequestMapping("users/userId)

| Method | Url           | Description             | Sample Valid Request Body |
|--------|---------------|-------------------------|---------------------------|
| PUT    | /stats        | Update user's stats     | [JSON](#stats)            |
| GET    | /stats        | Get user's stats        |                           |
| PUT    | /goals        | Update user's goals     | [JSON](#goal)             |
| GET    | /goals        | Get user's goals        |                           |
|        |               |                         |                           |
| GET    | /workouts     | Get user's workouts     |                           |
| GET    | /workouts/id  | Get workout with id     |                           |
| POST   | /workouts     | Create workout for user | [JSON](#workoutC)         |
| PUT    | /workouts/id  | Update workout          | [JSON](#workoutU)         |
| DELETE | /workouts/id  | Delete workout<br/>     |                           |
|        |               |                         |                           |
| GET    | /exercises    | Get all exercises       |                           |
| GET    | /exercises/id | Get single exercises    |                           |
| POST   | /exercises    | Create a exercise       | [JSON](#exerciseC)        |
| PUT    | exercises/id  | Update the exercise     | [JSON](#exerciseU)        |
| DELETE | exercises/id  | Delete the exercise     |                           |

## Sample Valid JSON Request Bodys

##### <a id="create">Create user</a>

```json
{
  "firstName": "new",
  "lastName": "new",
  "email": "email@example.com",
  "stats": {
    "weight": 180,
    "height": 190,
    "bodyFat": "new%"
  },
  "goal": {
    "weight": 170,
    "bodyFat": "goal%"
  }
}
```

##### <a id="update">Update user</a>

```json
{
  "firstName": "new",
  "lastName": "new",
  "email": "email@example.com"
}
```

##### <a id="goal">Update user's goals</a>

```json
{
  "weight": 180,
  "bodyFat": "20%"
}
```

##### <a id="goal">Update user's stats</a>

```json
{
  "weight": 180,
  "height": 190,
  "bodyFat": "20%"
}
```

##### <a id="workoutC">Create user's workout</a>

```json
{
  "name": "Legs",
  "day": "MONDAY",
  "exercises": [
    {
      "name": "Push-ups",
      "sets": 3,
      "reps": 12,
      "rpe": 7
    }
  ]
}
```

##### <a id="workoutU">Create user's workout</a>

```json
{
  "name": "Legs",
  "day": "MONDAY"
}
```

##### <a id="exerciseC">Create workout's exercise</a>

```json
{
  "name": "Bench Press",
  "sets": 4,
  "reps": 6,
  "rpe": 7
}
```
##### <a id="exerciseU">Update workout's exercise</a>

```json
{
  "name": "new Press",
  "sets": 5,
  "reps": 5,
  "rpe": 8
}
```