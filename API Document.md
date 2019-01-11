# 1. Login Candidate
URL: http://127.0.0.1:8080/loginCandidate
Request: 
```
{
	"email": "trantrungtruc",
	"password": "652606"
}
```
Response:

```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJZb3VyQ29tcGFueU9yQXBwTmFtZUhlcmUiLCJhdWQiOiJOb3RSZWFsbHlJbXBvcnRhbnQiLCJpYXQiOjE1NDU0Nzk1MTUsImV4cCI6MTU0NTY1MjMxNSwiaW5mbyI6eyJpZCI6MTF9fQ.i2eb8_Iw3y90uLCK55cqGUbh6cxv8ctgSYg1SLLEmZ8",
    "candidate": {
        "id": 11,
        "firstName": null,
        "lastName": null,
        "phoneNumber": "0908420640",
        "email": "trantrungtruc",
        "password": "652606",
        "avatarUrl": null,
        "birthday": null
    }
}
```

# 2. Signup Candidate
URL: http://127.0.0.1:8080/registerCandidate
Request: 

```
{
	"firstName": "test",
	"lastName": "652606",
	"phoneNumber": "",
	"email": "tructran@gmail.com",
	"password": "11111",
	"avatarUrl": "",
	"birthdate": "2018-01-03"
}
```

Response:

```
{
    "id": 25,
    "firstName": "test",
    "lastName": "652606",
    "phoneNumber": "",
    "email": "tructran@gmail.com",
    "password": "111111",
    "avatarUrl": "",
    "birthday": "2018-01-03T00:00:00.000+0000"
}
```

# 3. Login Employer
URL: http://127.0.0.1:8080/loginEmployer
Request:

```
{
	"email": "trantrungtruc05",
	"password": "652606"
}
```

Response:

```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJZb3VyQ29tcGFueU9yQXBwTmFtZUhlcmUiLCJhdWQiOiJOb3RSZWFsbHlJbXBvcnRhbnQiLCJpYXQiOjE1NDU0ODAwMDIsImV4cCI6MTU0NTY1MjgwMiwiaW5mbyI6eyJpZCI6MjB9fQ.tRwoODLJrYmwNFCEddK10gI8NjzIfB01Wtikzt3d-Ks",
    "employer": {
        "id": 20,
        "email": "trantrungtruc05",
        "password": "652606",
        "company": {
            "id": 19,
            "companyName": "VIB Bank",
            "companyIndustry": {
                "id": 1,
                "industryName": "IT - Software"
            },
            "website": null,
            "addressNo": "111A",
            "addressStreet": "Pasteur",
            "addressWard": "Ben Nghe",
            "addressDistrict": "1",
            "addressCity": "TPHCM",
            "quantityEmployee": 0,
            "facebookLink": null,
            "googleLink": null,
            "linkedinLink": null,
            "description": null
        },
        "phoneNumber": "0908420640",
        "statusRecuriting": true
    }
}
```

# 4. Register Employer
URL: http://127.0.0.1:8080/registerEmployer
Request:

```
{
	"email": "trantrungtruc05",
	"password": "652606",
	"companyName": "VIB Bank",
	"phoneNumber": "0908420640",
	"companyIndustryId": 1,
	"addressNo": "111A",
	"addressStreet": "Pasteur",
	"addressrWard": "Ben Nghe",
	"addressDistrict": "1",
	"addressCity": "TPHCM",
	"statusRecuriting": true
}
```

Response:

```
{
    "id": 27,
    "email": "trantrungtruc05",
    "password": "652606",
    "company": {
        "id": 26,
        "companyName": "VIB Bank",
        "companyIndustry": {
            "id": 1,
            "industryName": "IT - Software"
        },
        "website": null,
        "addressNo": "111A",
        "addressStreet": "Pasteur",
        "addressWard": "Ben Nghe",
        "addressDistrict": "1",
        "addressCity": "TPHCM",
        "quantityEmployee": 0,
        "facebookLink": null,
        "googleLink": null,
        "linkedinLink": null,
        "description": null
    },
    "phoneNumber": "0908420640",
    "statusRecuriting": true
}
```

# 5. Login Admin
URL: http://127.0.0.1:8080/loginAdmin
Request:

```
{
	"email": "trucAdmin",
	"password": "222222"
}
```

Response:

