## README

# This is a challenge by [Coodesh](https://coodesh.com/)
## [Repository Link](https://github.com/mateuskih/task_teste)

# Technologies / Dependencies
- Java
- JUnit4
- AWS SDK for S3
- JSON Simple
- Mockito
- JAXB API
- System Rules
- Apache HttpClient
- AssertJ


# TASK1: Palindrome Checker

### Description
Task here is to implement a function that says if a given string is
palindrome.

Definition=> A palindrome is a word, phrase, number, or other sequence of
characters which reads the same backward as forward, such as madam or
racecar.


## Overview
The `TASK1` program checks if a given string is a palindrome, meaning it reads the same backward as forward. Examples of palindromes include "madam" and "racecar". The program prompts the user to enter a string and determines if it is a palindrome.

## How It Works

1. **Input**: The user is prompted to enter a string.
2. **Processing**:
    - **Format the Input**: Removes whitespace and converts the string to lowercase.
    - **Check for Palindrome**: Uses two pointers to compare characters from both ends of the string:
        - If characters differ, returns `false`.
        - If characters match, moves pointers inward.
3. **Output**: Prints whether the input string is a palindrome.

## Usage

### Compile:
```bash
javac com/example/TASK1.java
```

### Run:
```bash
java com.example.TASK1
```

### Example::
```bash
Enter a string to check if it's a palindrome:
A man a plan a canal Panama
a man a plan a canal panama is a palindrome.
```

## Test
Available in TASK1Test.java

## TASK2: Doubly Linked List with Middle Element Remove

### Description
Task here is to write a list. Each element must know the element before and
after it. Print out your list and them remove the element in the middle of
the list. Print out again.

### Overview
The `TASK2` program creates a doubly linked list where each element knows its previous and next elements. The program prints the list, removes the middle element, and then prints the list again.


### How It Works
#### Data Structures:
- **Node**: Represents an element in the doubly linked list, with references to the previous and next nodes.
- **DoublyLinkedList**: Manages the list of nodes.

#### Operations:
1. **Add Elements**: Adds elements to the end of the list.
2. **Print List**: Prints all elements in the list.
3. **Remove Middle Element**: Removes the middle element from the list.
    - **Find Middle**: Uses two pointers (slow and fast) to locate the middle element.

### Usage

### Compile:
```bash
javac com/example/TASK1.java
```
### Run:
```bash
java com.example.TASK2
```
### Example:
```bash
Original list:
1 2 3 4 5 
List after removing middle element:
1 2 4 5 
```

## Test
Available in TASK2Test.java

## TASK3: Random String List with Distinct Item Count

### Description
Write a list and add an aleatory number of Strings. In the end, print out how
many distinct itens exists on the list.

### Overview
The `TASK3` program generates a list with a random number of strings, prints the list, and then prints the count of distinct items in the list.

### How It Works

#### Operations:
1. **Generate Random String List**: Creates a list with a specified number of random strings.
2. **Generate Random String**: Generates a random string of a given length using uppercase and lowercase letters.
3. **Print List**: Prints all strings in the list.
4. **Count Distinct Items**: Counts and returns the number of distinct items in the list using a `HashSet`.

### Usage

### Compile:
```bash
javac com/example/TASK3.java
```
### Run:
```bash
java com.example.TASK3
```
### Example:
```bash
Enter a string to check if it's a palindrome:
nqQb
JaCfeEuGQ
i
m
FXXMnXb
w
egrmfZRAB
BXGCrPY
OwQLHrczrM
Uv
Number of distinct items: 10
```

## Test
Available in TASK3Test.java

## TASK4: Gender Count from API

### Description
Create an implementation of a Rest API client.
Prints out how many records exists for each gender and save this file to s3 bucket
API endpoint=> https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda 
AWS s3 bucket => interview-digiage

### Overview
The `TASK4` program retrieves data from a specified API endpoint, counts the occurrences of genders in the data, and saves the results to an Amazon S3 bucket.

### How It Works

#### Steps:
1. **Call API**: Sends a GET request to the specified API endpoint and retrieves the JSON response.
2. **Count Genders**: Processes the JSON response to count the occurrences of each gender.
3. **Save to S3**: Writes the gender counts to a file and uploads it to an S3 bucket.

#### Details:

1. **Call API**:
   - URL: `https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda`
   - HTTP Method: `GET`
   - Checks for a successful response (`HTTP_OK`) and reads the response data.

2. **Count Genders**:
   - Parses the JSON response.
   - Iterates through the JSON array to count occurrences of each gender.

3. **Save to S3**:
   - AWS Credentials: Uses `BasicAWSCredentials` for authentication.
   - AWS S3 Client: Configures the S3 client with the specified region and credentials.
   - Upload: Converts the gender counts to a byte stream and uploads it to the S3 bucket (`interview-digiage`) with the file name `gender_counts.txt`.

### Usage

### Compile:
```bash
javac com/example/TASK4.java
```
### Run:
```bash
java com.example.TASK4
```
### Example:
```bash
male: 45
female: 55
Saves the above result to S3 as "gender_counts.txt"
```

## Test
Available in TASK4Test.java

## TASK5: API CRUD

### Description
Create an implementation of a Rest API .
Expose an API. Feel free to explore possibilities/functionalities/capabilities following Rest standard.
We suggest that your implementation have at least a CRUD scenario.

### Overview
The `TASK5` program simulates a user management system using the TASK5API. It demonstrates simulate CRUD(CREATE, READ, UPDATE, and DELETE) users, as well as authenticating a user and searching users by name. 
I found it a bit ambiguous, so I simulated a CRUD instead of going with Spring Boot and implementing a real server

