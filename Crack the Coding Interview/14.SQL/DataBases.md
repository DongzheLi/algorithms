# DataBases

## Declarative Programming

[Lectures](http://composingprograms.com/pages/43-declarative-programming.html)

## SQL syntax

We use explicit join.

```sql
select CourseName, TeacherName
from   Courses inner join Teachers
on     Courses.TeacherID = Teachers.TeacherID
```

## Normalized vs. Denormalized

Normalized databases are designed to minimize redundancy, while denormalized databases are designed to optimize read time.

Example:

+ In a traditional normalized database with data like Courses and Teachers, Courses oftern contain a column called TeacherID, which is a foreign key to Teacher.

+ The benifit of this is that information about the teacher(name, number, email) is only stored in Teachers table, stored only once in the database.

+ The drawback is that many common queries such as find the email of the teacher of that course will require joining two tables.

+ So we can denormalize the database by storing redundant data. If we knew that we would have to repeat that query often, we can store teacher's name and email into Courses table

## Small database design

1. handle Ambiguity
2. define the core objects
3. analyze relationships
4. Investigate actions

Example:

A rental system:

A one-to-many relationship : One building has many apartments

Building
```
BuildingID   |  BuildingName   |  BuildingAddress
--------------------------------------------------
int          |  varchar(100)   |  varchar(500)
```

Apartments
```
ApartmentID  |  ApartmentAddress|  BuildingID
--------------------------------------------------
int          |  varchar(100)    |  int
```

Note that `BuildingID` in apartments as a foreign key,

works for one-to-many or one-to-one.

A many-to-many relationship : Tenant can rent many apartments, a apartment can live many tenants.

Tenants
```
TenantID     |  TenantName     |  TenantAddress
--------------------------------------------------
int          |  varchar(100)   |  varchar(500)
```

Use a junction table

TenantApartments
```
TenantID  | ApartmentID
-----------------------
int       |   int
```

## Large database design

Remember : joins are expensive and slow. You must `denormalize` your data, think about how data will be used, what are common queries, duplicate data in mulitple tables.


