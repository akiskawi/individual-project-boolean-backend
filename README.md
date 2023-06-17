#### @PostMapping("users") (Register)
```json
{
	"firstName":"new",
	"lastName":"new",
	"email":"email@example.com",
	"stats":{
		"weight":180,
		"height":190,
		"bodyFat":"new%"
	},
	"goal":{
		"weight":170,
		"bodyFat":"goal%"
	}
}
```
#### @PutMapping("users/{id}") (Update)
```json
{
  "firstName":"new",
  "lastName":"new",
  "email":"email@example.com"
}
```
#### @DeleteMapping("users/{id}") (Delete)
#### @GetMapping("users/{id}") (Get)
#### @GetMapping("users/{userId}/goals")
#### @GetMapping("users/{userId}/stats")
#### @PutMapping("users/{userId}/goals")
```json
{
  "weight": 180,
  "bodyFat": "20%"
}
```
#### @PutMapping("users/{userId}/stats")
```json
{
  "weight":180,
  "height":190,
  "bodyFat":"20%"
}
```
