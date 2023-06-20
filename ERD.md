| User          |           
|---------------|
| id (PK)       |     
| first_name    |
| last_name     |
| email (UQ)    |
| stats_id (FK) |
| goal_id (FK)  |

| Stats    |
|----------|
| id (PK)  |
| weight   |
| height   |
| body_fat |

| Goals    |
|----------|
| id (PK)  | 
| weight   |  
| body_fat | 

| Exercise        |
|-----------------|
| id (PK)         |         
| reps            |         
| rpe             |         
| sets            |         
| workout_id (FK) |    
| name            |