### How It Works

#### Steps:
1. **Simulate API Calls**: Creates multiple users, retrieves their data, updates a user, deletes a user, and prints the remaining users.
2. **User Authentication**: Simulates user authentication.
3. **Search Users by Name**: Searches for users by name and prints the results.

#### Details:

1. **Simulate API Calls**:
   - **Create Users**: Calls `createUser` method to add three users (`Mateus`, `Maria`, `Daniel`).
   - **Retrieve User Data**: Calls `getUser` method to retrieve user details by user ID and prints them.
   - **Update User Data**: Updates the first user (`Mateus`) and prints the updated details.
   - **Delete User**: Deletes the second user (`Maria`) and confirms deletion by printing remaining users.

2. **User Authentication**:
   - **Authenticate**: Calls `authenticate` method for user `Daniel` with a password and prints the authentication result.

3. **Search Users by Name**:
   - **Search**: Calls `getUsersByName` method to find users named `Daniel` and prints the search results.

### Usage

### Compile:
```bash
javac com/example/TASK5.java
```
### Run:
```bash
java com.example.TASK5
```
### Example:
```
User with ID 1: User{id=1, name='Mateus', email='mateus@example.com', password='password123'}
User with ID 2: User{id=2, name='Maria', email='maria@example.com', password='password456'}
User with ID 3: User{id=3, name='Daniel', email='daniel@example.com', password='password789'}
User updated: 1: User{id=1, name='Mateus Oliveira.', email='mateusoliveira@example.com', password='newpassword'}
User with ID 2 deleted.
Remaining users:
ID: 1, User: User{id=1, name='Mateus Oliveira.', email='mateusoliveira@example.com', password='newpassword'}
ID: 3, User: User{id=3, name='Daniel', email='daniel@example.com', password='password789'}
Authentication result for Daniel: true
Result search users by name: [User{id=3, name='Daniel', email='daniel@example.com', password='password789'}]
```

## Test
Available in TASK5Test.java


# SQL

## Query que retorna a quantidade de funcionários separados por sexo.

### Query
```
SELECT gender, COUNT(*) AS quantidade 
FROM employees 
GROUP BY gender;
```

### Example Output
![Example](https://i.imgur.com/hcK9qMT.png)

## Query que retorna a quantidade de funcionários distintos por sexo, ano e ano de nascimento.

### Query
```
SELECT gender, YEAR(birth_date) AS ano_nascimento, COUNT(DISTINCT emp_no) AS quantidade 
FROM employees 
GROUP BY gender, YEAR(birth_date);
```

### Example Output
![Example](https://i.imgur.com/rYFlJL6.png)

## Query que retorna a média, min e max de salário por sexo.

### Query
```
SELECT 
    e.gender,
    AVG(s.salary) AS media_salario,
    MIN(s.salary) AS min_salario,
    MAX(s.salary) AS max_salario
FROM employees e
INNER JOIN salaries s ON e.emp_no = s.emp_no
GROUP BY e.gender;
```

### Output Example
![Example](https://i.imgur.com/aYCQmob.png)

### Apresentação/Sobre mim
Olá, meu nome é Mateus. Tenho 23 anos e atualmente sou um Desenvolvedor de Software. Desde a minha adolescência, sempre gostei de mexer nos arquivos e descobrir como as coisas funcionavam "por baixo dos panos". Como eu gostava muito de jogos, frequentemente explorava as pastas dos jogos e tentava modificar as configurações e arquivos. Tentando entender como funcionava, foi assim que criei meus primeiros scripts para o RPG Maker na época e, posteriormente, servidores privados de Tibia e Grand Chase. Por necessidade, buscava aprender por meio de fóruns de programação da época mesmo sem saber muito como funcionava de fato.

Alguns anos depois, ingressei no Ensino Médio técnico em informática, com foco em programação. Lá, adquiri conhecimentos fundamentais de programação em C, posteriormente em Orientação a Objetos com Java e desenvolvimento web com PHP, Ruby, JavaScript, entre outras linguagens e ferramentas. Em seguida fui para o mercado de trabalho e desde então, não parei mais de programar, embora tenha diminuído meu tempo com jogos.

Uma curiosidade: minha namorada é estudante de Veterinária e, por causa dela, acabo tendo contato com muitos animais exóticos... Acredite, tenho fotos com serpentes, iguanas e todo tipo de bicho aleatório que ela me faz acompanhar nos seminários em que participa.


### Grafana Gráfico Análise

![Gráfico de análise](https://i.imgur.com/MzgTBHD.png)

Fiz uma análise das últimas 12 horas do gráfico de uso de memória/CPU do servidor. O gráfico mostra o uso da memória e da CPU de um servidor ao longo do tempo. O uso da memória e da CPU está aumentando constantemente, com alguns picos ocasionais.

Antes de analisar, fiz algumas alterações visuais no padrão que estava, para conseguir identificar melhor os picos em escala linear.

É notável que no intervalo das 08:00 às 13h, o uso de memória e CPU, em geral, se mantém bem abaixo da média, sendo esta faixa a de menor uso/requisições no servidor.

Das 14:00 às 18:00, o uso subiu mais de 20%, sendo um horário de maior uso de recursos no servidor.

Além disso, foram identificados dois picos de memória (7:24 e 14:18) e dois de CPU (16:41 e 17:07). Os picos de memória atingiram cerca de 53B e os de CPU, em média, 27%. Esses picos são preocupantes e vale a pena analisar cada um isoladamente para identificar o que os causou, a fim de melhorar o desempenho e prevenir possíveis sobrecargas no servidor.



