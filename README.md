    updated on: 06th June 2023, Tuesday

<div align="center">
    <a href="https://github.com/warmachine028/Swing-Bank">
        <img width="200" src="https://user-images.githubusercontent.com/75939390/235854846-0596d942-9ab1-4148-9f1c-7ed1f47201f5.png" alt="Swing Bank">
    </a>
    <p style="font-family: roboto, calibri; font-size:12pt; font-style:italic"> Experience banking without limits </p>
    <a href="https://github.com/warmachine028/Swing-Bank/actions">
        <img src="https://github.com/warmachine028/Swing-Bank/actions/workflows/ant.yml/badge.svg?branch=main" alt="Distribution"/>
    </a>
</div>

# [Swing Bank](https://github.com/warmachine028/Swing-Bank)

![line]

## Table of Contents

- [Introduction](#introduction)
- [Development](#development)
- [Concepts Used](#concepts-used)
- [Tech Stack Used](#tech-stack-used)
- [Dependencies](#dependencies)
- [Preview](#preview)
- [Table Schema](#table-schema)
- [Best Contributors](#best-contributors)
- [License](#license)

![line]

## Introduction

- This is a desktop based GUI Banking Application.
- Built using Java on top of Swing and AWT Framework.
- It uses MySQL as Database management.
- For automating build configuration ANT has been used.
- IVY has been used for dependency management.
- Extensive use of GitHub Workflows for CI/CD.
- Fully opensource

![line]

## Development

- Download and Install Ant
- Set path and environment variable

```sh
  $> ant -f ivysetup.xml
  ...  
  $> ant
  ...
  $> ant -f run.xml
```

![line]

## Concepts Used

- Inheritance
  - Hierarchical
  - MultiLevel
- Abstraction
  - Partial _(Abstract Class)_
  - Complete _(Interface)_
- Interface
  - Functional Interface
- Polymorphism
  - Static _(Method OverLoading)_
  - Dynamic _(Method OverRiding)_
- Exception Handling
  - Try Catch Block
  - Multi Catch
  - Multiple Exceptions in 1 Block _('|' symbol)_
  - Checked Exceptions
  - Usage of Throw vs Throws keywords
- Packaging
  - Sub-Packaging
- Folder Structuring
  - _build_
  - _lib_
  - _components_
  - _src_
  - _dist_
- String Formatting
- Environment Variables
- Form Validation
  - Email Validation
  - Prevention of SQL Injection
- Component Reusability
  - DRY Concept

![line]

## Tech Stack Used

- FrontEnd: Swing & AWT
- BackEnd: Java
- Configuration: XML
- Database: MySQL, JDBC
- Build: Ant
- Dependency Management: Ivy
- Version Control: Git
- Distribution: GitHub
- CI/CD: GitHub Actions
- Development: Intellij IDEA
- Documentation: VsCode

![line]

## Dependencies

- [JCalendar](https://mvnrepository.com/artifact/com.toedter/jcalendar/1.4)
- [MySQL-Connector-J](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/8.0.33)
- [Dotenv-java](https://mvnrepository.com/artifact/io.github.cdimascio/dotenv-java/3.0.0)

![line]

## Preview

![line]

## Table Schema

### - Users

| Field         | Type                             | Null | Key | Default | Extra          |
|---------------|----------------------------------|------|-----|---------|----------------|
| formNo        | int                              | NO   | PRI | NULL    | auto_increment |
| name          | varchar(255)                     | NO   |     | NULL    |                |
| fName         | varchar(255)                     | NO   |     | NULL    |                |
| dob           | date                             | NO   |     | NULL    |                |
| gender        | enum('Male','Female')            | NO   |     | NULL    |                |
| email         | varchar(255)                     | NO   |     | NULL    |                |
| maritalStatus | enum('Married','Single','Other') | NO   |     | NULL    |                |
| address       | varchar(255)                     | NO   |     | NULL    |                |
| city          | varchar(100)                     | NO   |     | NULL    |                |
| state         | varchar(100)                     | NO   |     | NULL    |                |
| pinCode       | varchar(20)                      | NO   |     | NULL    |                |

### - Additional Details

| Field          | Type                                                                                               | Null | Key | Default | Extra          |
|----------------|----------------------------------------------------------------------------------------------------|------|-----|---------|----------------|
| id             | int                                                                                                | NO   | PRI | NULL    | auto_increment |
| formNo         | int                                                                                                | NO   | UNI | NULL    |                |
| religion       | enum('Hindu','Muslim','Sikh','Other')                                                              | NO   |     | NULL    |                |
| category       | enum('General','OBC','SC','ST','Other')                                                            | NO   |     | NULL    |                |
| income         | enum('No Fixed Income','< 1,50,000','< 2,50,000','< 5,00,000','< 10,00,000','More than 10,00,000') | NO   |     | NULL    |                |
| qualification  | enum('Non Graduate','Graduate','Post Graduate','Doctorate','Other')                                | NO   |     | NULL    |                |
| occupation     | enum('Student','Salaried','Self Employed','Business','Retired','Other')                            | NO   |     | NULL    |                |
| pan            | char(10)                                                                                           | NO   |     | NULL    |                |
| aadhaar        | char(12)                                                                                           | NO   |     | NULL    |                |
| existingHolder | enum('Yes','No')                                                                                   | NO   |     | NULL    |                |
| seniorCitizen  | enum('Yes','No')                                                                                   | NO   |     | NULL    |                |

## Best Contributors

<div align="center">
    <a  href="https://github.com/warmachine028/memories/graphs/swing-bank">
        <img src="https://contrib.rocks/image?repo=warmachine028/swing-bank"  alt="contributors"/>
    </a>
</div>

![line]

## License

- See [LICENSE]

**Pritam, 2023**

![line]

## Thank you, everyone 💚

[line]: https://user-images.githubusercontent.com/75939390/137615281-3a875960-92cc-407f-97fe-fd2319bdb252.png

[License]: https://github.com/warmachine028/swing-bank/blob/main/LICENSE

<!-- 06/06/23 -->