```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJZb3VyQ29tcGFueU9yQXBwTmFtZUhlcmUiLCJhdWQiOiJOb3RSZWFsbHlJbXBvcnRhbnQiLCJpYXQiOjE1NDU0Nzk0NzAsImV4cCI6MTU0NTY1MjI3MCwiaW5mbyI6eyJpZCI6MjF9fQ.ich9uyGKOZiq6SR5VGibKdHBbcVWVDEacq5uL-abHJ0",
    "adminTamNhan": {
        "id": 21,
        "firstName": "test",
        "lastName": "652606",
        "email": "trucAdmin",
        "password": "222222",
        "phoneNumber": "",
        "avatarUrl": "",
        "birthday": "2018-01-03"
    }
}
```

# 6. Register Admin
URL: http://127.0.0.1:8080/registerAdmin
Request:

```
{
	"firstName": "test",
	"lastName": "652606",
	"phoneNumber": "",
	"email": "trucAdmin123",
	"password": "222222",
	"avatarUrl": "",
	"birthdate": "2018-01-03"
}
```

Response:

```
{
    "id": 24,
    "firstName": "test",
    "lastName": "652606",
    "email": "trucAdmin123",
    "password": "222222",
    "phoneNumber": "",
    "avatarUrl": "",
    "birthday": "2018-01-03T00:00:00.000+0000"
}
```
# 7. Search Job

URL: http://127.0.0.1:8080/searchJob
Request:

```
{
	"keyword": "dev",
	"companyIndustryId": 1,
	"workLocation": "HCM",
	"limit": 10,
	"offset": 0
}

```

Response:

```
[
    {
        "id": 1,
        "jobResponsibilites": "Test",
		"skill": "test",
		"qualification": "Test",
        
        "companyIndustry": {
            "id": 1,
            "industryName": "IT - Software"
        },
        "company": {
            "id": 1,
            "companyName": "VIB Bank",
            "companyIndustry": {
                "id": 1,
                "industryName": "IT - Software"
            },
            "website": null,
            "addressNo": "111A",
            "addressStreet": "Pasteur",
            "addressWard": "Ben Nghe",
            "addressDistrict": "1",
            "addressCity": "TPHCM",
            "quantityEmployee": 0,
            "facebookLink": null,
            "googleLink": null,
            "linkedinLink": null,
            "description": null
        },
        "workLocation": "HCM",
        "jobName": "Java Dev",
        "salary": "10000",
        "createdAt": "2017-12-31T17:00:00.000+0000",
        "tags": "Java"
    }
]
```

# 8. Job Detail

URL: http://127.0.0.1:8080/jobDetail/1 --- GET


Response:

```
{
    "id": 1,
    
    
	"jobResponsibilites": "Test",
	"skill": "test",
	"qualification": "Test",
   
    "companyIndustry": {
        "id": 1,
        "industryName": "IT - Software"
    },
    "company": {
        "id": 1,
        "companyName": "VIB Bank",
        "companyIndustry": {
            "id": 1,
            "industryName": "IT - Software"
        },
        "website": null,
        "addressNo": "111A",
        "addressStreet": "Pasteur",
        "addressWard": "Ben Nghe",
        "addressDistrict": "1",
        "addressCity": "TPHCM",
        "quantityEmployee": 0,
        "facebookLink": null,
        "googleLink": null,
        "linkedinLink": null,
        "description": null
    },
    "workLocation": "HCM",
    "jobName": "Java Dev",
    "salary": "10000",
    "createdAt": "2017-12-31T17:00:00.000+0000",
    "tags": "Java"
}
```

# 9. Get All CompanyIndustry

URL: http://127.0.0.1:8080/api/getAllCompanyIndustry --- GET


Response:

```
[
    {
        "id": 1,
        "industryName": "IT - Software"
    }
]
```

# 10. Get All Job

URL: http://127.0.0.1:8080/api/getAllJobs/10/0 --- GET


Response:

```
[
    {
        "id": 1,
        "jobResponsibilites": "Test",
		"skill": "test",
		"qualification": "Test",
        
        "companyIndustry": {
            "id": 1,
            "industryName": "IT - Software"
        },
        "company": {
            "id": 1,
            "companyName": "VIB Bank",
            "companyIndustry": {
                "id": 1,
                "industryName": "IT - Software"
            },
            "website": null,
            "addressNo": "111A",
            "addressStreet": "Pasteur",
            "addressWard": "Ben Nghe",
            "addressDistrict": "1",
            "addressCity": "TPHCM",
            "quantityEmployee": 0,
            "facebookLink": null,
            "googleLink": null,
            "linkedinLink": null,
            "description": null
        },
        "workLocation": "HCM",
        "jobName": "Java Dev",
        "salary": "10000",
        "createdAt": "2017-12-31T17:00:00.000+0000",
        "tags": "Java"
    }
]
```



