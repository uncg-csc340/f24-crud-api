# CRUD API

The REST API performs CRUD operations on Student objects as described below.

## Get list of Students

### Request

    `GET /students/all`

    `http://localhost:8080/students/all`

   
### Response

     [
   
     {"studentId": 1, "name": "sample1", "major": "csc", "gpa": 3.89}, 
   
     {"studentId": 2, "name": "sample2", "major": "mat", "gpa": 4.0}, 
   
     { "studentId": 3, "name": "sample3", "major": "eng", "gpa": 3.25}
   
     ]

## Get a specific Student

### Request

`GET /students/{studentId}`

`http://localhost:8080/students/1`

### Response

    {
      "studentId": 1, "name": "sample1", "major": "csc", "gpa": 3.89
    }

     
## Create a new Student

### Request

    `POST /students/new`
    
    `http://localhost:8080/students/new` --data '{ "studentId": 4, "name": "sample4", "major": "csc", "gpa": 3.55}'

   ### Response

   [
   
     {"studentId": 1, "name": "sample1", "major": "csc", "gpa": 3.89}, 
   
     {"studentId": 2, "name": "sample2", "major": "mat", "gpa": 4.0}, 
   
     { "studentId": 3, "name": "sample3", "major": "eng", "gpa": 3.25},

     { "studentId": 4, "name": "sample4", "major": "csc", "gpa": 3.55}
   
  ]

## Get Students by major

### Request

    `GET /students?major=csc`

    `http://localhost:8080/students/major=csc`

   
### Response

     [
   
      {"studentId": 1, "name": "sample1", "major": "csc", "gpa": 3.89}, 
   
      { "studentId": 4, "name": "sample4", "major": "csc", "gpa": 3.55}
   
     ]

## Update an existing Student

### Request

    `PUT /students/update/{studentId}`
    
    `http://localhost:8080/students/update/1` --data '{ "studentId": 1, "name": "sampleUpdated", "major": "csc", "gpa": 3.92}'

   ### Response
   
    {
      "studentId": 1, "name": "sampleUpdated", "major": "csc", "gpa": 3.92
    }


## Delete an existing Student

### Request

    `DELETE /students/delete/{studentId}`
    
    `http://localhost:8080/students/delete/1`

   ### Response
   
   [
   
     {"studentId": 2, "name": "sample2", "major": "mat", "gpa": 4.0}, 
   
     { "studentId": 3, "name": "sample3", "major": "eng", "gpa": 3.25},

     { "studentId": 4, "name": "sample4", "major": "csc", "gpa": 3.55}
   
  ]
