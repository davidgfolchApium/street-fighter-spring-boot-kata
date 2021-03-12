# Creation of REST API with SpringBoot and Java in combination with code wars Kata

The link to kata can be found [here](https://www.codewars.com/kata/58583922c1d5b415b00000ff/train/java)

## Api Endpoints

##### Get Array of all fighters
`street-fighter/all-fighters`  

```
{
    "fighers" : [
    ["figher1" "figher2" "figher1" "figher2"]
    ["figher1" "figher2""figher1" "figher2"]
    ]
}
```

##### Get current position
`street-fighter/current-position`
```
{
    "position" {
    "x" : 1,
    "y" : 1
    }
}
```

##### Get new position after a movement command
`street-fighter/move/{move-cmd}`

move-cmd:
- up
- left
- down
- right

```
{
    "position" {
    "x" : 1,
    "y" : 1
    }
}
```

## Persistance DAOs
- List of all fighters
- Current position